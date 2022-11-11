package com.example.bigbom.Model;

import java.util.Objects;

public class Usuario {
    private int id;
    private static String usuario;
    private static String senha;
    private static boolean admin;

    public Usuario(String usuario, String senha, boolean admin) {
        this.usuario = usuario;
        this.senha = senha;
        this.admin = admin;
    }

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
        this.admin = false;
        // se receber somente o usuario e senha, o usuário cadastrado não será admin
    }

    public int getId() {
        return id;
    }
    public static String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public static String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString(){
        return "Id: " + id
                + System.lineSeparator() + "Usuário: " + usuario
                + System.lineSeparator() + "Senha: " + senha
                + System.lineSeparator() + "Admin: " + admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario1)) return false;
        return Objects.equals(getUsuario(), usuario1.getUsuario()) && Objects.equals(getSenha(), usuario1.getSenha());
    }
}
