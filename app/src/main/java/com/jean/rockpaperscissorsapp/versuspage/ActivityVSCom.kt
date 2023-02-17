package com.jean.rockpaperscissorsapp.versuspage

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.jean.rockpaperscissorsapp.LandingActivity
import com.jean.rockpaperscissorsapp.MenuActivity
import com.jean.rockpaperscissorsapp.R
import com.jean.rockpaperscissorsapp.databinding.ActivityVscomBinding
import com.jean.rockpaperscissorsapp.landingpage.LandingPageThreeFragment

class ActivityVSCom : AppCompatActivity() {

    companion object {
        const val PLAYER_1 = "player1"
        const val PLAYER_2 = "player2"
    }

    private val binding: ActivityVscomBinding by lazy {
        ActivityVscomBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvPemainSatu.text = intent.getStringExtra(PLAYER_1)
        binding.tvCom.text = intent.getStringExtra(PLAYER_2).plus(" (COM)")

        //restart Activity
        binding.imgRestart.setOnClickListener {
            restart()
        }

        //random choice Computer
        val choiceCom = arrayListOf<ImageView>(
            binding.imgBatuCom,
            binding.imgKertasCom,
            binding.imgGuntingCom
        ).random()

        //player pilih batu
        binding.imgBatuPemain.setOnClickListener {
            binding.tvResultVS.visibility = View.VISIBLE
            binding.tvResultWin.visibility = View.INVISIBLE
            when (choiceCom) {
                binding.imgBatuCom -> {
                    binding.tvResultWin.text = getString(R.string.draw)
                    binding.tvResultWin.setBackgroundColor(resources.getColor(R.color.biru_draw))
                    showDialog("SERI")
                }
                binding.imgGuntingCom -> {
                    binding.tvResultWin.text = getString(R.string.pemain_win)
                    showDialog("Pemain 1 Menang")
                }
                binding.imgKertasCom -> {
                    binding.tvResultWin.text = getString(R.string.computer_win)
                    showDialog("Komputer Menang")
                }
            }
        }

        //player pilih gunting
        binding.imgGuntingPemain.setOnClickListener {
            binding.tvResultVS.visibility = View.VISIBLE
            binding.tvResultWin.visibility = View.INVISIBLE
            when (choiceCom) {
                binding.imgBatuCom -> {
                    binding.tvResultWin.text = getString(R.string.computer_win)
                    showDialog("Komputer Menang")
                }
                binding.imgGuntingCom -> {
                    binding.tvResultWin.text = getString(R.string.draw)
                    binding.tvResultWin.setTextColor(resources.getColor(R.color.biru_draw))
                    showDialog("SERI")
                }
                binding.imgKertasCom -> {
                    binding.tvResultWin.text = getString(R.string.pemain_win)
                    showDialog("Pemain 1 Menang")
                }
            }
        }

        //player pilih kertas
        binding.imgKertasPemain.setOnClickListener {
            binding.tvResultVS.visibility = View.VISIBLE
            binding.tvResultWin.visibility = View.INVISIBLE
            when (choiceCom) {
                binding.imgBatuCom -> {
                    binding.tvResultWin.text = getString(R.string.pemain_win)
                    showDialog("Pemain 1 Menang")
                }
                binding.imgGuntingCom -> {
                    binding.tvResultWin.text = getString(R.string.computer_win)
                    showDialog("Komputer Menang")
                }
                binding.imgKertasCom -> {
                    binding.tvResultWin.text = getString(R.string.draw)
                    binding.tvResultWin.setTextColor(resources.getColor(R.color.biru_draw))
                    showDialog("SERI")
                }
            }
        }
    }

    private fun showDialog(resultWin:String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_custom_dialog_result)
        val title = dialog.findViewById(R.id.tv_dial_tittle) as TextView
        val body = dialog.findViewById(R.id.tv_dial_body) as TextView
        body.text = resultWin
        val yesBtn = dialog.findViewById(R.id.btn_mainlagi) as Button
        val noBtn = dialog.findViewById(R.id.btn_kembalikemenu) as Button
        yesBtn.setOnClickListener {
            finish()
            restart()
        }
        noBtn.setOnClickListener {
            val intent = Intent(this, LandingActivity::class.java)
            startActivity(intent)
        }
        dialog.show()

    }

    private fun restart() {
        val intent = intent
        startActivity(intent)
//        recreate()
    }
}