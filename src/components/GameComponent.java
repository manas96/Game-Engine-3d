package components;

import core.CoreEngine;
import core.GameObject;
import core.Transform;
import rendering.RenderingEngine;
import rendering.Shader;

public abstract class GameComponent 
{
	private GameObject parent;
	
	public void init( float delta){}
	public void input( float delta){}
	public void update( float delta){}
	public void render( Shader shader, RenderingEngine renderingEngine){}
	
	public void setParent(GameObject parent)
	{
		this.parent = parent;
	}
	
	public Transform getTransform()
	{
		return parent.getTransform();
	}
	public void addToEngine(CoreEngine engine){}

}
