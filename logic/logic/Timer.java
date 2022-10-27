package logic;

import controller.Controller;

public class Timer extends Thread{	
	private Controller controller;
	private int elapsedSeconds, elapsedMinutes;
	private boolean update;
	
	public Timer(Controller controller) {
		this.controller = controller;
	}	
	
	@Override
	public void run() {
		update = true;
		long start = System.currentTimeMillis();
		long elapsedTime;
		
		while(update) {
			elapsedTime = (System.currentTimeMillis() - start) / 1000;
			
			elapsedSeconds = (int)(elapsedTime % 60);
			elapsedMinutes = (int)(elapsedTime / 60);
			controller.update_timer(elapsedMinutes, elapsedSeconds);
			
			try{
				Thread.sleep(1000 - (elapsedTime % 1000));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void set_update(boolean update) {
		this.update = update;
	}
	
	public int[] get_time() {
		return new int[] {elapsedMinutes, elapsedSeconds};
	}
}
