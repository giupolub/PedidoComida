package com.example.pedidocomida.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pedidocomida.R
import com.example.pedidocomida.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener(this)
        binding.textRecoverPassword.setOnClickListener(this)
        binding.textRegister.setOnClickListener(this)


    }

    override fun onClick(v: View) {

        when (v.id) {
            R.id.button_login ->
                startActivity(Intent(this, MainActivity::class.java))
            R.id.text_recover_password ->
                startActivity(Intent(this, RecoverPasswordActivity::class.java))
            R.id.text_register ->
                startActivity(Intent(this, RegisterActivity::class.java))
        }


    }
}