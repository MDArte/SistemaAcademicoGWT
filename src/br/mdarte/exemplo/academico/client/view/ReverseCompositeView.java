package br.mdarte.exemplo.academico.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.mvp4g.client.view.ReverseViewInterface;

/*
 * Classe necessária para que view e presenter possam comunicar entre si
 */

public class ReverseCompositeView<P> extends Composite implements ReverseViewInterface<P> {

	protected P presenter;

	public void setPresenter( P presenter ) {
		this.presenter = presenter;
	}

	public P getPresenter() {
		return presenter;
	}

}