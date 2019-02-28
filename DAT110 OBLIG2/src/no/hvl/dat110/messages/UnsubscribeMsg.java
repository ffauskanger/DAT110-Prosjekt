package no.hvl.dat110.messages;

public class UnsubscribeMsg extends Message {

	// TODO: 
	// Implement objectvariables, constructor, get/set-methods, and toString method
private String message;

	public UnsubscribeMsg(String user, String message)
	{
		super(MessageType.UNSUBSCRIBE, user);
		this.message = message;
	}

	
	public String getMessage()
	{
		return this.message;
	}
	
	public void setMessage(String topic)
	{
		this.message = topic;
	}
	
	
	@Override
	public String toString()
	{
		return "unSubscribeMsg [user=" + getUser() + "msg=" + this.message + "]";
	}
}
