package com.eko8757.customdata.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.eko8757.customdata.R
import com.eko8757.customdata.utils.StaticString
import com.eko8757.customdata.view.login.LoginActivity
import com.eko8757.customdata.view.main.MainActivity
import com.pixplicity.easyprefs.library.Prefs

class SplashActivity : AppCompatActivity() {

    private var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handler = Handler()
        handler!!.postDelayed(runnable, 2000)
    }

    internal val runnable : Runnable = Runnable {
        if (!isFinishing) {
            val uid = Prefs.getString(StaticString().UUID, "")
            if (uid != "") {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }

    override fun onDestroy() {

        if (handler != null) {
            handler!!.removeCallbacks(runnable)
        }

        super.onDestroy()
    }
}