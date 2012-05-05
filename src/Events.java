import Fsm.Event;
import event.*;

/**
 * All Events
 */
public class Events {
	public enum EventEnum {
	    PASSIVE, ACTIVE, SYN, SYNACK,
	    ACK, RDATA, SDATA, FIN, CLOSE, TIMEOUT
	}
		
	Event passive_e = new Passive_e(EventEnum.PASSIVE.toString());
	Event active_e = new Passive_e(EventEnum.ACTIVE.toString());
	Event syn_e = new Syn_e(EventEnum.SYN.toString());
	Event synAck_e = new SynAck_e(EventEnum.SYNACK.toString());
	Event ack_e= new Ack_e(EventEnum.ACK.toString());
	Event rData_e = new RData_e(EventEnum.RDATA.toString()); 
	Event sData_e = new SData_e(EventEnum.SDATA.toString());
	Event fin_e = new Fin_e(EventEnum.FIN.toString());
	Event close_e = new Close_e (EventEnum.CLOSE.toString());
	Event timeout_e = new Timeout_e(EventEnum.TIMEOUT.toString());
	
	/**
	 * Get the corresponding Event object based on user input
	 * @param event- input String from user input
	 * @return corresponding Event object or null if not valid
	 */
	public Event get(String event){
		
	if (event.equals(EventEnum.PASSIVE.toString()))
		return passive_e;
	else if (event.equals(EventEnum.ACTIVE.toString()))
		return active_e;
	else if (event.equals(EventEnum.SYN.toString()))
		return syn_e;
	else if (event.equals(EventEnum.SYNACK.toString()))
		return synAck_e;
	else if (event.equals(EventEnum.ACK.toString()))
		return ack_e;
	else if (event.equals(EventEnum.RDATA.toString()))
		return rData_e;
	else if (event.equals(EventEnum.SDATA.toString()))
		return sData_e;
	else if (event.equals(EventEnum.FIN.toString()))
		return fin_e;
	else if (event.equals(EventEnum.CLOSE.toString()))
		return close_e;
	else if(event.endsWith(EventEnum.TIMEOUT.toString()))
		return timeout_e;	
	else{		
		return null;
		}
	}
	

}
