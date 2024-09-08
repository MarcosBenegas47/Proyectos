package com.cursoJava.curso.controllers;

import com.cursoJava.curso.dao.UsuarioDao;
import com.cursoJava.curso.models.Usuario;
import com.cursoJava.curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private JWTUtil jwtUtil;
    @RequestMapping(value = "api/usuarios",method = RequestMethod.GET)
    public List<Usuario> getUsuario(@RequestHeader(value = "Authorization") String token){
        String idUsuario = jwtUtil.getKey(token);

        if(!usuarioDao.existeUsuario(idUsuario)) return new ArrayList<>();

        return usuarioDao.getUsuario();
    }

    @RequestMapping(value = "api/usuarios",method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);

        String hash = argon2.hash(1,1024,1,usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "api/usuario1")
    public Usuario editar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("marcos");
        usuario.setApellido("benegas");
        usuario.setEmail("correo@correo.com");
        usuario.setTelefono("1236626");
        return usuario;
    }


    @RequestMapping(value = "api/usuarios/{id}",method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){


        usuarioDao.eliminar(id);
    }


    @RequestMapping(value = "api/usuari3o")
    public Usuario buscar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("marcos");
        usuario.setApellido("benegas");
        usuario.setEmail("correo@correo.com");
        usuario.setTelefono("1236626");
        return usuario;
    }
}
