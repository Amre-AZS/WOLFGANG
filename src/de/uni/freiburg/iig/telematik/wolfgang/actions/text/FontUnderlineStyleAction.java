package de.uni.freiburg.iig.telematik.wolfgang.actions.text;

import java.awt.event.ActionEvent;
import java.io.IOException;

import de.invation.code.toval.properties.PropertyException;
import de.uni.freiburg.iig.telematik.wolfgang.actions.AbstractPNEditorAction;
import de.uni.freiburg.iig.telematik.wolfgang.editor.component.PNEditorComponent;
import de.uni.freiburg.iig.telematik.wolfgang.graph.util.MXConstants;
import de.uni.freiburg.iig.telematik.wolfgang.icons.IconFactory;

public class FontUnderlineStyleAction extends AbstractPNEditorAction {

	private static final long serialVersionUID = 7450908146578160638L;
	protected boolean underline = false;

	public FontUnderlineStyleAction(PNEditorComponent editor) throws PropertyException, IOException {
		super(editor, "Underline", IconFactory.getIcon("underline"));
	}

	@Override
	protected void doFancyStuff(ActionEvent e) throws Exception {
		if (!underline) {
			getGraph().setCellStyles((String) MXConstants.FONT_DECORATION, "underline");
			underline = true;
		} else {
			getGraph().setCellStyles((String) MXConstants.FONT_DECORATION, null);
			underline = false;
		}
	}

}