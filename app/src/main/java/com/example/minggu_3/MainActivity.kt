package com.example.minggu_3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Menggunakan ScoreViewModel
    private val scoreViewModel: ScoreViewModel by viewModels()

    private lateinit var tvScoreA: TextView
    private lateinit var tvScoreB: TextView
    private lateinit var btnPlus1A: Button
    private lateinit var btnPlus2A: Button
    private lateinit var btnPlus1B: Button
    private lateinit var btnPlus2B: Button
    private lateinit var btnReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi UI
        tvScoreA = findViewById(R.id.tv_score_a)
        tvScoreB = findViewById(R.id.tv_score_b)
        btnPlus1A = findViewById(R.id.btn_plus1_a)
        btnPlus2A = findViewById(R.id.btn_plus2_a)
        btnPlus1B = findViewById(R.id.btn_plus1_b)
        btnPlus2B = findViewById(R.id.btn_plus2_b)
        btnReset = findViewById(R.id.btn_reset)

        // Menampilkan skor terakhir saat Activity dibuat ulang
        updateScores()

        // Event Listener untuk tombol Team A
        btnPlus1A.setOnClickListener {
            scoreViewModel.incrementScoreA()
            updateScores()
        }

        btnPlus2A.setOnClickListener {
            repeat(2) { scoreViewModel.incrementScoreA() }
            updateScores()
        }

        // Event Listener untuk tombol Team B
        btnPlus1B.setOnClickListener {
            scoreViewModel.incrementScoreB()
            updateScores()
        }

        btnPlus2B.setOnClickListener {
            repeat(2) { scoreViewModel.incrementScoreB() }
            updateScores()
        }

        // Tombol Reset
        btnReset.setOnClickListener {
            scoreViewModel.resetScore()
            updateScores()
        }

        // Mengatur padding sesuai dengan insets sistem (opsional)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Fungsi untuk memperbarui tampilan skor Kabaddi
    private fun updateScores() {
        tvScoreA.text = scoreViewModel.scoreA.toString()
        tvScoreB.text = scoreViewModel.scoreB.toString()
    }
}