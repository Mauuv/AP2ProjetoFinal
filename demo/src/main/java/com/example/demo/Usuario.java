// Maurício
package com.example.demo;

public class Usuario {
    private int id;
    private String usuario;
    private String senha;
    private static boolean admin = false;

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

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
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
        if (!(o instanceof Usuario)) return false;
        Usuario other = (Usuario) o;
        return this.getUsuario().equals(other.getUsuario());
    }
}
