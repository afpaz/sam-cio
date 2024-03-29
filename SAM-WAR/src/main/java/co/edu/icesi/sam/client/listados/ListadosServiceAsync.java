package co.edu.icesi.sam.client.listados;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

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

public interface ListadosServiceAsync
{
    public void listarMaterialesPorCurso(int idCurso, AsyncCallback<List<MaterialBO>> callback);
    public void listarMetasTerminalesPorCurso(int idCurso, AsyncCallback<List<MetaTerminalBO>> callback);
    public void listarObjEspecificosPorCurso(int idCurso, AsyncCallback<List<ObjetivoEspecificoBO>> callback);
    public void listarObjEspecificosPorMetaTerminal(int idMetaTerminal, AsyncCallback<List<ObjetivoEspecificoBO>> callback);    
    public void listarObjEspecificosPorUnidad(int idUnidad,AsyncCallback<List<ObjetivoEspecificoBO>> callback);
    public void listarObjTerminalesPorCurso(int idCurso, AsyncCallback<List<ObjetivoTerminalBO>> callback);
    public void listarRecursosPorSaber(int idSaber, AsyncCallback<List<RecursoBO>> callback);
    public void listarSaberesPorCurso(int idCurso, AsyncCallback<List<SaberBO>> callback);
    public void listarSaberesPorObjetivoEspecifico(int idObjEspecifico, AsyncCallback<List<SaberBO>> callback);
    public void listarSesionesPorUnidad(int idUnidad, AsyncCallback<List<SesionBO>> callback);
    public void listarTrabajosAsignadosPorSesion(int idSesion, AsyncCallback<List<TrabajoAsignadoBO>> callback);
    public void listarRecursosAsignadosPorTrabajoAsignado(int idTrabajoAsignado, AsyncCallback<List<RecursoAsignadoBO>> callback);
    public void listarUnidadesPorCurso(int idCurso, AsyncCallback<List<UnidadBO>> callback);
}
