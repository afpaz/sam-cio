package co.edu.icesi.sam.bo;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ObjetivoGeneralBO implements IsSerializable
{
    private int id;
    private String contenido;
    private int idCurso;
    private String codigoCurso;
    private String nombreCurso;
    
    public ObjetivoGeneralBO( )
    {
        
    }

    public int getId( )
    {
        return id;
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

    public void setId( int id )
    {
        this.id = id;
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
}
