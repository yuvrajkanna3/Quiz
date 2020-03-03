package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    int check = 0;
    CheckBox meat;
    CheckBox cheese;
    CheckBox milk;
    EditText editText;
    EditText editText1;
    String compareText1 = "delhi";
    String compareText = "pi";
    String finalText1;
    String finalText;
    RadioButton button1;
    RadioButton button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkbox(View view) {

        meat = findViewById(R.id.checkbox_meat);
        cheese = findViewById(R.id.checkbox_cheese);
        milk = findViewById(R.id.checkbox_milk);


        if (cheese.isChecked() && milk.isChecked()) {
            score = score + 2;
        }
        if (cheese.isChecked() && milk.isChecked() && meat.isChecked()) {
            reset(view);
        }
        if (cheese.isChecked() || milk.isChecked() || meat.isChecked()) {
            check = 1;
        }

    }

    public void onRadioButtonClicked(View view) {

        button1 = findViewById(R.id.radio_button_1);
        button2 = findViewById(R.id.radio_button_2);

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio_button_1:
                if (checked)
                    score = score + 1;
                break;
            case R.id.radio_button_2:
                if (checked)
                    break;

        }
    }

    private void editText() {
        editText = findViewById(R.id.textField);
        finalText = String.valueOf(editText.getText());
        if (finalText.equalsIgnoreCase(compareText)) {
            score = score + 3;
        } else {
            return;
        }

    }

    private void editText1() {
        editText1 = findViewById(R.id.textField1);
        finalText1 = String.valueOf(editText1.getText());
        if (finalText1.equalsIgnoreCase(compareText1)) {
            score = score + 3;
        } else {
            return;
        }

    }


    public void submit(View view) {
        editText();
        editText1();

        if (check == 0) {
            Toast toast = Toast.makeText(getApplication(), "Score : " + score+" / 9", Toast.LENGTH_LONG);
            toast.show();
        }
        if (check > 0) {
            Toast toast1 = Toast.makeText(getApplication(), "Score : " + score+" / 9" , Toast.LENGTH_LONG);
            toast1.show();
            if (meat.isChecked())
                meat.toggle();
            if (cheese.isChecked())
                cheese.toggle();
            if (milk.isChecked())
                milk.toggle();

        }
        RadioGroup radioGroup = findViewById(R.id.radiogroup);
        radioGroup.clearCheck();
        score = 0;
        editText.setText("");
        editText1.setText("");
        ScrollView scrollView = findViewById(R.id.scrollView);
        scrollView.smoothScrollTo(0, 0);
    }

    public void reset(View view) {
        Toast toast2 = Toast.makeText(this, "Choose any 2", Toast.LENGTH_LONG);
        toast2.show();
        score = 0;
        meat.toggle();
        cheese.toggle();
        milk.toggle();
    }
}
