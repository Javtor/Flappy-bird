package main;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import io.Input;
import util.ShaderUtils;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.io.IOException;

public class Main implements Runnable {

	private int width = 800;
	private int height = 600;
	private String title = "Flappy";

	private boolean running = false;
	private Thread thread;

	private long window;

	public void start() {
		running = true;
		thread = new Thread(this, "Game");
		thread.start();
	}

	public static void main(String[] args) {
		new Main().start();
	}

	public void run() {
		
	
		init();
		while (running) {
			update();
			render();

			if (glfwWindowShouldClose(window))
				running = false;
		}

	}

	private void init() {
		if (!glfwInit()) {
			System.err.println("Error: Couldn't initialize GLFW");
			System.exit(-1);
		}

//		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
//		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
//		glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
//		if(System.getProperty("os.name").contains("Mac")) {
//			glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
//			glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
//		}
//		glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);
//		glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
		window = glfwCreateWindow(width, height, title, NULL, NULL);

		GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		if (window == NULL) {
			System.err.println("Error: Window couldn't be created");
			System.exit(-1);
		}
		glfwSetWindowPos(window, (vidMode.width() - width) / 2, (vidMode.height() - height) / 2);
		glfwSetKeyCallback(window, new Input());

		glfwMakeContextCurrent(window);
		glfwShowWindow(window);

		GL.createCapabilities();
		glClearColor(1f, 1f, 1f, 1f);
		glEnable(GL_DEPTH_TEST);
		System.out.println("Opengl: "+glGetString(GL_VERSION));
		
	}

	private void render() {
		glClear(GL_COLOR_BUFFER_BIT);
		glfwSwapBuffers(window);

	}

	private void update() {
		glfwPollEvents();
		if (Input.keys[GLFW_KEY_SPACE])
			System.out.println("flap");
	}

}
