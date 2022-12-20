package com.example.recantodosabia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.recantodosabia.databinding.ActivityAddProductBinding
import com.google.firebase.firestore.FirebaseFirestore

class AddProductActivity : AppCompatActivity(), OnClickListener {

    lateinit var binding: ActivityAddProductBinding
    private val db = FirebaseFirestore.getInstance()
    private var itemMenu = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonAdd.setOnClickListener(this)

        spinnerFunction()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_add) {
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
    }

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