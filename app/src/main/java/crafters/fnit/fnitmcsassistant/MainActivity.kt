package crafters.fnit.fnitmcsassistant

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import crafters.fnit.fnitmcsassistant.Adapter.DataClass.Player
import crafters.fnit.fnitmcsassistant.Adapter.PlayerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.titlebar)

        // instantiate RecyclerView
        val playersRecyclerView = findViewById<RecyclerView>(R.id.playersRecyclerView) as? RecyclerView ?: return
        playersRecyclerView.setHasFixedSize(true)
        playersRecyclerView.layoutManager = LinearLayoutManager(this)

        val ref = FirebaseDatabase.getInstance().reference

        ref.child("users").addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                // snapshotからdataを取り出す
                dataSnapshot ?: return
                val playersHash = dataSnapshot.value as? HashMap<String, Any>
                playersHash ?: return

                var players : MutableList<Player> = mutableListOf()

                // HashのusersをPlayer ModelのArrayにparseする
                playersHash.values.forEach {
                    val playerHash = it as? HashMap<String, Any>
                    playerHash ?: return

                    val name = playerHash["name"] as? String ?: ""
                    val urlString = "https://minotar.net/avatar/" + name
                    val isOnline = playerHash["isOnline"] as? Boolean ?: false
                    val lastLogin = playerHash["lastLogin"] as? Long

                    val player = Player(name, urlString, isOnline, lastLogin)

                    players.add(player)
                }

                val playerArray = players.toTypedArray()

                // instantiate Adapter
                val playerAdapter = PlayerAdapter(playerArray)

                playersRecyclerView.adapter = playerAdapter
            }

            override fun onCancelled(error: DatabaseError?) {
                Log.w("onCancelled", "error: ${error}")
            }
        })
    }
}
