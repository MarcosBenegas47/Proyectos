package dao;

import models.Estudiantes;

import java.util.List;

public interface EstudianteDao {
    public List<Estudiantes> listar();
    public  boolean ingresar(Estudiantes estudiantes);
}
