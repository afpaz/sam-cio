package co.edu.icesi.sam.client.planificador;

import com.google.gwt.user.client.rpc.AsyncCallback;

import co.edu.icesi.sam.bo.MaterialBO;
import co.edu.icesi.sam.bo.RecursoAsignadoBO;
import co.edu.icesi.sam.bo.RecursoBO;
import co.edu.icesi.sam.bo.SaberBO;
import co.edu.icesi.sam.bo.SesionBO;
import co.edu.icesi.sam.bo.TrabajoAsignadoBO;

public interface PlanificadorServiceAsync
{
    public void agregarMaterial(MaterialBO material, AsyncCallback<Integer> callback);
    public void editarMaterial(MaterialBO material, AsyncCallback<Integer> callback);
    public void buscarMaterial(int idMaterial, AsyncCallback<MaterialBO> callback);
    
    public void agregarSaber(SaberBO saber, AsyncCallback<Integer> callback);
    public void editarSaber(SaberBO saber, AsyncCallback<Integer> callback);
    public void buscarSaber(int idSaber, AsyncCallback<SaberBO> callback);
    
    public void agregarRecurso(RecursoBO recurso,AsyncCallback<Integer> callback);
    public void eliminarRecurso(RecursoBO recurso, AsyncCallback<Integer> callback);
    public void buscarRecurso(int idRecurso, AsyncCallback<RecursoBO> callback);
    
    public void agregarSesion(SesionBO sesion, AsyncCallback<Integer> callback);
    public void editarSesion(SesionBO sesion, AsyncCallback<Integer> callback);
    public void buscarSesion(int idSesion, AsyncCallback<SesionBO> callback);
    
    public void agregarTrabajoAsignado(TrabajoAsignadoBO trabajoAsignado, AsyncCallback<Integer> callback);
    public void editarTrabajoAsignado(TrabajoAsignadoBO trabajoAsignado, AsyncCallback<Integer> callback);
    public void buscarTrabajoAsignado(int idTrabajoAsignado, AsyncCallback<TrabajoAsignadoBO> callback);
    
    public void agregarRecursoAsignado(RecursoAsignadoBO recursoAsignado, AsyncCallback<Integer> callback);
    public void eliminarRecursoAsignado(RecursoAsignadoBO recursoAsignado, AsyncCallback<Integer> callback);
    public void buscarRecursoAsignado(int idRecursoAsignado, AsyncCallback<RecursoAsignadoBO> callback);
}
