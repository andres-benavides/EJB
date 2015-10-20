package co.estampas.entities;

import co.estampas.entities.ColorCamiseta;
import co.estampas.entities.EstampaCamiseta;
import co.estampas.entities.FacturaDetalle;
import co.estampas.entities.LugarEstampaCamiseta;
import co.estampas.entities.MaterialCamiseta;
import co.estampas.entities.PrecioCamiseta;
import co.estampas.entities.TallaCamiseta;
import co.estampas.entities.TextoCamiseta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T22:32:01")
@StaticMetamodel(Camiseta.class)
public class Camiseta_ { 

    public static volatile SingularAttribute<Camiseta, EstampaCamiseta> idEstampaCamiseta;
    public static volatile SingularAttribute<Camiseta, TextoCamiseta> idTextoCamiseta;
    public static volatile SingularAttribute<Camiseta, Integer> idCamiseta;
    public static volatile SingularAttribute<Camiseta, PrecioCamiseta> idPrecioCamiseta;
    public static volatile ListAttribute<Camiseta, FacturaDetalle> facturaDetalleList;
    public static volatile SingularAttribute<Camiseta, TallaCamiseta> idTalla;
    public static volatile SingularAttribute<Camiseta, MaterialCamiseta> idMaterial;
    public static volatile SingularAttribute<Camiseta, Integer> cantidad;
    public static volatile SingularAttribute<Camiseta, LugarEstampaCamiseta> idLugarEstampaCamiseta;
    public static volatile SingularAttribute<Camiseta, ColorCamiseta> idColor;

}