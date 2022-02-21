package com.example.aopdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnFastClick).setOnClickListener(object : View.OnClickListener {
            @FastClickView(2000)
            override fun onClick(view: View?) {
                Log.d("MainActivity", "onClick: click me...")
            }
        })
    }

    @TimeConsume
    override fun onStart() {
        try {
            Thread.sleep(3000)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        super.onStart()
    }

    @TimeConsume
    override fun onResume() {
        super.onResume()
    }

}