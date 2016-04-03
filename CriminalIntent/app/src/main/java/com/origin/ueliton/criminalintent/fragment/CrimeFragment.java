    package com.origin.ueliton.criminalintent.fragment;

    import android.os.Bundle;
    import android.support.annotation.Nullable;
    import android.support.v4.app.Fragment;
    import android.text.Editable;
    import android.text.TextWatcher;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.Button;
    import android.widget.CheckBox;
    import android.widget.CompoundButton;
    import android.widget.EditText;

    import com.origin.ueliton.criminalintent.R;
    import com.origin.ueliton.criminalintent.model.Crime;

    import java.text.SimpleDateFormat;
    import java.util.Locale;

    /**
     * A simple {@link Fragment} subclass.
     */
    public class CrimeFragment extends Fragment {

        private Crime mCrime;
        private EditText mTitleField;
        private Button mDateButton;
        private CheckBox mSolvedCheckBox;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            mCrime = new Crime();
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.fragment_crime, container, false);

            mTitleField = (EditText) view.findViewById(R.id.crime_title);
            mTitleField.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    // This space intentionally left blank
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    mCrime.setTitle(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {
                    // This one too
                }
            });

            mDateButton = (Button) view.findViewById(R.id.crime_date);

            String pattern = "EEEE, MMM d, yyy";
            SimpleDateFormat formatter = new SimpleDateFormat(pattern, new Locale("en", "US"));
            mDateButton.setText(formatter.format(mCrime.getDate()));
            mDateButton.setEnabled(false);

            mSolvedCheckBox = (CheckBox) view.findViewById(R.id.crime_solved);
            mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    // Set the crime's solved property
                    mCrime.setSolved(isChecked);
                }
            });

            return view;
        }
    }
