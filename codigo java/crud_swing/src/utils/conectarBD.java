package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectarBD {
    private Connection conexion;
    private static conectarBD instance;
    private String url = "jdbc:mysql://localhost:3306/dbuser";


    public conectarBD() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion = DriverManager.getConnection(url,"root","1234");
            System.out.println("conectado");

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getConexion(){
        return conexion;
    }
    public static conectarBD getInstance() throws SQLException {
        if(instance == null || instance.getConexion().isClosed()){
            instance = new conectarBD();
        }
        return instance;
    }
}
