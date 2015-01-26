package br.mdarte.exemplo.academico.client.view.widgets;

import java.util.Collection;

import br.mdarte.exemplo.academico.shared.EstudanteVO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.MultiSelectionModel;

public class EstudanteDataGrid extends Composite implements HasClickHandlers
{
	
	private static EstudanteDataGridUiBinder uiBinder = GWT.create(EstudanteDataGridUiBinder.class);
	/**
	 * The UiBinder interface used by this example.
	 */
	interface EstudanteDataGridUiBinder extends UiBinder<Widget, EstudanteDataGrid> {
	}
	
	public EstudanteDataGrid() {
		setup();
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	boolean built = false;

	/**
	 * The main DataGrid.
	 */
	@UiField (provided = true)
	DataGrid<EstudanteVO> dataGrid;

	/**
	 * The pager used to change the range of data.
	 */
	@UiField (provided = true)
	SimplePager pager;

	/**
	 * Initialize this example.
	 */

	public void setup() {
		// Create a DataGrid.
		/*
		 * Set a key provider that provides a unique key for each row. If key is
		 * used to identify rows when fields change.
		 */

		dataGrid = new DataGrid<EstudanteVO>(EstudanteVO.KEY_PROVIDER);
	
		// Create a Pager to control the table.
		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class); //pega imagens de navegacao da paginacao
		pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
		pager.setDisplay(dataGrid); //poe o datagrid para ser paginado

	}
	
	public DataGrid<EstudanteVO> getDataGrid()
	{
		return this.dataGrid;
	}
	
	public HandlerRegistration addClickHandler(ClickHandler handler)
	{
		return addDomHandler(handler, ClickEvent.getType());
	}
	
	public boolean isBuilt() {
		return built;
	}
	
	public void setBuilt(boolean built) {
		this.built = built;
	}
	
	public Collection<EstudanteVO> getSelection() {
		MultiSelectionModel<EstudanteVO> selectionModel = (MultiSelectionModel<EstudanteVO>) dataGrid.getSelectionModel();
		
		Collection<EstudanteVO> selection = selectionModel.getSelectedSet();
		
		selectionModel.clear();

		return selection;
	}
	

	//Code to add footer at end of column
	
	/*private void addIdColumn(ListHandler<EstudanteVO> sortHandler) { //NumberColumn
	    Column<EstudanteVO, Number> column = table.getIdColumn(true);
	    
	    Header<String> ageFooter = new Header<String>(new TextCell()) {
	      @Override
	      public String getValue() {
	        List<EstudanteVO> items = dataGrid.getVisibleItems();
	        if (items.size() == 0) {
	          return "";
	        } else {
	          int totalAge = 0;
	          for (EstudanteVO item : items) {
	            totalAge += item.getId();
	          }
	          return "Avg: " + totalAge / items.size();
	        }
	      }
	    };
	    
	    dataGrid.addColumn(column, new SafeHtmlHeader(SafeHtmlUtils.fromSafeConstant(constants.getId())), ageFooter);
	    dataGrid.setColumnWidth(column, 10, Unit.PCT);
	}*/
	
}
