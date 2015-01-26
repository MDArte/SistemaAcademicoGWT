package br.mdarte.exemplo.academico.client.common;


import java.util.Comparator;

import br.mdarte.exemplo.academico.shared.EstudanteVO;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;

public class EstudanteTableBuilder extends CoppetecTableBuilder<EstudanteVO>
{
	
	GetValue<EstudanteVO, Number> getterId = new GetValue<EstudanteVO,Number>() {
		public Long getValue(EstudanteVO estudante) {
			return estudante.getId();
		}
	};
	
	Comparator<EstudanteVO> sortId = new Comparator<EstudanteVO>() {
		public int compare(EstudanteVO o1, EstudanteVO o2) {
			return o1.getId().compareTo(o2.getId());
		}
	};
	
	GetValue<EstudanteVO, String> getterNome = new GetValue<EstudanteVO,String>() {
		public String getValue(EstudanteVO estudante) {
			return estudante.getNome();
		}
	};
	
	Comparator<EstudanteVO> sortNome = new Comparator<EstudanteVO>() {
		public int compare(EstudanteVO o1, EstudanteVO o2) {
			return o1.getNome().compareTo(o2.getNome());
		}
	};
	
	GetValue<EstudanteVO, String> getterMatricula = new GetValue<EstudanteVO,String>() {
		public String getValue(EstudanteVO estudante) {
			return estudante.getMatricula();
		}
	};
	
	Comparator<EstudanteVO> sortMatricula = new Comparator<EstudanteVO>() {
		public int compare(EstudanteVO o1, EstudanteVO o2) {
			return o1.getMatricula().compareTo(o2.getMatricula());
		}
	};
	
	public Column<EstudanteVO,Number> getIdColumn(boolean sortable) {
		Column<EstudanteVO,Number> column = makeColumn(new NumberCell(), getterId);
		
		if (sortable) makeColumnSortable(column, sortId);
		
		return column;
	}
	
	public Column<EstudanteVO,String> getNomeColumn(boolean sortable) {
		Column<EstudanteVO,String> column = makeColumn(new TextCell(), getterNome);
		
		if (sortable) makeColumnSortable(column, sortNome);
		
		return column;
	}
	
	public Column<EstudanteVO,String> getMatriculaColumn(boolean sortable) {
		Column<EstudanteVO,String> column = makeColumn(new TextCell(), getterMatricula);
		
		if (sortable) makeColumnSortable(column, sortMatricula);
		
		return column;
	}

	public SelectionModel<EstudanteVO> makeSelectionModel()
	{
		final SelectionModel<EstudanteVO> selectionModel = new MultiSelectionModel<EstudanteVO>(EstudanteVO.KEY_PROVIDER);
		
		return selectionModel;
	}

	public Column<EstudanteVO, Boolean> getCheckboxColumn(SelectionModel<EstudanteVO> selectionModel)
	{
		return makeCheckBoxColumn(selectionModel);
	}
	
	public void makeActionColumn(DataGrid<EstudanteVO> dataGrid, ActionCell<EstudanteVO> cell, String header)
	{
		dataGrid.addColumn(makeActionColumn(cell, getterRow), header);
		dataGrid.setColumnWidth(dataGrid.getColumnCount()-1, 10, Unit.PCT);
	}
	
	public void makeDataGrid(DataGrid<EstudanteVO> dataGrid)
	{
		// Coloquei em 95% por causa de um bug que faz a tabela não aparecer com uma porcentagem maior
		
		dataGrid.setWidth("95%");		
		/*
		 * Do not refresh the headers every time the data is updated. The footer
		 * depends on the current data, so we do not disable auto refresh on the
		 * footer.
		 */
		dataGrid.setAutoHeaderRefreshDisabled(true);
		
		// Set the message to display when the table is empty.
		dataGrid.setEmptyTableWidget(new Label("Tabela Vazia")); //constants.getEmpty()
		
		dataGrid.addColumnSortHandler(sortHandler);
		
		// Add a selection model so we can select cells.
		dataGrid.setSelectionModel(makeSelectionModel(), DefaultSelectionEventManager.<EstudanteVO> createCheckboxManager());
		
		initColumns(dataGrid);
		
		dataView.addDataDisplay(dataGrid);
	}
	
	public void initColumns(DataGrid<EstudanteVO> dataGrid) {
		
		SelectionModel<EstudanteVO> selectionModel = (SelectionModel<EstudanteVO>) dataGrid.getSelectionModel();
		
		dataGrid.addColumn(getCheckboxColumn(selectionModel), SafeHtmlUtils.fromSafeConstant("<br/>"));
		dataGrid.setColumnWidth(dataGrid.getColumnCount()-1, 5, Unit.PCT);
		
		dataGrid.addColumn(getIdColumn(true), "Id"); //constants.getId()
		dataGrid.setColumnWidth(dataGrid.getColumnCount()-1, 10, Unit.PCT);
		
		dataGrid.addColumn(getNomeColumn(true), "Nome");
		dataGrid.setColumnWidth(dataGrid.getColumnCount()-1, 25, Unit.PCT);
		
		dataGrid.addColumn(getMatriculaColumn(true), "Matricula");
		dataGrid.setColumnWidth(dataGrid.getColumnCount()-1, 40, Unit.PCT);
		
	}
	

}
