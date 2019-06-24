package com.example.projecta.settings

interface SettingsContracts {
    interface view{
        fun openLoginActivity()
    }
    interface presenter{
        fun signOut()
        fun onDestroy()
    }
    interface repository{

    }
}