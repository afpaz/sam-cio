package co.edu.icesi.sam.competencias;

import java.util.List;

import javax.ejb.Remote;

import co.edu.icesi.sam.bo.MaterialBO;
import co.edu.icesi.sam.bo.MetaTerminalBO;
import co.edu.icesi.sam.bo.ObjetivoEspecificoBO;
import co.edu.icesi.sam.bo.ObjetivoGeneralBO;
import co.edu.icesi.sam.bo.ObjetivoTerminalBO;
import co.edu.icesi.sam.bo.SaberBO;
import co.edu.icesi.sam.bo.SesionBO;
import co.edu.icesi.sam.bo.UnidadBO;

@Remote
public interface GestionCompetenciasSessionRemote
{
    public int agregarUnidad(UnidadBO unidad);
    public int editarUnidad(UnidadBO unidad);
    public UnidadBO buscarUnidad(int idUnidad);
    
    public int agregarObjGeneral(ObjetivoGeneralBO objGeneral);
    public int editarObjGeneral(ObjetivoGeneralBO objGeneral);
    public ObjetivoGeneralBO buscarObjGeneral(int idCurso);
    
    public int agregarObjTerminal(ObjetivoTerminalBO objTerminal);
    public int editarObjTerminal(ObjetivoTerminalBO objTerminal);
    public ObjetivoTerminalBO buscarObjTerminal(int idObjTerminal);
    
    public int agregarObjEspecifico(ObjetivoEspecificoBO objEspecifico);
    public int editarObjEspecifico(ObjetivoEspecificoBO objEspecifico);
    public ObjetivoEspecificoBO buscarObjEspecifico(int idObjEspecifico);
    
    public int agregarMetaTerminal(MetaTerminalBO metaTerminal);
    public int eliminarMetaTerminal(MetaTerminalBO metaTerminal);
    public MetaTerminalBO buscarMetaTerminal(int idMetaTerminal);   
}