package com.example.minggu_3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    private val _scoreA = MutableLiveData(0)
    val scoreA: LiveData<Int> get() = _scoreA

    private val _scoreB = MutableLiveData(0)
    val scoreB: LiveData<Int> get() = _scoreB

    private val _winner = MutableLiveData<String?>()
    val winner: LiveData<String?> get() = _winner

    private val WINNING_SCORE = 25

    fun incrementScoreA() {
        if (_winner.value == null) {
            _scoreA.value = (_scoreA.value ?: 0) + 1
            checkWinner()
        }
    }

    fun incrementScoreB() {
        if (_winner.value == null) {
            _scoreB.value = (_scoreB.value ?: 0) + 1
            checkWinner()
        }
    }

    private fun checkWinner() {
        if ((_scoreA.value ?: 0) >= WINNING_SCORE) {
            _winner.value = "Tim A Menang!"
        } else if ((_scoreB.value ?: 0) >= WINNING_SCORE) {
            _winner.value = "Tim B Menang!"
        }
    }

    fun resetScore() {
        _scoreA.value = 0
        _scoreB.value = 0
        _winner.value = null
    }
}