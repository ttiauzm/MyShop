package com.example.myshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.myshop.databinding.FragmentAddressBinding


/**
 * A simple [Fragment] subclass.
 * Use the [AddressFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddressFragment : Fragment() {

    private var _binding : FragmentAddressBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentAddressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            //ambil data provinsi
            val provinces = resources.getStringArray(R.array.provinces)
            val adapterProvinces = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, provinces)
            adapterProvinces.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerProvinces.adapter = adapterProvinces

            btnDone.setOnClickListener {
                findNavController().apply {
                    val selectedProvince = spinnerProvinces.selectedItem.toString()
                    //simpan state dgn key address dan vale selectedProvince
                    previousBackStackEntry?.savedStateHandle?.set("address",selectedProvince )
                }.navigateUp() //navigasi ke halaman sblmnya
            }
        }
    }

}