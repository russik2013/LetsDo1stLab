package part1;

import part1.*;

import java.util.Scanner;
import java.util.concurrent.*;


public class Start {
public static void main(String args[]){
	// Первый способ создания потока
	Thread thread = new Thread(new OurRun());
	thread.start();
	//Второй способ создания потока
	OurRunTwo threadTwo = new OurRunTwo();
	threadTwo.start();
	//Создание потоков с помощью исполнителя
	// 1) создание отдельных потоков для каждой поступающей задачи
	//используя newCachedThreadPool()
	ExecutorService service = Executors.newCachedThreadPool();
	
	service.execute(new OurRun());
	//2)создание исполнителя с пулом потоков фиксированного количества,
	//используя newFixedThreadPool(N)
	ExecutorService serviceTwo = Executors.newFixedThreadPool(2);
	for(int i = 0; i < 6; i++){
		System.out.println(i);
		serviceTwo.execute(new OurRun());
		
	}
	//Третий способ запуска потока, позволяющий также вернуть какое- то 
	//значение после завершения потока.
	ExecutorService serviceThree = Executors.newCachedThreadPool();
	Future fut = service.submit(new OurCallMethod());
	try {
	   System.out.println("Returned value: " + fut.get());
	}
	catch(InterruptedException ex) {
	   ex.printStackTrace();
	}
	catch(ExecutionException ex) {
	   ex.printStackTrace();
	}
    // Часто возникает необходимость временно приостановить выполнение потока, переведя его в режим ожидания.
	// Для этого используется метод sleep().

	//В данном примере в потоке работает бесконечный цикл, а в основном потоке при вводе чего-то в консоль вызывается
	// метод interrupt().
	Thread TaskThread = new Thread(new OurTask());
	TaskThread.start();
	try
	{
		for (int i = 0; i < 5; i++)
		{
			System.out.println("MAIN thread: " + i);
			TimeUnit.SECONDS.sleep(1);
		}
	} catch (InterruptedException ex) {
		ex.printStackTrace(); }
	// Следует отметить, что, находясь в режиме ожидания, поток может выбросить исключение InterruptedException,
	// которое необходимо обработать

	Thread TaskTwoThread = new Thread(new OurTaskTwo("task"));
	TaskTwoThread.start();
	Scanner scanner = new Scanner(System.in);
	scanner.next();
	thread.interrupt();

}
}
