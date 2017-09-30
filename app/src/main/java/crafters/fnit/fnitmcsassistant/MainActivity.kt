package crafters.fnit.fnitmcsassistant

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import crafters.fnit.fnitmcsassistant.Adapter.PlayerAdapter
import crafters.fnit.fnitmcsassistant.DataClass.Player

class MainActivity : AppCompatActivity() {

    val samplePlayers : Array<Player> = arrayOf(Player("Fnit", null), Player("Taiki", null))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playersRecyclerView = findViewById(R.id.playersRecyclerView) as? RecyclerView ?: return
        playersRecyclerView.setHasFixedSize(true)

        playersRecyclerView.layoutManager = LinearLayoutManager(this)

        val playerAdapter = PlayerAdapter(samplePlayers)

        playersRecyclerView.adapter = playerAdapter
    }
}
