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
   //binding
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         enableEdgeToEdge()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
             _binding = null

    }
}
