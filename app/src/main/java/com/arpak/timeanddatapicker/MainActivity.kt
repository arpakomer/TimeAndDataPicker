package com.arpak.timeanddatapicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.Time
import android.widget.DatePicker
import com.arpak.timeanddatapicker.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var design : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design = ActivityMainBinding.inflate(layoutInflater)
        val view = design.root
        setContentView(view)



        design.editTextHour.setOnClickListener {

            val calendar = Calendar.getInstance()

            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePicker = TimePickerDialog(this@MainActivity, { view, hourOfDay, minute ->

                design.editTextHour.setText("$hourOfDay : $minute")
            },hour,minute,true)

            timePicker.setTitle("Select Time")
            timePicker.setButton(DialogInterface.BUTTON_POSITIVE,"Setting",timePicker)
            timePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"Cancel",timePicker)

            timePicker.show()
        }


        design.editTextData.setOnClickListener {

            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)


            val dataPicker = DatePickerDialog(this@MainActivity,DatePickerDialog.OnDateSetListener { view, yr, mnth, dy ->

                design.editTextData.setText("$dy/$mnth/$yr")

            },year,month,day)

            dataPicker.setTitle("Select data")
            dataPicker.setButton(DialogInterface.BUTTON_POSITIVE,"Setting",dataPicker)
            dataPicker.setButton(DialogInterface.BUTTON_NEGATIVE,"Cancel",dataPicker)

            dataPicker.show()
        }

    }
}