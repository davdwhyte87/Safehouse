package com.example.davidwhyte.safehouse

import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val login_btn=findViewById<Button>(R.id.btn_login)
        login_btn.setOnClickListener {
            validation()
        }
    }

    fun validation(){
        val f_email=findViewById<EditText>(R.id.f_email)
        val f_pass=findViewById<EditText>(R.id.f_pass)
        val err_email=findViewById<TextView>(R.id.err_mail)
        val err_pass=findViewById<TextView>(R.id.err_pass)
        val max_mail=5
        val max_pass=5
        var v=0
        //check for empty fields
        if(f_email.text.isEmpty()){
            err_email.visibility=View.VISIBLE
            v=0
        }
        else{
            err_email.visibility=View.INVISIBLE
            v=1
            if(f_email.text.count()<max_mail){
                err_email.visibility=View.VISIBLE
                err_email.text=getString(R.string.err_mail_l)
                v=0
            }
            else{
                err_email.visibility=View.INVISIBLE
                v=1
            }
        }
        if(f_pass.text.isEmpty()){
            err_pass.visibility=View.VISIBLE
            v=0
        }else{
            err_pass.visibility=View.INVISIBLE
            v=1

            if(f_pass.text.count()<max_pass){
                err_pass.visibility=View.VISIBLE
                err_pass.text=getString(R.string.err_pass_l)
                v=0
            }
            else{
                err_email.visibility=View.INVISIBLE
                v=1
            }
        }
        //check for small fields

    }
}
