package com.example.calculator

import android.util.Log
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.round

class Actions {

    fun clearMathOperation(binding: ActivityMainBinding) {
        binding.mathOperation.text = ""
    }

    fun clearOperationResult(binding: ActivityMainBinding) {
        binding.operationResult.text = ""
    }

    fun deleteDigitsInMathOperationField(binding: ActivityMainBinding) {
        val str = binding.mathOperation.text.toString()

        if (str.isNotEmpty()) binding.mathOperation.text = str.substring(0, str.length - 1)
    }

    fun getEvaluationResult(binding: ActivityMainBinding) {
        try {
            val ex = ExpressionBuilder(binding.mathOperation.text.toString()).build()
            val result = ex.evaluate().toBigDecimal().stripTrailingZeros()
            round(result.toDouble())

            binding.operationResult.text = result.toString()
        } catch (e: ArithmeticException) {
            Log.d("Ошибка", "сообщение: ${e.message}")
        } catch (e: Exception) {
            Log.d("Ошибка", "сообщение: ${e.message}")
        }
    }

    fun setTextFields(binding: ActivityMainBinding, str: String) {
        if (binding.operationResult.text != "") {
            binding.mathOperation.text = binding.operationResult.text
            clearOperationResult(binding)
        }

        binding.mathOperation.append(str)
    }
}
