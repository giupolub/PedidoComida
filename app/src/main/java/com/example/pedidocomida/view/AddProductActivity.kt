package com.example.pedidocomida.view

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Build.VERSION_CODES.P
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.pedidocomida.R
import com.example.pedidocomida.databinding.ActivityAddProductBinding
import com.example.pedidocomida.viewmodel.AddProductViewModel

class AddProductActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAddProductBinding
    private lateinit var viewModel: AddProductViewModel
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
                val bitmap: Bitmap = if (Build.VERSION.SDK_INT < P) {
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

        viewModel = ViewModelProvider(this).get(AddProductViewModel::class.java)

        //binding.spinnerCategory.setOnClickListener(this)
        binding.editTitle.setOnClickListener(this)
        binding.editDescription.setOnClickListener(this)
        binding.editPrice.setOnClickListener(this)
        binding.imageProduct.setOnClickListener(this)
        binding.buttonAdd.setOnClickListener(this)

        binding.buttonPickImage.setOnClickListener { verifyPermissionGallery() }



    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_add) {
            handleAddProduct()
            startActivity(Intent(this, MainActivity::class.java))
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

    private fun handleAddProduct() {

//        val bitmap = ImageDecoder.decodeBitmap(ImageDecoder.createSource())
//        val image = binding.imageProduct.bitmap
//
//
//
//        val category = binding.spinnerCategory.toString()
//        val title = binding.editTitle.text.toString()
//        val description = binding.editDescription.text.toString()
//        val price = binding.editPrice.text.toString()
//        val image = binding.imageProduct.bitmap
//
//        val asdadas = ProductsModel(0, category, title, description, price, image)
//
//
//        viewModel.insertProducts()
    }
}
