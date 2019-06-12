package com.example.projecta.home

import com.example.projecta.base.BaseContracts

interface HomeContracts {
    interface presenter{
        fun sendNotif()

    }
    interface view: BaseContracts.view{
        fun startNotifThread()
    }
    interface repository{

    }
}