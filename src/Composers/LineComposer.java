package Composers;

import java.awt.Point;

import mainpackage.AbstractShape;
import mainpackage.MyLine;

public class LineComposer implements ShapeComposer {
	private AbstractShape shape;
	
	/**
	 * 
	 */
	@Override
	public AbstractShape create(Point p) {
		// Where the mouse went down is the start
		// position of the shape to be drawn
		MyLine s = new MyLine(); // Create the shape - Line
		s.setStart(p);// Set the start position where mouse went down
		shape = s;
		return s;
	}

	@Override
	public AbstractShape expand(Point p) {
		MyLine s = (MyLine) shape;
		s.setEnd(p);
		shape = s;
		return s;
	}

	@Override
	public AbstractShape complete(Point p) {
		MyLine s = (MyLine) shape;
		s.setEnd(p);
		shape = s;
		return s;
	}
}
