package ru.khasang.honeymoney.registration.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.khasang.honeymoney.R;

public class RegistrationActivity extends Activity {
    public static int NEW_REG_CODE = 100;
    public static int RECOVER_CODE = 200;
    private Matcher matcher;

    @Bind(R.id.emailWrapper)
    TextInputLayout emailWrapper;
    @Bind(R.id.passwordFWrapper)
    TextInputLayout passwordFWrapper;
    @Bind(R.id.passwordSWrapper)
    TextInputLayout passwordSWrapper;
    @Bind(R.id.registrationLayout)
    LinearLayout registrationLayout;
    @Bind(R.id.recoverLayout)
    LinearLayout recoverLayout;

    final Pattern emailPattern = Pattern.compile(
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        int code = intent.getIntExtra("newreg", 0);
        Log.v("CODE", " code = " + code);
        if (code == RECOVER_CODE) {
            registrationLayout.setVisibility(View.GONE);
            recoverLayout.setVisibility(View.VISIBLE);
        }
    }


    public boolean validateEmail(String email) {
        matcher = emailPattern.matcher(email);
        return matcher.matches();
    }

    @OnClick(R.id.newRegist)
    public void register() {
        String email = emailWrapper.getEditText().getText().toString();
        if (validateEmail(email)) {
            Toast.makeText(this, "email ok", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Not a valid email address!", Toast.LENGTH_SHORT).show();
        }
    }
}
