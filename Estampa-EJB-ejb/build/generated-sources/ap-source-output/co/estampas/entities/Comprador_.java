package co.estampas.entities;

import co.estampas.entities.Factura;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T22:32:01")
@StaticMetamodel(Comprador.class)
public class Comprador_ { 

    public static volatile SingularAttribute<Comprador, String> password;
    public static volatile SingularAttribute<Comprador, Integer> idCliente;
    public static volatile SingularAttribute<Comprador, String> cedula;
    public static volatile SingularAttribute<Comprador, String> apellido;
    public static volatile SingularAttribute<Comprador, String> direccion;
    public static volatile ListAttribute<Comprador, Factura> facturaList;
    public static volatile SingularAttribute<Comprador, String> celular;
    public static volatile SingularAttribute<Comprador, String> usuario;
    public static volatile SingularAttribute<Comprador, String> nombre;

}