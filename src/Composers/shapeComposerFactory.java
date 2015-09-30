package Composers;


public class ShapeComposerFactory {
	static private ShapeComposerFactory _instance;
	
	private ShapeComposerFactory()
	{
		
	}
	
	public static ShapeComposerFactory getInstance()
	{
		if(_instance==null)
		{
			_instance = new ShapeComposerFactory();
		}
		return _instance;
	}
	
	public String[] listComposerNames() {
			String[] names = {"Oval","Rectangle","Line"}; //Final shape will be the default shape to be drawn.
			return names;
	}
	
	public ShapeComposer createComposer(String name) {
			switch (name)
			{
				case "Line": return new LineComposer(); 
				case "Oval": return new OvalComposer();
				case "Rectangle": return new RectangleComposer();
				default: return new LineComposer();
			}
	}

}
