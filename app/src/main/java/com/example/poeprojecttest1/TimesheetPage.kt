package com.example.poeprojecttest1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class TimesheetPage : AppCompatActivity() {
    private var imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timesheet_page)

        var category = findViewById<EditText>(R.id.categoryET)
        var startTime = findViewById<EditText>(R.id.startingETT)
        var endingTime = findViewById<EditText>(R.id.endingETT)
        var upButton = findViewById<Button>(R.id.uploadedBtn)
        imageView = findViewById<ImageView>(R.id.uploadedIV)
        var subButton = findViewById<Button>(R.id.SubmitBtn)

        val entryDate = intent.getStringExtra("Selected_Date")

        subButton.setOnClickListener{
            val timesheetInfo = Bundle()
            timesheetInfo.putString("Date", entryDate)
            timesheetInfo.putString("Category", category.text.toString())
            timesheetInfo.putString("Start_Time", startTime.text.toString())
            timesheetInfo.putString("End_Time", endingTime.text.toString())
            timesheetInfo.putString("Photo_URI", imageView?.tag?.toString())

            val intent = Intent(this@TimesheetPage, HomePage::class.java)
            intent.putExtras(timesheetInfo)
            startActivity(intent)
        }

        var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                var imageUri = result.data!!.data
                imageView?.setImageURI(imageUri)
                imageView?.tag = imageUri.toString()
            } else {
                imageView?.setImageDrawable(null)
                imageView?.tag = null
            }
        }

        upButton.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            resultLauncher.launch(gallery)
        }
    }
}


