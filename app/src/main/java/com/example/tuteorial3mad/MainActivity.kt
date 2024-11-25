package com.example.tuteorial3mad // Corrected package name

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tuteorial3mad.Models.Calculator // Ensure this package is correct
import com.example.tuteorial3mad.R

class MainActivity : AppCompatActivity() {



    private lateinit var edtNumber1: EditText
    private lateinit var edtNumber2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the EditText views
        edtNumber1 = findViewById(R.id.edtNumber1)
        edtNumber2 = findViewById(R.id.edtNumber2)

        // Set up button click listeners if not using onClick in XML
        findViewById<View>(R.id.btnAdd).setOnClickListener { buttonClick(it) }
        findViewById<View>(R.id.btnSubtract).setOnClickListener { buttonClick(it) }
        findViewById<View>(R.id.btnMultiply).setOnClickListener { buttonClick(it) }
        findViewById<View>(R.id.btnDivide).setOnClickListener { buttonClick(it) }
    }

    fun buttonClick(v: View) {
        var ans = 0.0

        try {
            val num1 = edtNumber1.text.toString().toDouble()
            val num2 = edtNumber2.text.toString().toDouble()

            val calculator = Calculator(num1, num2)

            when (v.id) {
                R.id.btnAdd -> ans = calculator.add()
                R.id.btnSubtract -> ans = calculator.subtract()
                R.id.btnMultiply -> ans = calculator.multiply()
                R.id.btnDivide -> {
                    if (num2 != 0.0) {
                        ans = calculator.divide()
                    } else {
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                        return
                    }
                }
            }
            // Display the result (you might want to use a TextView for better UI)
            println(ans) // This will print the output on the terminal
            Toast.makeText(this, "Result: $ans", Toast.LENGTH_SHORT).show() // Show result in a Toast
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
        }
    }
}
