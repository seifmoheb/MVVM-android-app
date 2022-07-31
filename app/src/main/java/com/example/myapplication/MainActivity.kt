package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.nio.file.Files.list
import java.util.Collections.list

class MainActivity : AppCompatActivity() {
    var list: RecyclerView?=null
    var recyclerAdapter: RecyclerAdapter?=null
    var button: Button ?= null
    var count: Int = 0
    private val scoreModel by lazy{
        ViewModelProvider(this).get(ScoreViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById<Button>(R.id.button)
        list = findViewById(R.id.recyclerView)

        initialiseAdapter()
    }
    fun add(v: View){
        scoreModel.add(count++)
        //list!!.adapter!!.notifyDataSetChanged()

    }

    private fun initialiseAdapter(){
        list!!.setLayoutManager(LinearLayoutManager(this))
        list!!.adapter= RecyclerAdapter(scoreModel, scoreModel.arrlist,this)

        observeData()
    }

    fun observeData(){

        scoreModel.list.observe(this, Observer{

            list!!.adapter= RecyclerAdapter(scoreModel, it, this)
        })
    }

}