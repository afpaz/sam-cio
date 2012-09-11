package co.edu.icesi.sam.client;

import java.util.ArrayList;
import java.util.List;

import co.edu.icesi.sam.client.model.CursoModel;
import co.edu.icesi.sam.client.multilingual.MultiLingualConstants;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

public class PanelUnidad extends TabItem
{

    private final static MultiLingualConstants MultiLingualConstants = GWT.create( MultiLingualConstants.class );

    private Text labObjGeneral;
    private TextArea txtObjGeneral;
    private Button btnAgregar;

    private Grid<CursoModel> gridUnidad;
    private List<ColumnConfig> configsUnidad;

    public PanelUnidad( )
    {

        setText( MultiLingualConstants.tabUnidades_text( ) );
        setSize( 800, 600 );
        LayoutContainer container = new LayoutContainer( );
        container.setLayout( new AbsoluteLayout( ) );

        labObjGeneral = new Text( MultiLingualConstants.labObjGeneral_text( ) );
        container.add( labObjGeneral, new AbsoluteData( 100, 30 ) );

        txtObjGeneral = new TextArea( );
        txtObjGeneral.setSize( "600px", "150px" );
        container.add( txtObjGeneral, new AbsoluteData( 100, 50 ) );

        btnAgregar = new Button( MultiLingualConstants.btnAgregar_text( ) );
        container.add( btnAgregar, new AbsoluteData( 375, 510 ) );

        // CARGA LA TABLA DE UNIDADES
        configsUnidad = new ArrayList<ColumnConfig>( );

        ColumnConfig columnUnidad = new ColumnConfig( );

        columnUnidad = new ColumnConfig( "nombre", "Nombre Unidad", 100 );
        columnUnidad.setAlignment( HorizontalAlignment.LEFT );
        configsUnidad.add( columnUnidad );
        columnUnidad.setWidget( new CheckBox( ), "" );

        // llamar al metodo que retorna la lista de objetivos terminales y hacer un for
        CheckColumnConfig checkColumn = new CheckColumnConfig( "objetivoTerminal", "OT", 30 );
        CellEditor checkBoxEditor = new CellEditor( new CheckBox( ) );
        checkColumn.setEditor( checkBoxEditor );
        configsUnidad.add( checkColumn );

        ColumnModel cm = new ColumnModel( configsUnidad );

        // Aqui se agrega la unidades
        ListStore<CursoModel> listaUnidades = new ListStore<CursoModel>( );

        gridUnidad = new Grid<CursoModel>( listaUnidades, cm );
        gridUnidad.setStyleAttribute( "borderTop", "none" );
        gridUnidad.setAutoExpandColumn( "name" );
        gridUnidad.setBorders( true );
        gridUnidad.setStripeRows( true );

        gridUnidad.setSize( "100px", "50px" );

        ContentPanel cpUnidad = new ContentPanel( );
        cpUnidad.setBodyBorder( false );
        cpUnidad.setHeading( "Lista de Unidades:" );
        cpUnidad.setButtonAlign( HorizontalAlignment.CENTER );
        cpUnidad.setLayout( new FitLayout( ) );
        cpUnidad.setSize( 380, 150 );
        cpUnidad.add( gridUnidad );
        add( cpUnidad );

        add( cpUnidad, new AbsoluteData( 36, 105 ) );

    }

    public void listarColumnas( )
    {

    }

    private ColumnModel getColumnModelUnidades( )
    {
        List<ColumnConfig> configsUnidad = new ArrayList<ColumnConfig>( );

        ColumnConfig columnUnidad = new ColumnConfig( );

        columnUnidad = new ColumnConfig( "nombre", "Unidad", 50 );
        columnUnidad.setAlignment( HorizontalAlignment.CENTER );
        configsUnidad.add( columnUnidad );
        
        return new ColumnModel( configsUnidad );
    }

}
