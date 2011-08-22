package playground.sergioo.Visualizer2D;

import java.awt.Graphics2D;


public class Layer {
	
	//Attributes
	private boolean visible;
	private final boolean active;
	private final Painter painter;
	
	//Method
	public Layer(Painter painter) {
		super();
		this.painter = painter;
		visible = true;
		active = true;
	}
	public Layer(Painter painter, boolean active) {
		super();
		this.painter = painter;
		visible = true;
		this.active = active;
	}
	public Painter getPainter() {
		return painter;
	}
	public void paint(Graphics2D g2, LayersPanel layersPanel) throws Exception {
		if(visible)
			painter.paint(g2, layersPanel);
	}
	public void changeVisible() {
		visible = !visible;
	}
	public boolean isActive() {
		return active;
	}
	
}
