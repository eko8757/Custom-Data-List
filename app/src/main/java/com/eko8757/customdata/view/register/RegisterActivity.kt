package com.eko8757.customdata.view.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.eko8757.customdata.R
import com.eko8757.customdata.utils.gone
import com.eko8757.customdata.utils.invisible
import com.eko8757.customdata.utils.visible
import com.eko8757.customdata.view.login.LoginActivity
import com.eko8757.customdata.view.main.MainView
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterView, MainView, View.OnClickListener {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()
        btn_register.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.btn_register -> checkDataRegister()
        }
    }

    override fun showLoading() {
        btn_register.invisible()
        progressBar_register.visible()
    }

    override fun hideLoading() {
        btn_register.visible()
        progressBar_register.gone()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun checkDataRegister() {
        showLoading()
        if (ed_nama_register.text.toString().isNullOrEmpty()) {
            return
            showMessage("Nama tidak boleh kosong..")
        } else {
            if (ed_email_register.text.toString().isNullOrEmpty()) {
                return
                showMessage("Email tidak boleh kosong..")
            } else {
                if (ed_password_register.text.toString().isNullOrEmpty()) {
                    return
                    showMessage("Password tidak boleh kosong")
                } else {
                    putDataRegister(
                        ed_nama_register.text.toString(),
                        ed_email_register.text.toString(),
                        ed_password_register.text.toString()
                    )
                }
            }
        }
    }

    override fun putDataRegister(nama: String, email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->
            if (task.isSuccessful) {
                hideLoading()
                showMessage("Success Register")
                startActivity(Intent(this, LoginActivity::class.java))
            } else {
                hideLoading()
                showMessage("Failed register")
            }
        })
    }
}