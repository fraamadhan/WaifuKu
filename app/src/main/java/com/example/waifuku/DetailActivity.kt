package com.example.waifuku

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
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
            binding.apply {
                imgItemPhoto.setImageResource(waifuDetail.photo)
                tvItemName.text = waifuDetail.name
                tvItemDescription.text = text
                tvContentDetail.text = waifuDetail.detail
            }
        }

        fadeIn()
    }

    private fun fadeIn() {
        binding.apply {
            val titleDetail = ObjectAnimator.ofFloat(tvTitleDetail, View.ALPHA, 1f).setDuration(500)
            val titleDesc = ObjectAnimator.ofFloat(tvTitleDescription, View.ALPHA, 1f).setDuration(500)
            val contentDetail = ObjectAnimator.ofFloat(tvContentDetail, View.ALPHA, 1f).setDuration(500)

            AnimatorSet().apply {
                playSequentially(titleDetail, titleDesc, contentDetail)
            }.start()
        }

    }

}