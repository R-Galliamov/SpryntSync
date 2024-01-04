package com.developers.spryntsync.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.developers.spryntsync.R
import com.developers.spryntsync.databinding.FragmentOnboardingBinding
import com.developers.spryntsync.ui.TAG

class OnboardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding: FragmentOnboardingBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {

            findNavController().navigate(
                R.id.action_onboardingFragment_to_tabsFragment
            )
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Onboarding Fragment")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}