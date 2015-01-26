/*
 * Copyright 2010 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.mdarte.exemplo.academico.client.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.view.client.SelectionModel;

/**
 * Creates cells tailored to an object
 */
public abstract class CoppetecTableBuilder<T> {
	
	protected DataInterface<T> dataView = new DataInterface<T>();
	
	// Attach a column sort handler to the ListDataProvider to sort the list.
	protected ListHandler<T> sortHandler = new ListHandler<T>(dataView.getDataProvider().getList());
	
	GetValue<T,T> getterRow = new GetValue<T,T>() {
		public T getValue(T object) {
			return object;
		}
	};

	public CoppetecTableBuilder() {

	}
	
	/**
	 * Get a cell value from a record.
	 * 
	 * @param <C> the cell type
	 */
	protected static interface GetValue<T,C> {
		C getValue(T object);
	}
	
	protected Column<T, Boolean> makeCheckBoxColumn(final SelectionModel<T> selectionModel) {
		// Checkbox column. This table will uses a checkbox column for selection.
		
		Column<T, Boolean> checkColumn =
			new Column<T, Boolean>(new CheckboxCell(true, false)) {
				@Override
				public Boolean getValue(T object) {
					// Get the value from the selection model.
					return selectionModel.isSelected(object);
				}
			};
		
		return checkColumn;
	}
	
	protected <C> Column<T, C> makeActionColumn(ActionCell<C> cell, final GetValue<T,C> getter) {
		Column<T, C> column = new Column<T, C>(cell) {
			@Override
			public C getValue(T object) {
				return getter.getValue(object);
			}
		};

		return column;
	}
	
	protected <C> Column<T, C> makeColumn(Cell cell, final GetValue<T,C> getter) {
		Column<T, C> column = new Column<T, C>(cell) {
			@Override
			public C getValue(T object) {
				return getter.getValue(object);
			}
		};

		return column;
	}
	
	protected <C> Column<T, C> makeColumn(Cell cell, final GetValue<T,C> getter, FieldUpdater<T, C> fieldUpdater) {
		Column<T, C> column = makeColumn(cell, getter);
		
		column.setFieldUpdater(fieldUpdater);

		return column;
	}
	
	/*protected void addListColumn() {
	    final Category[] categories = ContactDatabase.get().queryCategories();
	    List<String> categoryNames = new ArrayList<String>();
	    for (Category category : categories) {
	      categoryNames.add(category.getDisplayName());
	    }
	    SelectionCell categoryCell = new SelectionCell(categoryNames);
	    Column<ContactInfo, String> categoryColumn = new Column<ContactInfo, String>(categoryCell) {
	      @Override
	      public String getValue(ContactInfo object) {
	        return object.getCategory().getDisplayName();
	      }
	    };
	    dataGrid.addColumn(categoryColumn, constants.cwDataGridColumnCategory());
	    categoryColumn.setFieldUpdater(new FieldUpdater<ContactInfo, String>() {

	      public void update(int index, ContactInfo object, String value) {
	        for (Category category : categories) {
	          if (category.getDisplayName().equals(value)) {
	            object.setCategory(category);
	          }
	        }
	        ContactDatabase.get().refreshDisplays();
	      }
	    });
	    dataGrid.setColumnWidth(categoryColumn, 130, Unit.PX);
	}*/
	
	protected void makeColumnSortable(Column column, Comparator<T> comp) {
		column.setSortable(true);
		sortHandler.setComparator(column, comp);
	}
	
	public void setData(ArrayList<T> list)
	{
		dataView.clean();
		dataView.addList(list);
	}
	
	public void deleteRow(T item) {
		this.dataView.removeItem(item);
	}
	
	public void deleteRows(Collection<T> items) {
		this.dataView.removeItems(items);
	}
	
	
	public abstract void makeActionColumn(DataGrid<T> dataGrid, ActionCell<T> cell, String header);
	
	public abstract Column<T,Boolean> getCheckboxColumn(SelectionModel<T> selectionModel);
	
	public abstract void makeDataGrid(DataGrid<T> dataGrid);
	
	public abstract SelectionModel<T> makeSelectionModel();

}