package com.example.myshop

import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myshop.databinding.FragmentCheckoutBinding
import kotlin.getValue
import kotlin.with


/**
 * A simple [Fragment] subclass.
 * Use the [CheckoutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CheckoutFragment : Fragment() {

    private var _binding : FragmentCheckoutBinding? = null
    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCheckoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            //get argumen yg diirim dari home
            val args: CheckoutFragmentArgs by navArgs()
            var productName = args.productName

            txtProductName.text = productName

            edtAddress.setOnClickListener {
                //bikin action
                val action = CheckoutFragmentDirections.actionCheckoutFragmentToAddressFragment()
                //find navigation & navigate action
                findNavController().navigate(action)
            }

            btnDone.setOnClickListener {
                findNavController().navigateUp()
            }

            findNavController()
                .currentBackStackEntry?.savedStateHandle?.let {handle ->
                    handle.getLiveData<String>("address")
                        .observe(viewLifecycleOwner) { res ->
                            edtAddress.setText(res)
                        }
                }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}