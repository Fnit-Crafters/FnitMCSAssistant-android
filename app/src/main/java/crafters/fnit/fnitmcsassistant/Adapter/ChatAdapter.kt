package crafters.fnit.fnitmcsassistant.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import crafters.fnit.fnitmcsassistant.R

/**
 * Created by taikifnit on 2017/09/30.
 */

class ChatAdapter(chats: Array<String>): RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    val chats = chats

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var textView: TextView = itemView.findViewById(R.id.chatText)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var view: View = LayoutInflater.from(parent?.context).inflate(R.layout.chat_recyclerview_cell, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val h = holder ?: return
        h.textView.text = chats[position]
    }

    override fun getItemCount(): Int = chats.count()
}