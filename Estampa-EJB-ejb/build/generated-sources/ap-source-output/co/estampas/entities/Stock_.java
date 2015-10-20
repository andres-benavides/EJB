package co.estampas.entities;

import co.estampas.entities.FacturaDetalle;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T22:32:01")
@StaticMetamodel(Stock.class)
public class Stock_ { 

    public static volatile SingularAttribute<Stock, Integer> idStock;
    public static volatile ListAttribute<Stock, FacturaDetalle> facturaDetalleList;
    public static volatile SingularAttribute<Stock, Integer> cantidad;

}