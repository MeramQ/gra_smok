package com.example.walkazesmokiem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editTextNumber);
        Button button = findViewById(R.id.button);
        Random rand = new Random();

        button.setOnClickListener(view -> {
            String test = editText.getText().toString();

            if (test.isEmpty()){
                showAlertDialog("Wprowadź liczbę aby zagrać!");
            } else {
                int guessedNumber = Integer.parseInt(test);
                if (guessedNumber > 100 || guessedNumber < 0) {
                    showAlertDialog("Wprowadź poprawną liczbę!");
                } else {
                    int randomNumber = rand.nextInt(100);
                    if (guessedNumber == randomNumber) {
                        showAlertDialog("Wygrałeś!");
                    } else {
                        showAlertDialog("Przegrałeś! Poprawną liczbą było " + randomNumber);
                    }
                }
            }
        });
    }
    private void showAlertDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Walka ze smokiem").setMessage(message).setPositiveButton("OK", (dialog, id) -> {});
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}