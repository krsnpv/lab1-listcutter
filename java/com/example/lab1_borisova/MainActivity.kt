package com.example.lab1_borisova

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var userInput : EditText
    private lateinit var listtext: TextView
    private lateinit var counttext: TextView
    private lateinit var listresult: TextView
    private lateinit var countresult: TextView
    private lateinit var resetbutton: Button
    private lateinit var cutter : ListCutter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // инициализируем поля
        userInput = findViewById(R.id.userinput);
        counttext = findViewById(R.id.counttext)
        listtext = findViewById(R.id.listtext)
        listresult = findViewById(R.id.listresult)
        countresult = findViewById(R.id.countresult)
        resetbutton = findViewById(R.id.resetbutton)

        // получаем объект Application через свойство application класса Context
        cutter = application as ListCutter
    }

    // функция, которая висит на кнопке "начать"
    fun start(view: View){

        // создаем пока пустой список
        val list: List<Int>
        // берем значение из поля EditText
        val inputText = userInput.getText().toString()
        if(!(inputText.isEmpty())) {
            val limit = Integer.parseInt(inputText)
            // запускаем функцию на объекте Application и на выходе получаем список элементов не больше инпута
            list = cutter.cut(limit)

            // берем длину списка и выводим в текстовое поле
            counttext.setText("Количество:")
            countresult.setText(list.size)

            // преобразуем список в строку и выводим в текстовое поле
            listtext.setText("Числа, меньше вашего:")
            listresult.setText(list.joinToString())

            // показываем кнопку сброса
            resetbutton.visibility = View.VISIBLE
        }
        else { counttext.setText("Введите число от 1 до 100")}
    }

    // функция, которая висит на кнопке "сбросить"
    fun reset(view: View){
        userInput.getText().clear()
        val fields = listOf<TextView>(counttext, countresult, listtext, listresult)
        fields.forEach{
            it.setText("")
        }
        resetbutton.visibility = View.INVISIBLE
    }
}

