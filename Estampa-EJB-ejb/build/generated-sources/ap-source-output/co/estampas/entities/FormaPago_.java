package co.estampas.entities;

import co.estampas.entities.Factura;
import co.estampas.entities.FacturaDetalle;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T22:32:01")
@StaticMetamodel(FormaPago.class)
public class FormaPago_ { 

    public static volatile SingularAttribute<FormaPago, Integer> idFormaPago;
    public static volatile SingularAttribute<FormaPago, String> descripcionFormaPago;
    public static volatile ListAttribute<FormaPago, FacturaDetalle> facturaDetalleList;
    public static volatile ListAttribute<FormaPago, Factura> facturaList;

}