package com.example.davidwhyte.safehouse

import android.app.AlertDialog
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidwhyte.safehouse.Model.Payout
import kotlinx.android.synthetic.main.investment_history_list.view.*
import kotlinx.android.synthetic.main.payout_history_list.view.*

class PayoutHistoryAdapter(val items:ArrayList<Payout>,val context: Context):RecyclerView.Adapter<PayoutHistoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view= LayoutInflater.from(p0.context).inflate(R.layout.payout_history_list,p0,false) as ConstraintLayout
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.payout_h_amount.text=items[position].amount
        holder.view.payout_h_date.text=items[position].date
        holder.view.setOnClickListener {
            Log.v("Inv","clicked")
            val builder= AlertDialog.Builder(context)
            builder.setMessage("This investment of"+items[position].amount+" was made on "+items[position].date+" ")
            builder.show()
        }
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}