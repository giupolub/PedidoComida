package com.example.recantodosabia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recantodosabia.databinding.ActivityAddProductBinding

class AddProductActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}