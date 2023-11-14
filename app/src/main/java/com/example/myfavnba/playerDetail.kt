package com.example.myfavnba

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class playerDetail : AppCompatActivity() {

    companion object{
        const val EXTRA_PLAYER = "extra_player"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_detail)



        val detailPlayer = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_PLAYER, nbaPlayer::class.java)
        } else {
            intent.getParcelableExtra(EXTRA_PLAYER)
        }

        if (detailPlayer != null) {
            findViewById<TextView>(R.id.nama_pemain).text = detailPlayer.name
            findViewById<TextView>(R.id.kelahiran_pemain).text = detailPlayer.kelahiran
            findViewById<TextView>(R.id.no_punggung).text = detailPlayer.no_punggung
            findViewById<TextView>(R.id.tinggi_pemain).text = detailPlayer.tinggi
            findViewById<TextView>(R.id.tim_saat_ini).text = detailPlayer.tim
            findViewById<TextView>(R.id.status_pemain).text = detailPlayer.status
            findViewById<TextView>(R.id.deskrisi_pemain).text = detailPlayer.description
            findViewById<ImageView>(R.id.player_photo).setImageResource(detailPlayer.photo)
            supportActionBar?.setTitle(detailPlayer.name)
        }
    }
}