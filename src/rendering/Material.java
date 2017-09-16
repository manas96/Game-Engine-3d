package rendering;

import java.util.HashMap;

import resourceManagment.MappedValues;

public class Material extends MappedValues {

	private HashMap<String, Texture> textureHashMap;

	public Material()
	{
		super();
		textureHashMap = new HashMap<String, Texture>();
	}
	
	public void addTexture(String name, Texture texture)
	{
		textureHashMap.put(name, texture);
	}
	
	public Texture getTexture(String name)
	{
		Texture result = textureHashMap.get(name);
		if(result != null)
			return result;
		return new Texture("test.png");
	}
}