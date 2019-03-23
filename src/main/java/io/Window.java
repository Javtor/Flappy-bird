package io;

import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwGetKey;
import static org.lwjgl.glfw.GLFW.glfwGetMouseButton;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

import org.lwjgl.glfw.GLFWVidMode;

public class Window {

	private int width, height;
	private String title;
	private long window;

	public Window(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;
	}

	public void create() {
		if (!glfwInit()) {
			System.err.println("Error: Couldn't initialize GLFW");
			System.exit(-1);
		}

		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
		
		window = glfwCreateWindow(width, height, title, 0, 0);

		if (window == 0) {
			System.err.println("Error: Window couldn't be created");
			System.exit(-1);
		}
		
		GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, (videoMode.width() - width) / 2, (videoMode.height() - height) / 2);

		glfwMakeContextCurrent(window);
		
		glfwShowWindow(window);
	}
	
	public boolean isClosed() {
		return glfwWindowShouldClose(window);
	}
	
	public void update() {
		glfwPollEvents();
	}
	
	public void swapBuffers() {
		
		glfwSwapBuffers(window);
	}
	
	public boolean isKeyDown(int keyCode) {
		return glfwGetKey(window, keyCode) == GLFW_PRESS;
	}
	
	public boolean isMouseDown(int mouseButton) {
		return glfwGetMouseButton(window, mouseButton) == GLFW_PRESS;
	}

}
