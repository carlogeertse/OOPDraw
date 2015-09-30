package Composers;

import java.util.HashMap;

public class shapeComposerFactory {
	static private shapeComposerFactory _instance;
	
	private shapeComposerFactory()
	{
		
	}
	
	public static shapeComposerFactory getInstance()
	{
		if(_instance==null)
		{
			_instance = new shapeComposerFactory();
		}
		return _instance;
	}
	
	public HashMap<String,String> listComposerNames() {
			return null;
	}
	
	public ShapeComposer createComposer(String name) {
			return null;
	}

}
