package topic_11_Threads;

import java.util.Scanner;

public class ThreadDemoCLASS {
	
	public static class MyThread extends Thread{
		public MyThread(String name) {
			super(name);
			
// Wenn "true" kann dieser Thread nur dann laufen, wenn auch der "main" Thread läuft
			this.setDaemon(true); 
		}	
		public void run() {
			for (int i = 0; i < 100;i++) {
				System.out.println(i);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// Normal wake up
				}
			}		
		}
	}
	public static void main(String[] args) {
		MyThread thread = new MyThread("counter thread");
		thread.start();
		
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Gib irgendetwas ein um das Programm zu beeenden");
			System.out.println(scan.next());
		}
	}
}
