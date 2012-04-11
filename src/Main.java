import action.*;
import event.*;
import state.*;
import Fsm.Action;
import Fsm.Event;
import Fsm.FSM;
import Fsm.State;
import Fsm.Transition;

 

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		State listen = new Listen("listen state");	
		State syn_sent = new Syn_Sent("Syn sent");
		FSM fsm = new FSM("finate state machine", listen);
			
		Event e = new Passive("PASSIVE");

		Action ac = new Action_();
		//ac.execute(fsm, e);
		Transition t = new Transition(listen, e, syn_sent, ac);
		
		fsm.addTransition(t);
		
		fsm.doEvent(e);
		
		
	 
	  }

}