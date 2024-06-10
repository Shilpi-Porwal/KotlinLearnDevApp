package com.example.kotlinlearndevapp.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlinlearndevapp.R
import com.example.kotlinlearndevapp.databinding.LayoutFrgment2Binding

class FragmentB : Fragment() {
   private lateinit var bindingFragmentB: LayoutFrgment2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       bindingFragmentB = LayoutFrgment2Binding.inflate(inflater,container,false)
       // var view = inflater.inflate(R.layout.layout_frgment2,container,false)
        bindingFragmentB.displayMessage.text = arguments?.getString("message")
        return bindingFragmentB.root
    }
}