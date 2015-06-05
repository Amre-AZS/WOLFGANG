package de.uni.freiburg.iig.telematik.wolfgang.menu.toolbars.property;

import java.util.HashSet;
import java.util.Set;

import de.uni.freiburg.iig.telematik.sepia.petrinet.properties.PropertyCheckingResult;
import de.uni.freiburg.iig.telematik.sepia.petrinet.properties.threaded.AbstractThreadedPNPropertyChecker;
import de.uni.freiburg.iig.telematik.sepia.petrinet.pt.abstr.AbstractPTNet;
import de.uni.freiburg.iig.telematik.sepia.petrinet.pt.properties.wfnet.WFNetException;
import de.uni.freiburg.iig.telematik.sepia.petrinet.pt.properties.wfnet.WFNetProperties;
import de.uni.freiburg.iig.telematik.sepia.petrinet.pt.properties.wfnet.structure.ThreadedWFNetStructureChecker;
import de.uni.freiburg.iig.telematik.sepia.petrinet.pt.properties.wfnet.structure.WFNetStructureCheckingCallableGenerator;
import de.uni.freiburg.iig.telematik.wolfgang.editor.component.PNEditorComponent;

public class WFNetStructureCheckLabel extends PNPropertyCheckLabel<WFNetProperties> {

	private static final long serialVersionUID = -8561240983245503666L;
	
	protected Set<WFNetCheckLabelListener<WFNetProperties>> wfNetCheckListeners = new HashSet<WFNetCheckLabelListener<WFNetProperties>>();

	public WFNetStructureCheckLabel(PNEditorComponent editorComponent, String propertyName) {
		super(editorComponent, propertyName);
	}

	public WFNetStructureCheckLabel(PNEditorComponent editorComponent) {
		super(editorComponent);
	}
	
	public void addWFNetCheckListener(WFNetCheckLabelListener<WFNetProperties> listener){
		wfNetCheckListeners.add(listener);
	}
	
	@Override
	public void executorFinished(WFNetProperties result) {
		super.executorFinished(result);
		for(WFNetCheckLabelListener listener: wfNetCheckListeners)
			listener.wfNetCheckFinished(WFNetStructureCheckLabel.this, result);
	}

	@Override
	public void executorStopped() {
		super.executorStopped();
		for(WFNetCheckLabelListener listener: wfNetCheckListeners)			
			listener.wfNetCheckStopped(WFNetStructureCheckLabel.this, null);
	}

	@Override
	protected AbstractThreadedPNPropertyChecker<?,?,?,?,?,?,WFNetProperties,?> createNewExecutor() {
		return new ThreadedWFNetStructureChecker(new WFNetStructureCheckingCallableGenerator((AbstractPTNet<?,?,?,?>) editorComponent.getNetContainer().getPetriNet().clone()));
	}

	@Override
	protected void setPropertyHolds(WFNetProperties calculationResult) {
		this.propertyHolds = calculationResult.hasWFNetStructure == PropertyCheckingResult.TRUE;
		editorComponent.getPropertyCheckView().updateFieldContent(calculationResult, null);
	}

	@Override
	public void executorException(Exception exception) {
		super.executorException(exception);
		if(exception instanceof WFNetException){
			if(((WFNetException) exception).getProperties() != null){
				editorComponent.getPropertyCheckView().updateFieldContent(((WFNetException) exception).getProperties(), exception);
			}
		} else {
			editorComponent.getPropertyCheckView().resetFieldContent();
		}
		for(WFNetCheckLabelListener listener: wfNetCheckListeners)
			listener.wfNetCheckException(WFNetStructureCheckLabel.this, exception);
	}
	
	
}