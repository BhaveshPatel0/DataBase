package com.color.tools.database

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.color.tools.database.activity.FruitsAct
import com.color.tools.database.activity.IndiaTeamAct
import com.color.tools.database.databinding.ActivityMainBinding
import com.color.tools.database.gallery.image.ImageAct
import com.color.tools.database.mobilephone.MobileAct
import com.color.tools.database.vehicle.VehicleAct
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var btnIndiaTeam: Button
    private lateinit var btnFruits: Button

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindView()
        bindClick()
    }

    private fun bindView() {
        btnIndiaTeam = findViewById(R.id.btnIndiaTeam)
        btnFruits = findViewById(R.id.btnFruits)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun bindClick() {
        btnIndiaTeam.setOnClickListener {
            startActivity(Intent(this, IndiaTeamAct::class.java))
        }
        btnFruits.setOnClickListener {
            startActivity(Intent(this, FruitsAct::class.java))
        }
        binding.btnVehicle.setOnClickListener {
            startActivity(Intent(this, VehicleAct::class.java))
        }
        binding.btnMobilePhone.setOnClickListener {
            startActivity(Intent(this, MobileAct::class.java))
        }
        binding.btnImageGlideUse.setOnClickListener {
//            startActivity(Intent(this,ImageAct::class.java))
            askPermission()


        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    fun askPermission() {
        Dexter.withContext(this)
            .withPermissions(
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.TIRAMISU){
                    android.Manifest.permission.READ_MEDIA_IMAGES
                }
                else{
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                }

            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) { /* ... */
                    if (report.areAllPermissionsGranted()) {
                        startActivity(Intent(this@MainActivity, ImageAct::class.java))
                    }
                    else if (report.isAnyPermissionPermanentlyDenied){
//                        startActivity(Intent(this@MainActivity,Settings::class.java))
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest?>?,
                    token: PermissionToken?
                ) {
                    token?.continuePermissionRequest()
                }
            }).check()
    }
}