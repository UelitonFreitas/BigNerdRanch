package com.origin.ueliton.quiz;

/**
 * Created by ueliton on 17/01/2016.
 */
public class Question {
    private int mTextRestId;
    private boolean mAnswerTrue;

    public Question(int mTextRestId, boolean mAnswerTrue) {
        this.mTextRestId = mTextRestId;
        this.mAnswerTrue = mAnswerTrue;
    }

    public int getTextResId() {
        return mTextRestId;
    }

    public void setTextRestId(int textRestId) {
        mTextRestId = textRestId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
