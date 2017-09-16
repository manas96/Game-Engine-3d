package game;

import components.GameComponent;
import core.Quaternion;
import core.Vector3f;
import rendering.RenderingEngine;
import rendering.Shader;

public class LookAtComponent extends GameComponent
{
	RenderingEngine renderingEngine;

	@Override
	public void update(float delta)
	{
		if(renderingEngine != null)
		{
			Quaternion newRot = getTransform().getLookAtRotation(renderingEngine.getMainCamera().getTransform().getTransformedPos(),
					new Vector3f(0,1,0));//always getTransformedPos(), not getPos()
					//getTransform().getRot().getUp());

			getTransform().setRot(getTransform().getRot().nlerp(newRot, delta * 5.0f, true));
			//getTransform().setRot(getTransform().getRot().slerp(newRot, delta * 5.0f, true));
		}
	}

	@Override
	public void render(Shader shader, RenderingEngine renderingEngine)
	{
		this.renderingEngine = renderingEngine;
	}
}