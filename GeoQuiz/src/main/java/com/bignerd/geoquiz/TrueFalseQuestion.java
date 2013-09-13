package com.bignerd.geoquiz;

/**
 * Created by mdljohnston on 25/07/13.
 */
public class TrueFalseQuestion {

    private int mQuestion;
    private boolean mTrueQuestion;
    public TrueFalseQuestion(int question, boolean trueQuestion)
    {
        mQuestion = question;
        mTrueQuestion = trueQuestion;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean mTrueQuestion) {
        this.mTrueQuestion = mTrueQuestion;
    }


}
