import state.*;
import Fsm.State;

/**
 * All States
 *
 */
public class States {
	
	State closed = new Closed("Closed");		
	State listen = new Listen("Listen");	
	State syn_sent = new Syn_Sent("Syn sent");
	State syn_rcvd = new Syn_Rcvd("Syn received");		
	State established = new Established("Establised");
	State fin_wait_1 = new Fin_Wait_1("Fin wait 1");
	State fin_wait_2 = new Fin_Wait_2("Fin wait 2");
	State close_wait = new Close_Wait("Close Wait");
	State last_ack = new Last_Ack("Last Ack");
	State closing = new Closing("Closing");
	State time_wait = new Time_Wait("Time Wait");
	
	
}
