package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val login = "123"
        val passw = "123"

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(applicationContext,MainActivity2::class.java)

            val log = binding.editTextLogin.text.toString()
            val pass = binding.editTextPassw.text.toString()

            if (log == login && pass == passw) {
                intent.putExtra("greetings","Добро пожаловать, ${log}!")
                startActivity(intent)
            }else if (log == "") {
                binding.textViewLog.setText("Введите логин")
            }else if (pass == ""){
                binding.textViewLog.setText("Введите пароль")
            }else{
                binding.textViewLog.setText("Неправильный логин или пароль")
            }

//            binding.TextViewLog.text = pass

//            startForResult.launch(intent)
        }


    }
}