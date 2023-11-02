package threads.wait_notify_example;

public class Notifier implements Runnable {

	private Message msg;

	public Notifier(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name+" started");
		try {
			Thread.sleep(3000);
			synchronized (msg) {
				msg.setMsg("test message 1");
				System.out.println("message populated. calling notify...");
				msg.notify();
				// msg.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

