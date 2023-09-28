package com.example.waifuku

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.waifuku.databinding.ActivityUserAccountBinding

class UserAccountActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding : ActivityUserAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserAccountBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = "My Account"
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#800000")))

        val userProfile = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra(EXTRA_DATA, UserAccount::class.java)
        }
        else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_DATA)
        }

        if(userProfile != null){
            binding.profileName.text = userProfile.name
            binding.profileEmail.text = userProfile.email
        }


    }
}