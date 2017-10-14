package py.com.ffcc.jee.example.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_venta")
    private Long idDetalleVenta;

    @Column
    private String producto;

    @Column
    private BigDecimal precio;

    @Column
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name= "id_venta")
    private Venta venta;

    public Long getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Long idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.idDetalleVenta).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DetalleVenta) {
            final DetalleVenta other = (DetalleVenta) obj;
            return new EqualsBuilder().append(this.idDetalleVenta, other.idDetalleVenta).isEquals();
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "DetalleVenta [idDetalleVenta=" + idDetalleVenta + "]";
    }
}
