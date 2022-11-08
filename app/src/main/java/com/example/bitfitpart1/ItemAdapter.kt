package com.example.bitfitpart1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(private val items: MutableList<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {


    private lateinit var longListener: OnItemLongClickListener

    interface OnItemLongClickListener {
        fun onItemLongClick(itemView: View?, position: Int)
    }

    fun setOnItemLongClickListener(longListener: OnItemLongClickListener) {
        this.longListener = longListener
    }


    class ViewHolder(itemView: View, longListener: OnItemLongClickListener) : RecyclerView.ViewHolder(itemView) {


        val itemNameTextView: TextView
        val SetsTextView: TextView


        init {

            itemNameTextView = itemView.findViewById(R.id.itemName)
            SetsTextView = itemView.findViewById(R.id.no_sets)

            itemView.setOnLongClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    longListener.onItemLongClick(itemView, position)
                }
                return@setOnLongClickListener true
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val contactView = inflater.inflate(R.layout.item_recyclerview, parent, false)

        return ViewHolder(contactView, longListener)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items.get(position)

        holder.itemNameTextView.text = item.itemName
        holder.SetsTextView.text = item.calories
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun deleteItem(position: Int) {
        items.removeAt(position)
    }
}

