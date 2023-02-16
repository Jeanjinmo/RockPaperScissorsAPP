package com.jean.rockpaperscissorsapp.landingpage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jean.rockpaperscissorsapp.MenuActivity
import com.jean.rockpaperscissorsapp.databinding.FragmentLandingPageThreeBinding

class LandingPageThreeFragment : Fragment() {


    private var _binding: FragmentLandingPageThreeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLandingPageThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStartGame.setOnClickListener {
            val name =binding.etName.text.toString()
            val mintent = Intent(requireActivity(), MenuActivity::class.java)
            mintent.putExtra(MenuActivity.NAME, name)
            startActivity(mintent)
        }
    }
}