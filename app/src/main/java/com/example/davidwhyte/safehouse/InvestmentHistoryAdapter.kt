package com.example.davidwhyte.safehouse

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import com.example.davidwhyte.safehouse.Model.InvestmentHistory
import kotlinx.android.synthetic.main.investment_history_list.view.*

class InvestmentHistoryAdapter(val items:ArrayList<InvestmentHistory>,val context: Context):RecyclerView.Adapter<InvestmentHistoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view= LayoutInflater.from(p0.context).inflate(R.layout.investment_history_list,p0,false) as ConstraintLayout
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.inv_h_amount.text=items[position].amount
        holder.view.inv_h_date.text=items[position].date
        holder.view.setOnClickListener {
            Log.v("Inv","clicked")
           val builder=AlertDialog.Builder(context)
            builder.setMessage("This investment of"+items[position].amount+" was made on "+items[position].date+" ")
            builder.show()
        }
//        holder.view.record_date.text=items[position].date

    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
    @SuppressLint("ValidFragment")
    inner class InvestmentH: DialogFragment(){
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val builder= AlertDialog.Builder(view?.context)
            return super.onCreateDialog(savedInstanceState)

        }

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//            return super.onCreateView(inflater, container, savedInstanceState)
            val view=inflater.inflate(R.layout.investment_fragment,container,false)

            return view
        }

    }
}