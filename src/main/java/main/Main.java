package main;

import io.Window;

public class Main implements Runnable{
	
	private int width = 1280;
	private int height = 720;	
	private String title = "Flappy";
	
	private boolean running = false;
	private Thread thread;
	private long window;

	public void start() {
		
	}
		
	public static void main(String[] args) {
		Window window = new Window(1280, 720, "Flappy");
		window.create();
		
		while(!window.isClosed()) {
			window.update();
			System.out.println("asd");
			window.swapBuffers();
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}

}
