package com.example.sortowanie2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


class WyjscieFragment : Fragment() {
    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_wyjscie, container, false)

        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        val textView = view.findViewById<TextView>(R.id.oldChain)
        val sortedTextView = view.findViewById<TextView>(R.id.sortedChain)
        viewModel.text.observe(viewLifecycleOwner) { text ->
            textView.text = text

            viewModel.sortAlgorithm.observe(viewLifecycleOwner) { algorithm ->
                sortedTextView.text = when (algorithm) {

                    SortAlgorithm.BUBBLE_SORT -> bubbleSort(text)
                    SortAlgorithm.SELECTION_SORT -> selectionSort(text)
                }
            }
        }

        return view
    }

    private fun bubbleSort(text: String): String {
        val numbers =
            text.split("\\s+".toRegex()).filter { it.isNotEmpty() }.map { it.trim().toInt() }
                .toIntArray()
        for (i in numbers.indices) {
            for (j in 0 until numbers.size - i - 1) {
                if (numbers[j] > numbers[j + 1]) {
                    val temp = numbers[j]
                    numbers[j] = numbers[j + 1]
                    numbers[j + 1] = temp
                }
            }
        }
        return numbers.joinToString(" ")
    }

    private fun selectionSort(text: String): String {
        val numbers =
            text.split("\\s+".toRegex()).filter { it.isNotEmpty() }.map { it.trim().toInt() }
                .toIntArray()
        for (i in numbers.indices) {
            var minIdx = i
            for (j in i + 1 until numbers.size) {
                if (numbers[j] < numbers[minIdx]) {
                    minIdx = j
                }
            }
            val temp = numbers[minIdx]
            numbers[minIdx] = numbers[i]
            numbers[i] = temp
        }
        return numbers.joinToString(" ")
    }

}