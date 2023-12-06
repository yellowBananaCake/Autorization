package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result: ActivityResult ->
        if(result.resultCode == 200) {
            val res = result.data?.getStringExtra("key2")
            Toast.makeText(applicationContext,res, Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val https = "https://bmstu.ru"
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
         /*   val uri = Uri.parse(https)
            // неявное намерение
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(uri)
            startActivity(intent)

          */

        }

        binding.button2.setOnClickListener {
            // явное намерение
            val intent = Intent(applicationContext,MainActivity2::class.java)
            intent.putExtra("key","hello from mainactivity!")
           // startActivity(intent)
            startForResult.launch(intent)
        }


    }
}