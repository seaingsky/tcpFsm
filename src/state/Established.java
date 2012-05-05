package state;

import Fsm.*;

public class Established extends State{
	
	/**
	 * the number of SDATA or RDATA Events received to date
	 */
	public int num;
	public Established(String name) {
		super(name);
	}

}






