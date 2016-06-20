package clock;

public class Clock extends Thread{
	int seconds;
	int minutes;
	int hours;
	private TimePanel[] panels;
	
	public Clock(int seconds, int minutes, int hours) throws IllegalArgumentException{
		if(seconds > 59 || seconds < 0 || minutes > 59 || minutes < 0 || hours > 23 || hours < 0){
			throw new IllegalArgumentException("Invalid time arguments.");
		}
		this.seconds = seconds;
		this.minutes = minutes;
		this.hours = hours;
	}
	
	public void run(){
		while(true){
			secondElapsed();
			printTime();
		}
	}
	public void printTime(){
		System.out.println(this.toString());
	}
	
	public String toString(){
		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}
	private void secondElapsed(){
		if(seconds < 59){
			seconds++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else{
			minuteElapsed();
			seconds = 0;
		}
		refreshSeconds();
	}
	private void minuteElapsed(){
		if(minutes < 59){
			minutes++;
		}
		else{
			hourElapsed();
			minutes = 0;
		}
		refreshMinutes();
	}
	private void hourElapsed(){
		if(hours < 23){
			hours++;
		}
		else{
			hours = 0;
		}
		refreshHours();
	}
	private void refreshHours(){
		panels[0].actualizeTime(getHours());
	}
	private void refreshMinutes(){
		panels[1].actualizeTime(getMinutes());
	}
	private void refreshSeconds(){
		panels[2].actualizeTime(getSeconds());
	}
	public void setTimePanels(TimePanel hours, TimePanel minutes, TimePanel seconds){
		panels = new TimePanel[3];
		panels[0] = hours;
		panels[1] = minutes;
		panels[2] = seconds;
	}
	public int getSeconds() {
		return seconds;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getHours() {
		return hours;
	}	
}
