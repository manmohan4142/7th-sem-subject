public class OddEven{

	int counter = 1;

	public void Odd()
	{
		synchronized (this)
		{
			
			while (counter < 20) {

				while (counter % 2 == 0) {

					try {
						wait();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print(counter + " ");

				counter++;
				notify();
			}
		}
	}

	// Function to print even numbers
	public void Even()
	{
		synchronized (this)
		{
			while (counter < 20) {

				while (counter % 2 != 0) {

					try {
						wait();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				System.out.print(counter + " ");

				counter++;
				notify();
			}
		}
	}

	// Driver Code
	public static void main(String[] args)
	{

				OddEven obj= new OddEven();

		// Create thread t1
		 Thread t1 = new Thread(new Runnable() {
			public void run()
			{
				Obj. Odd();
			}
		});

		// Create thread t2
		Thread t2 = new Thread(new Runnable() {
			public void run()
			{
				Obj. Even();
			}
		});

		// Start both threads
		t1.start();
		t2.start();
	}
}