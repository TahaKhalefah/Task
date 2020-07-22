package com.tahadroid.deliverbuddy.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.tahadroid.deliverbuddy.R
import com.tahadroid.deliverbuddy.views.home.HomeActivity

import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : BaseActivity() {

    private lateinit var auth: FirebaseAuth
    private val TAG = "RegisterActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        auth = FirebaseAuth.getInstance()
        loginButton.setOnClickListener {
            if (isValidForm()) {
                signInUser()
            }
        }

    }

    private fun isValidForm(): Boolean {
        if (TextUtils.isEmpty((emailEditText.text))) {
            emailEditText.setError(getString(R.string.not_valid_email))
            return false
        }
        if (TextUtils.isEmpty((passwordEditText.text))) {
            passwordEditText.setError(getString(R.string.not_valid_password))
            return false
        }
        if (passwordEditText.text.toString().length < 6) {
            passwordEditText.setError(getString(R.string.not_valid_password))
            return false
        }
        return true
    }

    private fun signInUser() {
        showDialog(this)
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        auth.signInWithEmailAndPassword(email, password)
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
            val intent = Intent(this@SignInActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}