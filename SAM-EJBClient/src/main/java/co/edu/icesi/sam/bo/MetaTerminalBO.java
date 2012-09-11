package co.edu.icesi.sam.bo;

import java.io.Serializable;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class MetaTerminalBO implements IsSerializable
{
    private int id;
    private int idUnidad;
    private int numeroUnidad;
    private String nombreUnidad;
    private String contenidoUnidad;
    private int idObjTerminal;
    private String nombreObjTerminal;
    private String contenidoObjTerminal;
    private List<Integer> objEspecificos; 
    
    public MetaTerminalBO()
    {
        
    }

    public int getId( )
    {
        return id;
    }

    public int getIdUnidad( )
    {
        return idUnidad;
    }

    public int getNumeroUnidad( )
    {
        return numeroUnidad;
    }

    public String getNombreUnidad( )
    {
        return nombreUnidad;
    }

    public String getContenidoUnidad( )
    {
        return contenidoUnidad;
    }

    public int getIdObjTerminal( )
    {
        return idObjTerminal;
    }

    public String getNombreObjTerminal( )
    {
        return nombreObjTerminal;
    }

    public String getContenidoObjTerminal( )
    {
        return contenidoObjTerminal;
    }

    public List<Integer> getObjEspecificos( )
    {
        return objEspecificos;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public void setIdUnidad( int idUnidad )
    {
        this.idUnidad = idUnidad;
    }

    public void setNumeroUnidad( int numeroUnidad )
    {
        this.numeroUnidad = numeroUnidad;
    }

    public void setNombreUnidad( String nombreUnidad )
    {
        this.nombreUnidad = nombreUnidad;
    }

    public void setContenidoUnidad( String contenidoUnidad )
    {
        this.contenidoUnidad = contenidoUnidad;
    }

    public void setIdObjTerminal( int idObjTerminal )
    {
        this.idObjTerminal = idObjTerminal;
    }

    public void setNombreObjTerminal( String nombreObjTerminal )
    {
        this.nombreObjTerminal = nombreObjTerminal;
    }

    public void setContenidoObjTerminal( String contenidoObjTerminal )
    {
        this.contenidoObjTerminal = contenidoObjTerminal;
    }

    public void setObjEspecificos( List<Integer> objEspecificos )
    {
        this.objEspecificos = objEspecificos;
    }                
}
