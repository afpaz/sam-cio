package co.edu.icesi.sam.client.dialogos.agregar;

import co.edu.icesi.sam.client.multilingual.MultiLingualConstants;
import co.edu.icesi.sam.client.tabs.TabMateriales;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.Text;
import com.google.gwt.core.client.GWT;

public class DialogoAgregarMaterial extends Dialog
{
    private final static MultiLingualConstants MultiLingualConstants = GWT.create( MultiLingualConstants.class );
    
    private TabMateriales tabMateriales;
    
    private Text labNombre;
    private TextArea txtNombre;
    
    public DialogoAgregarMaterial(TabMateriales tabMateriales)
    {
        this.tabMateriales = tabMateriales;
        
        setModal( true );
        setSize( 500, 300 );
        setHeading( MultiLingualConstants.dialogoAgregarMaterial_heading( ) );
        setLayout( new AbsoluteLayout( ) );
        
        labNombre = new Text( MultiLingualConstants.labNombre_text( ) );
        add( labNombre, new AbsoluteData( 30, 110 ) );

        txtNombre = new TextArea( );
        add( txtNombre, new AbsoluteData( 157, 110 ) );
        txtNombre.setSize( "212px", "60px" );
        
        eventoAgregarMaterial( );
    }
    
    private void eventoAgregarMaterial( )
    {
        getButtonById( OK ).addSelectionListener( new SelectionListener<ButtonEvent>( )
        {
            @Override
            public void componentSelected( ButtonEvent ce )
            {
                agregarMaterial( );
                limpiarDatos( );
            }
        } );
    }

    private void eventoCerrarVentana( )
    {
        this.addListener( Events.Close, new Listener<BaseEvent>( )
        {
            @Override
            public void handleEvent( BaseEvent be )
            {
                limpiarDatos( );
            }
        } );
    }

    private void agregarMaterial( )
    {
        String nombre = txtNombre.getValue( );
        
        tabMateriales.agregarMaterial( nombre);
    }    
    
    private void limpiarDatos( )
    {
        txtNombre.clear( );   
        hide( );
    }
}
