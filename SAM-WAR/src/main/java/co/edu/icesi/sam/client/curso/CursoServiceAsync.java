package co.edu.icesi.sam.client.curso;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import co.edu.icesi.sam.bo.CursoBO;

public interface CursoServiceAsync
{
    public void agregarCurso(CursoBO curso, AsyncCallback<Integer> callback);
    public void editarCurso(CursoBO curso, AsyncCallback<Integer> callback);
    public void buscarCurso(int idCurso, AsyncCallback<CursoBO> callback);
    public void listarCursos(AsyncCallback<List<CursoBO>> callback);
}
