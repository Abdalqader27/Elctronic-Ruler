package com.abdalqader27.electriccalculatorruler.View

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdalqader27.electriccalculatorruler.Adapter.RulerAdapterItem
import com.abdalqader27.electriccalculatorruler.Models.RulerItem
import com.abdalqader27.electriccalculatorruler.R
import com.github.ybq.android.spinkit.SpinKitView
import kotlinx.android.synthetic.main.fragment_ruler.*

class RulerFragment : Fragment() {
    private var types = arrayOf("simple User", "Admin")
    var index: Int = 0
    var spinKit: SpinKitView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView: View = inflater.inflate(R.layout.fragment_ruler, container, false)
        val kwRadio: RadioButton = myView.findViewById(R.id.kwRadio)
        val hpRadio: RadioButton = myView.findViewById(R.id.hpRadio)
        val recyclerView: RecyclerView = myView.findViewById(R.id.reyeclerRuler)
        val arr = Array(9) { arrayOf("") }



        arr[0] = arrayOf(
            "7.5",
            "11",
            "15",
            "18.5",
            "22",
            "30",
            "37",
            "45",
            "55",
            "75",
            "90",
            "110",
            "132",
            "160",
            "200"
        )
        arr[1] = arrayOf(
            "10",
            "15",
            "20",
            "25",
            "30",
            "40",
            "50",
            "60",
            "75",
            "100",
            "125",
            "150",
            "180",
            "220",
            "270"
        )

        arr[2] = arrayOf(
            "16",
            "22",
            "30",
            "37",
            "43",
            "57",
            "72",
            "86",
            "105",
            "140",
            "168",
            "205",
            "245",
            "290",
            "360"
        )

        arr[3] = arrayOf(
            "40",
            "40",
            "63",
            "80",
            "80",
            "100",
            "160",
            "160",
            "200",
            "250",
            "315",
            "400",
            "500",
            "500",
            "600 oder 800"
        )

        arr[4] = arrayOf(
            "25",
            "25",
            "40",
            "40",
            "63",
            "63",
            "100",
            "100",
            "160",
            "160 oder 250",
            "250",
            "250",
            "400",
            "400",
            "630"
        )

        arr[5] = arrayOf(
            "11 - 16",
            "16 - 26",
            "20 - 32",
            "30 - 45",
            "30 - 45",
            "40 - 63",
            "60 - 90",
            "60 - 90",
            "80 - 130",
            "100 - 160",
            "130 - 210",
            "160 - 210",
            "160 - 250",
            "200 - 400",
            "200 - 400"
        )
        arr[6] = arrayOf(
            "4",
            "6",
            "6",
            "10",
            "10",
            "16",
            "25",
            "25",
            "35",
            "50",
            "70",
            "95",
            "120",
            "185",
            "240"
        )
        arr[7] = arrayOf(
            "100",
            "110",
            "80",
            "105",
            "90",
            "100",
            "140",
            "110",
            "120",
            "130",
            "150",
            "175",
            "200",
            "225",
            "250"
        )

        (0..7).forEach { i ->
            println(arr[i][index])
        }

        kwRadio.setOnClickListener {
            types = arr[0]
            setSpinner(myView, arr, recyclerView)
        }
        hpRadio.setOnClickListener {
            types = arr[1]
            setSpinner(myView, arr, recyclerView)
        }

        return myView
    }

    private fun setSpinner(myView: View, arr: Array<Array<String>>, recycler_view: RecyclerView) {
        spinner.adapter =
            ArrayAdapter(myView.context, R.layout.spinner_item, types) as SpinnerAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                println("erreur")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val type = parent?.getItemAtPosition(position).toString()
                index = position
                recycler_view.visibility = View.GONE
                spinKit?.visibility = View.VISIBLE
                Toast.makeText(activity, type, Toast.LENGTH_LONG).show()
                println(type)
                setRecyclerView(arr, recycler_view, myView)
            }

        }
    }

    private fun generateDummyList(arr: Array<Array<String>>, index: Int): ArrayList<RulerItem> {
        val list = ArrayList<RulerItem>()
        var item = RulerItem(arr[0][index], "استطاعة المحرك KW", "PN")
        list.add(item)
        item = RulerItem(arr[1][index], "استطاعة المحرك HP", "PN")
        list.add(item)
        item = RulerItem(arr[2][index], "شدة التيار المرك", "IN")
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
        arr: Array<Array<String>>,
        recycler_view: RecyclerView,
        view: View
    ) {
        val rulerList = generateDummyList(arr, index)
        val adapter = RulerAdapterItem(rulerList)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(view.context)
        recycler_view.setHasFixedSize(true)
        recycler_view.visibility = View.VISIBLE
        spinKit?.visibility = View.GONE


    }
}