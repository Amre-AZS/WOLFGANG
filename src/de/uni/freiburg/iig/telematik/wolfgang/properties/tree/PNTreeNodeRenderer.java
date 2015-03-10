package de.uni.freiburg.iig.telematik.wolfgang.properties.tree;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import com.mxgraph.util.mxRectangle;

import de.invation.code.toval.properties.PropertyException;
import de.uni.freiburg.iig.telematik.wolfgang.editor.properties.WolfgangProperties;
import de.uni.freiburg.iig.telematik.wolfgang.graph.util.MXConstants;
import de.uni.freiburg.iig.telematik.wolfgang.graph.util.Utils;
import de.uni.freiburg.iig.telematik.wolfgang.icons.IconFactory;
import de.uni.freiburg.iig.telematik.wolfgang.icons.IconFactory.IconSize;

public class PNTreeNodeRenderer extends DefaultTreeCellRenderer {

	public PNTreeNodeRenderer() throws PropertyException, IOException {
		super();
		this.placeImage = createPlaceImage();;
		this.transitionImage = createTransitionImage();
		this.arcIcon = arcIcon;
		this.rootIcon = rootIcon;
	}



	private static final long serialVersionUID = -7829208008630231526L;
	private static String nodeColor = "#333333";
	private Image placeImage;
	private Image transitionImage;
	//	private ImageIcon placeIcon = new ImageIcon(createPlaceImage());
//	private ImageIcon transitionIcon = new ImageIcon(createTransitionImage());
	private ImageIcon arcIcon = new ImageIcon(IconFactory.class.getResource("arrow.png"));
	private ImageIcon rootIcon = new ImageIcon(IconFactory.class.getResource("cloud.png"));
//	public static Image createPlaceImage() {
//		Color defaultFillColor = Utils.parseColor(nodeColor);
//		IconSize iconsize = null;
//		try {
//			iconsize = WolfgangProperties.getInstance().getIconSize();
//		} catch (PropertyException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		int size = iconsize.getSize();
//
//
//        Image image = new BufferedImage (size, size, BufferedImage.TYPE_INT_ARGB_PRE);
//        Graphics g = image.getGraphics();
//        Graphics2D g2 = (Graphics2D) g;
//        g2.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        int placeSize = (size-size/5);
//        g2.setColor(defaultFillColor);
//        g2.fillOval(size/10, size/10, placeSize, placeSize);
//        g2.dispose ();
//        return image;
//
//	}
	
	public static Image createPlaceImage() throws PropertyException, IOException {
		Color defaultFillColor = Utils.parseColor(nodeColor);
		IconSize iconsize = null;
		iconsize = WolfgangProperties.getInstance().getIconSize();
		int size = iconsize.getSize();

		Image image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB_PRE);
		Graphics g = image.getGraphics();
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		mxRectangle bounds = new mxRectangle(0, 0, size, size);
		float x1 = (float) bounds.getX();
		float y1 = (float) bounds.getY();
		float x2 = (float) bounds.getX();
		float y2 = (float) bounds.getY();

		GradientPaint fillPaint = new GradientPaint(x1, y1, defaultFillColor, x2, y2, defaultFillColor, false);
		g2.setPaint(fillPaint);
		int placeSize = (size - 1) / 2;
		Color bgcolor = UIManager.getColor("Panel.background");
		g2.setColor(bgcolor);
		g2.fillOval(0, 0, placeSize + placeSize / 2 + 2, placeSize + placeSize / 2 + 2);
		g2.setColor(defaultFillColor);
		g2.fillOval(0, 0, placeSize + placeSize / 2, placeSize + placeSize / 2);
		g2.setColor(new Color(0, 0, 0));
		g2.setStroke(new BasicStroke(1));
		g2.drawOval(0, 0, placeSize + placeSize / 2, placeSize + placeSize / 2);

		g2.dispose();
		return image;

	}
	
	public static Image createTransitionImage() throws PropertyException, IOException {
		Color defaultFillColor = Utils.parseColor(nodeColor);
		IconSize iconsize = null;
		iconsize = WolfgangProperties.getInstance().getIconSize();
		int size = iconsize.getSize();

		Image image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB_PRE);
		Graphics g = image.getGraphics();
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		mxRectangle bounds = new mxRectangle(0, 0, size, size);
		float x1 = (float) bounds.getX();
		float y1 = (float) bounds.getY();
		float x2 = (float) bounds.getX();
		float y2 = (float) bounds.getY();

		GradientPaint fillPaint = new GradientPaint(x1, y1, defaultFillColor, x2, y2, defaultFillColor, false);
		g2.setPaint(fillPaint);
		int transitionSize = (size - 1) / 2;
		g2.fillRect(transitionSize - (transitionSize / 2), transitionSize - (transitionSize / 2), transitionSize + (transitionSize / 2), transitionSize + (transitionSize / 2));
		g2.setColor(new Color(0, 0, 0));
		g2.setStroke(new BasicStroke(1));
		g2.drawRect(transitionSize - (transitionSize / 2), transitionSize - (transitionSize / 2), transitionSize + (transitionSize / 2), transitionSize + (transitionSize / 2));

		g2.dispose();
		return image;

	}
	
//	public static Image createTransitionImage() {
//		Color defaultFillColor = Utils.parseColor(nodeColor  );
//		IconSize iconsize = null;
//
//			try {
//				iconsize = WolfgangProperties.getInstance().getIconSize();
//			} catch (PropertyException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		int size = iconsize.getSize();
//
//
//        Image image = new BufferedImage (size, size, BufferedImage.TYPE_INT_ARGB_PRE);
//        Graphics g = image.getGraphics();
//        Graphics2D g2 = (Graphics2D) g;
//        g2.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        int placeSize = (size-size/5);
//        g2.setColor(defaultFillColor);
//        g2.fillRect(size/10, size/10, 	placeSize, placeSize);
//        g2.dispose ();
//        return image;
//
//	}
	
	@Override
	public Component getTreeCellRendererComponent(final JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		Component container = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
		final PNTreeNode node = (PNTreeNode) value;

		container.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				tree.stopEditing();
			}

		});

		Component result = this;
		switch (node.getFieldType()) {

		case ARCS:
			setIcon(new ImageIcon(arcIcon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
			setText(getText() + " ("+ node.getChildCount()+ ")");
			break;
		case PLACES:
			setIcon(new ImageIcon(placeImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));	
			setText(getText() + " ("+ node.getChildCount()+ ")");
			break;
		case TRANSITIONS:
			setIcon(new ImageIcon(transitionImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
			setText(getText() + " ("+ node.getChildCount()+ ")");
			break;
		default:
			break;
		case ROOT:
			setIcon(new ImageIcon(rootIcon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
			break;
		case PLACE:
			setIcon(new ImageIcon(placeImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
//			setText(node.getTextfield().getText()); // Overrides NAME with LABEL
//			keepSelectionWhileEditing(tree, node);
			break;
		case TRANSITION:
			setIcon(new ImageIcon(transitionImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
//			setText(node.getTextfield().getText()); // Overrides NAME with LABEL
//			keepSelectionWhileEditing(tree, node);
			break;
		case ARC:
			setIcon(new ImageIcon(arcIcon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
//			setText(node.getTextfield().getText());
//			keepSelectionWhileEditing(tree, node);
			break;
		case LEAF:
			result = node.getTable();
			break;

		}

		return result;
	}

	
	//�berdenken wann genau Node highlighted sein soll
	/**
	 * @param tree
	 * @param node
	 */
	public void keepSelectionWhileEditing(JTree tree, PNTreeNode node) {
		DefaultMutableTreeNode child = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		if (child != null && child.isLeaf() && child.getParent() == node){
			selected = true;
			}
//		if (child != null && child.isLeaf() && child.getParent() != node){
//			selected = false;
//			}
//		if (child != null && !child.isLeaf() && child == node){
//			selected = true;
//			}
//		if (child != null && !child.isLeaf() && child != node){
//			selected = false;
//			}
	}

//	private Component getTextPanel(PNTreeNode node) {
//		JPanel panel = new JPanel();
//		panel.setLayout(new BorderLayout());
//		JLabel label = new JLabel(node.toString() + ": ");
//		label.setSize(new Dimension(200, 30));
//		panel.add(label, BorderLayout.LINE_START);
//		panel.add(node.getTextfield(), BorderLayout.LINE_END);
//		return panel;
//	}
	
	 @Override
	    public Color getBackgroundNonSelectionColor() {
	        return (null);
	    }

	    @Override
	    public Color getBackgroundSelectionColor() {
	        return MXConstants.LABEL_HANDLE_FILLCOLOR;
	    }

	    @Override
	    public Color getBackground() {
	        return (null);
	    }

}