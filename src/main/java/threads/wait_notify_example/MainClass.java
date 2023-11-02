package threads.wait_notify_example;

public class MainClass {

	/*
	* In this example wait is called on message from receiver thread
	* then notifier thread sleeps for 3 seconds and then populated the
	* message and calls notify
	* So receiver is printing the message
	* Source: https://www.digitalocean.com/community/tutorials/java-thread-wait-notify-and-notifyall-example
	 */
	public static void main(String[] args) {
		Message message = new Message();

		Notifier notifier = new Notifier(message);
		Receiver receiver = new Receiver(message);

		new Thread(notifier, "notifier").start();
		new Thread(receiver,"receiver").start();

	}
}
