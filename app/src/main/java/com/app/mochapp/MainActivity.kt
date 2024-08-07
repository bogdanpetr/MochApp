package com.app.mochapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

fun String.logErrorMessage(tag: String = "MyApp") {
    Log.e(tag, this)
}

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        clickOnButton(findViewById<Button>(R.id.btn_press)) {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
//            finish()
        }
    }

    private fun clickOnButton(button: Button, lambda: (() -> Unit)) {
        button.setOnClickListener {
            lambda.invoke()
        }
    }

}