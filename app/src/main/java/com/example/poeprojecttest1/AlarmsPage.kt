package com.example.poeprojecttest1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class AlarmsPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarms_page)

        var txtNumber1 = findViewById<EditText>(R.id.txtNumber1)
        var btnAddtoArray = findViewById<Button>(R.id.btnAddtoArray)
        var txtFromArray = findViewById<TextView>(R.id.txtFromArray)
        var btnClear = findViewById<Button>(R.id.btnClear)
        var btnAverage = findViewById<Button>(R.id.btnAverage)
        var btnMinMax = findViewById<Button>(R.id.btnMinMax)
        var txtDisAverage = findViewById<TextView>(R.id.txtDisAverage)
        var txtDisMinMax = findViewById<TextView>(R.id.txtDisMinMax)

        val number = ArrayList<String>()

        btnAddtoArray.setOnClickListener {
            if(txtNumber1.text.isNotEmpty()) {
                val addToArray = txtNumber1.text.toString()
                number.add(addToArray)
                txtFromArray.text = ""
                for(num in number) {
                    txtFromArray.append("$num,")
                }
            }
        }

        btnClear.setOnClickListener(){
            txtFromArray.text = ""
            txtDisAverage.text = ""
            txtDisMinMax.text = ""
            number.clear()
        }

        btnAverage.setOnClickListener(){
            val dis = number[0]
            txtDisAverage.text = "$dis hours"
        }

        btnMinMax.setOnClickListener(){
            val dis = number[1]
            txtDisMinMax.text = "$dis hours"
        }

    }
}