package com.color.tools.database.mobilephone

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.color.tools.database.R
import com.color.tools.database.database.FruitsDataBase
import com.color.tools.database.databinding.ActivityMobileBinding
import com.color.tools.database.mobilephone.adapter.AdapterMobile
import io.github.inflationx.viewpump.ViewPump
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class MobileAct : AppCompatActivity() {
    private lateinit var binding: ActivityMobileBinding
    private lateinit var mAdapterMobile: AdapterMobile
    private lateinit var dataBase: FruitsDataBase

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMobileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindClick()

    }


    private fun bindClick() {
        binding.btnBack.setOnClickListener { finish() }

        binding.ivAdd.setOnClickListener {
            startActivity(Intent(this, MobileBrandAddAct::class.java))
        }

    }

    override fun onResume() {
        super.onResume()

        dataBase = Room.databaseBuilder(
            applicationContext,
            FruitsDataBase::class.java,
            "VehicleBrandNameDB"
        ).build()


        val getAllMobileBrandName=dataBase.MobileBrandNameDAO().getAllMobileBrandName()



    }


}