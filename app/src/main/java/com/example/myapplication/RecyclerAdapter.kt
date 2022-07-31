package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val viewModel: ScoreViewModel, val arrayList: ArrayList<Int>, val context: Context): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var root = LayoutInflater.from(parent.context).inflate(R.layout.cardview,parent,false)
        return ViewHolder(root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.textView.setText(arrayList.get(position).toString())


        holder.bind(arrayList.get(position))

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.title)
        val delete: ImageButton = view.findViewById(R.id.delete)
        fun bind(blog: Int){

            textView.text = blog.toString()
            delete.setOnClickListener {
                viewModel.remove(blog)

            }
        }
    }

}