package co.estampas.entities;

import co.estampas.entities.Artista;
import co.estampas.entities.Camiseta;
import co.estampas.entities.FacturaDetalle;
import co.estampas.entities.TamanoEstampa;
import co.estampas.entities.TemaEstampa;
import co.estampas.entities.VotoEstampa;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T22:32:01")
@StaticMetamodel(EstampaCamiseta.class)
public class EstampaCamiseta_ { 

    public static volatile SingularAttribute<EstampaCamiseta, String> descripcion;
    public static volatile SingularAttribute<EstampaCamiseta, String> imagenes;
    public static volatile SingularAttribute<EstampaCamiseta, String> ubicacion;
    public static volatile SingularAttribute<EstampaCamiseta, Integer> idEstampaCamiseta;
    public static volatile SingularAttribute<EstampaCamiseta, String> precio;
    public static volatile SingularAttribute<EstampaCamiseta, TemaEstampa> idTemaEstampa;
    public static volatile ListAttribute<EstampaCamiseta, VotoEstampa> votoEstampaList;
    public static volatile SingularAttribute<EstampaCamiseta, Artista> idArtista;
    public static volatile ListAttribute<EstampaCamiseta, FacturaDetalle> facturaDetalleList;
    public static volatile SingularAttribute<EstampaCamiseta, Integer> idLugarEstampa;
    public static volatile ListAttribute<EstampaCamiseta, Camiseta> camisetaList;
    public static volatile SingularAttribute<EstampaCamiseta, TamanoEstampa> idTamanoEstampa;

}