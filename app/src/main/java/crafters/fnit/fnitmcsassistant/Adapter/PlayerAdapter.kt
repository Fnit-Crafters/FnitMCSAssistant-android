package crafters.fnit.fnitmcsassistant.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import crafters.fnit.fnitmcsassistant.DataClass.Player
import crafters.fnit.fnitmcsassistant.R

/**
 * Created by taikifnit on 2017/09/30.
 */

class PlayerAdapter(playerSet: Array<Player>): RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {

    val playerSet: Array<Player> = playerSet

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var playerName: TextView = itemView.findViewById(R.id.playerName)
        var playerIcon: ImageView = itemView.findViewById(R.id.playerIcon)

        companion object Factory {
            fun create(view: RelativeLayout): ViewHolder = ViewHolder(view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        print("fnit")
        print(parent)
        var view: View = LayoutInflater.from(parent?.context).inflate(R.layout.player_recyclerview_cell, parent, false)
        val viewHolder = ViewHolder(view)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder ?: return
        holder.playerName.text = playerSet[position].name
    }

    override fun getItemCount(): Int = playerSet.size
}