package com.tahadroid.deliverbuddy.login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.tahadroid.deliverbuddy.R
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : BaseActivity() {
    private lateinit var auth: FirebaseAuth
    private val TAG = "RegisterActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = FirebaseAuth.getInstance()
        registerButton.setOnClickListener {
            if(isValidForm()) {
                registerUser()
            }
        }

    }

    private fun isValidForm(): Boolean {
        if(TextUtils.isEmpty((registerEmailEditText.text))){
            registerEmailEditText.setError(getString(R.string.not_valid_email))
            return false
        }
        if(TextUtils.isEmpty((registerPasswordEditText.text))){
            registerPasswordEditText.setError(getString(R.string.not_valid_password))
            return false
        }
        if(registerPasswordEditText.text.toString().length < 6){
            registerPasswordEditText.setError(getString(R.string.not_valid_password))
            return false
        }
        return true
    }

    private fun registerUser() {
       showDialog(this)
        val email = registerEmailEditText.text.toString()
        val password = registerPasswordEditText.text.toString()
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    hideDialog(this)
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    Toast.makeText(
                        baseContext, "Account Created Successfully );",
                        Toast.LENGTH_SHORT
                    ).show()
                    val userId = auth.currentUser
                    updateUI(userId)
                } else {
                    hideDialog(this)
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }

                // ...
            }

    }

    private fun updateUI(user: FirebaseUser?) {
        if (user !== null) {
            val intent = Intent(this@RegisterActivity, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}