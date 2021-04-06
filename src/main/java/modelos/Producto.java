package modelos;

public class Producto {

    private int id;
    private String nombre;
    private String descripcion;
    private double precioCompra;
    private double precioVenta;
    private int cantidadMinimaStock;
    private int idProveedor;

    public Producto() {

    }

    public Producto(int id, String nombre, String descripcion, double precio, double precioVenta, int cantidadMinimaStock, int idProveedor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCompra = precio;
        this.precioVenta = precioVenta;
        this.cantidadMinimaStock = cantidadMinimaStock;
        this.idProveedor = idProveedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidadMinimaStock() {
        return cantidadMinimaStock;
    }

    public void setCantidadMinimaStock(int cantidadMinimaStock) {
        this.cantidadMinimaStock = cantidadMinimaStock;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
}
