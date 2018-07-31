package com.example.davidwhyte.safehouse

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class InvestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invest)
        //investment spiner
        val investment_sp:Spinner=findViewById<Spinner>(R.id.investment_spinner)
        val adapter=ArrayAdapter.createFromResource(this,R.array.investment_plans,android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        investment_sp.adapter=adapter



        val paym_sp:Spinner=findViewById<Spinner>(R.id.paymethod_spinner)
        val adapter2=ArrayAdapter.createFromResource(this,R.array.payment_methods,android.R.layout.simple_spinner_item)
        paym_sp.adapter=adapter2

        //validation
        val btn_invest=findViewById<Button>(R.id.btn_invest)
        btn_invest.setOnClickListener {
            validate()
        }
    }

    fun validate(){
        val f_amount=findViewById<EditText>(R.id.f_amount)
        val err_amount=findViewById<TextView>(R.id.err_amount)
        var v=true
        if(f_amount.text.isEmpty()){
            err_amount.visibility=View.VISIBLE
            err_amount.text=getString(R.string.err_amount_r)
            v=false
        }
        else{
            err_amount.visibility=View.INVISIBLE
            v=true
        }
    }

}
