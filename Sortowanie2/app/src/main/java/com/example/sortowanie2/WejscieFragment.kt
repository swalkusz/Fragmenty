package com.example.sortowanie2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.lifecycle.ViewModelProvider


class WejscieFragment : Fragment() {
    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_wejscie, container, false)

        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        val editText = view.findViewById<EditText>(R.id.inputField)
        val button = view.findViewById<Button>(R.id.sortedButton)
        val radioGroup = view.findViewById<RadioGroup>(R.id.sortMethodRadioGroup)

        button.setOnClickListener {
            val inputText = editText.text.toString()
            val selectedSortAlgorithm = when (radioGroup.checkedRadioButtonId) {
                R.id.sort1RadioButton -> SortAlgorithm.BUBBLE_SORT
                R.id.sort2RadioButton -> SortAlgorithm.SELECTION_SORT
                else -> SortAlgorithm.BUBBLE_SORT
            }
            viewModel.setText(inputText)
            viewModel.setSortAlgorithm(selectedSortAlgorithm)
        }

        return view
    }
}
