package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding2: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding2.root)
        val bundle = intent.extras
        binding2.textView.text = bundle?.getString("key")
        binding2.button3.setOnClickListener {
            val intent = Intent()
            intent.putExtra("key2","HEllo from MainActivity2");
            setResult(200,intent)
            finish()
        }

    }
}