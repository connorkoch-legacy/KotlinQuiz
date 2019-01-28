package com.csci448.connorkoch.kotlinquiz

object QuizMaster {
    private val questionBank: MutableList<Question> = mutableListOf()
    var currentScore = 0
    private var currentQuestionIndex = 0

    init {
        questionBank.add(Question(R.string.question1, false))
        questionBank.add(Question(R.string.question2, true))
        questionBank.add(Question(R.string.question3, true))
        questionBank.add(Question(R.string.question4, true))
    }

    private fun getCurrentQuestion() = questionBank[currentQuestionIndex]
    fun getCurrentQuestionTextId() = getCurrentQuestion().textResId
    fun getCurrentAnswer() = getCurrentQuestion().isAnswerTrue

    fun moveToNextQuestion() {
        if(currentQuestionIndex == 3) currentQuestionIndex = 0
        else currentQuestionIndex++
    }

    fun moveToPreviousQuestion(){
        if(currentQuestionIndex == 0) currentQuestionIndex = 3
        else currentQuestionIndex--
    }

    fun isAnswerCorrect(ans: Boolean): Boolean{
        if(ans == getCurrentAnswer()) currentScore++
        return ans == getCurrentAnswer()
    }

}