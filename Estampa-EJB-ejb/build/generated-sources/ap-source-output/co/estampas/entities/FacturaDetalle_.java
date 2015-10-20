package co.estampas.entities;

import co.estampas.entities.Camiseta;
import co.estampas.entities.ColorCamiseta;
import co.estampas.entities.EstampaCamiseta;
import co.estampas.entities.Factura;
import co.estampas.entities.FormaPago;
import co.estampas.entities.LugarEstampaCamiseta;
import co.estampas.entities.MaterialCamiseta;
import co.estampas.entities.PrecioCamiseta;
import co.estampas.entities.PrecioEstampa;
import co.estampas.entities.PrecioTexto;
import co.estampas.entities.Stock;
import co.estampas.entities.TallaCamiseta;
import co.estampas.entities.TamanoEstampa;
import co.estampas.entities.TamanoTexto;
import co.estampas.entities.TemaEstampa;
import co.estampas.entities.TextoCamiseta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T22:32:01")
@StaticMetamodel(FacturaDetalle.class)
public class FacturaDetalle_ { 

    public static volatile SingularAttribute<FacturaDetalle, Stock> idStock;
    public static volatile SingularAttribute<FacturaDetalle, FormaPago> idFormaPago;
    public static volatile SingularAttribute<FacturaDetalle, TextoCamiseta> idTextoCamiseta;
    public static volatile SingularAttribute<FacturaDetalle, MaterialCamiseta> idMaterial;
    public static volatile SingularAttribute<FacturaDetalle, PrecioTexto> idPrecioTexto;
    public static volatile SingularAttribute<FacturaDetalle, TamanoEstampa> idTamanoEstampa;
    public static volatile SingularAttribute<FacturaDetalle, Integer> idFacturaDetalle;
    public static volatile SingularAttribute<FacturaDetalle, String> fecha;
    public static volatile SingularAttribute<FacturaDetalle, EstampaCamiseta> idEstampaCamiseta;
    public static volatile SingularAttribute<FacturaDetalle, TemaEstampa> idTemaEstampa;
    public static volatile SingularAttribute<FacturaDetalle, Camiseta> idCamiseta;
    public static volatile SingularAttribute<FacturaDetalle, Factura> idFactura;
    public static volatile SingularAttribute<FacturaDetalle, PrecioCamiseta> idPrecioCamiseta;
    public static volatile ListAttribute<FacturaDetalle, Factura> facturaList;
    public static volatile SingularAttribute<FacturaDetalle, TamanoTexto> idTamanoTexto;
    public static volatile SingularAttribute<FacturaDetalle, TallaCamiseta> idTalla;
    public static volatile SingularAttribute<FacturaDetalle, String> precioTotal;
    public static volatile SingularAttribute<FacturaDetalle, LugarEstampaCamiseta> idLugarEstampaCamiseta;
    public static volatile SingularAttribute<FacturaDetalle, PrecioEstampa> idPrecioEstampa;
    public static volatile SingularAttribute<FacturaDetalle, ColorCamiseta> idColor;

}