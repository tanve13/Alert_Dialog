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
                binding?.btnCalculate?.setOnClickListener {
                    var alertDialog = AlertDialog.Builder(this)
                    alertDialog.setTitle("Perform Calculation on ${binding?.etNumber}")
                    alertDialog.setMessage("Add ${binding?.etNumber}in number")
                    alertDialog.setMessage("Sub ${binding?.etNumber}in number")
                    alertDialog.setMessage("Press reset to set to zero")
                    alertDialog.setCancelable(false)
                    alertDialog.setPositiveButton("Add ${binding?.etNumber}", {_,_->
                        binding?.etNumber += binding?.etNumber
                        Toast.makeText(this, "Added ${binding?.etNumber}", Toast.LENGTH_SHORT)
                            .show()
                    })
                    alertDialog.setNegativeButton("Sub ${binding?.etNumber}", { _, _ ->
                        binding?.etNumber -= binding?.etNumber
                        Toast.makeText(this, "Subtracted ${binding?.etNumber}", Toast.LENGTH_SHORT)
                            .show()
                    })
                    alertDialog.setNeutralButton("Reset",{ _, _ ->
                        Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show()
                    })
                    alertDialog.show()
                }
            }
        }
    }
}


