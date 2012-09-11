/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
 package co.edu.icesi.sam.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.DateWrapper;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.RowEditor;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.impl.WindowImplIE.Resources;
import com.google.gwt.user.client.ui.RootPanel;

public class Hello implements EntryPoint {
  public void onModuleLoad() {
    RootPanel.get().add(new RowEditorExample());
  }
}
class RowEditorExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    setLayout(new FlowLayout(10));

    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

    ColumnConfig column = new ColumnConfig();
//    column.setId("name");
//    column.setHeader("Common Name");
//    column.setWidth(220);

    TextField<String> text = new TextField<String>();
    text.setAllowBlank(false);
//    column.setEditor(new CellEditor(text));
//    configs.add(column);

    final SimpleComboBox<String> combo = new SimpleComboBox<String>();
    combo.setForceSelection(true);
    combo.setTriggerAction(TriggerAction.ALL);
    combo.add("Shade");
    combo.add("Mostly Shady");
    combo.add("Sun or Shade");
    combo.add("Mostly Sunny");
    combo.add("Sunny");

    CellEditor editor = new CellEditor(combo) {
      @Override
      public Object preProcessValue(Object value) {
        if (value == null) {
          return value;
        }
        return combo.findModel(value.toString());
      }

      @Override
      public Object postProcessValue(Object value) {
        if (value == null) {
          return value;
        }
        return ((ModelData) value).get("value");
      }
    };

    column = new ColumnConfig();
    column.setId("light");
    column.setHeader("Light");
    column.setWidth(130);
    column.setEditor(editor);
    configs.add(column);

    column = new ColumnConfig();
    column.setId("price");
    column.setHeader("Price");
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setWidth(70);
    column.setNumberFormat(NumberFormat.getCurrencyFormat());
    column.setEditor(new CellEditor(new NumberField()));

    configs.add(column);

    DateField dateField = new DateField();
    dateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat("MM/dd/y"));

    column = new ColumnConfig();
    column.setId("available");
    column.setHeader("Available");
    column.setWidth(95);
    column.setEditor(new CellEditor(dateField));
    column.setDateTimeFormat(DateTimeFormat.getMediumDateFormat());
    configs.add(column);

    CheckColumnConfig checkColumn = new CheckColumnConfig("indoor", "Indoor?", 55);
    CellEditor checkBoxEditor = new CellEditor(new CheckBox());
    checkColumn.setEditor(checkBoxEditor);
    configs.add(checkColumn);

    final ListStore<Plant> store = new ListStore<Plant>();
    store.add(getPlants());

    ColumnModel cm = new ColumnModel(configs);

    ContentPanel cp = new ContentPanel();
    //cp.setIcon(Resources.ICONS.table());
    cp.setHeading("Unidades versus Objetivos Terminales");
    cp.setFrame(true);
    cp.setSize(600, 300);
    cp.setLayout(new FitLayout());

    final RowEditor<Plant> re = new RowEditor<Plant>();
    final Grid<Plant> grid = new Grid<Plant>(store, cm);
    grid.setAutoExpandColumn("name");
    grid.setBorders(true);
    grid.addPlugin(checkColumn);
    grid.addPlugin(re);
    cp.add(grid);

    ToolBar toolBar = new ToolBar();
    Button add = new Button("Add Plant");
    add.addSelectionListener(new SelectionListener<ButtonEvent>() {

      @Override
      public void componentSelected(ButtonEvent ce) {
        Plant plant = new Plant();
        plant.setName("New Plant 1");
        plant.setLight("Mostly Shady");
        plant.setPrice(0);
        plant.setAvailable(new DateWrapper().clearTime().asDate());
        plant.setIndoor(false);

        re.stopEditing(false);
        store.insert(plant, 0);
        re.startEditing(store.indexOf(plant), true);

      }

    });
    toolBar.add(add);
    cp.setTopComponent(toolBar);
    cp.setButtonAlign(HorizontalAlignment.CENTER);
    cp.addButton(new Button("Reset", new SelectionListener<ButtonEvent>() {

      @Override
      public void componentSelected(ButtonEvent ce) {
        store.rejectChanges();
      }
    }));

    cp.addButton(new Button("Save", new SelectionListener<ButtonEvent>() {

      @Override
      public void componentSelected(ButtonEvent ce) {
        store.commitChanges();
      }
    }));

    add(cp);
  }
  public static List<Plant> getPlants() {
    List<Plant> plants = new ArrayList<Plant>();
    plants.add(new Plant("Bloodroot", "Mostly Shady", 2.44, "03/15/2006", true));
    plants.add(new Plant("Columbine", "Shade", 9.37, "03/15/2006", true));
    plants.add(new Plant("Marsh Marigold", "Mostly Sunny", 6.81, "05/17/2006", false));
    plants.add(new Plant("Cowslip", "Mostly Shady", 9.90, "03/06/2006", true));
    plants.add(new Plant("Dutchman's-Breeches", "Mostly Shady", 6.44, "01/20/2006", true));
    plants.add(new Plant("Ginger, Wild", "Mostly Shady", 9.03, "04/18/2006", true));
    plants.add(new Plant("Hepatica", "Sunny", 4.45, "01/26/2006", true));
    plants.add(new Plant("Liverleaf", "Mostly Sunny", 3.99, "01/02/2006", true));
    plants.add(new Plant("Jack-In-The-Pulpit", "Mostly Shady", 3.23, "02/01/2006", true));
    plants.add(new Plant("Mayapple", "Mostly Shady", 2.98, "06/05/2006", true));
    plants.add(new Plant("Phlox, Woodland", "Sun or Shade", 2.80, "01/22/2006", false));
    plants.add(new Plant("Phlox, Blue", "Sun or Shade", 5.59, "02/16/2006", false));
    plants.add(new Plant("Spring-Beauty", "Mostly Shady", 6.59, "02/01/2006", true));
    plants.add(new Plant("Trillium", "Sun or Shade", 3.90, "04/29/2006", false));
    plants.add(new Plant("Wake Robin", "Sun or Shade", 3.20, "02/21/2006", false));
    plants.add(new Plant("Violet, Dog-Tooth", "Shade", 9.04, "02/01/2006", true));
    plants.add(new Plant("Trout Lily", "Shade", 6.94, "03/24/2006", true));
    plants.add(new Plant("Adder's-Tongue", "Mostly Shady", 6.59, "02/01/2006", true));
    plants.add(new Plant("Trillium", "Shade", 9.58, "04/13/2006", true));
    plants.add(new Plant("Anemone", "Mostly Shady", 8.86, "12/26/2006", true));
    plants.add(new Plant("Grecian Windflower", "Mostly Shady", 9.16, "07/10/2006", true));
    plants.add(new Plant("Bee Balm", "Shade", 4.59, "05/03/2006", true));
    plants.add(new Plant("Bergamot", "Shade", 7.16, "04/27/2006", true));
    plants.add(new Plant("Black-Eyed Susan", "Sunny", 9.80, "06/18/2006", false));
    plants.add(new Plant("Buttercup", "Shade", 2.57, "06/10/2006", true));
    plants.add(new Plant("Crowfoot", "Shade", 9.34, "04/03/2006", true));
    plants.add(new Plant("Butterfly Weed", "Sunny", 2.78, "06/30/2006", false));
    plants.add(new Plant("Cinquefoil", "Shade", 7.06, "05/25/2006", true));
    plants.add(new Plant("Primrose", "Sunny", 6.56, "01/30/2006", false));
    plants.add(new Plant("Gentian", "Sun or Shade", 7.81, "05/18/2006", false));
    plants.add(new Plant("Greek Valerian", "Shade", 3.41, "04/03/2006", true));
    plants.add(new Plant("California Poppy", "Mostly Shady", 2.78, "05/13/2006", false));
    plants.add(new Plant("Shooting Star", "Shade", 7.06, "07/11/2006", true));
    plants.add(new Plant("Snakeroot", "Sunny", 6.56, "02/22/2006", false));
    plants.add(new Plant("Cardinal Flower", "Shade", 7.81, "05/18/2006", false));
    return plants;
  }
}