package br.mdarte.exemplo.academico.client.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.mdarte.exemplo.academico.client.common.EstudanteTableBuilder;
import br.mdarte.exemplo.academico.client.presenter.interfaces.ResultadoConsultaViewInterface;
import br.mdarte.exemplo.academico.client.presenter.interfaces.ResultadoConsultaViewInterface.ResultadoConsultaPresenterInterface;
import br.mdarte.exemplo.academico.client.view.widgets.EstudanteDataGrid;
import br.mdarte.exemplo.academico.shared.EstudanteVO;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;

public class ResultadoConsultaView extends ReverseCompositeView<ResultadoConsultaPresenterInterface> implements ResultadoConsultaViewInterface {
	
	private static ResultadoConsultaViewUiBinder uiBinder = GWT.create( ResultadoConsultaViewUiBinder.class );

	interface ResultadoConsultaViewUiBinder extends UiBinder<Widget, ResultadoConsultaView> {
	}
	
	EstudanteTableBuilder tableBuilder = new EstudanteTableBuilder();
	
	@UiField  EstudanteDataGrid  studentTable;
	@UiField Button deleteSelected;

	public void createView() {
		//don't create the view before to take advantage of the lazy loading mechanism
		initWidget( uiBinder.createAndBindUi( this ) );
	}

	public void setTable(ArrayList<EstudanteVO> tabela)
	{
		if (!studentTable.isBuilt()) {
			
		
			tableBuilder.makeDataGrid(studentTable.getDataGrid());
			
			ActionCell<EstudanteVO> cell1 = new ActionCell<EstudanteVO>("Delete", new ActionCell.Delegate<EstudanteVO>() {
				public void execute(EstudanteVO estudante) {
					presenter.deletaEstudante(estudante.getId());
				}
			});
			
			tableBuilder.makeActionColumn(studentTable.getDataGrid(), cell1, "Delete");
			
			ActionCell<EstudanteVO> cell2 = new ActionCell<EstudanteVO>("Detalha", new ActionCell.Delegate<EstudanteVO>() {
				public void execute(EstudanteVO estudante) {
	
					presenter.goToDetalhaEstudante(estudante.getId());
				}
			});
			
			tableBuilder.makeActionColumn(studentTable.getDataGrid(), cell2, "Detalha");
			
			studentTable.setBuilt(true);
			
		}

		tableBuilder.setData(tabela);

	}

	@Override
	public void deleteRow(EstudanteVO estudante)
	{
		studentTable.clearSelection();
		tableBuilder.deleteRow(estudante);
	}

	@Override
	public void deleteRows(ArrayList<EstudanteVO> listaEstudantes)
	{
		tableBuilder.deleteRows(listaEstudantes);
	}
	
	@UiHandler( "deleteSelected" )
	public void onClickDeleteSelectedButton(ClickEvent e){
		
		Collection<EstudanteVO> selection = studentTable.getSelection();
		
		if (selection != null && !selection.isEmpty()) {
			ArrayList<Long> listaIds = new ArrayList<Long>();
			
			for (EstudanteVO est : selection) {
				listaIds.add(est.getId());
			}
			
			presenter.deletaEstudantes(listaIds);
		}
			//tableBuilder.deleteRows(selection);
	}
	
}
