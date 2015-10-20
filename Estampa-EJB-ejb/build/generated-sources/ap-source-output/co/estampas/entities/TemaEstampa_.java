package co.estampas.entities;

import co.estampas.entities.EstampaCamiseta;
import co.estampas.entities.FacturaDetalle;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T22:32:01")
@StaticMetamodel(TemaEstampa.class)
public class TemaEstampa_ { 

    public static volatile SingularAttribute<TemaEstampa, String> tipoTema;
    public static volatile SingularAttribute<TemaEstampa, Integer> idTemaEstampa;
    public static volatile ListAttribute<TemaEstampa, EstampaCamiseta> estampaCamisetaList;
    public static volatile ListAttribute<TemaEstampa, FacturaDetalle> facturaDetalleList;

}