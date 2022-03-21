package com.heltonbustos.ejemplomvpbasicorefuerzo01.interactor;

import com.heltonbustos.ejemplomvpbasicorefuerzo01.presenter.LoginPresenterInterface;

public interface LoginInteractorInterface {
    void validarUsuario(String user, String pass, LoginPresenterInterface presentador);
}
