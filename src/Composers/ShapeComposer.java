package composers;
import java.awt.Point;

import shapes.AbstractShape;


public interface ShapeComposer {
	public AbstractShape create(Point p);
	public AbstractShape expand(Point p);
	public AbstractShape complete(Point p);
}
