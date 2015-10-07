package composers;

import java.awt.Point;

import shapes.AbstractShape;
import shapes.ComposedShape;
import shapes.MyLine;
import shapes.MyOval;
import shapes.MyRect;

public class FunnyShapeComposer implements ShapeComposer {
	private ComposedShape compShape;
	
	@Override
	public AbstractShape create(Point p) {
		ComposedShape s = new ComposedShape();// Create the shape - Composite shape
		s.addShape(new MyOval());
		s.addShape(new MyRect());
		s.addShape(new MyLine());
		s.setStart(p);// Set the start position where mouse went down
		compShape = s;
		return s;
	}

	@Override
	public AbstractShape expand(Point p) {
		ComposedShape s = compShape;
		s.setEnd(p);
		compShape = s;
		return s;
	}

	@Override
	public AbstractShape complete(Point p) {
		return this.expand(p);
	}

}
