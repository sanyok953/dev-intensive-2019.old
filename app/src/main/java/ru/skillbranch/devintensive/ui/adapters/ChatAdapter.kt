package ru.skillbranch.devintensive.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.skillbranch.devintensive.R
import ru.skillbranch.devintensive.models.data.ChatItem

class ChatAdapter: RecyclerView.Adapter<ChatAdapter.SingleViewHolder>() {

    var items: List<ChatItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val converView = inflater.inflate(R.layout.item_chat_single, parent, false)
        return SingleViewHolder(converView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SingleViewHolder, position: Int) {
    }

    inner class SingleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item: ChatItem) {

        }
    }
}