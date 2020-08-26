package topic_11_Threads;

import java.util.Scanner;

public class ThreadDemoRUNNABLE {
	
	// Sind nun ein Runnable Objekt
	public static class MyRunnable implements Runnable{


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
		
		MyRunnable t = new MyRunnable(); // Übergeben das Objekt 't' an das Thread Objekt		
		Thread threadObject = new Thread(t); // Unser Thread Objekt
		
		threadObject.start();
		
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Gib irgendetwas ein um das Programm zu beeenden");
			System.out.println(scan.next());
		}
	}
}
