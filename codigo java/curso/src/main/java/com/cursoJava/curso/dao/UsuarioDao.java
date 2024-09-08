package com.cursoJava.curso.dao;

import com.cursoJava.curso.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List <Usuario> getUsuario();

    void eliminar(Long id);

    void registrar(Usuario usuario);

    Usuario obetenerCredenciales(Usuario usuario);

    Boolean existeUsuario(String idUsuario);
}
