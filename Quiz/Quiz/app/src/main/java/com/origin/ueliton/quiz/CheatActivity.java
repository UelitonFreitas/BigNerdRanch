package com.origin.ueliton.quiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {


    private static final String EXTRA_ANSWER_IS_TRUE = "com.origin.ueliton.quiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOW = "com.origin.ueliton.quiz.answer_show";
    private Boolean mAnswerIsTrue;
    private Button mShowAnswerButton;
    private TextView mAnswerIsTrueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerIsTrueTextView = (TextView) findViewById(R.id.answer_text_view);

        mShowAnswerButton = (Button) findViewById(R.id.show_answer_button);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue)
                    mAnswerIsTrueTextView.setText(R.string.true_button);
                else
                    mAnswerIsTrueTextView.setText(R.string.false_button);

                setAnswerShowResult(true);
            }
        });

    }

    private void setAnswerShowResult(Boolean isAnswerShow) {

        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOW, isAnswerShow);
        setResult(RESULT_OK, data);
    }

    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return i;
    }

    public static Boolean wasAnswerShow(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOW, false);
    }
}
