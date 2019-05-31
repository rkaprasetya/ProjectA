package com.example.projecta.base

import android.app.AlertDialog

interface BaseContracts {
    interface view{
        fun openLogoutDialog()
        var dialog:AlertDialog
    }
    interface presenter{

    }
    interface repository{

    }
}