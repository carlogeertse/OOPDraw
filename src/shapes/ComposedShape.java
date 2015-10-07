package shapes;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public class ComposedShape extends AbstractShape{
	private ArrayList<AbstractShape> shapes;

	public ComposedShape()
	{
		shapes = new ArrayList<AbstractShape>();
	}
	
	public void addShape(AbstractShape shape)
	{
		shapes.add(shape);
	}
	
	/**
	 * 
	 * @param shape
	 */
	public void removeShape(AbstractShape shape)
	{
		shapes.remove(shape);
	}
	
	public void clear()
	{
		shapes.clear();
	}
	
	@Override
	public void setStart(Point p)
	{
		for(AbstractShape shape: shapes)
		{
			shape.startPos = p;
		}
	}
	
	@Override
	public void setEnd(Point p)
	{
		for(AbstractShape shape: shapes)
		{
			shape.endPos = p;
		}
	}
	
	// Drawing routine
	public void Draw(Graphics2D g) {
		for(AbstractShape shape: shapes)
		{
			shape.Draw(g);
		}
	}
}
