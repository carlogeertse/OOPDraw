package Composers;
import java.awt.Point;

import mainpackage.AbstractShape;


public interface ShapeComposer {
	public AbstractShape create(Point p);
	public AbstractShape expand(Point p);
	public AbstractShape complete(Point p);
}
