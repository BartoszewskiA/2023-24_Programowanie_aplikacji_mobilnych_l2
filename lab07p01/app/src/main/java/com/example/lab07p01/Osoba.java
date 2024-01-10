package com.example.lab07p01;

public class Osoba {

    private String login;
    private String pass;
    Osoba(String login, String haslo)
    {
        this.login = login;
        this.pass = haslo;
    }

    public String getLogin()
    {
        return login;
    }

    public boolean sprawdzHaslo(String login , String haslo)
    {
        if(this.login.equals(login) && this.pass.equals(haslo))
            return true;
        else
            return false;
    }

}
