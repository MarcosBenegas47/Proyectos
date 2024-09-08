import dao.EstudianteDao;
import dao.EstudianteDaoImp;
import models.Estudiantes;
import utils.conectarBD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.List;

public class crud_estudiantes extends JFrame{
    PreparedStatement ps;
    DefaultListModel mod = new DefaultListModel();
    Statement st;
    ResultSet res;
    private JPanel panel;
    private JTextField IdText;
    private JButton ingresarBt;
    private JButton consultarBt;
    private JList lista;
    private JTextField nombreText;
    private JTextField apellidoText;
    private JTextField edadText;
    private JTextField telefonoText;
    private JTextField carrearaText;
    EstudianteDaoImp estudianteDaoImp = new EstudianteDaoImp();

    public crud_estudiantes() {

        consultarBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    listar();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        ingresarBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ingresar();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public void listar() throws SQLException {

        lista.setModel(mod);
        List<Estudiantes>estudiantes =  estudianteDaoImp.listar();
        mod.removeAllElements();
        for(Estudiantes estudiante :estudiantes){
            mod.addElement(estudiante.getId() +" "+ estudiante.getNombre() + " "+ estudiante.getApellido());

        }

    }
    public void ingresar() throws SQLException {

        Estudiantes estudiantes = new Estudiantes(
                Long.parseLong(IdText.getText()),
                nombreText.getText(),
                apellidoText.getText(),
                carrearaText.getText(),
                telefonoText.getText(),
                Integer.parseInt(edadText.getText())
        );

        if(estudianteDaoImp.ingresar(estudiantes)){
            lista.setModel(mod);
            mod.removeAllElements();
            mod.addElement("Datos guardados correctamente");
            IdText.setText("");
            nombreText.setText("");
            apellidoText.setText("");
            edadText.setText("");
            telefonoText.setText("");
            carrearaText.setText("");
        }
    }

    public static void main(String[] args) {
        crud_estudiantes frame = new crud_estudiantes();
        frame.setContentPane(new crud_estudiantes().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
