package part1;

import java.util.concurrent.Callable;


public class OurCallMethod implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int val = 123;
		return val;
	}

}
