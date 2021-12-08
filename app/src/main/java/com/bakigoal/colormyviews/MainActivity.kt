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
        .forEach { view -> view.setOnClickListener { it.setBackgroundColor(getRandomColor()) } }

    private fun getBoxesIds(): List<Int> = listOf(
        R.id.box_one_text,
        R.id.box_two_text,
        R.id.box_three_text,
        R.id.box_four_text,
        R.id.box_five_text,
        R.id.constraint_layout
    )

    private fun getRandomColor() = Color.argb(255, nextInt(256), nextInt(256), nextInt(256))
}