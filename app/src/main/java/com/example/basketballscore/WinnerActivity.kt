package com.example.basketballscore

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class WinnerActivity : AppCompatActivity() {

    private lateinit var scoreTeam1: TextView
    private lateinit var scoreTeam2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)
        val winner = intent.getStringExtra("WinnerTeam")
        val winnerTeam = findViewById<TextView>(R.id.winnerLabel)
        winnerTeam.text = "$winner"

        val sendingScore = findViewById<Button>(R.id.SendButton)
        sendingScore.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "$winner is the winner today")
            intent.type = "text/plain"

            try {
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {

            }
        }
    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//       val intent: Intent = Intent(this, MainActivity::class.java)
//        intent.putExtra("ResetScore" , 0)
//        startActivity(intent)
//        val ResTeam1 = 0
//        val ResTeam2 = 0
//        scoreTeam1.text = ResTeam1.toString()
//        scoreTeam2.text = ResTeam2.toString()
//    }
}