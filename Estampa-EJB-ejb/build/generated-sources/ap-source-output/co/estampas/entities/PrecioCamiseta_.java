package co.estampas.entities;

import co.estampas.entities.Camiseta;
import co.estampas.entities.FacturaDetalle;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T22:32:01")
@StaticMetamodel(PrecioCamiseta.class)
public class PrecioCamiseta_ { 

    public static volatile SingularAttribute<PrecioCamiseta, String> precio;
    public static volatile SingularAttribute<PrecioCamiseta, Integer> idPrecioCamiseta;
    public static volatile ListAttribute<PrecioCamiseta, FacturaDetalle> facturaDetalleList;
    public static volatile ListAttribute<PrecioCamiseta, Camiseta> camisetaList;

}