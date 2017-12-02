package crafters.fnit.fnitmcsassistant

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import crafters.fnit.fnitmcsassistant.Adapter.DataClass.Player
import crafters.fnit.fnitmcsassistant.Adapter.PlayerAdapter


class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val myView = inflater!!.inflate(R.layout.fragment_home, container, false)

        val playerRecyclerView = myView.findViewById<RecyclerView>(R.id.playerRecycleView)
        playerRecyclerView.setHasFixedSize(true)
        playerRecyclerView.layoutManager = LinearLayoutManager(activity)
        adaptPlayers(playerRecyclerView)

        return myView
    }

    fun adaptPlayers(playerRecyclerView: RecyclerView) {

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

                playerRecyclerView.adapter = playerAdapter

                playerAdapter.setOnItemClickListener(object: View.OnClickListener {
                    override fun onClick(p0: View?) {
                        p0 ?: return

                        val nameTextView = p0.findViewById<TextView>(R.id.playerName)
                        val name = nameTextView.text
                        Log.i("Fnit", name.toString())

                        val playerDetailActivity = PlayerDetailActivity()
                        val intent = Intent(activity, playerDetailActivity.javaClass)

                        val bundle = Bundle()
                        bundle.putString("playerName", name.toString())
                        intent.putExtras(bundle)

                        startActivity(intent)
                    }
                })
            }

            override fun onCancelled(error: DatabaseError?) {
                Log.w("onCancelled", "error: ${error}")
            }
        })
    }

    companion object {

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}
