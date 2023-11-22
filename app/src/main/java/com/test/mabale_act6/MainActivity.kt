package com.example.dialogexamples

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.test.mabale_act6.R
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alertDialogButton: Button = findViewById(R.id.button_alert_dialog)
        val datePickerDialogButton: Button = findViewById(R.id.button_date_picker_dialog)
        val timePickerDialogButton: Button = findViewById(R.id.button_time_picker_dialog)

        alertDialogButton.setOnClickListener {
            showAlertDialog()
        }

        datePickerDialogButton.setOnClickListener {
            showDatePickerDialog()
        }

        timePickerDialogButton.setOnClickListener {
            showTimePickerDialog()
        }
    }

    private fun showAlertDialog() {
        AlertDialog.Builder(this)
            .setTitle("Alert Dialog")
            .setMessage("This is an alert dialog.")
            .setPositiveButton("OK") { dialog, which ->
                showToast("OK clicked")
            }
            .setNegativeButton("Cancel") { dialog, which ->
                showToast("Cancel clicked")
            }
            .show()
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, monthOfYear, dayOfMonth ->
                val dateString = "Date set to: $dayOfMonth/${monthOfYear + 1}/$year"
                showToast(dateString)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val timePickerDialog = TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                val timeString = "Time set to: $hourOfDay:$minute"
                showToast(timeString)
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            true // is 24 hour view
        )
        timePickerDialog.show()
    }

    private fun showToast(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
}
