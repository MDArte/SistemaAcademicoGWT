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
import java.util.List;

import com.google.gwt.user.client.Random;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ListDataProvider;

/**
 * The data source for information used in the table.
 */
public class DataInterface<T> {

	/**
	 * The provider that holds the list of items.
	 */
	private ListDataProvider<T> dataProvider = new ListDataProvider<T>();

	/**
	 * Construct a new database.
	 */
	public DataInterface() {

	}

	/**
	 * Add an item.
	 * 
	 * @param item the item to add.
	 */
	
	public void addItem(T item) {
		List<T> items = dataProvider.getList();
		// Remove the item first so we don't add a duplicate.
		items.remove(item);
		items.add(item);
	}

	/**
	 * Add a display to the database. The current range of interest of the display
	 * will be populated with data.
	 * 
	 * @param display a {@Link HasData}.
	 */
	public void addDataDisplay(HasData<T> display) {
		dataProvider.addDataDisplay(display);
	}

	public void addList(ArrayList<T> list) {
		List<T> items = dataProvider.getList();
		for (int i = 0; i < list.size(); i++) {
			items.add(list.get(i));
		}
	}
	
	public void clean() {
		List<T> items = dataProvider.getList();
		items.clear();
	}
	
	public void removeItem(T item) {
		List<T> items = dataProvider.getList();
		
		items.remove(item);	
	}
	
	public void removeItems(Collection<T> selection) {
		List<T> items = dataProvider.getList();
		
		items.removeAll(selection);	
	}

	public ListDataProvider<T> getDataProvider() {
		return dataProvider;
	}

	/**
	 * Refresh all displays.
	 */
	public void refreshDisplays() {
		dataProvider.refresh();
	}

	/**
	 * Get the next random value from an array.
	 * 
	 * @param array the array
	 * @return a random value in the array
	 */
	private <T> T nextValue(T[] array) {
		return array[Random.nextInt(array.length)];
	}

}