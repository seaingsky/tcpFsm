package action;

import state.Established;
import event.RData_e;
import event.SData_e;
import Fsm.*;

/**
 * Action to take when a transition happens
 *
 */
public class Action_impl extends Action{

	@Override
	public void execute(FSM fsm, Event event) {
		
		State currentState = fsm.currentState(); 
		System.out.println(event + "received, current State is "+ currentState);
		
		/**
		 * Counting the number of SDATA or RDATA Events received to date
		 */
		if (event.getClass().equals(RData_e.class))
		{	
			Established state = (Established) currentState;
			state.num++;
			System.out.println("DATA received "+ state.num);
		}
		
		if (event.getClass().equals(SData_e.class))
		{	
			Established state = (Established) currentState;
			state.num++;
			System.out.println("DATA sent "+ state.num);
		}
	
	}

}
