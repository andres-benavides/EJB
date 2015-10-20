package co.estampas.entities;

import co.estampas.entities.EstampaCamiseta;
import co.estampas.entities.FacturaDetalle;
import co.estampas.entities.PrecioEstampa;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T22:32:01")
@StaticMetamodel(TamanoEstampa.class)
public class TamanoEstampa_ { 

    public static volatile SingularAttribute<TamanoEstampa, String> especificacionTamano;
    public static volatile ListAttribute<TamanoEstampa, EstampaCamiseta> estampaCamisetaList;
    public static volatile ListAttribute<TamanoEstampa, FacturaDetalle> facturaDetalleList;
    public static volatile SingularAttribute<TamanoEstampa, PrecioEstampa> idPrecioEstampa;
    public static volatile SingularAttribute<TamanoEstampa, Integer> idTamanoEstampa;

}