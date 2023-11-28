package com.example.fragmentdrawings20

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class InputFragment : Fragment() {

    private var communicationListener: FragmentCommunicationListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val generateButton: Button = view.findViewById(R.id.generateButton)

        generateButton.setOnClickListener {
            // Anropa funktionen för att generera figuren och skicka den till det andra fragmentet
            val color = getRandomColor()
            communicationListener?.onGenerateButtonClicked(color)
        }
    }

    private fun getRandomColor(): Int {
        return Color.rgb((0..255).random(), (0..255).random(), (0..255).random())
    }

    fun setFragmentCommunicationListener(listener: FragmentCommunicationListener) {
        this.communicationListener = listener
    }
}