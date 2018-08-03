package com.example.davidwhyte.safehouse


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AccountdetailsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_accountdetails, container, false)
        val update_details=view.findViewById<Button>(R.id.btn_update_details)
        update_details?.setOnClickListener {
            Log.v("botton click","clicked")
            validate()
        }
        return view

    }

    fun chains(){

    }

    fun validate(){
        val f_bank_name=activity?.findViewById<EditText>(R.id.f_bank_name)
        val f_acc_name=activity?.findViewById<EditText>(R.id.f_acc_name)
        val f_acc_number=activity?.findViewById<EditText>(R.id.f_acc_number)

        var v=1
        val err_bank_name=activity?.findViewById<TextView>(R.id.err_bank_name)
        val err_acc_name=activity?.findViewById<TextView>(R.id.err_acc_name)
        val err_acc_number=activity?.findViewById<TextView>(R.id.err_acc_number)

        if(f_bank_name?.text!!.isEmpty()){
            err_bank_name?.visibility=View.VISIBLE
            v=0
        }
        else{
            err_bank_name?.visibility=View.INVISIBLE
        }

        if(f_acc_name?.text!!.isEmpty()){
            err_acc_name?.visibility=View.VISIBLE
            v=0
        }
        else{
            err_acc_name?.visibility=View.INVISIBLE
        }

        if(f_acc_number?.text!!.isEmpty()){
            err_acc_number?.visibility=View.VISIBLE
        }
        else{
            err_acc_number?.visibility=View.INVISIBLE
        }
        Log.v("validation",v.toString())
    }


}
