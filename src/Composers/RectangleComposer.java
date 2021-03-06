package composers;

import java.awt.Point;

import shapes.AbstractShape;
import shapes.MyRect;

public class RectangleComposer implements ShapeComposer{
	private MyRect rect;
	
	@Override
	public AbstractShape create(Point p) {
		MyRect s = new MyRect(); // Create the shape - Rectangle
		s.setStart(p);// Set the start position where mouse went down
		rect = s;
		return s;
	}

	@Override
	public AbstractShape expand(Point p) {
		MyRect s = rect;
		s.setEnd(p);
		rect = s;
		return s;
	}

	@Override
	public AbstractShape complete(Point p) {
		return this.expand(p);
	}
}
