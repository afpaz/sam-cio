/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package co.edu.icesi.sam.server;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.edu.icesi.sam.bo.MetaTerminalBO;
import co.edu.icesi.sam.bo.ObjetivoEspecificoBO;
import co.edu.icesi.sam.bo.ObjetivoGeneralBO;
import co.edu.icesi.sam.bo.ObjetivoTerminalBO;
import co.edu.icesi.sam.bo.UnidadBO;
import co.edu.icesi.sam.client.competencias.CompetenciasService;
import co.edu.icesi.sam.client.listados.ListadosService;
import co.edu.icesi.sam.competencias.GestionCompetenciasSessionRemote;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class CompetenciasServiceImpl extends RemoteServiceServlet implements CompetenciasService
{

    private GestionCompetenciasSessionRemote competenciasRemote;
    private InitialContext context;

    public CompetenciasServiceImpl( )
    {
        try
        {
            context = new InitialContext( );
            competenciasRemote = (GestionCompetenciasSessionRemote) context.lookup( "gestionCompetencias" );
        }
        catch( NamingException e )
        {
            e.printStackTrace( );
        }

    }
    @Override
    public int agregarUnidad( UnidadBO unidad )
    {
        return competenciasRemote.agregarUnidad( unidad );
    }

    @Override
    public int editarUnidad( UnidadBO unidad )
    {
        return competenciasRemote.editarUnidad( unidad );
    }

    @Override
    public UnidadBO buscarUnidad( int idUnidad )
    {
        return competenciasRemote.buscarUnidad( idUnidad );
    }

    @Override
    public int agregarObjGeneral( ObjetivoGeneralBO objGeneral )
    {
        return competenciasRemote.agregarObjGeneral( objGeneral );
    }

    @Override
    public int editarObjGeneral( ObjetivoGeneralBO objGeneral )
    {
        return competenciasRemote.editarObjGeneral( objGeneral );
    }

    @Override
    public ObjetivoGeneralBO buscarObjGeneral( int idCurso )
    {
        return competenciasRemote.buscarObjGeneral( idCurso );
    }

    @Override
    public int agregarObjTerminal( ObjetivoTerminalBO objTerminal )
    {
        return competenciasRemote.agregarObjTerminal( objTerminal );                
    }
    
    @Override
    public int editarObjTerminal( ObjetivoTerminalBO objTerminal )
    {
        return competenciasRemote.editarObjTerminal( objTerminal );
    }

    @Override
    public ObjetivoTerminalBO buscarObjTerminal( int idObjTerminal )
    {
        return competenciasRemote.buscarObjTerminal( idObjTerminal );
    }

    @Override
    public int agregarObjEspecifico( ObjetivoEspecificoBO objEspecifico )
    {
        return competenciasRemote.agregarObjEspecifico( objEspecifico );
    }

    @Override
    public int editarObjEspecifico( ObjetivoEspecificoBO objEspecifico )
    {
        return competenciasRemote.editarObjEspecifico( objEspecifico );
    }

    @Override
    public ObjetivoEspecificoBO buscarObjEspecifico( int idObjEspecifico )
    {
        return competenciasRemote.buscarObjEspecifico( idObjEspecifico );
    }

    @Override
    public int agregarMetaTerminal( MetaTerminalBO metaTerminal )
    {
        return competenciasRemote.agregarMetaTerminal( metaTerminal );
    }

    @Override
    public int eliminarMetaTerminal( MetaTerminalBO metaTerminal )
    {
        return competenciasRemote.eliminarMetaTerminal( metaTerminal );
    }

    @Override
    public MetaTerminalBO buscarMetaTerminal( int idMetaTerminal )
    {
        return competenciasRemote.buscarMetaTerminal( idMetaTerminal );
    }
}
