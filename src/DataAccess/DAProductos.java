/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import BusinessEntities.BEProductos;
import com.mysql.cj.jdbc.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anthony
 */
public class DAProductos {

    Conexion cn = new Conexion();//objeto de conexion
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    

    public List Listarproductos() {
        List<BEProductos> Listapro = new ArrayList();
        String sql = "SELECT p.PRO_id,p.PROmodelo,p.PROgama,d.DEScamara,p.PROfoto FROM productos AS p INNER JOIN descripciones AS d ON p.DES_id = d.DES_id;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//ejecuttar query
            while (rs.next()) {
                BEProductos pro = new BEProductos();
                pro.setPro_id(rs.getInt("p.PRO_id"));
                pro.setModelo(rs.getString("p.PROmodelo"));
                pro.setGama(rs.getString("p.PROgama"));
                pro.setCamara(rs.getString("d.DEScamara"));
                pro.setFoto((Blob)rs.getBlob("p.PROfoto"));
                Listapro.add(pro);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return Listapro;
    }
}
