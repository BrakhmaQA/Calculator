package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        for (button in getButtonList()) {
            button.key.setOnClickListener { setTextFields(button.value) }
        }

        binding?.apply {
            btnClear.setOnClickListener {
                mathOperation.clearText()
                operationResult.clearText()
            }

            btnBack.setOnClickListener {
                mathOperation.text = mathOperation.text.dropLast(1)
                operationResult.clearText()
            }

            btnEqual.setOnClickListener {
                getEvaluationResult()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun getButtonList(): MutableMap<TextView, String> {
        val buttons = mutableMapOf<TextView, String>()

        binding?.apply {
            buttons += btn0 to "0"
            buttons += btn1 to "1"
            buttons += btn2 to "2"
            buttons += btn3 to "3"
            buttons += btn4 to "4"
            buttons += btn5 to "5"
            buttons += btn6 to "6"
            buttons += btn7 to "7"
            buttons += btn8 to "8"
            buttons += btn9 to "9"
            buttons += btnSubtract to "-"
            buttons += btnSum to "+"
            buttons += btnMultiply to "*"
            buttons += btnDivide to "/"
            buttons += btnBracketOpen to "("
            buttons += btnBracketClose to ")"
            buttons += btnDot to "."
        }

        return buttons
    }

    private fun TextView.clearText() {
        this.text = ""
    }

    private fun getEvaluationResult() {
        binding?.apply {
            try {
                val ex = ExpressionBuilder(mathOperation.text.toString()).build()
                val result = ex.evaluate().toBigDecimal().stripTrailingZeros()
                round(result.toDouble())

                operationResult.text = result.toString()
            } catch (e: ArithmeticException) {
                Log.d("Ошибка", "сообщение: ${e.message}")
            } catch (e: Exception) {
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }
    }

    private fun setTextFields(str: String) {
        binding?.apply {
            if (operationResult.text != "") {
                mathOperation.text = operationResult.text
                operationResult.clearText()
            }

            mathOperation.append(str)
        }
    }
}
