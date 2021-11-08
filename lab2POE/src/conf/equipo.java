package conf;

import java.sql.*;
import java.util.Vector;

/**
 *
 * @author Usuario
 */
public class equipo {

    private int id_equipo;
    private String nombre_equipo;

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public String toString() {
        return this.nombre_equipo;
    }

    public Vector<equipo> mostrarEquipo() {

        conexion conn = new conexion();
        Connection conet = conn.getConnection();
        ResultSet rs;
        PreparedStatement ps = null;

        Vector<equipo> datos = new Vector<equipo>();
        equipo dat = null;
        try {
            String sql = "SELECT * FROM equipo";
            ps = conet.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new equipo();
            dat.setId_equipo(0);
            dat.setNombre_equipo("Seleccione equipo");
            datos.add(dat);

            while (rs.next()) {
                dat = new equipo();
                dat.setId_equipo(rs.getInt("id_equipo"));
                dat.setNombre_equipo(rs.getString("nombre_equipo"));
                datos.add(dat);
            }
            rs.close();
        } catch (Exception e) {
            System.err.println("" + e);
        }
        return datos;
    }
}
