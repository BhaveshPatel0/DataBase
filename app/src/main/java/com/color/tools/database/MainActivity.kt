package com.color.tools.database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.color.tools.database.activity.FruitsAct
import com.color.tools.database.activity.IndiaTeamAct

class MainActivity : AppCompatActivity() {
    private lateinit var btnIndiaTeam:Button
    private lateinit var btnFruits:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindView()
        bindClick()
    }

    private fun bindView() {
        btnIndiaTeam=findViewById(R.id.btnIndiaTeam)
        btnFruits=findViewById(R.id.btnFruits)
    }

    private fun bindClick() {
        btnIndiaTeam.setOnClickListener {
            startActivity(Intent(this,IndiaTeamAct::class.java))
        }
        btnFruits.setOnClickListener {
            startActivity(Intent(this,FruitsAct::class.java))
        }
    }
}