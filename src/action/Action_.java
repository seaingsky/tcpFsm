package action;

import event.RData_e;
import event.SData_e;
import Fsm.*;

public class Action_ extends Action{

	@Override
	public void execute(FSM fsm, Event event) {
		State s = fsm.currentState();
		
		System.out.println(event + "received, current State is "+s);
		
		if (event.getClass().equals(RData_e.class))
		{
			System.out.println("DATA received nnn");
		}
		
		if (event.getClass().equals(SData_e.class))
		{
			System.out.println("DATA sent nnn");
		}
		
		if (event.getName().equals("bad")){
			System.err.println("Error: unexpected Event: "+event.getName());
		}
		
		
		//throw undefined event for current state exception
		
	}

}
