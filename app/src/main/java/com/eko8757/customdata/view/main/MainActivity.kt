package com.eko8757.customdata.view.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.eko8757.customdata.R
import com.eko8757.customdata.adapter.AdapterData
import com.eko8757.customdata.model.data.ResultData
import com.eko8757.customdata.presenter.data.PresenterData
import com.eko8757.customdata.service.BaseApi
import com.eko8757.customdata.utils.StaticString
import com.eko8757.customdata.utils.gone
import com.eko8757.customdata.utils.visible
import com.eko8757.customdata.view.detail.DetailActivity
import com.eko8757.customdata.view.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.pixplicity.easyprefs.library.Prefs
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity(), DataView, MainView, AdapterData.OnItemClickListener {

    private lateinit var auth: FirebaseAuth
    private lateinit var adapter: AdapterData
    private lateinit var presenter: PresenterData
    private lateinit var dataGlobal: ArrayList<ResultData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        val factory: BaseApi = BaseApi.create()
        presenter = PresenterData(this, this, factory)
        presenter.getList()
    }

    override fun showLoading() {
        progressBar_list.visible()
    }

    override fun hideLoading() {
        progressBar_list.gone()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_logout, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.logout -> logout()
        }
        return true
    }

    private fun logout() {
        Prefs.remove(StaticString().UUID)
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }


    override fun showDataList(data: ArrayList<ResultData>) {
        adapter = AdapterData(data)
        rv_list.layoutManager = LinearLayoutManager(this)
        rv_list.adapter = adapter
        adapter.setOnItemClickListener(this)
        adapter.notifyDataSetChanged()
        this.dataGlobal = data
    }

    override fun onItemClick(position: Int) {
        val i = Intent(this, DetailActivity::class.java)
        i.putExtra("DataList", dataGlobal[position])
        startActivity(i)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}