package com.jean.rockpaperscissorsapp

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.jean.rockpaperscissorsapp.databinding.ActivityMenuBinding
import com.jean.rockpaperscissorsapp.versuspage.ActivityVSPlayer

class MenuActivity : AppCompatActivity() {

    companion object {
        const val NAME = "name"
    }

    private val binding: ActivityMenuBinding by lazy {
        ActivityMenuBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val name = intent.getStringExtra(NAME)


        binding.tvPlayervsplayer.text = "$name VS Pemain".uppercase()
        binding.tvPlayervscom.text = "$name VS CPU".uppercase()

        binding.btnVspemain.setOnClickListener {
            showDialog()
        }

        Snackbar.make(binding.root,"Selamat Datang $name", Snackbar.LENGTH_SHORT).show()
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_custom_dialog)
        val body = dialog.findViewById(R.id.ed_dial_body) as EditText
        val yesBtn = dialog.findViewById(R.id.btn_dial_yes) as Button
        val noBtn = dialog.findViewById(R.id.btn_dial_no) as Button
        val namePlayer1 = intent.getStringExtra(NAME)
        yesBtn.setOnClickListener {
            val namePlayer2 = body.text.toString()
            val intent = Intent(this, ActivityVSPlayer::class.java)
            intent.putExtra(ActivityVSPlayer.PLAYER_2,namePlayer2)
            intent.putExtra(ActivityVSPlayer.PLAYER_1,namePlayer1)
            startActivity(intent)
        }
        noBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

    }
}