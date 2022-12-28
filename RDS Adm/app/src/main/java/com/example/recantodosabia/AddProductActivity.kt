package com.example.recantodosabia

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.recantodosabia.databinding.ActivityAddProductBinding
import com.google.firebase.firestore.FirebaseFirestore

class AddProductActivity : AppCompatActivity(), OnClickListener {

    lateinit var binding: ActivityAddProductBinding
    private val db = FirebaseFirestore.getInstance()
    private var itemMenu = ""

    private lateinit var dialog: AlertDialog

    companion object {
        const val PERMISSION_GALLERY = android.Manifest.permission.READ_EXTERNAL_STORAGE
    }

    private val requestGallery =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { permission ->
            if (permission) {
                resultGallery.launch(
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                )
            } else {
                showDialogPermission()
            }
        }

    private val resultGallery =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.data?.data != null) {
                val bitmap: Bitmap = if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
                    MediaStore.Images.Media.getBitmap(
                        baseContext.contentResolver,
                        result.data?.data
                    )
                } else {
                    val source = ImageDecoder.createSource(
                        this.contentResolver,
                        result.data?.data!!
                    )
                    ImageDecoder.decodeBitmap(source)
                }
                binding.imageProduct.setImageBitmap(bitmap)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonPickImage.setOnClickListener(this)
        binding.buttonAdd.setOnClickListener(this)

        spinnerFunction()
    }

    override fun onClick(v: View) {
        when (v.id) {
            binding.buttonPickImage.id ->{
                verifyPermissionGallery()
            }
            binding.buttonAdd.id -> {
                buttonAddProduct()
            }
        }

    }

    private fun buttonAddProduct() {
        val title = binding.editTitle.text.toString()
        val price = binding.editPrice.text.toString()
        val description = binding.editDescription.text.toString()
        //val image = binding.imageProduct

        if (title.isEmpty() || price.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        } else {
            addProduct(title, price, description)
        }
    }

    private fun verifyPermissionGallery() {
        val permissionGalleryAccept = verifyPermission(PERMISSION_GALLERY)

        when {
            permissionGalleryAccept -> {
                resultGallery.launch(
                    Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                    )
                )
            }
            shouldShowRequestPermissionRationale(PERMISSION_GALLERY) -> showDialogPermission()
            else -> requestGallery.launch(PERMISSION_GALLERY)
        }
    }

    private fun showDialogPermission() {
        val builder = AlertDialog.Builder(this)
            .setTitle("Atenção")
            .setMessage("Precisamos do acesso a galeria do dispositivo, deseja permitir agora?")
            .setNegativeButton("Não") { _, _ ->
                dialog.dismiss()
            }
            .setPositiveButton("Sim") { _, _ ->
                val intent = Intent(
                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.fromParts("package", packageName, null)
                )
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                dialog.dismiss()
            }

        dialog = builder.create()
        dialog.show()
    }

    private fun verifyPermission(permission: String) =
        ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED

    private fun addProduct(title: String, price: String, description: String) {
        val mapProduct = hashMapOf(
            "title" to title,
            "price" to price,
            "description" to description
        )

        db.collection(itemMenu).document(title)
            .set(mapProduct).addOnSuccessListener {
                Toast.makeText(this, "Produto adicionado com sucesso", Toast.LENGTH_SHORT)
                    .show()
                clearData()

            }.addOnFailureListener {
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()

            }

    }

    private fun clearData() {
        binding.editTitle.setText("")
        binding.editPrice.setText("")
        binding.editDescription.setText("")
    }

    private fun spinnerFunction() {
        val category = binding.spinnerCategory
        ArrayAdapter.createFromResource(
            this,
            R.array.products,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            category.adapter = adapter
        }

        category.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                v: View?,
                position: Int,
                id: Long
            ) {
                itemMenu = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}

        }

    }
}