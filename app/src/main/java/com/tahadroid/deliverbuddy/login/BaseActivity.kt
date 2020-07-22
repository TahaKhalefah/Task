package com.tahadroid.deliverbuddy.login

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tahadroid.deliverbuddy.R

open class BaseActivity : AppCompatActivity() {
    private var progressDialog: ProgressDialog? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

    }

    fun showDialog(context: Context){
        progressDialog=  ProgressDialog.show(context,"Loading .. ","Wait untill finish")
    }
    fun hideDialog(context: Context){
        progressDialog?.let {
            if(it.isShowing){
                it.dismiss()
            }
        }
    }
}