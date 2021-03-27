package com.example.trybeforeapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.trybeforeapp.Controller.MainActivity
import com.example.trybeforeapp.Controller.SignInActivity
import com.example.trybeforeapp.Controller.SignUpActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_fourth.*


class FourthFragment : Fragment() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDataBase: DatabaseReference
    private lateinit var userID: String
    private lateinit var mUser: FirebaseUser
    private lateinit var name: TextView
    private lateinit var lastName: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Initializing variables

        /**
         *  HERE WE ARE GOING TO CREATE A LOGIC
         *  OF PARSING DATA FROM FIREBASE
         *  TO USER PROFILE PAGE!!!
         *
         *  NOT READY YET!!!!!!!!!!
         * */
        mAuth = FirebaseAuth.getInstance()
        mUser = FirebaseAuth.getInstance().currentUser!!
        mDataBase = FirebaseDatabase.getInstance().getReference("Users")
        userID = mUser.uid

        name = userFirstName
        lastName = userLastName

        mDataBase.child(userID).addListenerForSingleValueEvent( ){

        }


        //Sign Out button click action
        signOut.setOnClickListener {
            mAuth.signOut()

            val mainActivityIntent = Intent(view.context, MainActivity::class.java)
            startActivity(mainActivityIntent)
        }
    }
}