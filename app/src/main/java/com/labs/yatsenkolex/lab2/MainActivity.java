package com.labs.yatsenkolex.lab2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Double firstValue;
    Double secondValue;
    String operation;
    Boolean point = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.actin_settings || super.onOptionsItemSelected(item);
    }

    public void buttonClick(View view) {
        Button button = (Button) view;
        String text = editText.getText().toString();
        text = text.substring(text.length());
        String pattern = "[0-9]*";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        if (m.matches()) {
            switch (button.getText().toString()) {
                case "C":
                    firstValue = null;
                    secondValue = null;
                    operation = null;
                    editText.setText("");
                    break;
                case ".":
                    firstValue = Double.valueOf(editText.getText().toString());
                    point = true;
                    editText.setText(editText.getText().toString() + button.getText());
                    break;
                case "<-":
                    String s = editText.getText().toString();
                    editText.setText(s.substring(0, s.length() - 1));
                    break;
                case "+":
                    if (point) break;
                    firstValue = Double.valueOf(editText.getText().toString());
                    operation = "+";
                    editText.setText(editText.getText().toString() + button.getText());
                    break;
                case "-":
                    if (point) break;
                    firstValue = Double.valueOf(editText.getText().toString());
                    operation = "-";
                    editText.setText(editText.getText().toString() + button.getText());
                    break;
                case "*":
                    if (point) break;
                    firstValue = Double.valueOf(editText.getText().toString());
                    operation = "*";
                    editText.setText(editText.getText().toString() + button.getText());
                    break;
                case "/":
                    if (point) break;
                    firstValue = Double.valueOf(editText.getText().toString());
                    operation = "/";
                    editText.setText(editText.getText().toString() + button.getText());
                    break;
                case "√":
                    if (point) break;
                    firstValue = Double.valueOf(editText.getText().toString());
                    operation = "√";
                    editText.setText(editText.getText().toString() + button.getText());
                    break;
                case "^":
                    if (point) break;
                    firstValue = Double.valueOf(editText.getText().toString());
                    operation = "^";
                    editText.setText(editText.getText().toString() + button.getText());
                    break;
                case "=":
                    if (point) break;
                    switch (operation) {
                        case "+":
                            editText.setText(String.valueOf((firstValue + secondValue)));
                            break;
                        case "-":
                            editText.setText(String.valueOf((firstValue - secondValue)));
                            break;
                        case "*":
                            editText.setText(String.valueOf((firstValue * secondValue)));
                            break;
                        case "/":
                            if (secondValue == 0) {
                                editText.setText("Деление на ноль");
                            } else {
                                editText.setText(String.valueOf(firstValue / secondValue));
                            }
                            break;
                        case "√":
                            editText.setText(String.valueOf(Math.round(Math.pow(firstValue, (1 / secondValue)))));
                            break;
                        case "^":
                            editText.setText(String.valueOf(Math.round(Math.pow(firstValue, secondValue))));
                            break;
                        default:
                            break;
                    }
                    firstValue = null;
                    secondValue = null;
                    operation = null;
                    break;
                default:
                    point = false;
                    if (operation != null) {
                        if (secondValue != null)
                            secondValue = Double.valueOf((String.valueOf(secondValue) + button.getText().toString()));
                        else
                            secondValue = Double.valueOf(button.getText().toString());
                    }
                    editText.setText(editText.getText().toString() + button.getText());
                    break;
            }
        }
    }
}