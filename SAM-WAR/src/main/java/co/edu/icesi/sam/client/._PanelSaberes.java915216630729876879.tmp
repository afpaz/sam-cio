package co.edu.icesi.sam.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.xerces.impl.dtd.models.CMUniOp;

import co.edu.icesi.sam.client.controller.DTEvent;
import co.edu.icesi.sam.client.model.CursoModel;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;

public class PanelSaberes extends LayoutContainer {

	private Grid<CursoModel> gridSaberes;
	private Grid<CursoModel> gridObjEspecifico;
	private ColumnModel cmObjs;
	private ColumnModel cmSaberes;

	public PanelSaberes() {
		setLayout(new AbsoluteLayout());

		Button btnNewButton = new Button("Agregar");
		add(btnNewButton, new AbsoluteData(227, 264));

		//		Table table = new Table(new TableColumnModel(new TableColumn("id.1", "Objetivo Especifico", 0.4f), new TableColumn("id.2", "Contenido", 0.7f)));
		//		add(table, new AbsoluteData(37, 19));
		//		table.setSize("374px", "100px");
		//		
		//		Table table_1 = new Table(new TableColumnModel(new TableColumn("id.1", "Nombre", 0.3f), new TableColumn("id.2", "Tipo", 0.2f),new TableColumn("id.3", "Contenido", 0.7f)));
		//		add(table_1, new AbsoluteData(37, 128));
		//		table_1.setSize("372px", "106px");


		//CARGA LA TABLA DE OBJETIVOS ESPECIFICOS
		List<ColumnConfig> configsObjEspecifico = new ArrayList<ColumnConfig>();  

		ColumnConfig columnObj = new ColumnConfig();    
		columnObj.setId("id");    
		columnObj.setHeader("Identificacion");    
		columnObj.setWidth(80);
		columnObj.setHidden(true);
		configsObjEspecifico.add(columnObj);  

		columnObj = new ColumnConfig("contenidoUnidad", "Objetivo Especifico", 100);    
		columnObj.setAlignment(HorizontalAlignment.LEFT);    
		configsObjEspecifico.add(columnObj);  

		columnObj = new ColumnConfig("contenido", "Contenido", 150);    
		columnObj.setAlignment(HorizontalAlignment.LEFT);    
		configsObjEspecifico.add(columnObj);  

		ListStore<CursoModel> listaObjs = new ListStore<CursoModel>();    
		//employeeList.add(TestData.getEmployees()); 

		cmObjs = new ColumnModel(configsObjEspecifico);  
		gridObjEspecifico = new Grid<CursoModel>(listaObjs, cmObjs);   
		gridObjEspecifico.setStyleAttribute("borderTop", "none");   
		gridObjEspecifico.setAutoExpandColumn("name");   
		gridObjEspecifico.setBorders(true);   
		gridObjEspecifico.setStripeRows(true); 

		ContentPanel cpObjs = new ContentPanel();    
		cpObjs.setBodyBorder(false);    
		cpObjs.setHeading("Lista de Objetivos Especificos:");    
		cpObjs.setButtonAlign(HorizontalAlignment.CENTER);    
		cpObjs.setLayout(new FitLayout());    
		cpObjs.setSize(450, 93);   
		cpObjs.add(gridObjEspecifico);    
		add(cpObjs, new AbsoluteData(36, 30));



		//CARGA LA TABLA DE SABERES
		List<ColumnConfig> configSaberes = new ArrayList<ColumnConfig>();  

		ColumnConfig columnSaberes = new ColumnConfig();    
		columnSaberes.setId("id");    
		columnSaberes.setHeader("Identificacion");    
		columnSaberes.setWidth(80);    
		configSaberes.add(columnSaberes);  

		columnSaberes = new ColumnConfig("nombre", "Nombre", 100);    
		columnSaberes.setAlignment(HorizontalAlignment.LEFT);    
		configSaberes.add(columnSaberes);  

		columnSaberes = new ColumnConfig("tipo", "Tipo", 200);    
		columnSaberes.setAlignment(HorizontalAlignment.LEFT);    
		configSaberes.add(columnSaberes);  

		columnSaberes = new ColumnConfig("contenido", "Contenido", 200);    
		columnSaberes.setAlignment(HorizontalAlignment.LEFT);    
		configSaberes.add(columnSaberes);  

		ListStore<CursoModel> listaSaberes = new ListStore<CursoModel>();    
		//employeeList.add(TestData.getEmployees()); 

		cmSaberes = new ColumnModel(configSaberes);  
		gridSaberes = new Grid<CursoModel>(listaSaberes, cmSaberes);   
		gridSaberes.setStyleAttribute("borderTop", "none");   
		gridSaberes.setAutoExpandColumn("name");   
		gridSaberes.setBorders(true);   
		gridSaberes.setStripeRows(true); 

		ContentPanel cpSaberes = new ContentPanel();    
		cpSaberes.setBodyBorder(false);    
		cpSaberes.setHeading("Lista de Saberes:");    
		cpSaberes.setButtonAlign(HorizontalAlignment.CENTER);    
		cpSaberes.setLayout(new FitLayout());    
		cpSaberes.setSize(450, 116);   
		cpSaberes.add(gridSaberes);   

		add(cpSaberes, new AbsoluteData(36, 142));

	}

	public void actualizarTablaSaberes(ListStore<CursoModel> listaUnidades){

		gridSaberes.reconfigure(listaUnidades, cmSaberes);

	}

	public void eventoSeleccionarSaber( )
	{
		gridSaberes.addListener( Events.OnClick, new Listener<GridEvent<BaseModel>>( )
				{
			public void handleEvent( GridEvent<BaseModel> be )
			{
				CursoModel cursoModel = (CursoModel) be.getGrid( ).getSelectionModel( ).getSelectedItem( );
				Dispatcher.forwardEvent( DTEvent.SELECCIONAR_CURSO, cursoModel );
			}
				} );

	}

	public void eventoSeleccionarObj( )
	{
		gridObjEspecifico.addListener( Events.OnClick, new Listener<GridEvent<BaseModel>>( )
				{
			public void handleEvent( GridEvent<BaseModel> be )
			{

			}
				} );

	}

	public void cargarSaberes(){

		gridSaberes.addListener( Events.OnClick, new Listener<GridEvent<BaseModel>>( )
				{
			public void handleEvent( GridEvent<BaseModel> be )
			{

			}
				} );

	}

	public void cargarObjEspecificos(){

	}

	public void actualizarTablaObjEspecifico(ListStore<CursoModel> listaObjs){

		gridObjEspecifico.reconfigure(listaObjs, cmObjs);

	}
}
