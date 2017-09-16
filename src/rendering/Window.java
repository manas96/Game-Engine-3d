package rendering;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import core.Vector2f;

public class Window {
	public static void createWindow(int height,int width, String title){
		Display.setTitle(title);
		try {
			Display.setDisplayMode(new DisplayMode(width,height));
			Display.create();
			Keyboard.create();
			Mouse.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void render(){
		Display.update();
	}
	public static void dispose(){
		Display.destroy();
		Keyboard.destroy();
		Mouse.destroy();
	}
	public static boolean isCloseRequested(){
		return Display.isCloseRequested();
	}
	public static int getWidth(){
		return Display.getDisplayMode().getWidth();
	}
	public static int getHeight(){
		return Display.getDisplayMode().getHeight();
	}
	public static String getTitle(){
		return Display.getTitle();
	}
	
	public Vector2f getCenter()
	{
		return new Vector2f(getWidth()/2,getHeight()/2);
	}
}






