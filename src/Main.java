import action.*;
import event.*;
import state.*;
import Fsm.Action;
import Fsm.Event;
import Fsm.FSM;
import Fsm.State;
import Fsm.Transition;

 //http://upload.wikimedia.org/wikipedia/en/f/f6/Tcp_state_diagram_fixed_new.svg
//http://www.tcpipguide.com/free/t_TCPOperationalOverviewandtheTCPFiniteStateMachineF-2.htm

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		State listen = new Listen("listen state");	
		State syn_sent = new Syn_Sent("Syn sent");
		FSM fsm = new FSM("finate state machine", listen);
			
		Event e = new Passive_e("PASSIVE");

		Action ac = new Action_();
		//ac.execute(fsm, e);
		Transition t = new Transition(listen, e, syn_sent, ac);
		
		fsm.addTransition(t);
		
		fsm.doEvent(e);
		
		
	 
	  }

}