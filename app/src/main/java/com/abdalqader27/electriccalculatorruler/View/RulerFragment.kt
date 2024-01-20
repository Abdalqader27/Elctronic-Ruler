package com.abdalqader27.electriccalculatorruler.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdalqader27.electriccalculatorruler.Adapter.RulerAdapterItem
import com.abdalqader27.electriccalculatorruler.Data.RulerData
import com.abdalqader27.electriccalculatorruler.Models.RulerItem
import com.abdalqader27.electriccalculatorruler.R
import com.abdalqader27.electriccalculatorruler.databinding.FragmentRulerBinding


class RulerFragment : Fragment() {
    private var types = arrayOf("simple User", "Admin")
    var index: Int = 0
    private val data = RulerData.arrayOfData
    private lateinit var fragmentView: View
    private lateinit var spinner: Spinner
    private lateinit var kwRadioType: RadioButton
    private lateinit var hpRadioType: RadioButton
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentView = inflater.inflate(R.layout.fragment_ruler, container, false)

        spinner = fragmentView.findViewById(R.id.spinner)
        kwRadioType =fragmentView.findViewById(R.id.kwRadioType)
        hpRadioType=fragmentView.findViewById(R.id.hpRadioType)
        recyclerView = fragmentView.findViewById(R.id.recyclerview_ruler)





        kwRadioType.setOnClickListener {
            types = data[0]
            setSpinner()
        }
        hpRadioType.setOnClickListener {
            types = data[1]
            setSpinner()
        }

        return fragmentView
    }

    override fun onResume() {
        super.onResume()
        kwRadioType.isChecked = true
        types = data.first()
        setSpinner()

    }

    private fun setSpinner() {
        spinner.adapter =
            ArrayAdapter(fragmentView.context, R.layout.spinner_item, types) as SpinnerAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                index = position
                setRecyclerView()
            }

        }
    }

    private fun itemArrayList(arr: Array<Array<String>>, index: Int): ArrayList<RulerItem> {
        val list = ArrayList<RulerItem>()
        var item = RulerItem(arr[0][index], "استطاعة المحرك KW", "PN")
        list.add(item)
        item = RulerItem(arr[1][index], "استطاعة المحرك HP", "PN")
        list.add(item)
        item = RulerItem(arr[2][index], "شدة التيار المحرك", "IN")
        list.add(item)
        item = RulerItem(arr[3][index], "شدة تيار الفاصمة", "A")
        list.add(item)
        item = RulerItem(arr[4][index], "القاطع الألي", "A")
        list.add(item)
        item = RulerItem(arr[5][index], "عيار الريليه الحرارية", "A")
        list.add(item)
        item = RulerItem(arr[6][index], "سطح مقطع السلك", "mm")
        list.add(item)
        item = RulerItem(arr[7][index], "مسافة سلك النحاس", "cu")
        list.add(item)
        return list

    }

    private fun setRecyclerView(
    ) {
        val rulerList = itemArrayList(data, index)
        val adapter = RulerAdapterItem(rulerList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(fragmentView.context)
        recyclerView.setHasFixedSize(true)


    }

}