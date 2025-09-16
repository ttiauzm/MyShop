package com.example.myshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myshop.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    //bikin binding
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            with(binding) {
                //baca product name dari UI txtview
                var productName = txtProduct.text.toString()

                //define
                //kirim melalui action
                val action = HomeFragmentDirections.actionHomeFragmentToCheckoutFragment(productName)

                btnBuy.setOnClickListener {
                    //
                    findNavController().navigate(action)
                }
            }
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    }


