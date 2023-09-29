package com.color.tools.database.mobilephone

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.color.tools.database.R
import com.color.tools.database.database.FruitsDataBase
import com.color.tools.database.databinding.ActivityMobileBrandAddBinding
import com.color.tools.database.mobilephone.database.mobilebrandname.DataMobileBrandName
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class MobileBrandAddAct : AppCompatActivity() {
    private lateinit var binding: ActivityMobileBrandAddBinding
    private lateinit var dataBase: FruitsDataBase

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMobileBrandAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindClick()

        dataBase = Room.databaseBuilder(
            applicationContext,
            FruitsDataBase::class.java,
            "VehicleBrandNameDB"
        ).build()
    }

    private fun bindClick() {
        binding.ivBackButton.setOnClickListener { finish() }

        binding.btnBrandAdd.setOnClickListener {

            val phoneBrandName = binding.edtMobileBrandName.text.toString()

            if (phoneBrandName == "") {
                Toast.makeText(this, "Please Enter Mobile Name", Toast.LENGTH_SHORT).show()
            } else {
                binding.edtMobileBrandName.setText("")

                Thread {

                    dataBase.MobileBrandNameDAO()
                        .insertMobileBrandName(DataMobileBrandName(0, phoneBrandName))

                    runOnUiThread { finish() }

                }.start()
            }
        }
    }
}