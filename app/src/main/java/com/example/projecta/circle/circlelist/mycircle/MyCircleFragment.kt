package com.example.projecta.circle.circlelist.mycircle

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.projecta.R
import com.example.projecta.firebase.authentication.FirebaseAuthenticationManager
import com.example.projecta.firebase.database.FirebaseDatabaseManager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MyCircleFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MyCircleFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MyCircleFragment : Fragment(), MyCircleContracts.view {

    // TODO: Rename and change types of parameters
    var presenter : MyCirclePresenterImpl = MyCirclePresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.getCircle()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_circle, container, false)

    }

    override fun showCreateCirclePopup() {

    }


}
