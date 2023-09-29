package com.color.tools.database.gallery.video

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.color.tools.database.R
import com.color.tools.database.databinding.ActivityVideoBinding

class VideoAct : AppCompatActivity() {
    private lateinit var binding: ActivityVideoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindClick()




    }

    private fun bindClick() {

    }
}