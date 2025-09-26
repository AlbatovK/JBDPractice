package org.example;

class User {
    private String name;
    private String email;
    private String password;

    // ... конструктор и геттеры/сеттеры ...
}

class AuthenticationService {
    public void register(String name, String email, String password) {
        // ... логика регистрации ...
    }

    public void authenticate(String email, String password) {
        // ... логика авторизации ...
    }
}

class PasswordRecoveryService {
    public void recoverPassword() {

    }
}

public class SingleResponsibility {
    public static void main(String[] args) {

    }
}
