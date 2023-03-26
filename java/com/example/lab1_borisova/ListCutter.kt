package com.example.lab1_borisova

import android.app.Application
import android.util.Log
import android.widget.TextView

public class ListCutter : Application() {

    // создаем неизменяемый список из 10 пустых целых чисел на старте приложения
    private lateinit var list: List<Int>

    override fun onCreate() {
        super.onCreate()
        //наполняем список 10 случайными числами от 1 до 100 при создании
        list  = List(10) {(1..100).random()}
    }

    // функция, которая возвращает новый список с ограничением
    fun cut(limit: Int): List<Int> {
        val limitedlist: MutableList<Int> = list as MutableList<Int>
        limitedlist.forEach{
            if (it > limit)
                limitedlist.remove(it)
        }
        return limitedlist
    }

}