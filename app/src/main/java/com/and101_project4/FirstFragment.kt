package com.and101_project4

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.and101_project4.databinding.FragmentFirstBinding
import java.util.Locale

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btCalc.setOnClickListener {

            try {
                val cost = binding.tfCost.text.toString()
                val percent = binding.tfPercent.text.toString()
                Log.println(Log.DEBUG, "echo", cost)
                Log.println(Log.DEBUG, "echo", percent)
                val tip = cost.toDouble() * (percent.toDouble() / 100)
                binding.tvOutput.text = String.format(Locale.US, "Tip is $%.2f", tip)
            } catch (e: Exception) {
                binding.tvOutput.text = "Invalid Input"
            }
        }
//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}