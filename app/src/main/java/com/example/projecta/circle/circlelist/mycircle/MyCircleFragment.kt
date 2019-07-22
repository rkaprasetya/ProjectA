package com.example.projecta.circle.circlelist.mycircle


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projecta.R
import com.example.projecta.circle.circlelist.newfriend.NewFriendActivity
import kotlinx.android.synthetic.main.fragment_my_circle.*
import kotlinx.android.synthetic.main.fragment_my_circle.view.*

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
class MyCircleFragment : Fragment(), MyCircleContracts.view, View.OnClickListener {


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

        val view : View =inflater.inflate(R.layout.fragment_my_circle, container, false)
        initView(view)

        return view

    }

    private fun initView(view : View){
        view.btn_add_friends.setOnClickListener(this)
    }

    override fun showCreateCirclePopup() {

    }
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_add_friends -> openSearchFriend()
        }
    }

    private fun openSearchFriend() {
        val intent = Intent(activity,NewFriendActivity::class.java)
        activity!!.startActivity(intent)
    }


}
