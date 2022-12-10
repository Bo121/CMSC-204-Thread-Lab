import java.util.LinkedList;

public class CarQueue {

	private LinkedList<Integer> queue;
	
	public CarQueue() {
		queue = new LinkedList<Integer>();
		for (int i=0; i<1000; i++) {
			queue.add((int)(Math.random()*4));
		}
	}

	public void addToQueue() {
		class AddToQueueRunnable implements Runnable {
			public void run() {
				try {
					for (int i=0; i<5; i++) {
						queue.add((int)(Math.random()*4));
						Thread.sleep(1000);
					}
				} catch (InterruptedException exception) {
					
				}
			}
		}
		
		Runnable r = new AddToQueueRunnable();
		Thread t = new Thread(r);
		t.start();
	}

	public int deleteQueue() {
		if (!queue.isEmpty()) {
			return queue.remove();
		}
		return 0;
	}
}
