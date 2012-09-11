package co.edu.icesi.sam.client.model;

import java.io.Serializable;
import java.util.List;

import com.extjs.gxt.ui.client.data.BaseModel;

public class UnidadModel extends BaseModel implements Serializable
{
    private int id;
    private int numero;
    private String nombre;
    private String contenido;
    private int idCurso;
    private String codigoCurso;
    private String nombreCurso;
    private List<Integer> metasTerminales;
    private List<Integer> sesiones;
    
    public UnidadModel( )
    {

    }

    public int getId( )
    {
        return id;
    }

    public int getNumero( )
    {
        return numero;
    }

    public String getNombre( )
    {
        return nombre;
    }

    public String getContenido( )
    {
        return contenido;
    }

    public int getIdCurso( )
    {
        return idCurso;
    }

    public String getCodigoCurso( )
    {
        return codigoCurso;
    }

    public String getNombreCurso( )
    {
        return nombreCurso;
    }

    public List<Integer> getMetasTerminales( )
    {
        return metasTerminales;
    }

    public List<Integer> getSesiones( )
    {
        return sesiones;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public void setNumero( int numero )
    {
        this.numero = numero;
    }

    public void setNombre( String nombre )
    {
        this.nombre = nombre;
    }

    public void setContenido( String contenido )
    {
        this.contenido = contenido;
    }

    public void setIdCurso( int idCurso )
    {
        this.idCurso = idCurso;
    }

    public void setCodigoCurso( String codigoCurso )
    {
        this.codigoCurso = codigoCurso;
    }

    public void setNombreCurso( String nombreCurso )
    {
        this.nombreCurso = nombreCurso;
    }

    public void setMetasTerminales( List<Integer> metasTerminales )
    {
        this.metasTerminales = metasTerminales;
    }

    public void setSesiones( List<Integer> sesiones )
    {
        this.sesiones = sesiones;
    }      
}
