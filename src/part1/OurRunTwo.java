package part1;

public class OurRunTwo extends Thread{
	@Override
	public void run(){
		System.out.println("Thread started");
		System.out.println("Thread do same work");
		System.out.println("Thread finished");
	}

}
