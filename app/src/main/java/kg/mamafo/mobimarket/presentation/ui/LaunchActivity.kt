package kg.mamafo.mobimarket.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.mamafo.mobimarket.R
import kg.mamafo.mobimarket.presentation.extensions.toast

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        val thread = Thread {
            try {
                Thread.sleep(800)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } catch (e: InterruptedException) {
                toast(e.message.toString())
            }
        }
        thread.start()
    }
}