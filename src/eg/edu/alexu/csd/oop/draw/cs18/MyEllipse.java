package eg.edu.alexu.csd.oop.draw.cs18;

import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class MyEllipse extends MyShape {
	public MyEllipse() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics canvas) {
		// TODO Auto-generated method stub
		int xend = getProperties().get("x").intValue();
		int yend = getProperties().get("y").intValue();
		int xstart = getPosition().x;
		int ystart = getPosition().y;
		int minX = Math.min(xend, xstart);
		int minY = Math.min(yend, ystart);
		int maxX = Math.max(xend, xstart);
		int maxY = Math.max(yend, ystart);
		canvas.setColor(getFillColor());
		canvas.fillOval(minX, minY, maxX - minX, maxY - minY);
		canvas.setColor(getColor());
		canvas.drawOval(minX, minY, maxX - minX, maxY - minY);
		setPosition(new Point(minX, minY));
		getProperties().put("x", (double) (minX + maxX - minX));
		getProperties().put("y", (double) (minY + maxY - minY));
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		MyEllipse e = new MyEllipse();
		e.setProperties((Map<String, Double>) ((HashMap<String, Double>)this.getProperties()).clone());
		e.setPosition((Point) this.getPosition().clone());
		e.setColor(this.getColor());
		e.setFillColor(this.getFillColor());
		return e;
	}


}
