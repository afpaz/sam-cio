package co.edu.icesi.sam.client.dialogos;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.Text;

public class DialogoEditarSesion extends Dialog {

	public DialogoEditarSesion() {
		setModal(true);
		setHeading("Editar Sesión");
		setLayout(new AbsoluteLayout());
		
		Button btnNewButton = new Button("Editar");
		add(btnNewButton, new AbsoluteData(225, 112));
		
		TextField txtfldNewTextfield = new TextField();
		add(txtfldNewTextfield, new AbsoluteData(157, 25));
		txtfldNewTextfield.setSize("212px", "24px");
		txtfldNewTextfield.setFieldLabel("Nombre:");
		
		Text txtNewText = new Text("Nombre:");
		add(txtNewText, new AbsoluteData(30, 36));
		
		Text txtNewText_2 = new Text("Número:");
		add(txtNewText_2, new AbsoluteData(30, 79));
		
		TextField txtfldNewTextfield_1 = new TextField();
		add(txtfldNewTextfield_1, new AbsoluteData(157, 68));
		txtfldNewTextfield_1.setSize("212px", "24px");
		txtfldNewTextfield_1.setFieldLabel("Número:");
		
		Button btnSeleccionarRecurso = new Button("Seleccionar Recurso");
		add(btnSeleccionarRecurso, new AbsoluteData(200, 142));
	}
	protected void onButtonPressed(Button button) {
		if (button == getButtonBar().getItemByItemId(OK)) {
			// TODO
		}
		super.onButtonPressed(button);
	}
}
