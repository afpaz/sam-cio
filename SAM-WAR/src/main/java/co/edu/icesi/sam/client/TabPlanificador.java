                                                                     
                                                                     
                                                                     
                                             
package co.edu.icesi.sam.client;



import java.util.ArrayList;
import java.util.List;

import co.edu.icesi.sam.client.model.CursoModel;
import co.edu.icesi.sam.client.model.UnidadModel;
import co.edu.icesi.sam.client.multilingual.MultiLingualConstants;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelIconProvider;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.RootPanel;

public class TabPlanificador extends TabItem
{
    private final static MultiLingualConstants MultiLingualConstants = GWT.create( MultiLingualConstants.class );
	
	private Grid<CursoModel> gridObj;
	private Grid<CursoModel> gridSesiones;
	private Grid<CursoModel> gridEstudiante;
	private Grid<CursoModel> gridProfesor;
	private ContentPanel cp;
	private ContentPanel panelUnidades;
	private ColumnModel cmObj;
	private ColumnModel cmSesiones;
	private ColumnModel cmEstudiante;
	private ColumnModel cmProfesor;

	public TabPlanificador() {
	    
        setText( MultiLingualConstants.tabObjEspecificos_text( ) );
        setSize( 800, 600 );

        LayoutContainer container = new LayoutContainer( );
        container.setLayout( new AbsoluteLayout( ) );
        
		panelUnidades = new ContentPanel();
		panelUnidades.setSize(690, 600);	
		panelUnidades.setLayout(new AccordionLayout());

		List<ContentPanel> lista=new ArrayList<ContentPanel>();

		for (int i = 0; i < 4; i++) {
			cp = new ContentPanel();
			cp.setAnimCollapse(false);
			cp.setBodyStyleName("pad-text");
			cp.setHeading("Unidad " + (1));
			cp.setId(""+(1));

			lista.add(cp);

			TextArea txtrNewTextarea = new TextArea();
			cp.add(txtrNewTextarea, new AbsoluteData(53, 24));
			txtrNewTextarea.setSize("589px", "78px");
			txtrNewTextarea.setFieldLabel("New TextArea");
			Text txtDescripcionUnidad = new Text("Descripcion Unidad");
			cp.add(txtDescripcionUnidad, new AbsoluteData(295, 6));
			//CARGA LA TABLA DE OBJETIVOS ESPECIFICOS
			List<ColumnConfig> configsObj = new ArrayList<ColumnConfig>();
			ColumnConfig columnObj = new ColumnConfig();
			columnObj.setId("id");
			columnObj.setHeader("Identificacion");
			columnObj.setWidth(80);
			configsObj.add(columnObj);
			columnObj = new ColumnConfig("nombre", "Objetivo Especifico",100);
			columnObj.setAlignment(HorizontalAlignment.LEFT);
			configsObj.add(columnObj);
			columnObj = new ColumnConfig("contenido", "Contenido", 200);
			columnObj.setAlignment(HorizontalAlignment.LEFT);
			configsObj.add(columnObj);
			ListStore<CursoModel> listaObjetivos = new ListStore<CursoModel>();

			cmObj = new ColumnModel(configsObj);
			gridObj = new Grid<CursoModel>(listaObjetivos, cmObj);

			gridObj.setBorders(true);
			gridObj.setStripeRows(true);
			ContentPanel cpObj = new ContentPanel();
			cpObj.setBodyBorder(false);
			cpObj.setHeading("Lista de Objetivos Especificos:");
			cpObj.setButtonAlign(HorizontalAlignment.CENTER);
			cpObj.setLayout(new FitLayout());
			cpObj.setSize(340, 40);
			cpObj.add(gridObj);
			cp.add(cpObj, new AbsoluteData(53, 108));
			cpObj.setSize("589px", "118px");

//			//CARGA LA TABLA DE SESIONES
			List<ColumnConfig> configsSesiones = new ArrayList<ColumnConfig>();
			ColumnConfig columnaSesiones = new ColumnConfig();
			columnaSesiones.setId("id");
			columnaSesiones.setHeader("Identificacion");
			columnaSesiones.setWidth(80);
			columnaSesiones.setHidden(true);
			configsSesiones.add(columnaSesiones);
			columnaSesiones = new ColumnConfig("nombreSesion","Nombre Sesion", 100);
			columnaSesiones.setAlignment(HorizontalAlignment.LEFT);
			configsSesiones.add(columnaSesiones);
			
			ListStore<CursoModel> listaSesiones = new ListStore<CursoModel>();

			cmSesiones = new ColumnModel(configsSesiones);
			gridSesiones = new Grid<CursoModel>(listaSesiones, cmSesiones);

			gridSesiones.setBorders(true);
			gridSesiones.setStripeRows(true);
			ContentPanel cpSesiones = new ContentPanel();
			cpSesiones.setBodyBorder(false);
			cpSesiones.setHeading("Lista de Sesiones:");
			cpSesiones.setButtonAlign(HorizontalAlignment.CENTER);
			cpSesiones.setLayout(new FitLayout());
			cpSesiones.setSize(340, 40);
			cpSesiones.add(gridSesiones);
			cp.add(cpSesiones, new AbsoluteData(53, 232));
			cpSesiones.setSize("119px", "118px");
			
//			//CARGA LA TABLA DE ESTUDIANTES
			List<ColumnConfig> configsEstudiantes = new ArrayList<ColumnConfig>();
			ColumnConfig columnaEstudiantes = new ColumnConfig();
			columnaEstudiantes.setId("antes");
			columnaEstudiantes.setHeader("Antes");
			columnaEstudiantes.setWidth(40);
			//columnaEstudiantes.setHidden(true);
			configsEstudiantes.add(columnaEstudiantes);
			columnaEstudiantes = new ColumnConfig("durante","Durante", 60);
			columnaEstudiantes.setAlignment(HorizontalAlignment.LEFT);
			configsEstudiantes.add(columnaEstudiantes);
			columnaEstudiantes = new ColumnConfig("despues","Despues", 60);
			columnaEstudiantes.setAlignment(HorizontalAlignment.LEFT);
			configsEstudiantes.add(columnaEstudiantes);
			
			ListStore<CursoModel> listaEstudiantes = new ListStore<CursoModel>();

			cmEstudiante = new ColumnModel(configsEstudiantes);
			gridEstudiante = new Grid<CursoModel>(listaEstudiantes, cmEstudiante);

			gridEstudiante.setBorders(true);
			gridEstudiante.setStripeRows(true);
			ContentPanel cpEstudiantes = new ContentPanel();
			cpEstudiantes.setBodyBorder(false);
			cpEstudiantes.setHeading("Estudiante:");
			cpEstudiantes.setButtonAlign(HorizontalAlignment.CENTER);
			cpEstudiantes.setLayout(new FitLayout());
			cpEstudiantes.setSize(340, 40);
			cpEstudiantes.add(gridEstudiante);
			
			cp.add(cpEstudiantes, new AbsoluteData(178, 232));
			cpEstudiantes.setSize("229px", "118px");
//
//			//FIN GRIDS
			
			
			
			//CARGA LA TABLA DE PROFESOR
			List<ColumnConfig> configProf = new ArrayList<ColumnConfig>();
			ColumnConfig columnaProf = new ColumnConfig();
			columnaProf.setId("antes");
			columnaProf.setHeader("Antes");
			columnaProf.setWidth(40);
			//columnaProf.setHidden(true);
			configProf.add(columnaProf);
			columnaProf = new ColumnConfig("durante","Durante", 60);
			columnaProf.setAlignment(HorizontalAlignment.LEFT);
			configProf.add(columnaProf);
			columnaProf = new ColumnConfig("despues","Despues", 60);
			columnaProf.setAlignment(HorizontalAlignment.LEFT);
			configProf.add(columnaProf);
			
			ListStore<CursoModel> listaProf = new ListStore<CursoModel>();

			cmProfesor = new ColumnModel(configProf);
			gridProfesor = new Grid<CursoModel>(listaProf, cmProfesor);

			gridProfesor.setBorders(true);
			gridProfesor.setStripeRows(true);
			ContentPanel cpProf = new ContentPanel();
			cpProf.setBodyBorder(false);
			cpProf.setHeading("Profesor:");
			cpProf.setButtonAlign(HorizontalAlignment.CENTER);
			cpProf.setLayout(new FitLayout());
			cpProf.setSize(340, 40);
			cpProf.add(gridProfesor);
			
			cp.add(cpProf, new AbsoluteData(413, 232));
			cpProf.setSize("229px", "118px");

			//FIN GRIDS
			
			
			Button btnCrearSesin = new Button("Crear Sesi\u00F3n");
			cp.add(btnCrearSesin, new AbsoluteData(332, 397));

			cp.setLayout(new AbsoluteLayout());

			panelUnidades.add(cp);
			
		
			
			


		}

		panelUnidades.setSize("690px", "600px");
		add(panelUnidades);

		eventos(lista);
	}

	public void eventos(final List<ContentPanel> lista){
		
		
		for (int i = 0; i < lista.size(); i++) {
			final ContentPanel temp = lista.get(i);
			temp.addListener(Events.Expand, new Listener<BaseEvent>() {
				@Override
				public void handleEvent(BaseEvent be) {
					System.out.println(temp.getId());
				}
			});		
		}
									
		
	}
	
	public void actualizarTableUnidades(ListStore<UnidadModel> unidades)
	{
	    panelUnidades.removeAll( );
	}
	
	
	private ColumnModel getColumnModelObjEspecificos()
	{
        List<ColumnConfig> configsObj = new ArrayList<ColumnConfig>( );

        ColumnConfig columnObj = new ColumnConfig( "nombre", MultiLingualConstants.columnObjEspecificos_nombre( ), 50 );
        columnObj.setAlignment( HorizontalAlignment.LEFT );
        configsObj.add( columnObj );

        columnObj = new ColumnConfig( "contenido", MultiLingualConstants.columnObjEspecificos_contenido( ), 525 );
        columnObj.setAlignment( HorizontalAlignment.LEFT );
        configsObj.add( columnObj );

        return new ColumnModel( configsObj );
	}
	
	private void getColumnModelSesiones()
	{
	    
	}
}