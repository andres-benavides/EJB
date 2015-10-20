package co.estampas.entities;

import co.estampas.entities.EstampaCamiseta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T22:32:01")
@StaticMetamodel(Artista.class)
public class Artista_ { 

    public static volatile SingularAttribute<Artista, String> password;
    public static volatile ListAttribute<Artista, EstampaCamiseta> estampaCamisetaList;
    public static volatile SingularAttribute<Artista, String> cedula;
    public static volatile SingularAttribute<Artista, Integer> idArtista;
    public static volatile SingularAttribute<Artista, String> apellido;
    public static volatile SingularAttribute<Artista, String> direccion;
    public static volatile SingularAttribute<Artista, String> celular;
    public static volatile SingularAttribute<Artista, String> usuario;
    public static volatile SingularAttribute<Artista, String> nombre;

}