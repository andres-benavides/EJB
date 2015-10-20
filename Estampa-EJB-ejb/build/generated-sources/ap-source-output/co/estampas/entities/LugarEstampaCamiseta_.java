package co.estampas.entities;

import co.estampas.entities.Camiseta;
import co.estampas.entities.FacturaDetalle;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T22:32:01")
@StaticMetamodel(LugarEstampaCamiseta.class)
public class LugarEstampaCamiseta_ { 

    public static volatile SingularAttribute<LugarEstampaCamiseta, String> especificacionLugar;
    public static volatile ListAttribute<LugarEstampaCamiseta, FacturaDetalle> facturaDetalleList;
    public static volatile SingularAttribute<LugarEstampaCamiseta, Integer> idLugarEstampaCamiseta;
    public static volatile ListAttribute<LugarEstampaCamiseta, Camiseta> camisetaList;

}