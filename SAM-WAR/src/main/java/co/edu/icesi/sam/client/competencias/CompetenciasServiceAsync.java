package co.edu.icesi.sam.client.competencias;

import com.google.gwt.user.client.rpc.AsyncCallback;

import co.edu.icesi.sam.bo.MetaTerminalBO;
import co.edu.icesi.sam.bo.ObjetivoEspecificoBO;
import co.edu.icesi.sam.bo.ObjetivoGeneralBO;
import co.edu.icesi.sam.bo.ObjetivoTerminalBO;
import co.edu.icesi.sam.bo.UnidadBO;

public interface CompetenciasServiceAsync
{
    public void agregarUnidad(UnidadBO unidad, AsyncCallback<Integer> callback);
    public void editarUnidad(UnidadBO unidad, AsyncCallback<Integer> callback);
    public void buscarUnidad(int idUnidad, AsyncCallback<UnidadBO> callback);
    
    public void agregarObjGeneral(ObjetivoGeneralBO objGeneral, AsyncCallback<Integer> callback);
    public void editarObjGeneral(ObjetivoGeneralBO objGeneral, AsyncCallback<Integer> callback);
    public void buscarObjGeneral(int idCurso, AsyncCallback<ObjetivoGeneralBO> callback);
    
    public void agregarObjTerminal(ObjetivoTerminalBO objTerminal, AsyncCallback<Integer> callback);
    public void editarObjTerminal(ObjetivoTerminalBO objTerminal, AsyncCallback<Integer> callback);
    public void buscarObjTerminal(int idObjTerminal, AsyncCallback<ObjetivoTerminalBO> callback);
    
    public void agregarObjEspecifico(ObjetivoEspecificoBO objEspecifico, AsyncCallback<Integer> callback);
    public void editarObjEspecifico(ObjetivoEspecificoBO objEspecifico, AsyncCallback<Integer> callback);
    public void buscarObjEspecifico(int idObjEspecifico, AsyncCallback<ObjetivoEspecificoBO> callback);
    
    public void agregarMetaTerminal(MetaTerminalBO metaTerminal, AsyncCallback<Integer> callback);
    public void eliminarMetaTerminal(MetaTerminalBO metaTerminal, AsyncCallback<Integer> callback);
    public void buscarMetaTerminal(int idMetaTerminal, AsyncCallback<MetaTerminalBO> callback);
}
