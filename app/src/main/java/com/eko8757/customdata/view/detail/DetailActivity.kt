package com.eko8757.customdata.view.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.eko8757.customdata.R
import com.eko8757.customdata.presenter.data.PresenterDetail
import com.eko8757.customdata.utils.Constants
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailView {

    private lateinit var presenter: DetailView.presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        presenter = PresenterDetail(this)
        getData()

    }

    override fun getData() {
        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            presenter.extractData(applicationContext, bundle.getParcelable("DataList")!!)
        }
    }

    override fun showData(image: String, title: String, desc: String) {
        Glide.with(applicationContext).load(Constants.IMAGE_PATH + image).into(img_detail)
        tv_title_detail.text = title
        tv_desc_detail.text = desc
    }
}