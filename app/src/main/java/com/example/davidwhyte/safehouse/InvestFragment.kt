package com.example.davidwhyte.safehouse


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class InvestFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_invest, container, false)
        //investment spiner
        val investment_sp: Spinner =view.findViewById<Spinner>(R.id.investment_spinner)
        val adapter= ArrayAdapter.createFromResource(view.context,R.array.investment_plans,android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        investment_sp.adapter=adapter



        val paym_sp: Spinner =view.findViewById<Spinner>(R.id.paymethod_spinner)
        val adapter2= ArrayAdapter.createFromResource(view.context,R.array.payment_methods,android.R.layout.simple_spinner_item)
        paym_sp.adapter=adapter2

        val btn_invest=view.findViewById<Button>(R.id.btn_invest)
        btn_invest.setOnClickListener {
            validate()
        }
        return view

    }

    fun validate(){
        val f_amount=view?.findViewById<EditText>(R.id.f_amount)
        val err_amount=view?.findViewById<TextView>(R.id.err_amount)
        var v=true
        if(f_amount?.text!!.isEmpty()){
            err_amount?.visibility=View.VISIBLE
            err_amount?.text=getString(R.string.err_amount_r)
            v=false
        }
        else{
            err_amount?.visibility=View.INVISIBLE
            v=true
        }
    }


}
