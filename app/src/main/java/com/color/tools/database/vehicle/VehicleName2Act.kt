package com.color.tools.database.vehicle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.color.tools.database.R
import com.color.tools.database.database.FruitsDataBase
import com.color.tools.database.databinding.ActivityVehicleName2Binding
import com.color.tools.database.vehicle.database.vehiclename.DataVehicleName

class VehicleName2Act : AppCompatActivity() {
    private lateinit var binding: ActivityVehicleName2Binding
    private lateinit var dataBase: FruitsDataBase
    private  var vehicleBrandName=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVehicleName2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        vehicleBrandName=intent.extras?.getString("vehicleBrandName").toString()

        binding.tvVehicleBrandName.text=vehicleBrandName

        binding.ivBackButton.setOnClickListener { finish() }

        bindClick()

        dataBase =
            Room.databaseBuilder(applicationContext, FruitsDataBase::class.java, "VehicleBrandNameDB")
                .build()

    }

    private fun bindClick() {
        binding.btnAdd.setOnClickListener {

            val vehicleName = binding.edtVehicleName.text.toString()
            binding.edtVehicleName.setText("")

            Thread {

                dataBase.VehicleNameDao().insertVehicleName(DataVehicleName(0, vehicleName,vehicleBrandName.toString()))
                runOnUiThread { finish() }

            }.start()

        }
    }
}