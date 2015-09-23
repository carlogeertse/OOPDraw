package Composers;

import java.awt.Point;

import mainpackage.AbstractShape;
import mainpackage.MyRect;

public class RectangleComposer implements ShapeComposer{
	private AbstractShape shape;
	
	@Override
	public AbstractShape create(Point p) {
		MyRect s = new MyRect(); // Create the shape - Rectangle
		s.setStart(p);// Set the start position where mouse went down
		shape = s;
		return s;
	}

	@Override
	public AbstractShape expand(Point p) {
		MyRect s = (MyRect) shape;
		s.setEnd(p);
		shape = s;
		return s;
	}

	@Override
	public AbstractShape complete(Point p) {
		MyRect s = (MyRect) shape;
		s.setEnd(p);
		shape = s;
		return s;
	}
}
