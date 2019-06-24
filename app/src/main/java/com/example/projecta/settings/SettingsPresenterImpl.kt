package com.example.projecta.settings

import com.example.projecta.firebase.authentication.FirebaseAuthenticationManager

class SettingsPresenterImpl(var view: SettingsContracts.view?):SettingsContracts.presenter {
    override fun onDestroy() {
        view = null
    }

    override fun signOut() {
        val auth = FirebaseAuthenticationManager()
        auth.logout()
        view?.openLoginActivity()
    }
}