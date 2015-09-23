package Composers;

import java.awt.Point;

import mainpackage.AbstractShape;
import mainpackage.MyOval;

public class OvalComposer implements ShapeComposer{
	private AbstractShape shape;
	private Point startpos;

	@Override
	public AbstractShape create(Point p) {
		MyOval s = new MyOval(); // Create the shape - Oval
		s.setStart(p);// Set the start position where mouse went down
		startpos = p;
		shape = s;
		return s;
	}

	@Override
	public AbstractShape expand(Point p) {
		Point drawto = new Point(Math.max(p.x, startpos.x), Math.max(p.y, startpos.y));
		Point newstart = new Point(Math.min(p.x, startpos.x), Math.min(p.y, startpos.y));
		int width = Math.abs((drawto.x - newstart.x));
		int height = Math.abs((drawto.y - newstart.y));
		MyOval s = (MyOval) shape;
		s.setWidth(width);
		s.setHeight(height);
		s.setStart(newstart);
		shape = s;
		return s;
	}

	@Override
	public AbstractShape complete(Point p) {
		Point drawto = new Point(Math.max(p.x, startpos.x), Math.max(p.y, startpos.y));
		Point newstart = new Point(Math.min(p.x, startpos.x), Math.min(p.y, startpos.y));
		int width = Math.abs((drawto.x - newstart.x));
		int height = Math.abs((drawto.y - newstart.y));
		MyOval s = (MyOval) shape;
		s.setWidth(width);
		s.setHeight(height);
		s.setStart(newstart);
		shape = s;
		return s;
	}
}
