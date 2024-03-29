package action;

import state.Established;
import event.RData_e;
import event.SData_e;
import Fsm.*;

public class Action_ extends Action{

	@Override
	public void execute(FSM fsm, Event event) {
		
		State currentState = fsm.currentState(); 
		System.out.println(event + "received, current State is "+ currentState);
		
		if (event.getClass().equals(RData_e.class))
		{	
			Established state = (Established) fsm.currentState();
			state.num++;
			System.out.println("DATA received "+ state.num);
		}
		
		if (event.getClass().equals(SData_e.class))
		{
			System.out.println("DATA sent ");
		}
		

		
	}

}
