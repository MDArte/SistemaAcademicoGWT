package br.mdarte.exemplo.academico.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.Mvp4gModule;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SistemaAcademicoGWT implements EntryPoint {

	/**
	 * This is the entry point method.
	 */

	public void onModuleLoad() {
	
		Mvp4gModule module = (Mvp4gModule)GWT.create( Mvp4gModule.class );
		module.createAndStartModule();
		RootPanel.get().add( (Widget)module.getStartView() );
		
	}
}
