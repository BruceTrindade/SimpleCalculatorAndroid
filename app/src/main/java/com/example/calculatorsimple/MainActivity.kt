package com.example.calculatorsimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()
        //add numbers on the screen
        number_zero.setOnClickListener {AddanExpression("0", clear_date = true)}
        number_one.setOnClickListener  {AddanExpression("1", clear_date = true)}
        number_two.setOnClickListener  {AddanExpression("2", clear_date = true)}
        number_three.setOnClickListener{AddanExpression("3", clear_date = true)}
        number_four.setOnClickListener {AddanExpression("4", clear_date = true)}
        number_five.setOnClickListener {AddanExpression("5", clear_date = true)}
        number_six.setOnClickListener  {AddanExpression("6", clear_date = true)}
        number_seven.setOnClickListener{AddanExpression("7", clear_date = true)}
        number_eight.setOnClickListener{AddanExpression("8", clear_date = true)}
        number_nine.setOnClickListener {AddanExpression("9", clear_date = true)}
        bt_point.setOnClickListener    {AddanExpression(".", clear_date = true)}

        //operators
        bt_addition.setOnClickListener {AddanExpression("+", false)}
        bt_subtration.setOnClickListener {AddanExpression("-", false)}
        bt_mutiplication.setOnClickListener {AddanExpression("*", false)}
        bt_division.setOnClickListener {AddanExpression("/", false)}

        bt_clear.setOnClickListener{
            txt_expression.text = ""
            txt_result.text = ""
        }

        bt_backspace.setOnClickListener{

            val string = txt_expression.text.toString()

            if (string.isNotBlank()) {
                txt_expression.text = string.substring(0, string.length-1)
            }

            txt_result.text = ""
        }

        bt_equal.setOnClickListener{

          try {


             val expression = ExpressionBuilder(txt_expression.text.toString()).build()
             val result = expression.evaluate()
             val longResult = result.toLong ()

              if (result == longResult.toDouble())
                   txt_result.text = longResult.toString ()

              else
                  txt_result.text = result.toString()

            }catch (e: Exception) {

          }


        }



    }

    fun AddanExpression (string: String, clear_date : Boolean) {

        if (txt_result.text.isNotEmpty()) {
            txt_expression.text = ""
        }

        if (clear_date) {
            txt_result.text = ""
            txt_expression.append(string)
        } else {
            txt_expression.append(txt_result.text)
            txt_expression.append(string)
            txt_result.text = ""
        }

    }




}