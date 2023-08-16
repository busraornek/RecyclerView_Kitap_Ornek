package com.busraornek.kitaplar

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.busraornek.kitaplar.databinding.CardKitapTasarimBinding

class KitapAdapter(private val mContext: Context, private val kitaplarListesi:List<Kitaplar>): RecyclerView.Adapter<KitapAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(val binding: CardKitapTasarimBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardKitapTasarimBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        return kitaplarListesi.size  //kaç içerik olduğunu belirttik suan tüm listeyi gösteriyor
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kitap = kitaplarListesi[position]
        val binding = holder.binding
        binding.textViewKitapAd.text = kitap.kitapAd
        binding.textViewKitapFiyat.text = "${kitap.kitapFiyat} Tl"


        val resimId = mContext.resources.getIdentifier(kitap.kitapResimAd, "drawable", mContext.packageName)

        binding.imageViewKitapResmi.setImageResource(resimId)

        binding.buttonSepeteEkle.setOnClickListener {
            Toast.makeText(mContext, "${kitap.kitapAd} karakteri sepete eklendi.", Toast.LENGTH_SHORT).show()
        }

    }
}