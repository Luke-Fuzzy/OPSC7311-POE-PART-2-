package com.example.poeprojecttest1

import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.widget.*
import androidx.annotation.RequiresApi


class TimesheetEntriesPage : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timesheet_entries_page)

        val entriesInfo = intent?.getSerializableExtra("TimeSheetListExtra") as? ArrayList<HomePage.TimeSheet>
        val displayELV = findViewById<ListView>(R.id.displayELV)
        val picIV = findViewById<ImageView>(R.id.picIV)

        val adapter = ArrayAdapter<HomePage.TimeSheet>(this, android.R.layout.simple_list_item_1, entriesInfo ?: ArrayList())
        displayELV.adapter = adapter

        displayELV.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedTimeSheet = entriesInfo?.get(position)
            val photoUriString = selectedTimeSheet?.photoUri

            if (!photoUriString.isNullOrEmpty()) {
                val photoUri = Uri.parse(photoUriString)
                picIV.setImageURI(photoUri)
            } else {
                Toast.makeText(this@TimesheetEntriesPage, "No image found", Toast.LENGTH_SHORT).show()
            }

        }
    }
}