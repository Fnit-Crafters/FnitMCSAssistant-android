package crafters.fnit.fnitmcsassistant

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    fun setFragment(id: Int) {

        var fragment: Fragment? = null

        when (id) {
            R.id.fragment_home -> {
                fragment = HomeFragment.newInstance()
            }

            R.id.fragment_chat -> {
                fragment = ChatFragment.newInstance()
            }

            R.id.fragment_setting -> {
                fragment = SettingFragment.newInstance()
            }
        }

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_warpper, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.titlebar)

        setFragment(R.id.fragment_home)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_item -> {
                    setFragment(R.id.fragment_home)
                    true
                }
                R.id.chat_item -> {
                    setFragment(R.id.fragment_chat)
                    true
                }
                R.id.setting_item -> {
                    setFragment(R.id.fragment_setting)
                    true
                }
            }
            false
        }

        // instantiate RecyclerView
//        val playersRecyclerView = findViewById<RecyclerView>(R.id.playersRecyclerView) as? RecyclerView ?: return
//        playersRecyclerView.setHasFixedSize(true)
//        playersRecyclerView.layoutManager = LinearLayoutManager(this)
//
//        val ref = FirebaseDatabase.getInstance().reference
//
//        ref.child("users").addValueEventListener(object : ValueEventListener {
//
//            override fun onDataChange(dataSnapshot: DataSnapshot?) {
//                // snapshotからdataを取り出す
//                dataSnapshot ?: return
//                val playersHash = dataSnapshot.value as? HashMap<String, Any>
//                playersHash ?: return
//
//                var players : MutableList<Player> = mutableListOf()
//
//                // HashのusersをPlayer ModelのArrayにparseする
//                playersHash.values.forEach {
//                    val playerHash = it as? HashMap<String, Any>
//                    playerHash ?: return
//
//                    val name = playerHash["name"] as? String ?: ""
//                    val urlString = "https://minotar.net/avatar/" + name
//                    val isOnline = playerHash["isOnline"] as? Boolean ?: false
//                    val lastLogin = playerHash["lastLogin"] as? Long
//
//                    val player = Player(name, urlString, isOnline, lastLogin)
//
//                    players.add(player)
//                }
//
//                val playerArray = players.toTypedArray()
//
//                // instantiate Adapter
//                val playerAdapter = PlayerAdapter(playerArray)
//
//                playersRecyclerView.adapter = playerAdapter
//            }
//
//            override fun onCancelled(error: DatabaseError?) {
//                Log.w("onCancelled", "error: ${error}")
//            }
//        })
    }
}
