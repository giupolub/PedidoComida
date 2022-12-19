package com.example.recantodosabiauser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recantodosabiauser.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var productList: ArrayList<Product>
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Layout da RecycleView
        binding.recyclerProducts.layoutManager = LinearLayoutManager(this)
        //Adapter da RecycleView

        productList = arrayListOf()

        db.collection("Alimento").get()
            .addOnSuccessListener {
                if (!it.isEmpty) {
                    for (data in it.documents) {
                        val product: Product? = data.toObject(Product::class.java)
                        if (product != null) {
                            productList.add(product)
                        }
                    }
                    binding.recyclerProducts.adapter = ProductsAdapter(productList)
                }
            }.addOnFailureListener {
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            }

    }

}