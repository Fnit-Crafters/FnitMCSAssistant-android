package crafters.fnit.fnitmcsassistant.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import crafters.fnit.fnitmcsassistant.Adapter.DataClass.Player
import crafters.fnit.fnitmcsassistant.R

/**
 * Created by taikifnit on 2017/09/30.
 */

class PlayerAdapter(playerSet: Array<Player>): RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {

    val playerSet: Array<Player> = playerSet

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var playerName: TextView = itemView.findViewById(R.id.playerName)
        var playerIcon: ImageView = itemView.findViewById(R.id.playerIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var view: View = LayoutInflater.from(parent?.context).inflate(R.layout.player_recyclerview_cell, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val h = holder ?: return
        h.playerName.text = playerSet[position].name
    }

    override fun getItemCount(): Int = playerSet.size
}