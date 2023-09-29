package com.color.tools.database.vehicle

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.room.Room
import com.color.tools.database.database.FruitsDataBase
import com.color.tools.database.databinding.ActivityVehicleBinding
import com.color.tools.database.vehicle.adapter.AdapterVehicleName
import io.github.inflationx.viewpump.ViewPumpContextWrapper


class VehicleAct : AppCompatActivity() {
    private lateinit var binding: ActivityVehicleBinding
    private lateinit var mAdapterVehicleName: AdapterVehicleName
    private lateinit var dataBase: FruitsDataBase


    val listOfVehicleName = arrayListOf<String>()

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVehicleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackButton.setOnClickListener {
            finish()
        }

        bindClick()


    }

    override fun onResume() {
        super.onResume()

        dataBase =
            Room.databaseBuilder(applicationContext, FruitsDataBase::class.java, "VehicleBrandNameDB")
                .build()

        mAdapterVehicleName = AdapterVehicleName(this, listOfVehicleName,{

            startActivity(
                Intent(
                    this,
                    VehicleNameAct::class.java
                ).putExtra("VehicleBrandName", it)
            )
        },false,false)

        Thread {
            listOfVehicleName.clear()
            val allVehicleName = dataBase.VehicleBrandNameDao().getAllVehicleBrand()

            listOfVehicleName.addAll(allVehicleName)


            Log.d("TAG", "onResume:$allVehicleName ")
            runOnUiThread {

                binding.rcvVehicleBrandName.apply {

                    layoutManager = GridLayoutManager(this@VehicleAct, 1)
                    adapter = mAdapterVehicleName
                    mAdapterVehicleName.notifyDataSetChanged()
                }
            }
        }.start()
    }

    private fun bindClick() {
        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, VehicleBrandNameAct::class.java))

        }
        binding.ivFavorite.setOnClickListener {
            startActivity(Intent(this,FavoriteAct::class.java))
        }
    }
}