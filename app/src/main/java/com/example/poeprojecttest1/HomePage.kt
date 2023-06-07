package com.example.poeprojecttest1

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.CalendarView
import androidx.appcompat.app.AppCompatActivity

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)


        var btnPoints = findViewById<Button>(R.id.btnPoints)
        var btnPaidTime = findViewById<Button>(R.id.btnPaidTime)
        var btnReports = findViewById<Button>(R.id.btnReports)
        var btnTimesheetEntries = findViewById<Button>(R.id.btnTimeSheetEntries)
        var btnAlarms = findViewById<Button>(R.id.btnAlarms)
        var btnProjects = findViewById<Button>(R.id.btnProjects)
        var btnExports = findViewById<Button>(R.id.btnExports)
        var btnSettings = findViewById<Button>(R.id.btnSettings)
        var calendarView = findViewById<CalendarView>(R.id.calendar_view)

        val timeEntriesArrayList = ArrayList<TimeSheet>()
        val timeSheetInfo = intent.extras
        timeEntriesArrayList.add(TimeSheet(
            timeSheetInfo?.getString("Date"),
            timeSheetInfo?.getString("Category"),
            timeSheetInfo?.getString("Start_Time"),
            timeSheetInfo?.getString("End_Time"),
            timeSheetInfo?.getString("Photo_URI")
        ))

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val date = "$dayOfMonth/${month + 1}/$year" // Adjust month index to match human-readable format
            val calendarIntent = Intent(this@HomePage, TimesheetPage::class.java)
            calendarIntent.putExtra("Selected_Date", date.toString())
            startActivity(calendarIntent)
        }



        btnPoints.setOnClickListener(){
            val intent = Intent(this@HomePage, PointsPage::class.java)
            startActivity(intent)
        }

        btnPaidTime.setOnClickListener(){
            val intent = Intent(this@HomePage, PaidTimePage::class.java)
            startActivity(intent)
        }

        btnReports.setOnClickListener(){
            val intent = Intent(this@HomePage, ReportsPage::class.java)
            startActivity(intent)
        }

        btnTimesheetEntries.setOnClickListener(){
            val intent = Intent(this@HomePage, TimesheetEntriesPage::class.java)
            intent.putExtra("TimeSheetListExtra", timeEntriesArrayList)
            startActivity(intent)
        }

        btnAlarms.setOnClickListener(){
            val intent = Intent(this@HomePage, AlarmsPage::class.java)
            startActivity(intent)
        }

        btnProjects.setOnClickListener(){
            val intent = Intent(this@HomePage, ProjectsPage::class.java)
            startActivity(intent)
        }

        btnExports.setOnClickListener(){
            val intent = Intent(this@HomePage, ExportPage::class.java)
            startActivity(intent)
        }

        btnSettings.setOnClickListener(){
            val intent = Intent(this@HomePage, SettingsPage::class.java)
            startActivity(intent)
        }
    }

     data class TimeSheet(
         val date: String?,
         val category: String?,
         val startTime: String?,
         val endTime: String?,
         val photoUri: String?
         ) : java.io.Serializable
}