package com.csci448.connorkoch.kotlinquiz

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_quiz.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val LOG_TAG = "448.MainActivity"
        private const val CURRENT_SCORE_KEY = "CURRENT_SCORE_KEY"
        private const val CURRENT_QUESTION_KEY = "CURRENT_QUESTION_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "MainActivity onCreate() called")
        setContentView(R.layout.activity_quiz)

        if( savedInstanceState != null ) {
            Log.d(LOG_TAG, "savedInstanceState is not null")
            val scoreHistory = savedInstanceState.getInt( CURRENT_SCORE_KEY );
            val priorQuestion = savedInstanceState.getInt(CURRENT_QUESTION_KEY);
            QuizMaster.currentScore = scoreHistory
            QuizMaster.currentQuestionIndex = priorQuestion
        }

        updateQuestion()
        true_button.setOnClickListener { checkAnswer(true) }
        false_button.setOnClickListener { checkAnswer(false) }
        prev_button.setOnClickListener { moveToQuestion(1) }
        next_button.setOnClickListener { moveToQuestion(-1) }
    }

    override fun onStart(){
        super.onStart()
        Log.d(LOG_TAG, "MainActivity onStart() called")
    }

    override fun onResume(){
        super.onResume()
        Log.d(LOG_TAG, "MainActivity onResume() called")
    }

    override fun onPause() {
        Log.d(LOG_TAG, "MainActivity onPause() called")
        super.onPause()
    }

    override fun onStop() {
        Log.d(LOG_TAG, "MainActivity onStop() called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(LOG_TAG, "MainActivity onDestroy() called")
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.d(LOG_TAG, "onSaveInstanceState() called")

        outState?.putInt( CURRENT_SCORE_KEY, QuizMaster.currentQuestionIndex )
    }

    private fun moveToQuestion(mv: Int){
        if(mv >= 0) QuizMaster.moveToNextQuestion()
        else QuizMaster.moveToPreviousQuestion()
        updateQuestion()
    }


    private fun updateQuestion(){
        setCurrentScoreText()
        question_text_view.text = resources.getString( QuizMaster.getCurrentQuestionTextId() )
    }

    private fun setCurrentScoreText() {
        score_text_view.text = QuizMaster.currentScore.toString()
    }

    private fun checkAnswer(ans: Boolean){
        if(QuizMaster.isAnswerCorrect(ans)){
            Toast.makeText(baseContext, R.string.correct_toast, Toast.LENGTH_SHORT).show()
            setCurrentScoreText()
        }
        else Toast.makeText(baseContext,
                R.string.incorrect_toast, Toast.LENGTH_SHORT).show()
    }

}


