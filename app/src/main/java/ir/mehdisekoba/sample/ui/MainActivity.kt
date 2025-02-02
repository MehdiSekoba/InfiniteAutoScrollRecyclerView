package ir.mehdisekoba.sample.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ir.mehdisekoba.sample.R
import ir.mehdisekoba.sample.data.listImage
import ir.mehdisekoba.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding?.apply {
             val myAdapter = SplashAdapter()
            listItem.adapter = myAdapter
            myAdapter.setData(listImage)
            listItem.startScrolling()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null // Important: Set to null to prevent memory leaks
    }
}