package com.example.minggu_3

import androidx.lifecycle.ViewModel

class ScoreViewModel:ViewModel() {
    var scoreA: Int = 0
    var scoreB: Int = 0

    // Fungsi untuk menambah skor Tim A sebanyak 1
    fun incrementScoreA(){
        scoreA++
    }
    // Fungsi untuk menambah skorr tim B sebanyak 1
    fun incrementScoreB(){
        scoreB++
    }

    fun resetScore(){
        scoreA = 0
        scoreB = 0
    }
}