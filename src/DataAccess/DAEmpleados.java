package DataAccess;

import BusinessEntities.BEEmpleados;
import com.mysql.cj.jdbc.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author Anthony
 */
public class DAEmpleados {
    Conexion cn = new Conexion();//objeto de conexion
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    BEEmpleados empleado = new BEEmpleados();
    
    public BEEmpleados validarLogin(String user, String pass) {  //validar inicio de sesion
        
        String sql = "SELECT * FROM empleados WHERE EMPacceso = ? AND EMPcredencial = ?";//consulta
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                empleado.setEmp_id(rs.getInt("EMP_id"));
                empleado.setCar_id(rs.getInt("CAR_id"));
                empleado.setEmpnombres(rs.getString("EMPnombres"));
                empleado.setEmpapellidos(rs.getString("EMPapellidos"));
                empleado.setEmpsexo(rs.getString("EMPsexo"));
                empleado.setEmpfoto((Blob) rs.getBlob("EMPfoto"));
                empleado.setEmpacceso(rs.getString("EMPacceso"));
                empleado.setEmpcredencial(rs.getString("EMPcredencial"));
                empleado.setCar_id(rs.getInt("CAR_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            
        }
        return empleado;
    }
    
    public void listarEmpleados(JComboBox empleados){
        String sql="SELECT EMPnombres,EMPapellidos FROM empleados";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                empleados.addItem(rs.getString("EMPnombres") + " " + rs.getString("EMPapellidos"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void listarGeneros(JComboBox generos){
        String sql="CALL sp_listarGeneros";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                generos.addItem(rs.getString("GENtipo"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }    
}
