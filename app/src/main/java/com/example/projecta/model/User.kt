package com.example.projecta.model

data class User(val id:String, val fullname:String, val email:String, val phoneNumber:String, val password:String){
    constructor():this("","","","","")


}
