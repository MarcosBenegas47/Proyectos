package com.cursoJava.curso.controllers;

import com.cursoJava.curso.dao.UsuarioDao;
import com.cursoJava.curso.models.Usuario;
import com.cursoJava.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final UsuarioDao usuarioDao;
    private final JWTUtil jwtUtil;
    public AuthController(UsuarioDao usuarioDao, JWTUtil jwtUtil){
        //esta es una alternativa para no utilizar el @Autowired
        //para la inyeccion de dependencias
        this.usuarioDao = usuarioDao;
        this.jwtUtil = jwtUtil;
    }


    @RequestMapping(value = "api/login",method = RequestMethod.POST)
    public String lgin(@RequestBody Usuario usuario){
        Usuario usuariologiado = usuarioDao.obetenerCredenciales(usuario);
        if (usuariologiado != null){
            return jwtUtil.create(String.valueOf(usuariologiado.getId()),usuariologiado.getEmail());


        }
        return "FAIL";
    }
}
