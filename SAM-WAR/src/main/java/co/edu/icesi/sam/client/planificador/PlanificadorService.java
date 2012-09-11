package co.edu.icesi.sam.client.planificador;

import co.edu.icesi.sam.bo.MaterialBO;
import co.edu.icesi.sam.bo.RecursoAsignadoBO;
import co.edu.icesi.sam.bo.RecursoBO;
import co.edu.icesi.sam.bo.SaberBO;
import co.edu.icesi.sam.bo.SesionBO;
import co.edu.icesi.sam.bo.TrabajoAsignadoBO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("PlanificadorService")
public interface PlanificadorService extends RemoteService
{
    public int agregarMaterial(MaterialBO material);
    public int editarMaterial(MaterialBO material);
    public MaterialBO buscarMaterial(int idMaterial);
    
    public int agregarSaber(SaberBO saber);
    public int editarSaber(SaberBO saber);
    public SaberBO buscarSaber(int idSaber);
    
    public int agregarRecurso(RecursoBO recurso);
    public RecursoBO buscarRecurso(int idRecurso);
    public int eliminarRecurso(RecursoBO recurso);
    
    public int agregarSesion(SesionBO sesion);
    public int editarSesion(SesionBO sesion);
    public SesionBO buscarSesion(int idSesion);
    
    public int agregarTrabajoAsignado(TrabajoAsignadoBO trabajoAsignado);
    public int editarTrabajoAsignado(TrabajoAsignadoBO trabajoAsignado);
    public TrabajoAsignadoBO buscarTrabajoAsignado(int idTrabajoAsignado);
    
    public int agregarRecursoAsignado(RecursoAsignadoBO recursoAsignado);
    public int eliminarRecursoAsignado(RecursoAsignadoBO recursoAsignado);
    public RecursoAsignadoBO buscarRecursoAsignado(int idRecursoAsignado);
}
