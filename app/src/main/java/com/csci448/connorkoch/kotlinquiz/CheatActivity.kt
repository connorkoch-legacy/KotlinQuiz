package com.csci448.connorkoch.kotlinquiz

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_cheat.*

class CheatActivity : AppCompatActivity() {

    companion object {
        private const val LOG_TAG = "448.CheatActivity"
        private const val ANSWER_KEY = "CORRECT_ANSWER_KEY"
        private const val CHEATED = "CHEATED"
        private const val STATUS = "OK"

        fun createIntent(context: Context, isAnswerTrue: Boolean): Intent{
            val intent = Intent(context, CheatActivity::class.java)
            intent.putExtra(ANSWER_KEY, isAnswerTrue)
            return intent
        }

        fun getCheatedString() = CHEATED
    }

    fun setCheated(){
        val intent = Intent()
        intent.putExtra(CHEATED, true)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "CheatActivity onCreate() called")
        setContentView(R.layout.activity_cheat)
        intent.getBooleanExtra(ANSWER_KEY, false)

        cheat_show_ans.setOnClickListener {
            cheat_text.text = QuizMaster.getCurrentAnswer().toString()
            cheat_text.visibility = View.VISIBLE
            setCheated()
        }
    }

    override fun onStart(){
        super.onStart()
        Log.d(LOG_TAG, "CheatActivity onStart() called")
    }

    override fun onResume(){
        super.onResume()
        Log.d(LOG_TAG, "CheatActivity onResume() called")
    }

    override fun onPause() {
        Log.d(LOG_TAG, "CheatActivity onPause() called")
        super.onPause()
    }

    override fun onStop() {
        Log.d(LOG_TAG, "CheatActivity onStop() called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(LOG_TAG, "CheatActivity onDestroy() called")
        super.onDestroy()
    }


}
