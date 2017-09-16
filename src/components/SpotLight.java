package components;

import core.Vector3f;
import rendering.Attenuation;
import rendering.Shader;

public class SpotLight extends PointLight{

	private float cutoff;
	
	public SpotLight(Vector3f color, float intensity, Attenuation attenuation, float cutoff)
	{
		super(color,intensity,attenuation);
		this.cutoff = cutoff;
		
		setShader(new Shader("forward-spot"));
	}

	public Vector3f getDirection() {
		return getTransform().getTransformedRot().getForward();
	}

	public float getCutoff() {
		return cutoff;
	}
	public void setCutoff(float cutoff) {
		this.cutoff = cutoff;
	}
	
}
