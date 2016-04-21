package ru.khasang.honeymoney;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.khasang.honeymoney.registration.ui.RegistrationActivity;

public class AuthorizationFragment extends Fragment {

    @Bind(R.id.registration)
    TextView registration;

    public AuthorizationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View authView = inflater.inflate(R.layout.fragment_authorization, container, false);
        ButterKnife.bind(this, authView);
        return authView;
    }

    @OnClick(R.id.registration)
    public void newRegistrtion() {
        Intent intent = new Intent(getContext(), RegistrationActivity.class);
        intent.putExtra("newreg", RegistrationActivity.NEW_REG_CODE);
        startActivity(intent);
    }

    @OnClick(R.id.recoverPass)
    public void recoverPass() {
        startActivity(new Intent(getContext(), RegistrationActivity.class).putExtra("newreg", RegistrationActivity.RECOVER_CODE));
    }

}
