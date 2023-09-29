package com.color.tools.database.vehicle

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.room.Room
import com.color.tools.database.R
import com.color.tools.database.database.FruitsDataBase
import com.color.tools.database.databinding.ActivityFavoriteBinding
import com.color.tools.database.vehicle.adapter.AdapterVehicleName
import com.color.tools.database.vehicle.database.favorite.DataFavorite
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class FavoriteAct : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var dataBase: FruitsDataBase
    private lateinit var mAdapterVehicleName: AdapterVehicleName

    var listOfFavorite = arrayListOf<String>()

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataBase =
            Room.databaseBuilder(
                applicationContext,
                FruitsDataBase::class.java,
                "VehicleBrandNameDB"
            )
                .build()

        binding.ivBackButton.setOnClickListener { finish() }

        Thread {

            listOfFavorite.addAll(dataBase.FavoriteDao().getAllFavoriteVehicleName())
            runOnUiThread {
                mAdapterVehicleName = AdapterVehicleName(this, listOfFavorite, {

                }, true, false)


                binding.rcvFavorite.apply {
                    layoutManager = GridLayoutManager(this@FavoriteAct, 1)
                    adapter = mAdapterVehicleName


                }
            }

        }.start()


        bindClick()
    }

    private fun bindClick() {

    }
}