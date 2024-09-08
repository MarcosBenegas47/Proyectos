package dao;

import models.Estudiantes;
import utils.conectarBD;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDaoImp implements EstudianteDao{
    PreparedStatement ps = null;
    DefaultListModel mod = new DefaultListModel();
    Statement st;
    ResultSet res;
    @Override
    public List<Estudiantes> listar() {
        List<Estudiantes> listaEstudiante = new ArrayList<>();
        try {
            Connection con = conectarBD.getInstance().getConexion();
            st = con.createStatement();
            res = st.executeQuery("SELECT * FROM estudiante");
            while(res.next()){
                Estudiantes estudiantes = new Estudiantes(
                        res.getInt("id"),
                        res.getString("nombre"),
                        res.getString("apellido"),
                        res.getString("telefono"),
                        res.getString("carrera"),
                        res.getInt("edad")
                );
                listaEstudiante.add(estudiantes);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaEstudiante;
    }

    @Override
    public boolean ingresar(Estudiantes estudiantes) {
        try {
            Connection con = conectarBD.getInstance().getConexion();
            ps = con.prepareStatement("INSERT INTO estudiante VALUES (?, ?, ?, ?, ?, ?)");
            ps.setLong(1, estudiantes.getId());
            ps.setString(2, estudiantes.getNombre());
            ps.setString(3,estudiantes.getApellido());
            ps.setInt(4, estudiantes.getEdad());
            ps.setString(5,estudiantes.getTelefono());
            ps.setString(6,estudiantes.getCarrera());


            if(ps.executeUpdate()>0){
                return true;
            }


            System.out.println("ingresado correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
