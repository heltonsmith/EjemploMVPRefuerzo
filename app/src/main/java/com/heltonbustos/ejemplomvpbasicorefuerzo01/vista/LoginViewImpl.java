package com.heltonbustos.ejemplomvpbasicorefuerzo01.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.heltonbustos.ejemplomvpbasicorefuerzo01.R;
import com.heltonbustos.ejemplomvpbasicorefuerzo01.presenter.LoginPresenterImpl;
import com.heltonbustos.ejemplomvpbasicorefuerzo01.presenter.LoginPresenterInterface;

public class LoginViewImpl extends AppCompatActivity implements LoginViewInterface{

    Button btnLogin;
    EditText txtUser, txtPass;
    LoginPresenterInterface presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presentador = new LoginPresenterImpl(this);

        txtUser = findViewById(R.id.txtUser);
        txtPass = findViewById(R.id.txtPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presentador.validarUsuario(txtUser.getText().toString(), txtPass.getText().toString());
            }
        });
    }

    @Override
    public void exito() {
        Toast.makeText(this, "Bienvenido usuario", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void error() {
        Toast.makeText(this, "ERROR: Cuenta no existe", Toast.LENGTH_SHORT).show();
    }
}