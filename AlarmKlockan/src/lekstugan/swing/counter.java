package lekstugan.swing;

public class counter {
	
	private int second;

	public void time() throws InterruptedException {
		int currentTime = (int) System.currentTimeMillis();
		Thread.sleep(1000);
		int endTime = (int) System.currentTimeMillis();
		second = second + ((endTime - currentTime) / 1000);
		
	}
	
	public String toString() {
		return String.format("%02d", second); 
	}
}
