package com.example.trybeforeapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trybeforeapp.Controller.SignInActivity
import com.example.trybeforeapp.Controller.SignUpActivity
import kotlinx.android.synthetic.main.fragment_fourth.*


class FourthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //On sign in button click
        profileSignInButton.setOnClickListener {
            val intent = Intent(view.context, SignInActivity::class.java)
            startActivity(intent)
        }

        //On sign up button click
        profileSignUpButton.setOnClickListener {
            val intent = Intent(view.context, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}