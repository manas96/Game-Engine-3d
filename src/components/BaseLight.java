package components;

import core.CoreEngine;
import core.Vector3f;
import rendering.Shader;

public class BaseLight extends GameComponent {

	private Vector3f color;
	private float intensity;
	private Shader shader;

	
	public BaseLight(Vector3f color, float intensity)
	{
		this.color = color;
		this.intensity = intensity;
	}

	@Override
	public void addToEngine(CoreEngine engine)
	{
		engine.getRenderingEngine().addLight(this);
	}

	public void setShader (Shader shader)
	{
		this.shader = shader;
	}	
	
	public Shader getShader()
	{
		return shader;
	}
	public Vector3f getColor() {
		return color;
	}

	public void setColor(Vector3f color) {
		this.color = color;
	}

	public float getIntensity() {
		return intensity;
	}

	public void setIntensity(float intensity) {
		this.intensity = intensity;
	}
	
}
