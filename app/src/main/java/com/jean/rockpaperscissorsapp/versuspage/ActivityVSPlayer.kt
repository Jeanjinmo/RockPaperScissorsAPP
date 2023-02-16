package com.jean.rockpaperscissorsapp.versuspage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.jean.rockpaperscissorsapp.R
import com.jean.rockpaperscissorsapp.databinding.ActivityVsplayerBinding

@Suppress("DEPRECATION")
class ActivityVSPlayer : AppCompatActivity() {

    companion object {
        const val PLAYER_1 = "player1"
        const val PLAYER_2 = "Player2"
    }

    private val binding: ActivityVsplayerBinding by lazy {
        ActivityVsplayerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvPemainSatu.text = intent.getStringExtra(PLAYER_1)
        binding.tvCom.text = intent.getStringExtra(PLAYER_2)

        //restart Activity
        binding.imgRestart.setOnClickListener {
            restart()
        }


        //player pilih batu
//        binding.imgBatuPemain.setOnClickListener {
//            binding.tvResultVS.visibility = View.INVISIBLE
//            binding.tvResultWin.visibility = View.VISIBLE
//            when (choiceCom) {
//                binding.imgBatuCom -> {
//                    binding.tvResultWin.text = getString(R.string.draw)
//                    binding.tvResultWin.setBackgroundColor(resources.getColor(R.color.biru_draw))
//                }
//                binding.imgGuntingCom -> {
//                    binding.tvResultWin.text = getString(R.string.pemain_win)
//                }
//                binding.imgKertasCom -> {
//                    binding.tvResultWin.text = getString(R.string.computer_win)
//                }
//            }
//        }
//
//        //player pilih gunting
//        binding.imgGuntingPemain.setOnClickListener {
//            binding.tvResultVS.visibility = View.INVISIBLE
//            binding.tvResultWin.visibility = View.VISIBLE
//            when (choiceCom) {
//                binding.imgBatuCom -> {
//                    binding.tvResultWin.text = getString(R.string.computer_win)
//                }
//                binding.imgGuntingCom -> {
//                    binding.tvResultWin.text = getString(R.string.draw)
//                    binding.tvResultWin.setTextColor(resources.getColor(R.color.biru_draw))
//                }
//                binding.imgKertasCom -> {
//                    binding.tvResultWin.text = getString(R.string.pemain_win)
//                }
//            }
//        }
//
//        //player pilih kertas
//        binding.imgKertasPemain.setOnClickListener {
//            binding.tvResultVS.visibility = View.INVISIBLE
//            binding.tvResultWin.visibility = View.VISIBLE
//            when (choiceCom) {
//                binding.imgBatuCom -> {
//                    binding.tvResultWin.text = getString(R.string.pemain_win)
//                }
//                binding.imgGuntingCom -> {
//                    binding.tvResultWin.text = getString(R.string.computer_win)
//                }
//                binding.imgKertasCom -> {
//                    binding.tvResultWin.text = getString(R.string.draw)
//                    binding.tvResultWin.setTextColor(resources.getColor(R.color.biru_draw))
//                }
//            }
//        }
    }

    private fun restart() {
        val intent = intent
        finish()
            startActivity(intent)
//        recreate()
    }

    private fun vsPlayer(){

    }


}