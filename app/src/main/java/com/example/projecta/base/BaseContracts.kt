package com.example.projecta.base

import android.app.AlertDialog

interface BaseContracts {
    interface view{
        fun openSettingsActivity()
        var dialog:AlertDialog
    }
    interface presenter{

    }
    interface repository{

    }
}