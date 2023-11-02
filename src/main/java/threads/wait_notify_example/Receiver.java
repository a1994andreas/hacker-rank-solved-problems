package threads.wait_notify_example;

public class Receiver implements Runnable{

	private Message msg;

	public Receiver(Message m){
		this.msg=m;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name+" started");
		synchronized (msg) {
			try{
				if (msg.getMsg() == null) {
					System.out.println(name+" message is empty waiting..");
					msg.wait();
				}
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("The message is: " + msg.getMsg());
		}
	}
}
