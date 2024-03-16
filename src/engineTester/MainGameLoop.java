package engineTester;

import models.*;

import org.lwjgl.opengl.*;
import org.lwjgl.util.vector.*;

import renderEngine.*;
import shaders.*;
import textures.*;
import entities.*;

public class MainGameLoop {
	public static void main(String[] args) {
		DisplayManager.createDisplay();
		Loader loader = new Loader();
		StaticShader shader = new StaticShader();
		Renderer renderer = new Renderer(shader);

		RawModel model = OBJLoader.loadOBJ("stall", loader);
		
		TexturedModel staticModel = new TexturedModel(model, new ModelTexture(loader.loadTexture("stallTexture")));
		
		Entity entity = new Entity(staticModel, new Vector3f(0, 0, -25), 0, 180, 0, 1);
		
		Camera camera = new Camera();
		
		while(!Display.isCloseRequested()){
			camera.move();
			renderer.prepare();
			shader.start();
			shader.loadViewMatrix(camera);
			renderer.render(entity,shader);
			shader.stop();
			DisplayManager.updateDisplay();
		}

		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
}