package de.uni.freiburg.iig.telematik.wolfgang.editor.component;

import java.io.IOException;

import javax.swing.JPopupMenu;
import javax.swing.JToolBar;

import de.invation.code.toval.properties.PropertyException;
import de.invation.code.toval.types.Multiset;
import de.invation.code.toval.validate.ParameterException;
import de.uni.freiburg.iig.telematik.sepia.graphic.GraphicalCPN;
import de.uni.freiburg.iig.telematik.sepia.graphic.netgraphics.CPNGraphics;
import de.uni.freiburg.iig.telematik.sepia.petrinet.abstr.AbstractFlowRelation;
import de.uni.freiburg.iig.telematik.sepia.petrinet.cpn.CPN;
import de.uni.freiburg.iig.telematik.wolfgang.exception.EditorToolbarException;
import de.uni.freiburg.iig.telematik.wolfgang.graph.CPNGraph;
import de.uni.freiburg.iig.telematik.wolfgang.graph.CPNGraphComponent;
import de.uni.freiburg.iig.telematik.wolfgang.graph.PNGraphComponent;
import de.uni.freiburg.iig.telematik.wolfgang.menu.AbstractToolBar;
import de.uni.freiburg.iig.telematik.wolfgang.menu.CPNToolBar;
import de.uni.freiburg.iig.telematik.wolfgang.menu.popup.EditorPopupMenu;
import de.uni.freiburg.iig.telematik.wolfgang.menu.popup.TransitionPopupMenu;
import de.uni.freiburg.iig.telematik.wolfgang.properties.check.AbstractPropertyCheckView;
import de.uni.freiburg.iig.telematik.wolfgang.properties.check.CWNPropertyCheckView;
import de.uni.freiburg.iig.telematik.wolfgang.properties.view.CPNProperties;
import de.uni.freiburg.iig.telematik.wolfgang.properties.view.PNProperties;

public class CPNEditorComponent extends AbstractCPNEditorComponent {

	private static final long serialVersionUID = 7463202384539027183L;

	public CPNEditorComponent() {
		super();
	}

	public CPNEditorComponent(GraphicalCPN netContainer) {
		super(netContainer);
	}

	public CPNEditorComponent(GraphicalCPN netContainer, boolean askForLayout) {
		super(netContainer, askForLayout);
	}

	public CPNEditorComponent(GraphicalCPN netContainer, LayoutOption layoutOption) {
		super(netContainer, layoutOption);
	}

	@Override
	public GraphicalCPN getNetContainer() {
		return (GraphicalCPN) super.getNetContainer();
	}

	@Override
	public GraphicalCPN createNetContainer() {
		return new GraphicalCPN(new CPN(), new CPNGraphics());
	}

	@Override
	protected PNProperties createPNProperties() {
		return new CPNProperties(getNetContainer());
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected String getArcConstraint(AbstractFlowRelation relation) {
		// TODO: Do something
		return null;
	}

	@Override
	protected CPNProperties getPNProperties() {
		return (CPNProperties) super.getPNProperties();
	}

	@Override
	protected PNGraphComponent createGraphComponent() {
		return new CPNGraphComponent(new CPNGraph(getNetContainer(), getPNProperties()));
	}

	@Override
	public EditorPopupMenu getPopupMenu() {
		try {
			return new EditorPopupMenu(this);
		} catch (ParameterException | PropertyException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public JPopupMenu getTransitionPopupMenu() {
		try {
			return new TransitionPopupMenu(this);
		} catch (ParameterException | PropertyException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected AbstractToolBar createNetSpecificToolbar() throws EditorToolbarException {
		return new CPNToolBar(this, JToolBar.HORIZONTAL);
	}
	
	@Override
	public void markingForPlaceChanged(String placeName, Multiset placeMarking) {
		resetPropertyCheckView();		
	}

	@Override
	public void placeCapacityChanged(String placeName, String color, int newCapacity) {
		resetPropertyCheckView();	
	}

	@Override
	public void constraintChanged(String flowRelation, Multiset constraint) {
		resetPropertyCheckView();		
	}

	@Override
	protected AbstractPropertyCheckView createPropertyCheckView() {
		CWNPropertyCheckView cwnPropertyCheck = new CWNPropertyCheckView();
		cwnPropertyCheck.setUpGui();
		return cwnPropertyCheck;
	}

}
