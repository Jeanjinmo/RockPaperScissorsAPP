package com.jean.rockpaperscissorsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.viewpager.widget.ViewPager
import com.jean.rockpaperscissorsapp.databinding.ActivityLandingBinding
import com.jean.rockpaperscissorsapp.landingpage.LandingPageOneFragment
import com.jean.rockpaperscissorsapp.landingpage.LandingPageThreeFragment
import com.jean.rockpaperscissorsapp.landingpage.LandingPageTwoFragment

class LandingActivity : AppCompatActivity() {

    private val binding: ActivityLandingBinding by lazy {
        ActivityLandingBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val landingPageOne = LandingPageOneFragment()
        val landingPageTwo = LandingPageTwoFragment()
        val landingPageThree = LandingPageThreeFragment()

        val landingPagerAdapter = LandingPagerAdapter(
            fragmentManager = supportFragmentManager,
            landingPageOne, landingPageTwo, landingPageThree
        )

        binding.vpLanding.adapter = landingPagerAdapter
        binding.dotIndicator.attachTo(binding.vpLanding)

        binding.floatingActionButton.setOnClickListener {
            val currentPosition = binding.vpLanding.currentItem
            binding.vpLanding.setCurrentItem(currentPosition + 1, true)
        }

        binding.vpLanding.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    val isLastPosition = position == landingPagerAdapter.count-1
                    binding.floatingActionButton.isVisible = !isLastPosition
                }
            }
        )
    }
}