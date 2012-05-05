import java.io.BufferedReader;
import java.io.InputStreamReader;

import Fsm.Event;
import Fsm.FSM;
import Fsm.FsmException;

/**
 * Entry point class
 *
 */
public class Main {
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("TCP Finite State Machine Simulation Begins: ");
		
		States states = new States();
		FSM fsm = new FSM("finate state machine", states.closed);
		System.out.println("Start state: "+ fsm.currentState());
		
		Events events = new Events();
		Transitions transitions = new Transitions();
		
		fsm.addTransition(transitions.closed_to_listen);
		fsm.addTransition(transitions.listen_to_syn_rcvd);
		fsm.addTransition(transitions.syn_rcvd_to_established);
		fsm.addTransition(transitions.closed_to_syn_sent);
		fsm.addTransition(transitions.syn_sent_to_established);
		fsm.addTransition(transitions.listen_to_closed);
		fsm.addTransition(transitions.syn_sent_to_closed);
		fsm.addTransition(transitions.syn_sent_to_syn_rcvd);
		fsm.addTransition(transitions.syn_rvcd_to_fin_wait_1);
		fsm.addTransition(transitions.established_to_established_s);
		fsm.addTransition(transitions.established_to_established_r);
		fsm.addTransition(transitions.established_to_fin_wait_1);
		fsm.addTransition(transitions.established_to_close_wait);
		fsm.addTransition(transitions.fin_wait_1_to_fin_wait_2);
		fsm.addTransition(transitions.fin_wait_2_to_timewait);
		fsm.addTransition(transitions.close_wait_to_last_ack);
		fsm.addTransition(transitions.last_ack_to_closed);
		fsm.addTransition(transitions.time_wait_to_closed);
		fsm.addTransition(transitions.fin_wait_1_to_closing);
		fsm.addTransition(transitions.closing_to_time_wait);
		
		/**
		 * Get user input
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("please input the EVENT for next state: ");		
		String input = reader.readLine();
		
		/**
		 * LOOP TILL THE USER ENTER "END" TO STOP
		 */
		while (!input.equals("END")){
			
			Event event = events.get(input);
			if (event != null){
				// Undefined Transition exception
				try{				
					fsm.doEvent(event);
				} 
				catch(FsmException e){
					System.err.println(e.toString());
				}				
			}	
			//Undefined Event Error			
			else {				
				System.err.println("Error: unexpected Event:" + input);
			}
			
			System.out.println("please input the EVENT for next state: ");	
			input = reader.readLine();
		}
		
		System.out.println("Bye!");	
		

	  }

}