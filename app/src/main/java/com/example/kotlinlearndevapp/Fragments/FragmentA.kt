package com.example.kotlinlearndevapp.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlinlearndevapp.Interface.Communicator
import com.example.kotlinlearndevapp.R
import com.example.kotlinlearndevapp.databinding.LayoutFragmentBinding

class FragmentA : Fragment() {
    private lateinit var communicator: Communicator
    private lateinit var bindingFragmentA: LayoutFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       bindingFragmentA = LayoutFragmentBinding.inflate(inflater,container,false)
        //var view = inflater.inflate(R.layout.layout_fragment, container, false)
        communicator= activity as Communicator

        bindingFragmentA.sendBtn.setOnClickListener {
          communicator.passData("abcd")
        }
        return  bindingFragmentA.root;

    }
}
