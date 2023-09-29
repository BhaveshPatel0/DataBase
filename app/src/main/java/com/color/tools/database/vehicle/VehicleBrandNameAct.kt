package com.color.tools.database.vehicle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.color.tools.database.database.FruitsDataBase
import com.color.tools.database.databinding.ActivityVehicleBrandNameBinding
import com.color.tools.database.vehicle.database.vehiclebrandname.DataVehicleBrandName

class VehicleBrandNameAct : AppCompatActivity() {
    private lateinit var binding: ActivityVehicleBrandNameBinding
    private lateinit var dataBase: FruitsDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVehicleBrandNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackButton.setOnClickListener { finish() }

        bindClick()

        dataBase =
            Room.databaseBuilder(
                applicationContext,
                FruitsDataBase::class.java,
                "VehicleBrandNameDB"
            )
                .build()

    }

    private fun bindClick() {
        binding.btnBrandAdd.setOnClickListener {

            val vehicleName = binding.edtVehicleBrandName.text.toString()
            if (vehicleName == "") {
                Toast.makeText(this, "Plz Enter Name", Toast.LENGTH_SHORT).show()

            } else {
                binding.edtVehicleBrandName.setText("")

                Thread {

                    dataBase.VehicleBrandNameDao()
                        .insertVehicleBrandName(DataVehicleBrandName(0, vehicleName))
                    runOnUiThread {
                        finish()
                    }

                }.start()
            }
        }
    }
}