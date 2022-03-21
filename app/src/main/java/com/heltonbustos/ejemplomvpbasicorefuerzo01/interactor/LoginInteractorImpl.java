package com.heltonbustos.ejemplomvpbasicorefuerzo01.interactor;

import com.heltonbustos.ejemplomvpbasicorefuerzo01.presenter.LoginPresenterInterface;

public class LoginInteractorImpl implements LoginInteractorInterface{
    @Override
    public void validarUsuario(String user, String pass, LoginPresenterInterface presentador) {
        if(user.equals("admin") && pass.equals("123")){
            presentador.exito();
        }
        else{
            presentador.error();
        }
    }
}
