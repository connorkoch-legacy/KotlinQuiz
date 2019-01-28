package com.csci448.connorkoch.kotlinquiz

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_quiz.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        updateQuestion()
        true_button.setOnClickListener { checkAnswer(true) }
        false_button.setOnClickListener { checkAnswer(false) }
        prev_button.setOnClickListener { moveToQuestion(1) }
        next_button.setOnClickListener { moveToQuestion(-1) }
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
