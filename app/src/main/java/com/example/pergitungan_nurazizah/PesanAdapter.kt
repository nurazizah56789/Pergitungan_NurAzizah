package com.example.pergitungan_nurazizah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PesanAdapter (private val dataSet: MutableList<DataPesanan>)
:RecyclerView.Adapter<PesanAdapter.PesanHolder>(){
    class PesanHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nama = view.findViewById<TextView>(R.id.nama)
        val hrg = view.findViewById<TextView>(R.id.harga)
        val jmlh = view.findViewById<TextView>(R.id.jumlah)
        val total = view.findViewById<TextView>(R.id.total)
        val btnhapus = view.findViewById<ImageView>(R.id.rvhps)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PesanHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_pesan_adapter,parent,false)
        return PesanHolder(view)
    }

    override fun onBindViewHolder(holder: PesanHolder, position: Int) {
        val data = dataSet[position]
        holder.nama.text = dataSet[position].Nama
        holder.hrg.text = dataSet[position].Harga
        holder.jmlh.text = dataSet[position].Jumlah
        holder.total.text = dataSet[position].Total
        holder.btnhapus.setOnClickListener {
            dataSet.removeAt(position)
            notifyItemRangeRemoved(position,dataSet.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}
