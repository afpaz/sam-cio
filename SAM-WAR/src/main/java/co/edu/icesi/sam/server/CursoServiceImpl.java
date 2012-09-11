package co.edu.icesi.sam.server;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.edu.icesi.sam.bo.CursoBO;
import co.edu.icesi.sam.client.curso.CursoService;
import co.edu.icesi.sam.curso.GestionCursoSessionRemote;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class CursoServiceImpl extends RemoteServiceServlet implements CursoService
{

    private InitialContext context;
    private GestionCursoSessionRemote cursoService;
    
    public CursoServiceImpl()
    {
        try
        {
            context = new InitialContext( );
            cursoService = (GestionCursoSessionRemote) context.lookup( "gestionCurso" );
        }
        catch(NamingException e)
        {
            e.printStackTrace( );
        }
    }
    
    @Override
    public int agregarCurso( CursoBO curso )
    {
        return cursoService.agregarCurso( curso );
    }

    @Override
    public int editarCurso( CursoBO curso )
    {
        return cursoService.editarCurso( curso );
    }

    @Override
    public CursoBO buscarCurso( int idCurso )
    {
        return cursoService.buscarCurso( idCurso );
    }

    @Override
    public List<CursoBO> listarCursos( )
    {
        return cursoService.listarCursos( );
    }

}
