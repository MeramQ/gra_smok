package com.example.walkazesmokiem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int lives = 3;
    private Random rand = new Random();
    private int randomNumber = rand.nextInt(100);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editTextNumber);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(view -> {
            if (lives > 0) {
                String test = editText.getText().toString();

                if (test.isEmpty()) {
                    showAlertDialog("Wprowadź liczbę aby zagrać!");
                } else {
                    int guessedNumber = Integer.parseInt(test);
                    if (guessedNumber > 100 || guessedNumber < 0) {
                        showAlertDialog("Wprowadź poprawną liczbę!");
                    } else {

                        if (guessedNumber == randomNumber) {
                            showAlertDialog("Wygrałeś!");
                        } else {
                            lives--;
                            if (lives > 0) {
                                showAlertDialog("Przegrałeś! Pozostało " + lives + " żyć.");
                            } else {
                                lives = 3;
                                showAlertDialog("Przegrałeś! Skończyły się życia. Poprawną liczbą było " + randomNumber);
                                randomNumber = rand.nextInt(100);
                            }
                        }
                    }
                }
            } else {
                showAlertDialog("Przegrałeś! Skończyły się życia.");
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