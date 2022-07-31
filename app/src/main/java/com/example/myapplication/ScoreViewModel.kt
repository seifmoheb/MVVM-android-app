package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel(){
    var list = MutableLiveData<ArrayList<Int>>()
    var arrlist = arrayListOf<Int>()
    var scoreB = 0

    fun add(blog: Int){
        arrlist.add(blog)
        list.value = arrlist
    }
    fun remove(blog: Int){
        arrlist.remove(blog)
        list.value = arrlist
    }
}