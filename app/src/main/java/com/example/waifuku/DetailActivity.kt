package com.example.waifuku

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.waifuku.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity(){
    companion object{
        const val EXTRA_DATA ="extra_data"
    }

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = "About Her"
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#800000")))


        val waifuDetail = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra(EXTRA_DATA, Waifu::class.java)
        }
        else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_DATA)
        }

        if (waifuDetail != null){
            val text = waifuDetail.description
            binding.imageDetail.setImageResource(waifuDetail.photo)
            binding.tvName.text = waifuDetail.name
            binding.tvContentDescription.text = text
            binding.tvContentDetail.text = waifuDetail.detail
        }
    }

}