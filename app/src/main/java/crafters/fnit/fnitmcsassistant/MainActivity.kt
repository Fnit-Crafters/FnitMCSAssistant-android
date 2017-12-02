package crafters.fnit.fnitmcsassistant

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ActionBarを設定
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.titlebar)

        // 初期に表示されるFragmetnの表示
        setFragment(R.id.fragment_home)

        // NavigationBarの設定
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
    }

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
}
