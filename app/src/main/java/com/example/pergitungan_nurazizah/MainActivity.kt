package com.example.pergitungan_nurazizah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var nama: EditText
    private lateinit var jumlahpesan: EditText
    private lateinit var hargamenu: EditText
    private lateinit var geprek: RadioButton
    private lateinit var bakar: RadioButton
    private lateinit var crispy: RadioButton
    private lateinit var hasil: TextView
    private lateinit var simpan: Button
    private lateinit var order: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter:  RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var pesanan: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nama = findViewById(R.id.txtnama)
        jumlahpesan = findViewById(R.id.txtjmlhpesanan)
        hargamenu = findViewById(R.id.txtharga)
        geprek = findViewById(R.id.rbgeprek)
        bakar = findViewById(R.id.rbbakar)
        crispy = findViewById(R.id.rbcrispy)
        hasil = findViewById(R.id.txthsl)
        simpan = findViewById(R.id.btnsimpan)
        order = findViewById(R.id.btnorder)
        recyclerView = findViewById(R.id.listdata)

        val data = mutableListOf<DataPesanan>()
        viewManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerViewAdapter = PesanAdapter(data)
        recyclerView.adapter= recyclerViewAdapter
        recyclerView.layoutManager = viewManager

        simpan.setOnClickListener {
            val nama = nama.text.toString()
            val harga = hargamenu.text.toString()
            val jmlah = jumlahpesan.text.toString()
            val hasil = hasil.text.toString()
            val dataPesanan = DataPesanan(nama, harga, jmlah, hasil)
            data.add(dataPesanan)
            recyclerViewAdapter.notifyDataSetChanged()
        }

        order.setOnClickListener {
            var nama = nama.text.toString()
            var jmlh = jumlahpesan.text.toString().toInt()
            var harga = hargamenu.text.toString().toInt()

            if (geprek.isChecked) {
                pesanan = ((harga) * (jmlh))
                hasil.setText("Nama : $nama\ntotal = " + pesanan.toString())
            }else if (bakar.isChecked) {
                pesanan = ((harga) * (jmlh))
                hasil.setText("Nama: $nama \ntotal = " + pesanan.toString())
            }else if (crispy.isChecked) {
                pesanan = ((harga) * (jmlh))
                hasil.setText("Nama: $nama \ntotal : " + pesanan.toString())
            }else {
                hasil.setText("Pilih DAFTAR MENU dahulu")
            }
        }
    }
}