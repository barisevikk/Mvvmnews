package com.example.firestoremvvm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels

import com.example.firestoremvvm.viewmodel.Bviewmodel
import com.example.projemvvm.R
import com.example.projemvvm.databinding.FragmentAnasayfaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding:FragmentAnasayfaBinding
    private lateinit var bmodel:Bviewmodel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tampleviewmode:Bviewmodel by viewModels()
         bmodel=tampleviewmode
        bmodel.bilimlerservice()


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding= DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false)
        bmodel.bilimlist.observe(viewLifecycleOwner){
            val adapter = Badapter(requireContext(),it)
            binding.adapter=adapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}