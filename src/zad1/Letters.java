package zad1;

import java.util.ArrayList;
import java.util.List;

public class Letters extends Thread {
	private static boolean isFinished = false;
	private String name;
	private List<Thread> threads;

	public Letters(String name) {
		this.name = name;
		threads = new ArrayList<Thread>();
		initThreads(name);

	}

	public List<Thread> getThreads() {
		return threads;
	}

	private void initThreads(String name) {
		for (int i = 0; i < name.length(); i++) {
			String temp = "Thread " + name.substring(i, i + 1);
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					try {
					while (!isFinished) {
						System.out.print(temp.replace("Thread", "").trim());
							Thread.sleep(1000);

						}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
			}, temp);
			threads.add(t);
		}
	}

	public static boolean isFinished() {
		return isFinished;
	}

	public static void setFinished(boolean isFinished) {
		Letters.isFinished = isFinished;
	}
}
