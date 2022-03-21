package com.heltonbustos.ejemplomvpbasicorefuerzo01.presenter;

public interface LoginPresenterInterface {
    void validarUsuario(String user, String pass);
    void exito();
    void error();
}
