package com.id6130201483.ass06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            addFragment(MainFragment())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.character_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_boy -> {
                replaceFragment(BoyFragment())
                return true
            }
            R.id.menu_girl -> {
                replaceFragment(GirlFragment())
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().add(
            R.id.frameLayout,
            fragment
        ).commit()
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(
            R.id.frameLayout,
            fragment
        ).addToBackStack(null).commit()
    }
}