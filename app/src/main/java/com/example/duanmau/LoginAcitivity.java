package com.example.duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class LoginAcitivity extends AppCompatActivity {
    private TextInputLayout textInputLayout;
    private EditText textInputAccount;
    private TextInputLayout textInputLayout2;
    private EditText textInputPassword;
    private Pattern pattern;
    final String USERNAME_PATTERN = "^[a-z]$";
    private Button btnLogin;


    public LoginAcitivity() {
        pattern = Pattern.compile(USERNAME_PATTERN);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acitivi);

        textInputLayout = findViewById(R.id.textInputLayout);
        textInputAccount = findViewById(R.id.text_input_account);
        textInputLayout2 = findViewById(R.id.textInputLayout2);
        textInputPassword = findViewById(R.id.text_input_password);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textInputAccount.getText().toString().isEmpty() && textInputPassword.getText().toString().isEmpty()) {
                    Toast.makeText(LoginAcitivity.this, "Tai khoan mat khau trong", Toast.LENGTH_LONG).show();

                } else if (textInputAccount.getText().toString().equals("admin") && textInputPassword.getText().toString().equals("admin")) {

                    Intent intent = new Intent(LoginAcitivity.this, MainActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(LoginAcitivity.this, "Sai tai khoan mat khau", Toast.LENGTH_LONG).show();
                }

                textInputAccount.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        boolean match = textInputAccount.getText().toString().matches(USERNAME_PATTERN);
                        for (int j = 0; j < textInputAccount.getText().toString().length(); j++) {
                            String a = String.valueOf(textInputAccount.getText().toString().charAt(j));

                            if (a.matches(USERNAME_PATTERN)) {
                                textInputLayout.setErrorEnabled(false);

                            } else {
                                textInputAccount.setError("Khong chua ky tu dac biet");
                                btnLogin.setEnabled(false);

                            }

                        }

                        if (textInputAccount.getText().toString().length() > 15) {

                            textInputLayout.setError("Khong qua 15 ky tu");
                            btnLogin.setEnabled(false);


                        }


                    }

                    @Override
                    public void afterTextChanged(Editable editable) {


                    }
                });
                textInputPassword.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        if (textInputPassword.getText().toString().length() < 4) {
                            textInputPassword.setError("Mat khau lon hon 5 ky tu");
                        } else {

                        }
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

            }
        });




    }

    public void openMain(View view) {

    }

    public String removeUnicode(String value) {
        String temp = Normalizer.normalize(value, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").toLowerCase().replaceAll("đ", "d");
    }


}
