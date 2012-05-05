import Fsm.Action;
import Fsm.Transition;
import action.Action_impl;

/**
 * All Transitions
 *
 */
public class Transitions {
	
    Events events = new Events();
	States states = new States();
	Action ac = new Action_impl();
	
	/**
	 * connection establishing
	 */
	Transition closed_to_listen = new Transition(states.closed, events.passive_e, states.listen, ac);       
	Transition closed_to_syn_sent = new Transition(states.closed, events.active_e, states.syn_sent, ac);		
	Transition listen_to_syn_rcvd = new Transition(states.listen, events.syn_e, states.syn_rcvd, ac);		
	Transition syn_sent_to_established = new Transition(states.syn_sent, events.synAck_e, states.established, ac);		
	Transition syn_rcvd_to_established = new Transition(states.syn_rcvd, events.ack_e, states.established, ac);
	Transition listen_to_closed = new Transition(states.listen, events.close_e, states.closed, ac);
	Transition syn_sent_to_closed = new Transition(states.syn_sent, events.close_e, states.closed, ac);
	Transition syn_sent_to_syn_rcvd = new Transition(states.syn_sent, events.syn_e, states.syn_rcvd, ac);
	Transition syn_rvcd_to_fin_wait_1 = new Transition(states.syn_rcvd, events.close_e, states.fin_wait_1, ac);
	
	/**
	 * Data sending and reading
	 */
	Transition  established_to_established_s= new Transition(states.established, events.sData_e, states.established, ac);
	Transition  established_to_established_r= new Transition(states.established, events.rData_e, states.established, ac);
	
	/**
	 * Closing
	 */
	Transition established_to_fin_wait_1 = new Transition(states.established, events.close_e, states.fin_wait_1, ac);
	Transition established_to_close_wait = new Transition(states.established, events.fin_e, states.close_wait, ac);
	Transition fin_wait_1_to_fin_wait_2 = new Transition(states.fin_wait_1, events.ack_e, states.fin_wait_2, ac);		
	Transition fin_wait_2_to_timewait = new Transition(states.fin_wait_2, events.fin_e, states.time_wait, ac);
	Transition close_wait_to_last_ack = new Transition(states.close_wait, events.close_e, states.last_ack, ac);
	Transition last_ack_to_closed = new Transition(states.last_ack, events.ack_e, states.closed, ac);
	Transition time_wait_to_closed = new Transition(states.time_wait, events.timeout_e, states.closed, ac);
	Transition fin_wait_1_to_closing = new Transition(states.fin_wait_1, events.fin_e, states.closing, ac);
	Transition closing_to_time_wait = new Transition(states.closing, events.ack_e, states.time_wait, ac);

}
