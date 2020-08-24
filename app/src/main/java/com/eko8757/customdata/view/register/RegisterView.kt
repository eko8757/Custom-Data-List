package com.eko8757.customdata.view.register

interface RegisterView {

    fun checkDataRegister() {

    }

    fun putDataRegister(nama: String, email: String, password: String) {

    }

    interface presenter {
        fun putDataRegister(nama: String, email: String, password: String) {

        }
    }
}