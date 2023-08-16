package com.busraornek.kitaplar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.busraornek.kitaplar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var kitaplerArrayList: ArrayList<Kitaplar>
    private lateinit var adapter: KitapAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rv.setHasFixedSize(true) //kendi boyutlarını kullanmasınlar diye yazdık
        binding.rv.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL)


        val k1 = Kitaplar("İçimdeki Müzik","image_bir",45.5)
        val k2 = Kitaplar("Hayvan Çiftliği","image_iki",75.5)
        val k3 = Kitaplar("Olağanüstü Bir Gece ","image_uc",35.0)
        val k4 = Kitaplar("Simyacı","image_dort",60.0)
        val k5 = Kitaplar("Sol Ayağım","image_bes",90.5)
        val k6 = Kitaplar("Martı","image_alti",25.5)
        kitaplerArrayList = ArrayList<Kitaplar>()
        kitaplerArrayList.add(k1)
        kitaplerArrayList.add(k2)
        kitaplerArrayList.add(k3)
        kitaplerArrayList.add(k4)
        kitaplerArrayList.add(k5)
        kitaplerArrayList.add(k6)


        adapter = KitapAdapter(this,kitaplerArrayList)
        binding.rv.adapter = adapter




    }
}