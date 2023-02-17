package com.jean.rockpaperscissorsapp.versuspage

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.jean.rockpaperscissorsapp.LandingActivity
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

        val choicePlayer = arrayListOf<ImageView>(
            binding.imgBatuCom,
            binding.imgKertasCom,
            binding.imgGuntingCom
        )


        //player pilih batu
        binding.imgBatuPemain.setOnClickListener {
            binding.tvResultVS.visibility = View.VISIBLE
            binding.tvResultWin.visibility = View.INVISIBLE
            binding.imgBatuCom.setOnClickListener {
                showDialog("SERI")
            }
            binding.imgGuntingCom.setOnClickListener {
                showDialog("PEMAIN 1 MENANG")
            }
            binding.imgKertasCom.setOnClickListener {
                showDialog("PEMAIN 2 MENANG")
            }
        }

        //player pilih gunting
        binding.imgGuntingPemain.setOnClickListener {
            binding.tvResultVS.visibility = View.VISIBLE
            binding.tvResultWin.visibility = View.INVISIBLE
            binding.imgBatuCom.setOnClickListener {
                showDialog("PEMAIN 2 MENANG")
            }
            binding.imgGuntingCom.setOnClickListener {
                showDialog("SERI")
            }
            binding.imgKertasCom.setOnClickListener {
                showDialog("PEMAIN 1 MENANG")
            }
        }

        //player pilih kertas
        binding.imgKertasPemain.setOnClickListener {
            binding.tvResultVS.visibility = View.VISIBLE
            binding.tvResultWin.visibility = View.INVISIBLE
            binding.imgBatuCom.setOnClickListener {
                showDialog("PEMAIN 1 MENANG")
            }
            binding.imgGuntingCom.setOnClickListener {
                showDialog("PEMAIN 2 MENANG")
            }
            binding.imgKertasCom.setOnClickListener {
                showDialog("SERI")
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


