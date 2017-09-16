package game;

import core.CoreEngine;

public class Main {

	public static void main(String[] args)
	{
		CoreEngine engine = new CoreEngine(600, 800, 60, new TestGame());
		engine.createWindow("3D Game Engine");
		engine.start();
	}
	
}
