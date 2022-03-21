package com.heltonbustos.ejemplomvpbasicorefuerzo01.presenter;

import com.heltonbustos.ejemplomvpbasicorefuerzo01.interactor.LoginInteractorImpl;
import com.heltonbustos.ejemplomvpbasicorefuerzo01.interactor.LoginInteractorInterface;
import com.heltonbustos.ejemplomvpbasicorefuerzo01.vista.LoginViewInterface;

public class LoginPresenterImpl implements LoginPresenterInterface{

    LoginInteractorInterface interactor;
    LoginViewInterface vista;

    public LoginPresenterImpl(LoginViewInterface vista) {
        this.vista = vista;
        this.interactor = new LoginInteractorImpl();
    }

    @Override
    public void validarUsuario(String user, String pass) {
        interactor.validarUsuario(user, pass, this);
    }

    @Override
    public void exito() {
        vista.exito();
    }

    @Override
    public void error() {
        vista.error();
    }
}
