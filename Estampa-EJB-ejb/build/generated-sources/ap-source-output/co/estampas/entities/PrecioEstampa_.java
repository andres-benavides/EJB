package co.estampas.entities;

import co.estampas.entities.FacturaDetalle;
import co.estampas.entities.TamanoEstampa;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T22:32:01")
@StaticMetamodel(PrecioEstampa.class)
public class PrecioEstampa_ { 

    public static volatile ListAttribute<PrecioEstampa, TamanoEstampa> tamanoEstampaList;
    public static volatile SingularAttribute<PrecioEstampa, String> precio;
    public static volatile ListAttribute<PrecioEstampa, FacturaDetalle> facturaDetalleList;
    public static volatile SingularAttribute<PrecioEstampa, Integer> idPrecioEstampa;

}