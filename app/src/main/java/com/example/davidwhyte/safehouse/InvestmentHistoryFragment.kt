package com.example.davidwhyte.safehouse


import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidwhyte.safehouse.Model.InvestmentHistory


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var recyclerView: RecyclerView
private lateinit var viewAdapter: RecyclerView.Adapter<*>
private lateinit var viewManager: RecyclerView.LayoutManager
/**
 * A simple [Fragment] subclass.
 *
 */
class InvestmentHistoryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_investment_history, container, false)
        displayHistory(view)
        return view
    }

    fun displayHistory(view:View){
        viewManager= LinearLayoutManager(view.context)
        val recordList=ArrayList<InvestmentHistory>()
        var record=InvestmentHistory()
        record.amount=(2000).toString()
        record.date="2/17/2018"
        recordList.add(record)
        var record2=InvestmentHistory()
        record2.amount=(4000).toString()
        record2.date="2/17/2015"
        recordList.add(record2)
        viewAdapter=InvestmentHistoryAdapter(recordList,view.context)
        recyclerView=view.findViewById<RecyclerView>(R.id.investment_history_rv).apply {
            layoutManager=viewManager
            adapter=viewAdapter
        }
    }

    @SuppressLint("ValidFragment")
    inner class InvestmentH(view:View):DialogFragment(){
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val builder=AlertDialog.Builder(view?.context)
            return super.onCreateDialog(savedInstanceState)

        }

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//            return super.onCreateView(inflater, container, savedInstanceState)
            val view=inflater.inflate(R.layout.investment_fragment,container,false)

            return view
        }

    }
}
