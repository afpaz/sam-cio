package co.edu.icesi.sam.client.curso;

import java.util.List;

import co.edu.icesi.sam.bo.CursoBO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("CursoService")
public interface CursoService extends RemoteService
{
    public int agregarCurso(CursoBO curso);
    public int editarCurso(CursoBO curso);
    public CursoBO buscarCurso(int idCurso);
    public List<CursoBO> listarCursos();
}
