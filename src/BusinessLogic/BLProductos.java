package BusinessLogic;

import BusinessEntities.BEProductos;
import DataAccess.DAProductos;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.SQLException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anthony Carlos Casas Vila - U20311746
 */
public class BLProductos {

    DAProductos productos = new DAProductos();
    DefaultTableModel modelo = new DefaultTableModel();

    public void listarProductos(JTable tabla) throws SQLException {
        List<BEProductos> Listarpro = productos.Listarproductos();
        
        modelo = (DefaultTableModel) tabla.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < Listarpro.size(); i++) {
            
            ob[0] = Listarpro.get(i).getPro_id();
            ob[1] = Listarpro.get(i).getModelo();
            ob[2] = Listarpro.get(i).getGama();
            ob[3] = Listarpro.get(i).getCamara();
            
            ob[4] = Listarpro.get(i).getFoto();

            modelo.addRow(ob);
        }
        tabla.setModel(modelo);
    }
}
