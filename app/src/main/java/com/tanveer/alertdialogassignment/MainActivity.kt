package com.tanveer.alertdialogassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.tanveer.alertdialogassignment.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.btnCalculate?.setOnClickListener {
            if (binding?.etNumber?.text.toString().trim().isNullOrEmpty()) {
                binding?.etNumber?.error = "enter the number first"
           } else {
                    var alertDialog = AlertDialog.Builder(this)
                    alertDialog.setTitle("Perform Calculation on ${binding?.etNumber?.text}")
                    alertDialog.setMessage("Add ${binding?.etNumber?.text}in number \n Sub ${binding?.etNumber?.text}in number \nPress reset to set to zero")
                    alertDialog.setCancelable(false)
                    alertDialog.setPositiveButton("Add ${binding?.etNumber?.text}") { _, _ ->
                        var number = binding?.etNumber?.text?.toString()?.toIntOrNull() ?: 0
                        binding?.etNumber?.setText((number + number).toString())
                        Toast.makeText(this, "Added ${binding?.etNumber?.text}", Toast.LENGTH_SHORT)
                            .show()
                    }
                alertDialog.setNegativeButton("Sub ${binding?.etNumber?.text}") { _, _ ->
                    var number = binding?.etNumber?.text?.toString()?.toIntOrNull() ?: 0
                    binding?.etNumber?.setText((number - number).toString())
                    Toast.makeText(
                        this,
                        "Subtracted ${binding?.etNumber?.text}",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
                alertDialog.setNeutralButton("Reset") { _, _ ->
                    binding?.etNumber?.setText((0).toString())
                    Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show()
                }
                alertDialog.show()
           }
       }
    }
}


