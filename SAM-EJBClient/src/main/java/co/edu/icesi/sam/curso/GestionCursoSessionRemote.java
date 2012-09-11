package co.edu.icesi.sam.curso;

import java.util.List;

import javax.ejb.Remote;

import co.edu.icesi.sam.bo.CursoBO;

@Remote
public interface GestionCursoSessionRemote
{
    public int agregarCurso(CursoBO curso);
    public int editarCurso(CursoBO curso);
    public CursoBO buscarCurso(int idCurso);
    public List<CursoBO> listarCursos();
}
