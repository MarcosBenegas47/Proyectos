package com.cursoJava.curso.dao;

import com.cursoJava.curso.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Usuario> getUsuario() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public Usuario obetenerCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE email =:email ";
       List<Usuario> lista =  entityManager.createQuery(query)
                .setParameter("email",usuario.getEmail())
                .getResultList();

       if(lista.isEmpty()) return null;


       String passwordHash = lista.get(0).getPassword();
       Argon2 argon2 =  Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);
        if( argon2.verify(passwordHash, usuario.getPassword())){
            return lista.get(0);
        }
        return null;

    }

    @Override
    public Boolean existeUsuario(String idUsuario) {
        String query = "FROM Usuario WHERE id =:id ";
        List<Usuario> lista =  entityManager.createQuery(query)
                .setParameter("id",idUsuario)
                .getResultList();

        return !lista.isEmpty();
    }

}
