package action;

import Fsm.Action;
import Fsm.Event;
import Fsm.FSM;
import Fsm.*;

public class Action_ extends Action{

	@Override
	public void execute(FSM fsm, Event event) {
		State s = fsm.currentState();
		
		System.out.println(event + "received, current State is "+s);
		
		
		
		//throw undefined event for current state exception
		
	}

}
