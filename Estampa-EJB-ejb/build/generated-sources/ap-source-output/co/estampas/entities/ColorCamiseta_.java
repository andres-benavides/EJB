package co.estampas.entities;

import co.estampas.entities.Camiseta;
import co.estampas.entities.FacturaDetalle;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T22:32:01")
@StaticMetamodel(ColorCamiseta.class)
public class ColorCamiseta_ { 

    public static volatile SingularAttribute<ColorCamiseta, String> color;
    public static volatile ListAttribute<ColorCamiseta, FacturaDetalle> facturaDetalleList;
    public static volatile ListAttribute<ColorCamiseta, Camiseta> camisetaList;
    public static volatile SingularAttribute<ColorCamiseta, Integer> idColor;

}