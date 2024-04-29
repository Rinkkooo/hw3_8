package com.example.hw3_8

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.hw3_8.databinding.ItemCharCardsBinding

class CardsAdapter(private val cardList: List<Card>, private val onClickListener: OnClick) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCharCardsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(cardList[position])
        holder.itemView.setOnClickListener{
            onClickListener.onClick(cardList[position])
        }

    }
}

class ViewHolder(private val binding: ItemCharCardsBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(card: Card) {
        binding.image.setImageResource(card.image)
        binding.tvStatus.text = card.status
        binding.tvName.text = card.name
    }

}