package co.estampas.entities;

import co.estampas.entities.Camiseta;
import co.estampas.entities.FacturaDetalle;
import co.estampas.entities.TamanoTexto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T22:32:01")
@StaticMetamodel(TextoCamiseta.class)
public class TextoCamiseta_ { 

    public static volatile SingularAttribute<TextoCamiseta, Integer> idTextoCamiseta;
    public static volatile SingularAttribute<TextoCamiseta, String> descripcionTexto;
    public static volatile ListAttribute<TextoCamiseta, FacturaDetalle> facturaDetalleList;
    public static volatile SingularAttribute<TextoCamiseta, TamanoTexto> idTamanoTexto;
    public static volatile ListAttribute<TextoCamiseta, Camiseta> camisetaList;

}