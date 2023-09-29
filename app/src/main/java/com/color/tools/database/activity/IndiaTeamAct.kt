package com.color.tools.database.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.color.tools.database.R
import com.color.tools.database.adapter.AdapterTeamIndiaMember
import com.color.tools.database.database.FruitsDataBase
import com.color.tools.database.dataclass.DataIndiaTeam

class IndiaTeamAct : AppCompatActivity() {
    private lateinit var edtId: EditText
    private lateinit var edtName: EditText
    private lateinit var edtAge: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button
    private lateinit var dataBase: FruitsDataBase
    private lateinit var rcvIndiaTeam: RecyclerView
    private lateinit var mAdapterTeamIndiaMember: AdapterTeamIndiaMember


    private val listOfTeamDetail = arrayListOf<DataIndiaTeam>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_india_team)

        bindView()
        bindClick()
    }

    private fun bindView() {
        edtId = findViewById(R.id.edtId)
        edtName = findViewById(R.id.edtName)
        edtAge = findViewById(R.id.edtAge)
        btnAdd = findViewById(R.id.btnAdd)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)
        rcvIndiaTeam = findViewById(R.id.rcvIndiaTeam)

        runOnUiThread {
            mAdapterTeamIndiaMember = AdapterTeamIndiaMember(this, listOfTeamDetail)

            rcvIndiaTeam.apply {
                layoutManager = GridLayoutManager(this@IndiaTeamAct, 1)
                adapter = mAdapterTeamIndiaMember
                mAdapterTeamIndiaMember.notifyDataSetChanged()
            }
        }


        dataBase =
            Room.databaseBuilder(applicationContext, FruitsDataBase::class.java, "TeamIndiaDB")
                .build()
    }

    private fun bindClick() {


        btnAdd.setOnClickListener {
            val name = edtName.text.toString()
            val age = edtAge.text.toString().toInt()
            edtName.setText("")
            edtAge.setText("")

            Thread {
                    dataBase.IndiaTeamDAO().insertTeam(DataIndiaTeam(name = name, age = age))
                    val allData = dataBase.IndiaTeamDAO().getAllTeamMember()
                Log.d("TAG", "bindClick:$allData")
                    listOfTeamDetail.clear()
                    listOfTeamDetail.addAll(allData)
                runOnUiThread {
                    mAdapterTeamIndiaMember.notifyDataSetChanged()
                }
            }.start()
        }
        btnUpdate.setOnClickListener {
            val id = edtId.text.toString().toLong()
            val name = edtName.text.toString()
            val age = edtAge.text.toString().toInt()
            edtName.setText("")
            edtAge.setText("")
            edtId.setText("")

            Thread {
                listOfTeamDetail.add(DataIndiaTeam(id = id, name = name, age = age))
                dataBase.IndiaTeamDAO().updateTeam(DataIndiaTeam(id = id, name = name, age = age))
                val allData = dataBase.IndiaTeamDAO().getAllTeamMember()
                Log.d("TAG", "bindClick:$allData")
                listOfTeamDetail.clear()
                listOfTeamDetail.addAll(allData)
                runOnUiThread {
                    mAdapterTeamIndiaMember.notifyDataSetChanged()
                }
            }.start()
        }
        btnDelete.setOnClickListener {
            val id = edtId.text.toString().toLong()
            val name = edtName.text.toString()
            val age = edtAge.text.toString().toInt()
            edtName.setText("")
            edtAge.setText("").toString()
            edtId.setText("").toString()

            Thread {
                listOfTeamDetail.add(DataIndiaTeam(id = id, name = name, age = age))
                dataBase.IndiaTeamDAO().deleteTeam(DataIndiaTeam(id = id, name = name, age = age))
                val allData = dataBase.IndiaTeamDAO().getAllTeamMember()
                Log.d("TAG", "bindClick:$allData")
                listOfTeamDetail.clear()
                listOfTeamDetail.addAll(allData)
                runOnUiThread {
                    mAdapterTeamIndiaMember.notifyDataSetChanged()
                }

            }.start()
        }
    }
}