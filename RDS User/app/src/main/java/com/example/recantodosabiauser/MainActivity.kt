package com.example.recantodosabiauser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recantodosabiauser.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun productsRecovery() {
        db.collection("News").document("News").get()
            .addOnCompleteListener { document ->
                if (document.isSuccessful){
                    val title = document.result.get("Title").toString()
                    val news = document.result.get("News").toString()
                    val date = document.result.get("Date").toString()
                    val author = document.result.get("Author").toString()

                    binding.textTitle.text = title
                    binding.textNews.text = news
                    binding.textAuthor.text = author
                    binding.textDate.text = date
                }
            }
    }
}