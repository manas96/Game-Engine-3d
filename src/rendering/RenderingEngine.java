package rendering;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_VERSION;
import static org.lwjgl.opengl.GL32.GL_DEPTH_CLAMP;

import java.util.ArrayList;
import java.util.HashMap;

import components.BaseLight;
import components.Camera;
import core.GameObject;
import core.Transform;
import core.Vector3f;
import resourceManagment.MappedValues;

public class RenderingEngine extends MappedValues
{
	private HashMap<String, Integer> samplerMap;
	private ArrayList<BaseLight> lights;
	private BaseLight activeLight;
	
	private Shader forwardAmbient;
	private Camera mainCamera;
	
	public RenderingEngine()
	{
		super();
		lights = new ArrayList<BaseLight>();
		samplerMap = new HashMap<String, Integer>();	
		samplerMap.put("diffuse", 0);
		
		addVector3f("ambient", new Vector3f(0.1f, 0.1f, 0.1f));
		
		
		forwardAmbient = new Shader("forward-ambient");
		
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);		//clear all pixels
		
		glFrontFace(GL_CW);		//clockwise: frontface
		glCullFace(GL_BACK);	//anticlockwise: cullface
		glEnable(GL_CULL_FACE);
		glEnable(GL_DEPTH_TEST);	//keep track of depth for each component
		//things wont be drawn on top of each other
		
		glEnable(GL_DEPTH_CLAMP);
		
		glEnable(GL_TEXTURE_2D);
		
	}
	
	public void updateUniformStruct(Transform transform, Material material, Shader shader, String uniformName, String uniformType )
	{
		throw new IllegalArgumentException(uniformType + " is not a supported type in RenderingEngine");
	}
	
	public void render(GameObject object)
	{	
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		object.render(forwardAmbient, this);
		
		glEnable(GL_BLEND);
		glBlendFunc(GL_ONE, GL_ONE);
		glDepthMask(false);
		glDepthFunc(GL_EQUAL);
		
		for(BaseLight light : lights)
		{
			activeLight = light;
			object.render(light.getShader(), this);
		}

		glDepthFunc(GL_LESS);
		glDepthMask(true);
		glDisable(GL_BLEND);

	}

	public static String getOpenGLVersion()
	{
		return glGetString(GL_VERSION);
	}

	public Camera getMainCamera() {
		return mainCamera;
	}

	public void addLight(BaseLight light)
	{
		lights.add(light);
	}
	
	public void addCamera(Camera camera)
	{
		mainCamera = camera;
	}
	
	public int getSamplerSlot(String samplerName)
	{
		return samplerMap.get(samplerName);
	}
	public BaseLight getActiveLight()
	{
		return activeLight;
	}
	public void setMainCamera(Camera mainCamera) {
		this.mainCamera = mainCamera;
	}
}
