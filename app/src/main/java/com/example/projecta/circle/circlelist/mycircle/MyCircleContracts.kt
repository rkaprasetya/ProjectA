package com.example.projecta.circle.circlelist.mycircle

interface MyCircleContracts {
    interface presenter{
        fun getCircle()
    }
   interface view{
        fun showCreateCirclePopup()
   }
}