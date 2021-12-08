package com.bakigoal.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() = getBoxesIds()
        .map { findViewById<View>(it) }
        .forEach { setListener(it) }

    private fun setListener(view: View) = view.setOnClickListener {
        when (it.id) {
            // Android color resource
            R.id.box_two_text -> it.setBackgroundResource(android.R.color.holo_orange_dark)
            // Custom colors
            R.id.red_button -> findViewById<View>(R.id.box_three_text).setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> findViewById<View>(R.id.box_four_text).setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> findViewById<View>(R.id.box_five_text).setBackgroundResource(R.color.my_green)
            // default colors and generated colors using Color class
            R.id.constraint_layout -> it.setBackgroundColor(Color.LTGRAY)
            else -> it.setBackgroundColor(getRandomColor())
        }
    }

    private fun getBoxesIds(): List<Int> = listOf(
        R.id.box_one_text,
        R.id.box_two_text,
        R.id.box_three_text,
        R.id.box_four_text,
        R.id.box_five_text,
        R.id.constraint_layout,
        R.id.red_button,
        R.id.yellow_button,
        R.id.green_button
    )

    private fun getRandomColor() = Color.argb(255, nextInt(256), nextInt(256), nextInt(256))
}