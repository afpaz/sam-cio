package co.edu.icesi.sam.listados;

import java.util.List;

import javax.ejb.Remote;

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

@Remote
public interface GestionListadosSessionRemote {
    
    public List<MaterialBO> listarMaterialesPorCurso(int idCurso);
    public List<MetaTerminalBO> listarMetasTerminalesPorCurso(int idCurso);
    public List<ObjetivoEspecificoBO> listarObjEspecificosPorCurso(int idCurso);
    public List<ObjetivoEspecificoBO> listarObjEspecificosPorMetaTerminal(int idMetaTerminal);    
    public List<ObjetivoEspecificoBO> listarObjEspecificosPorUnidad(int idUnidad);
    public List<ObjetivoTerminalBO> listarObjTerminalesPorCurso(int idCurso);
    public List<RecursoBO> listarRecursosPorSaber(int idSaber);
    public List<SaberBO> listarSaberesPorCurso(int idCurso);
    public List<SaberBO> listarSaberesPorObjetivoEspecifico(int idObjEspecifico);
    public List<SesionBO> listarSesionesPorUnidad(int idUnidad);
    public List<TrabajoAsignadoBO> listarTrabajosAsignadosPorSesion(int idSesion);
    public List<RecursoAsignadoBO> listarRecursosAsignadosPorTrabajoAsignado(int idTrabajoAsignado);
    public List<UnidadBO> listarUnidadesPorCurso(int idCurso);
}