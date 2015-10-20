package co.estampas.entities;

import co.estampas.entities.FacturaDetalle;
import co.estampas.entities.TamanoTexto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T22:32:01")
@StaticMetamodel(PrecioTexto.class)
public class PrecioTexto_ { 

    public static volatile SingularAttribute<PrecioTexto, String> precio;
    public static volatile ListAttribute<PrecioTexto, FacturaDetalle> facturaDetalleList;
    public static volatile SingularAttribute<PrecioTexto, Integer> idPrecioTexto;
    public static volatile ListAttribute<PrecioTexto, TamanoTexto> tamanoTextoList;

}