package co.edu.icesi.sam.client.dialogos;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.button.Button;

public class DialogoSeleccionarRecursos extends Dialog {

	public DialogoSeleccionarRecursos() {
		setModal(true);
		setHeading("Asociar Recurso");
		setLayout(new AbsoluteLayout());
		
		ListView listView = new ListView(new ListStore());
		add(listView, new AbsoluteData(68, 6));
		listView.setSize("294px", "188px");
		
		Button btnAsociar = new Button("Asociar");
		add(btnAsociar, new AbsoluteData(196, 202));
	}
}
