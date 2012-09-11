package co.edu.icesi.sam.server;


import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.edu.icesi.sam.bo.MaterialBO;
import co.edu.icesi.sam.bo.MetaTerminalBO;
import co.edu.icesi.sam.bo.ObjetivoEspecificoBO;
import co.edu.icesi.sam.bo.ObjetivoTerminalBO;
import co.edu.icesi.sam.bo.RecursoAsignadoBO;
import co.edu.icesi.sam.bo.RecursoBO;
import co.edu.icesi.sam.bo.SaberBO;
import co.edu.icesi.sam.bo.SesionBO;
import co.edu.icesi.sam.bo.TrabajoAsignadoBO;
import co.edu.icesi.sam.bo.UnidadBO;
import co.edu.icesi.sam.client.listados.ListadosService;
import co.edu.icesi.sam.listados.GestionListadosSessionRemote;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ListadosServiceImpl extends RemoteServiceServlet implements ListadosService
{
    
    private InitialContext context;
    private GestionListadosSessionRemote listadosService;
    
    public ListadosServiceImpl( )
    {
        try
        {
            context = new InitialContext( );
            listadosService = (GestionListadosSessionRemote) context.lookup( "gestionListados" );
        }
        catch( NamingException e )
        {
            e.printStackTrace( );
        }
    }
    
    @Override
    public List<MaterialBO> listarMaterialesPorCurso( int idCurso )
    {
        return listadosService.listarMaterialesPorCurso( idCurso );
    }

    @Override
    public List<MetaTerminalBO> listarMetasTerminalesPorCurso( int idCurso )
    {
        return listadosService.listarMetasTerminalesPorCurso( idCurso );
    }

    @Override
    public List<ObjetivoEspecificoBO> listarObjEspecificosPorCurso( int idCurso )
    {
        return listadosService.listarObjEspecificosPorCurso( idCurso );
    }

    @Override
    public List<ObjetivoEspecificoBO> listarObjEspecificosPorMetaTerminal( int idMetaTerminal )
    {
        return listadosService.listarObjEspecificosPorMetaTerminal( idMetaTerminal );
    }

    @Override
    public List<ObjetivoEspecificoBO> listarObjEspecificosPorUnidad( int idUnidad )
    {
        return listadosService.listarObjEspecificosPorUnidad( idUnidad );
    }

    @Override
    public List<ObjetivoTerminalBO> listarObjTerminalesPorCurso( int idCurso )
    {
        return listadosService.listarObjTerminalesPorCurso( idCurso );
    }

    @Override
    public List<RecursoBO> listarRecursosPorSaber( int idSaber )
    {
        return listadosService.listarRecursosPorSaber( idSaber );
    }

    @Override
    public List<SaberBO> listarSaberesPorCurso(int idCurso)
    {
        return listadosService.listarSaberesPorCurso( idCurso );
    }
    
    @Override
    public List<SaberBO> listarSaberesPorObjetivoEspecifico( int idObjEspecifico )
    {
        return listadosService.listarSaberesPorObjetivoEspecifico( idObjEspecifico );
    }

    @Override
    public List<SesionBO> listarSesionesPorUnidad( int idUnidad )
    {
        return listadosService.listarSesionesPorUnidad( idUnidad );
    }

    @Override
    public List<TrabajoAsignadoBO> listarTrabajosAsignadosPorSesion( int idSesion )
    {
        return listadosService.listarTrabajosAsignadosPorSesion( idSesion );
    }

    @Override
    public List<RecursoAsignadoBO> listarRecursosAsignadosPorTrabajoAsignado( int idTrabajoAsignado )
    {
        return listadosService.listarRecursosAsignadosPorTrabajoAsignado( idTrabajoAsignado );
    }

    @Override
    public List<UnidadBO> listarUnidadesPorCurso( int idCurso )
    {
        return listadosService.listarUnidadesPorCurso( idCurso );
    }    
}
