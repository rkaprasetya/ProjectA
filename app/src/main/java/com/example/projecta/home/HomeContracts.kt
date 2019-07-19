package com.example.projecta.home

import com.example.projecta.base.BaseContracts

interface HomeContracts {
    interface presenter{
        fun sendNotif()
        fun getCircle()

    }
    interface view: BaseContracts.view{
        fun startNotifThread()
        fun openMapActivity()
    }
    interface repository{

    }
}