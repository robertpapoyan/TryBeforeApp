package com.example.trybeforeapp.Services

import com.example.trybeforeapp.Model.Category
import com.example.trybeforeapp.Model.Possition
import com.example.trybeforeapp.Model.Profession

object DataProvider {

    val categories = listOf(
        Category("QA", "qa"),
        Category("QA", "qa"),
        Category("DEV", "dev"),
        Category("QA", "qa"),
        Category("DEV", "dev")
    )

    val professionsQa = listOf(
        Profession("Manual QA", "qa"),
        Profession("Automation", "qa"),
        Profession("Manual QA", "qa"),
        Profession("Automation", "qa"),
        Profession("Manual QA", "qa"),
        Profession("Automation", "qa")

    )

    val professionsDev = listOf(
        Profession("Front", "dev"),
        Profession("Back", "dev"),
        Profession("Front", "dev"),
        Profession("Back", "dev"),
        Profession("Front", "dev"),
        Profession("Back", "dev")

    )

    val possitions = listOf(
        Possition("Jun", "qa"),
        Possition("Mid", "qa"),
        Possition("Senior", "qa"),
        Possition("Lead", "dev")
    )

    fun getProfessions(category: String): List<Profession> {
        return when(category){
            "QA" -> professionsQa
            else -> professionsDev
        }

        fun getPossitions(profession: String): List<Possition>{
            return when(profession){
                "Manual QA" -> possitions
                "Automation" -> possitions
                "Front" -> possitions
                else -> possitions
            }
        }
    }
}
