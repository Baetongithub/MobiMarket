package kg.mamafo.mobimarket.presentation.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.window.OnBackInvokedDispatcher
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.BuildCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kg.mamafo.mobimarket.R
import kg.mamafo.mobimarket.databinding.ActivityMainBinding
import kg.mamafo.mobimarket.presentation.utils.Constants

class MainActivity : AppCompatActivity() {

    private lateinit var vb: ActivityMainBinding

    @SuppressLint("UnsafeOptInUsageError")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(0, 0)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)

        val navView: BottomNavigationView = vb.bottomNavigationView
        vb.bottomNavigationView.background = null
        navView.menu.getItem(2).isEnabled = false

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            val list = arrayListOf<Int>()
            list.add(R.id.navigation_home)
            list.add(R.id.navigation_wallet)
            list.add(R.id.navigation_chats)
            list.add(R.id.profileFragment)
            if (list.contains(destination.id)) {
                vb.bottomAppBar.visibility = VISIBLE
                vb.fab.show()
            } else {
                vb.bottomAppBar.visibility = GONE
                vb.fab.hide()
            }
        }

//        if user == null дальше не пусткать
        val sharedPrefs = getSharedPreferences(Constants.SHARED_PREFS_SIGNED_UP, MODE_PRIVATE)
        val userSignedUp = sharedPrefs.getBoolean(Constants.PREFS_SIGNED_UP, false)
        if (!userSignedUp) {
            navController.navigate(R.id.loginFragment)
            if (BuildCompat.isAtLeastT()) {
                onBackInvokedDispatcher.registerOnBackInvokedCallback(
                    OnBackInvokedDispatcher.PRIORITY_DEFAULT
                ) {
                    finish()
                }
            } else {
                onBackPressedDispatcher.addCallback(this) {
                    finish()
                }
            }
        }
        navView.setupWithNavController(navController)

        //add products
        vb.fab.setOnClickListener {
            findNavController(R.id.nav_host_fragment_activity_main).navigate(R.id.addProductFragment)
        }
    }
}