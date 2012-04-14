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
		
		System.out.println("TCP Finite State Machine Simulation Begins: ");
		System.out.println("");
		
		State listen = new Listen("listen state");	
		State syn_sent = new Syn_Sent("Syn sent");
		
		State established = new Established("Establised state");
		
		FSM fsm = new FSM("finate state machine", listen);
			
		Event e = new Passive_e("PASSIVE");
		Event rData = new RData_e("RDATA"); 
		Event sData = new SData_e("SDATA");
		

		Action ac = new Action_();
		//ac.execute(fsm, e);
		Transition t = new Transition(listen, e, syn_sent, ac);
		
		fsm.addTransition(t);
		System.out.println("current State is "+fsm.currentState());
		fsm.doEvent(e);
		
		Transition t2 = new Transition(syn_sent, rData, established, ac);
		fsm.addTransition(t2);
		System.out.println("current State is "+fsm.currentState());
		fsm.doEvent(rData);
		
		Transition t3 = new Transition(established, sData, established, ac);
		fsm.addTransition(t3);
		System.out.println("current State is "+fsm.currentState());
		fsm.doEvent(sData);
		//Transition t1 = new Transition();
		
	 
	  }

}