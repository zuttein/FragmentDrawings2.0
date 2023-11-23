package com.example.fragmentdrawings20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), FragmentCommunicationListener {

    private val inputFragment = InputFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputFragment.setFragmentCommunicationListener(this)

        // Lägg till det första fragmentet när aktiviteten skapas
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, inputFragment)
            .commit()
    }

    override fun onGenerateButtonClicked(color: Int) {
        // Ersätt det nuvarande fragmentet med DrawingFragment
        val drawingFragment = DrawingFragment.newInstance(color)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, drawingFragment)
            .addToBackStack(null)
            .commit()
    }
}
