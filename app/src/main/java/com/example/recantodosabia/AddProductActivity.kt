package com.example.recantodosabia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import com.example.recantodosabia.databinding.ActivityAddProductBinding
import com.google.firebase.firestore.FirebaseFirestore

class AddProductActivity : AppCompatActivity(), OnClickListener {

    lateinit var binding: ActivityAddProductBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonAdd.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_add) {
            val category = binding
            val title = binding.editTitle.text.toString()
            val price = binding.editPrice.text.toString()
            val description = binding.editDescription.text.toString()
            //val image = binding.imageProduct

            if (title.isEmpty() || price.isEmpty() || description.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                addProduct(/*category,*/ title, price, description)
            }
        }
    }

    private fun addProduct(category:String, title: String, price: String, description: String) {
        val mapProduct = hashMapOf(
            "Price" to price,
            "Description" to description
        )

        db.collection(category).document(title)
            .set(mapProduct).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Produto adicionado com sucesso", Toast.LENGTH_SHORT)
                        .show()
                    clearData()
                }
            }.addOnFailureListener { }

    }

    private fun clearData() {
        binding.editTitle.setText("")
        binding.editPrice.setText("")
        binding.editDescription.setText("")
    }
}