package com.color.tools.database.vehicle

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.room.Room
import com.color.tools.database.database.FruitsDataBase
import com.color.tools.database.databinding.ActivityVehicleNameBinding
import com.color.tools.database.vehicle.adapter.AdapterVehicleName
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class VehicleNameAct : AppCompatActivity() {
    private lateinit var binding: ActivityVehicleNameBinding
    private lateinit var mAdapterVehicleName: AdapterVehicleName
    private lateinit var dataBase: FruitsDataBase

    val listOfVehicleName = arrayListOf<String>()
    var vehicleBrandName = ""

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVehicleNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackButton.setOnClickListener { finish() }

        bindClick()
        intent.extras?.apply {
            vehicleBrandName = this.getString("VehicleBrandName").toString()

        }

        binding.tvVehicleBrandName.text = vehicleBrandName

    }

    private fun bindClick() {

        binding.btnAdd.setOnClickListener {

            startActivity(
                Intent(this, VehicleName2Act::class.java).putExtra(
                    "vehicleBrandName",
                    vehicleBrandName
                )
            )
        }

    }

    override fun onResume() {
        super.onResume()

        dataBase =
            Room.databaseBuilder(
                applicationContext,
                FruitsDataBase::class.java,
                "VehicleBrandNameDB"
            )
                .build()

        mAdapterVehicleName = AdapterVehicleName(this, listOfVehicleName, {

        }, true, false)

        Thread {
            listOfVehicleName.clear()
            val vehicleName = dataBase.VehicleNameDao().getVehicleNameByBrandName(vehicleBrandName)
            listOfVehicleName.addAll(vehicleName)


            runOnUiThread {

                binding.rcvVehicleName.apply {

                    layoutManager = GridLayoutManager(this@VehicleNameAct, 1)
                    adapter = mAdapterVehicleName
                    mAdapterVehicleName.notifyDataSetChanged()

                }
            }

        }.start()
    }
}