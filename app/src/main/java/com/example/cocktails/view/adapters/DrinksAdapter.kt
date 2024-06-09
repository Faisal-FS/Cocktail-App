package com.example.cocktails.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.DiffResult
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.cocktails.databinding.ItemCocktailBinding
import com.example.cocktails.model.repository.models.DrinkListItem

class DrinksAdapter(
    val onItemClick: (DrinkListItem) -> Unit
): ListAdapter<DrinkListItem, DrinksAdapter.DrinksHolder>(ItemDiff()) {

    class ItemDiff: DiffUtil.ItemCallback<DrinkListItem>(){
        override fun areItemsTheSame(oldItem: DrinkListItem, newItem: DrinkListItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: DrinkListItem, newItem: DrinkListItem): Boolean {
            return oldItem.id == newItem.id
        }

    }

    class DrinksHolder(
        val binding: ItemCocktailBinding
    ) : ViewHolder(binding.root) {

        fun setData(drinksListItem: DrinkListItem){
            binding.ivThumb.load(drinksListItem.drinkThumb)
            binding.tvDrinkName.text = drinksListItem.drinkName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinksHolder {
        return DrinksHolder(ItemCocktailBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: DrinksHolder, position: Int) {
        val item = getItem(position)
        holder.setData(item)

        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }
}