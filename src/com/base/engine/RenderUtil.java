package com.base.engine;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL32.*;
public class RenderUtil {

	public static void clearScreen()
	{
		//TODO: stencil buffer
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
	
	public static void setTextures(boolean enabled)
	{
		if(enabled)
			glEnable(GL_TEXTURE_2D);
		else
			glDisable(GL_TEXTURE_2D);
	}
	
	public static void unbindTextures()
	{
		glBindTexture(GL_TEXTURE_2D, 0);
	}
	
	public static void setClearColor(Vector3f color)
	{
		glClearColor(color.getX(), color.getY(), color.getZ(), 1.0f);
	}
	
	public static void initGraphics()
	{
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);		//clear all pixels
		
		glFrontFace(GL_CW);		//clockwise: frontface
		glCullFace(GL_BACK);	//anticlockwise: cullface
		glEnable(GL_CULL_FACE);
		glEnable(GL_DEPTH_TEST);	//keep track of depth for each component
		//things wont be drawn on top of each other
		
		glEnable(GL_DEPTH_CLAMP);
		
		glEnable(GL_TEXTURE_2D);
		
		
	}
	
	public static String getOpenGLVersion()
	{
		return glGetString(GL_VERSION);
	}
}