package com.freshyfive.reflect.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.freshyfive.reflect.R
import com.freshyfive.reflect.data.beats
import com.freshyfive.reflect.databinding.FragmentHomeBinding
import com.freshyfive.reflect.models.getUserName

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        textView.text = "Hello, ${getUserName(root.context)}"
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val beatsRecyclerView = view.findViewById<RecyclerView>(R.id.beatsRecyclerView)
        beatsRecyclerView.adapter = BeatsAdapter(beats.shuffled().take(3))
        beatsRecyclerView.layoutManager = LinearLayoutManager(view.context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}