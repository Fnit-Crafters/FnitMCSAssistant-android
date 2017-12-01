package crafters.fnit.fnitmcsassistant.Adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.request.RequestOptions
import crafters.fnit.fnitmcsassistant.Adapter.DataClass.Player
import crafters.fnit.fnitmcsassistant.GlideApp
import crafters.fnit.fnitmcsassistant.R
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by taikifnit on 2017/09/30.
 */

class PlayerAdapter(playerSet: Array<Player>): RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {

    val playerSet: Array<Player> = playerSet

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var playerName: TextView = itemView.findViewById(R.id.playerName)
        var playerIcon: ImageView = itemView.findViewById(R.id.playerIcon)
        var status: TextView = itemView.findViewById(R.id.status)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var view: View = LayoutInflater.from(parent?.context).inflate(R.layout.player_recyclerview_cell, parent, false)
        Log.i("Fnit", view.toString())

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        Log.i("Fnit", "onBindViewHolder:" + holder.toString())
        val h = holder ?: return
        val player = playerSet[position]

        h.playerName.text = player.name
        GlideApp.with(h.itemView).load(player.urlString).apply(RequestOptions.circleCropTransform()).into(h.playerIcon)
        var statusMessage: String

        if (player.isOnline) {
            h.status.text = "Online"
            h.status.setTextColor(Color.rgb(66, 165, 243))
        } else {

            val statusText: String = player.lastLogin?.let {
                val date: Date = Date(it)
                val sdf = SimpleDateFormat("yyyy/MM/dd")
                sdf.timeZone = TimeZone.getTimeZone("GMT+9")
                "Last Login: " + sdf.format(date)
            } ?: "Offline"

            h.status.text = statusText
            h.status.setTextColor(Color.GRAY)
        }
    }

    override fun getItemCount(): Int = playerSet.size
}