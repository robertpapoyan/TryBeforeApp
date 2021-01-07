package com.example.trybeforeapp.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.trybeforeapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth
    lateinit var referenceUsers: DatabaseReference
    var currentUserID: String = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        mAuth = FirebaseAuth.getInstance()
    }



    fun createUserButtonClicked(view: View){
        //Variables creation which contain information from fields
        val emailField = createUserEmailText.text.toString()
        val passwordField = createUserPasswordText.text.toString()
        val firstName = createUserFirstNameText.text.toString()
        val lastName = createUserLastNameText.text.toString()


        //Validations
        /**NEEDS TO BE CORRRECTED AND IMPROVED**/
        if (emailField.isEmpty() || passwordField.isEmpty()) {
            Toast.makeText(this, "Please fill the form correctly",Toast.LENGTH_SHORT).show()
        } else if (!emailField.contains("@", false )||!emailField.contains(".",true)){
            Toast.makeText(this, "Please fill the form correctly",Toast.LENGTH_SHORT).show()
        }
        else {
            //Registration logic
            mAuth.createUserWithEmailAndPassword(emailField, passwordField)
                .addOnCompleteListener {task ->
                    if (task.isSuccessful){
                        currentUserID = mAuth.currentUser!!.uid
                        referenceUsers = FirebaseDatabase.getInstance()
                            .reference.child("Users").child(currentUserID)

                        //Data that is being saved into the DB
                        val userHashMap = HashMap<String, Any>()
                        userHashMap["uid"] = currentUserID
                        userHashMap["userFirstName"] = firstName
                        userHashMap["userLastName"] = lastName
                        userHashMap["userEmail"] = emailField
                        userHashMap["userPassword"] = passwordField

                        referenceUsers.updateChildren(userHashMap)
                            .addOnCompleteListener { task ->

                                //In case if creation is successful the user is being relocated to User profile page
                                if (task.isSuccessful) {

                                    val loggedInUserProfilePage = Intent(this, LoggedInUserProfilePage::class.java)
                                    startActivity(loggedInUserProfilePage)
                                }
                            }
                    } else {
                        Toast.makeText(this, "something went wrong you prick", Toast.LENGTH_LONG).show()
                    }
                }
        }

    }
}