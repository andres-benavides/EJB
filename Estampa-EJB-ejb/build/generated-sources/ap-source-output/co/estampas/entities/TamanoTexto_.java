package co.estampas.entities;

import co.estampas.entities.FacturaDetalle;
import co.estampas.entities.PrecioTexto;
import co.estampas.entities.TextoCamiseta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T22:32:01")
@StaticMetamodel(TamanoTexto.class)
public class TamanoTexto_ { 

    public static volatile SingularAttribute<TamanoTexto, String> especificacionTamano;
    public static volatile ListAttribute<TamanoTexto, FacturaDetalle> facturaDetalleList;
    public static volatile SingularAttribute<TamanoTexto, Integer> idTamanoTexto;
    public static volatile SingularAttribute<TamanoTexto, PrecioTexto> idPrecioTexto;
    public static volatile ListAttribute<TamanoTexto, TextoCamiseta> textoCamisetaList;

}