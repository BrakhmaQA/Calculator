package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val actions: Actions = Actions()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn0.setOnClickListener { actions.setTextFields(binding, "0") }
        binding.btn1.setOnClickListener { actions.setTextFields(binding, "1") }
        binding.btn2.setOnClickListener { actions.setTextFields(binding, "2") }
        binding.btn3.setOnClickListener { actions.setTextFields(binding, "3") }
        binding.btn4.setOnClickListener { actions.setTextFields(binding, "4") }
        binding.btn5.setOnClickListener { actions.setTextFields(binding, "5") }
        binding.btn6.setOnClickListener { actions.setTextFields(binding, "6") }
        binding.btn7.setOnClickListener { actions.setTextFields(binding, "7") }
        binding.btn8.setOnClickListener { actions.setTextFields(binding, "8") }
        binding.btn9.setOnClickListener { actions.setTextFields(binding, "9") }
        binding.btnSubtract.setOnClickListener { actions.setTextFields(binding, "-") }
        binding.btnSum.setOnClickListener { actions.setTextFields(binding, "+") }
        binding.btnMultiply.setOnClickListener { actions.setTextFields(binding, "*") }
        binding.btnDivide.setOnClickListener { actions.setTextFields(binding, "/") }
        binding.btnBracketOpen.setOnClickListener { actions.setTextFields(binding, "(") }
        binding.btnBracketClose.setOnClickListener { actions.setTextFields(binding, ")") }
        binding.btnDot.setOnClickListener { actions.setTextFields(binding, ".") }

        binding.btnClear.setOnClickListener {
            actions.clearMathOperation(binding)
            actions.clearOperationResult(binding)
        }

        binding.btnBack.setOnClickListener {
            actions.deleteDigitsInMathOperationField(binding)
            actions.clearOperationResult(binding)
        }

        binding.btnEqual.setOnClickListener {
            actions.getEvaluationResult(binding)
        }
    }
}