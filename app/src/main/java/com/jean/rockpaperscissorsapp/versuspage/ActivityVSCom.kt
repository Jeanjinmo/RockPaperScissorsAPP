package com.jean.rockpaperscissorsapp.versuspage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.jean.rockpaperscissorsapp.R
import com.jean.rockpaperscissorsapp.databinding.ActivityVscomBinding

class ActivityVSCom : AppCompatActivity() {

    private val binding: ActivityVscomBinding by lazy {
        ActivityVscomBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //random choice Computer
        val choiceCom = arrayListOf<ImageView>(
            binding.imgBatuCom,
            binding.imgKertasCom,
            binding.imgGuntingCom
        ).random()

        //player pilih batu
        binding.imgBatuPemain.setOnClickListener {
            binding.tvResultVS.visibility = View.INVISIBLE
            binding.tvResultWin.visibility = View.VISIBLE
            when (choiceCom) {
                binding.imgBatuCom -> {
                    binding.tvResultWin.text = getString(R.string.draw)
                    binding.tvResultWin.setBackgroundColor(resources.getColor(R.color.biru_draw))
                }
                binding.imgGuntingCom -> {
                    binding.tvResultWin.text = getString(R.string.pemain_win)
                }
                binding.imgKertasCom -> {
                    binding.tvResultWin.text = getString(R.string.computer_win)
                }
            }
        }

        //player pilih gunting
        binding.imgGuntingPemain.setOnClickListener {
            binding.tvResultVS.visibility = View.INVISIBLE
            binding.tvResultWin.visibility = View.VISIBLE
            when (choiceCom) {
                binding.imgBatuCom -> {
                    binding.tvResultWin.text = getString(R.string.computer_win)
                }
                binding.imgGuntingCom -> {
                    binding.tvResultWin.text = getString(R.string.draw)
                    binding.tvResultWin.setTextColor(resources.getColor(R.color.biru_draw))
                }
                binding.imgKertasCom -> {
                    binding.tvResultWin.text = getString(R.string.pemain_win)
                }
            }
        }

        //player pilih kertas
        binding.imgKertasPemain.setOnClickListener {
            binding.tvResultVS.visibility = View.INVISIBLE
            binding.tvResultWin.visibility = View.VISIBLE
            when (choiceCom) {
                binding.imgBatuCom -> {
                    binding.tvResultWin.text = getString(R.string.pemain_win)
                }
                binding.imgGuntingCom -> {
                    binding.tvResultWin.text = getString(R.string.computer_win)
                }
                binding.imgKertasCom -> {
                    binding.tvResultWin.text = getString(R.string.draw)
                    binding.tvResultWin.setTextColor(resources.getColor(R.color.biru_draw))
                }
            }
        }
    }
}