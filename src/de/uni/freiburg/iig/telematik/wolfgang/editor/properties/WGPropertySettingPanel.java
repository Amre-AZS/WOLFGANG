package de.uni.freiburg.iig.telematik.wolfgang.editor.properties;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import de.invation.code.toval.graphic.component.ColorChooserPanel;
import de.invation.code.toval.graphic.component.ColorChooserPanel.ColorMode;
import de.invation.code.toval.graphic.component.EnumComboBox;
import de.invation.code.toval.graphic.component.FontComboBox;
import de.invation.code.toval.graphic.component.FontComboBox.DisplayMode;
import de.invation.code.toval.graphic.component.RestrictedTextField;
import de.invation.code.toval.graphic.component.RestrictedTextField.Restriction;
import de.invation.code.toval.graphic.util.SpringUtilities;
import de.invation.code.toval.properties.PropertyException;
import de.uni.freiburg.iig.telematik.sepia.graphic.netgraphics.attributes.Fill.GradientRotation;
import de.uni.freiburg.iig.telematik.wolfgang.icons.IconFactory.IconSize;

public class WGPropertySettingPanel extends JPanel {

	private static final long serialVersionUID = 1066469038019795225L;
	
	private EnumComboBox<IconSize> comboIconSize;
	private RestrictedTextField txtDefPlaceSize;
	private RestrictedTextField txtDefTransitionWidth;
	private RestrictedTextField txtDefTransitionHeight;
	private RestrictedTextField txtDefTokenSize;
	private RestrictedTextField txtDefTokenDistance;
	private RestrictedTextField txtDefVertLabelOffset;
	private RestrictedTextField txtDefHorizLabelOffset;
	private RestrictedTextField txtGridSize;

	private ColorChooserPanel colDefLabelBGColor;
	private ColorChooserPanel colDefLabelLineColor;
	private ColorChooserPanel colDefPlaceColor;
	private ColorChooserPanel colDefTransitionColor;
	private ColorChooserPanel colDefLineColor;
	private ColorChooserPanel colDefGradientColor;
	private ColorChooserPanel colBGColor;
	private ColorChooserPanel colGridColor;

	private JCheckBox chckGridVisibility;
	private JCheckBox chckSnapToGrid;

	private JCheckBox chckUpdateNotification;
	private JCheckBox chckFileExtAssociation;

	private EnumComboBox<GradientRotation> comboGradientRotation;
	private FontComboBox comboFontFamily;
	private RestrictedTextField txtDefFontSize;
	private RestrictedTextField txtDefZoomStep;

	public WGPropertySettingPanel() throws PropertyException, IOException {
		super(new SpringLayout());
		initialize();
		addSettingComponents();
		generateGrid();
	}
	
	protected void addSettingComponents(){
		add(new JLabel("Icon Size:", JLabel.RIGHT));
		add(comboIconSize);
		add(new JLabel("Default Place Size:", JLabel.RIGHT));
		add(txtDefPlaceSize);
		add(new JLabel("Default Transition Width:", JLabel.RIGHT));
		add(txtDefTransitionWidth);
		add(new JLabel("Default Transition Height:", JLabel.RIGHT));
		add(txtDefTransitionHeight);
		add(new JLabel("Default Token Size:", JLabel.RIGHT));
		add(txtDefTokenSize);
		add(new JLabel("Default Token Distance:", JLabel.RIGHT));
		add(txtDefTokenDistance);
		add(new JLabel("Default Vertical Label Offset:", JLabel.RIGHT));
		add(txtDefVertLabelOffset);
		add(new JLabel("Default Horizontal Label Offset:", JLabel.RIGHT));
		add(txtDefHorizLabelOffset);

		add(new JLabel("Default Label BG Color:", JLabel.RIGHT));
		add(colDefLabelBGColor);
		add(new JLabel("Default Label Line Color:", JLabel.RIGHT));
		add(colDefLabelLineColor);
		add(new JLabel("Default Place Color:", JLabel.RIGHT));
		add(colDefPlaceColor);
		add(new JLabel("Default Transition Color:", JLabel.RIGHT));
		add(colDefTransitionColor);
		add(new JLabel("Default Line Color:", JLabel.RIGHT));
		add(colDefLineColor);
		add(new JLabel("Default Gradient Color:", JLabel.RIGHT));
		add(colDefGradientColor);

		add(new JLabel("Default Font Family:", JLabel.RIGHT));
		add(comboFontFamily);
		add(new JLabel("Default Font Size:", JLabel.RIGHT));
		add(txtDefFontSize);
		add(new JLabel("Default Zoom Step:", JLabel.RIGHT));
		add(txtDefZoomStep);

		add(new JLabel("Background Color:", JLabel.RIGHT));
		add(colBGColor);

		add(new JLabel("Grid Size:", JLabel.RIGHT));
		add(txtGridSize);
		add(new JLabel("Grid Color:", JLabel.RIGHT));
		add(colGridColor);
		add(new JLabel("Grid Visibility:", JLabel.RIGHT));
		add(chckGridVisibility);
		add(new JLabel("Snap To Grid:", JLabel.RIGHT));
		add(chckSnapToGrid);

		add(new JLabel("Check for updates:", JLabel.RIGHT));
		add(chckUpdateNotification);
		add(new JLabel("Ask for file extension association:", JLabel.RIGHT));
		add(chckFileExtAssociation);
	}
	
	protected void generateGrid(){
		SpringUtilities.makeCompactGrid(this, 24, 2, 5, 5, 5, 5);
	}
	
	protected void initialize() throws PropertyException, IOException {
		comboIconSize = new EnumComboBox<>(IconSize.class);
		comboIconSize.setSelectedItem(EditorProperties.getInstance().getIconSize());
		txtDefPlaceSize = new RestrictedTextField(Restriction.POSITIVE_INTEGER, EditorProperties.getInstance().getDefaultPlaceSize().toString());
		txtDefTransitionWidth = new RestrictedTextField(Restriction.POSITIVE_INTEGER, EditorProperties.getInstance().getDefaultTransitionWidth().toString());
		txtDefTransitionHeight = new RestrictedTextField(Restriction.POSITIVE_INTEGER, EditorProperties.getInstance().getDefaultTransitionHeight().toString());
		txtDefTokenSize = new RestrictedTextField(Restriction.POSITIVE_INTEGER, EditorProperties.getInstance().getDefaultTokenSize().toString());
		txtDefTokenDistance = new RestrictedTextField(Restriction.POSITIVE_INTEGER, EditorProperties.getInstance().getDefaultTokenDistance().toString());
		txtDefVertLabelOffset = new RestrictedTextField(Restriction.POSITIVE_INTEGER, EditorProperties.getInstance().getDefaultVerticalLabelOffset().toString());
		txtDefHorizLabelOffset = new RestrictedTextField(Restriction.POSITIVE_INTEGER, EditorProperties.getInstance().getDefaultHorizontalLabelOffset().toString());
		txtGridSize = new RestrictedTextField(Restriction.POSITIVE_INTEGER, EditorProperties.getInstance().getGridSize().toString());

		colDefLabelBGColor = new ColorChooserPanel(ColorMode.HEX, EditorProperties.getInstance().getDefaultLabelBackgroundColor());
		colDefLabelLineColor = new ColorChooserPanel(ColorMode.HEX, EditorProperties.getInstance().getDefaultLabelLineColor());
		colDefPlaceColor = new ColorChooserPanel(ColorMode.HEX, EditorProperties.getInstance().getDefaultPlaceColor());
		colDefTransitionColor = new ColorChooserPanel(ColorMode.HEX, EditorProperties.getInstance().getDefaultTransitionColor());
		colDefLineColor = new ColorChooserPanel(ColorMode.HEX, EditorProperties.getInstance().getDefaultLineColor());
		colDefGradientColor = new ColorChooserPanel(ColorMode.HEX, EditorProperties.getInstance().getDefaultGradientColor());
		colBGColor = new ColorChooserPanel(ColorMode.HEX, EditorProperties.getInstance().getBackgroundColor());
		colGridColor = new ColorChooserPanel(ColorMode.HEX, EditorProperties.getInstance().getGridColor());

		comboGradientRotation = new EnumComboBox<>(GradientRotation.class);
		comboGradientRotation.setSelectedItem(EditorProperties.getInstance().getDefaultGradientDirection());

		comboFontFamily = new FontComboBox(DisplayMode.FONT_FAMILY, EditorProperties.getInstance().getDefaultFontFamily());
		comboFontFamily.setSelectedItem(EditorProperties.getInstance().getDefaultFontFamily());
		txtDefFontSize = new RestrictedTextField(Restriction.POSITIVE_INTEGER, EditorProperties.getInstance().getDefaultFontSize().toString());
		txtDefZoomStep = new RestrictedTextField(Restriction.POSITIVE_DOUBLE, EditorProperties.getInstance().getDefaultZoomStep().toString());

		chckGridVisibility = new JCheckBox();
		chckGridVisibility.setSelected(EditorProperties.getInstance().getGridVisibility());
		chckSnapToGrid = new JCheckBox();
		chckSnapToGrid.setSelected(EditorProperties.getInstance().getSnapToGrid());

                chckUpdateNotification = new JCheckBox();
                chckUpdateNotification.setSelected(EditorProperties.getInstance().getShowUpdateNotification());
                chckFileExtAssociation = new JCheckBox();
                chckFileExtAssociation.setSelected(EditorProperties.getInstance().getShowFileExtensionAssociation());
	}
	
	public IconSize getIconSize(){
		return comboIconSize.getSelectedItem();
	}
	
	public int getDefaultTransitionWidth(){
		return Integer.valueOf(txtDefTransitionWidth.getText());
	}
	
	public int getDefaultTransitionHeight(){
		return Integer.valueOf(txtDefTransitionHeight.getText());
	}
	
	public int getDefaultPlaceSize(){
		return Integer.valueOf(txtDefPlaceSize.getText());
	}
	
	public int getDefaultTokenSize(){
		return Integer.valueOf(txtDefTokenSize.getText());
	}
	
	public int getDefaultTokenDistance(){
		return Integer.valueOf(txtDefTokenDistance.getText());
	}
	
	public int getDefaultVerticalLabelOffset(){
		return Integer.valueOf(txtDefVertLabelOffset.getText());
	}
	
	public int getDefaultHorizontalLabelOffset(){
		return Integer.valueOf(txtDefHorizLabelOffset.getText());
	}
	
	public Color getDefaultLabelBackgroundColor(){
		return colDefLabelBGColor.getChosenColor();
	}
	
	public Color getDefaultLabelLineColor(){
		return colDefLabelLineColor.getChosenColor();
	}
	
	public Color getDefaultPlaceColor(){
		return colDefPlaceColor.getChosenColor();
	}
	
	public Color getDefaultTransitionColor(){
		return colDefTransitionColor.getChosenColor();
	}
	
	public Color getDefaultLineColor(){
		return colDefLineColor.getChosenColor();
	}
	
	public Color getDefaultGradientColor(){
		return colDefGradientColor.getChosenColor();
	}
	
	public GradientRotation getDefaultGradientDirection(){
		return comboGradientRotation.getSelectedItem();
	}
	
	public String getDefaultFontFamily(){
		return comboFontFamily.getSelectedItem().toString();
	}
	
	public int getDefaultFontSize(){
		return Integer.valueOf(txtDefFontSize.getText());
	}
	
	public double getDefaultZoomStep(){
		return Double.valueOf(txtDefZoomStep.getText());
	}
	
	public Color getBackgroundColor(){
		return colBGColor.getChosenColor();
	}
	
	public Color getGridColor(){
		return colGridColor.getChosenColor();
	}
	
	public int getGridSize(){
		return Integer.valueOf(txtGridSize.getText());
	}
	
	public boolean getGridVisibility(){
		return chckGridVisibility.isSelected();
	}
	
	public boolean getSnapToGrid(){
		return chckSnapToGrid.isSelected();
	}
	
	public boolean getShowUpdateNotification(){
		return chckUpdateNotification.isSelected();
	}
	
	public boolean getShowFileExtensionAssociation(){
		return chckFileExtAssociation.isSelected();
	}
}
