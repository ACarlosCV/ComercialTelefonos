package BusinessEntities;

import com.mysql.cj.jdbc.Blob;
import java.util.Date;

/**
 *
 * @author Anthony Carlos Casas Vila - U20311746
 */

public class BEProductos {
    private int pro_id;
    private String modelo;
    private String ram;
    private String rom;
    private String camara;
    private String bateria;
    private String pantalla;
    private String gama;
    private Blob foto;
    private String lote;
    private int stock;
    private int precio;
    private Date empfechareg;
    private int estado;

    public BEProductos() {
    }

    public BEProductos(int pro_id, String modelo, String ram, String rom, String camara, String bateria, String pantalla, String gama, Blob foto, String lote, int stock, int precio, Date empfechareg, int estado) {
        this.pro_id = pro_id;
        this.modelo = modelo;
        this.ram = ram;
        this.rom = rom;
        this.camara = camara;
        this.bateria = bateria;
        this.pantalla = pantalla;
        this.gama = gama;
        this.foto = foto;
        this.lote = lote;
        this.stock = stock;
        this.precio = precio;
        this.empfechareg = empfechareg;
        this.estado = estado;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getCamara() {
        return camara;
    }

    public void setCamara(String camara) {
        this.camara = camara;
    }

    public String getBateria() {
        return bateria;
    }

    public void setBateria(String bateria) {
        this.bateria = bateria;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Date getEmpfechareg() {
        return empfechareg;
    }

    public void setEmpfechareg(Date empfechareg) {
        this.empfechareg = empfechareg;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
