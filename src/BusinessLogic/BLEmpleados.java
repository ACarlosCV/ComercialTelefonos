package BusinessLogic;

import Aplication.frmREPempleados;
import BusinessEntities.BEEmpleados;
import DataAccess.DAEmpleados;
import Presentation.Login;
import Presentation.frmVendedor;
import java.awt.Label;
import java.awt.TextField;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class BLEmpleados {

    BEEmpleados entidad = new BEEmpleados();
    DAEmpleados empleado = new DAEmpleados();

    //ICONOS
    Icon lock = new ImageIcon(getClass().getResource("/Resources/images/lock-24px.png"));

    public void validar(String user, String pass) throws SQLException, IOException {
        if (!"".equals(user) || !"".equals(pass)) {
            entidad = empleado.validarLogin(user, pass);
            if (entidad.getEmpacceso() != null && entidad.getEmpcredencial() != null) {
                
                byte[] recuperar = entidad.getEmpfoto().getBytes(1, (int) entidad.getEmpfoto().length());
                BufferedImage img = ImageIO.read(new ByteArrayInputStream(recuperar));
                
                frmVendedor ventana = new frmVendedor(entidad.getEmpnombres(), entidad.getEmpapellidos(), img);
                ventana.setVisible(true);
                
            } else {
                Login l = new Login();
                l.setVisible(true);
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Validacion de usuario", JOptionPane.PLAIN_MESSAGE, lock);
            }
        }
    }

    public void listarEmpleados(JComboBox empleados) {
        empleado.listarEmpleados(empleados);
    }
    
    public void listarGeneros(JComboBox generos) {
        empleado.listarGeneros(generos);
    }
}
