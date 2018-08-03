package com.example.davidwhyte.safehouse


import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ProfileprFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_profilepr, container, false)
        val paym_sp: Spinner =view.findViewById<Spinner>(R.id.f_state)
        val adapter2= ArrayAdapter.createFromResource(view.context,R.array.states,android.R.layout.simple_spinner_item)
        paym_sp.adapter=adapter2

        val f_bdate=view.findViewById<EditText>(R.id.f_bdate)
        var cal=java.util.Calendar.getInstance()
        val dateSetListener=object :DatePickerDialog.OnDateSetListener{
            override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
                cal.set(java.util.Calendar.YEAR,year)
                cal.set(java.util.Calendar.MONTH,month)
                cal.set(java.util.Calendar.DAY_OF_MONTH,day)
                f_bdate.setText(day.toString()+"/"+month.toString()+"/"+year.toString())
            }
        }
        f_bdate.setOnClickListener {
            DatePickerDialog(view.context,dateSetListener,
                    cal.get(java.util.Calendar.YEAR),
                    cal.get(java.util.Calendar.MONTH),
                    cal.get(java.util.Calendar.DAY_OF_MONTH)).show()
        }
        return view
    }



}
