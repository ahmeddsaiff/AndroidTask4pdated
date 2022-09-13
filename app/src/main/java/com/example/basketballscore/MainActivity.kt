package com.example.basketballscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var scoreTeam1: TextView
    private lateinit var scoreTeam2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //score views
        scoreTeam1 = findViewById(R.id.team1_score)
        scoreTeam2 = findViewById(R.id.team2_score)
        //team 1 buttons
        val Team1Add_2_pts = findViewById<Button>(R.id.team1_2points)
        val Team1Add_3_pts = findViewById<Button>(R.id.team1_3points)
        val Team1Add_1_pts = findViewById<Button>(R.id.team1_freeThrow)
        //team 2 buttons
        val Team2Add_2_pts = findViewById<Button>(R.id.team2_2points)
        val Team2Add_3_pts = findViewById<Button>(R.id.team2_3points)
        val Team2Add_1_pts = findViewById<Button>(R.id.team2_freeThrow)
        //reset button
        val ResetButton = findViewById<Button>(R.id.Reset)
        // Team 1 addition in score
        Team1Add_1_pts.setOnClickListener { addScore(1, scoreTeam1) }
        Team1Add_2_pts.setOnClickListener { addScore(2, scoreTeam1) }
        Team1Add_3_pts.setOnClickListener { addScore(3, scoreTeam1) }
        // Team 2 addition in score
        Team2Add_1_pts.setOnClickListener { addScore(1, scoreTeam2) }
        Team2Add_2_pts.setOnClickListener { addScore(2, scoreTeam2) }
        Team2Add_3_pts.setOnClickListener { addScore(3, scoreTeam2) }
        //Reset Button
        ResetButton.setOnClickListener {
            val ResTeam1 = 0
            val ResTeam2 = 0
            scoreTeam1.text = ResTeam1.toString()
            scoreTeam2.text = ResTeam2.toString()
        }
    }

    //adding function
    private fun addScore(points: Int, targetlabel: TextView) {
        val currentScore = targetlabel.text.toString().toInt()
        val newScore = currentScore + points
        targetlabel.text = "${newScore}"

        if (targetlabel.equals(scoreTeam1) && newScore >= 20) {
            OpenWinnerActivity("Team 1")
        } else if (targetlabel.equals(scoreTeam2) && newScore >= 20) {
            OpenWinnerActivity("Team 2")
        }
    }

    private fun OpenWinnerActivity(winnerTeam: String) {
        val intent: Intent = Intent(this, WinnerActivity::class.java)
        intent.putExtra("WinnerTeam", winnerTeam)
        startActivity(intent)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("Score_Team1", scoreTeam1.text.toString())
        outState.putString("Score_Team2", scoreTeam2.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        scoreTeam1.text = savedInstanceState.getString("Score_Team1")
        scoreTeam2.text = savedInstanceState.getString("Score_Team2")
    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//        val ResTeam1 = 0
//        val ResTeam2 = 0
//        scoreTeam1.text = ResTeam1.toString()
//        scoreTeam2.text = ResTeam2.toString()
//    }

}
