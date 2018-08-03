package com.example.davidwhyte.safehouse


import android.os.Bundle
import android.support.v4.app.Fragment
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
class ChangepassFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_changepass, container, false)
        val btn_change_pass=view.findViewById<Button>(R.id.btn_change_pass)
        btn_change_pass.setOnClickListener {
            validate()
        }
        return view
    }

    fun validate(){
        val current_pass=activity?.findViewById<EditText>(R.id.f_current_pass)
        val new_pass=activity?.findViewById<EditText>(R.id.f_new_pass)
        val conf_pass=activity?.findViewById<EditText>(R.id.f_confirm_pass)

        var v=1
        val err_current_pass=activity?.findViewById<TextView>(R.id.err_current_pass)
        val err_new_pass=activity?.findViewById<TextView>(R.id.err_new_pass)
        val err_conf_pass=activity?.findViewById<TextView>(R.id.err_confirm_pass)

        if(current_pass?.text!!.isEmpty()){
            v=0
            err_current_pass?.visibility=View.VISIBLE
        }else{
            err_current_pass?.visibility=View.INVISIBLE
        }

        if(new_pass?.text!!.isEmpty()){
            v=0
            err_new_pass?.visibility=View.VISIBLE
        }
        else{
            err_new_pass?.visibility=View.INVISIBLE
        }

        if(conf_pass?.text!!.isEmpty()){
            v=0
            err_conf_pass?.visibility=View.VISIBLE
        }
        else{
            err_conf_pass?.visibility=View.INVISIBLE
        }
    }


}
