package co.estampas.entities;

import co.estampas.entities.Comprador;
import co.estampas.entities.FacturaDetalle;
import co.estampas.entities.FormaPago;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T22:32:01")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, String> fecha;
    public static volatile SingularAttribute<Factura, FormaPago> idFormaPago;
    public static volatile SingularAttribute<Factura, Comprador> idCliente;
    public static volatile SingularAttribute<Factura, Integer> idFactura;
    public static volatile ListAttribute<Factura, FacturaDetalle> facturaDetalleList;
    public static volatile SingularAttribute<Factura, String> precioTotal;
    public static volatile SingularAttribute<Factura, FacturaDetalle> idFacturaDetalle;

}