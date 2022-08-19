package com.example.pedidocomida.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pedidocomida.R
import com.example.pedidocomida.databinding.ActivityAddProductBinding

class AddProductActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityAddProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClick(v: View) {
        TODO("Not yet implemented")
    }
}