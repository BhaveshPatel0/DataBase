package com.color.tools.database.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.color.tools.database.R
import com.color.tools.database.database.FruitsDataBase
import com.color.tools.database.dataclass.DataFruits

class FruitsAct : AppCompatActivity() {
    private lateinit var edtFruitsName: EditText
    private lateinit var edtFruitsDetail: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button
    private lateinit var rcvFruits: RecyclerView
    private lateinit var dataBase: FruitsDataBase

    val listOfFruits = arrayListOf<DataFruits>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits)
        bindView()
        bindClick()
    }

    private fun bindView() {
        edtFruitsName = findViewById(R.id.edtFruitsName)
        edtFruitsDetail = findViewById(R.id.edtFruitsDetail)
        btnAdd = findViewById(R.id.btnAdd)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)
        rcvFruits = findViewById(R.id.rcvFruits)



        dataBase =
            Room.databaseBuilder(applicationContext, FruitsDataBase::class.java, "FruitsDB")
                .build()

    }

    private fun bindClick() {
        btnAdd.setOnClickListener {
            val name = edtFruitsName.text.toString()
            val detail = edtFruitsDetail.text.toString()
            edtFruitsName.setText("")
             edtFruitsDetail.setText("")
            Thread{
                dataBase.FruitsDAO().insertFruits(DataFruits(name = name, detail = detail))
                val allData=dataBase.FruitsDAO().getAllFruits()
                Log.d("TAG1", "bindClick: $allData")
            }.start()
        }
        btnUpdate.setOnClickListener {
            val name=edtFruitsName.text.toString()
            val detail=edtFruitsDetail.text.toString()
            edtFruitsName.setText("")
            edtFruitsDetail.setText("")

            Thread{
                dataBase.FruitsDAO().updateFruits(DataFruits(name = name,detail=detail))
                val allData=dataBase.FruitsDAO().getAllFruits()
                Log.d("TAG1", "bindClick: $allData")
            }.start()
        }
        btnDelete.setOnClickListener {
            val name=edtFruitsName.text.toString()
            val detail=edtFruitsDetail.text.toString()
            edtFruitsName.setText("")
            edtFruitsDetail.setText("")
            Thread {
                dataBase.FruitsDAO().deleteFruits(DataFruits(name = name, detail = detail))
                val allData = dataBase.FruitsDAO().getAllFruits()
                Log.d("TAG1", "bindClick: $allData")
            }.start()
        }
    }
}