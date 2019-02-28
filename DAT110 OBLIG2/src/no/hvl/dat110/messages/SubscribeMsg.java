package no.hvl.dat110.messages;

public class SubscribeMsg extends Message {

	// TODO: 
	// Implement objectvariables, constructor, get/set-methods, and toString method
	
	private String message;
	

	public SubscribeMsg(String user, String message)
	{
		super(MessageType.SUBSCRIBE, user);
		this.message = message;
	}
	
	
	
	public String getTopic()
	{
		return this.message;
	}
	
	public void setTopic(String topic)
	{
		this.message = topic;
	}
	
	
	@Override
	public String toString()
	{
		return "subscribeMsg [user=" + getUser() + "msg=" + this.message + "]";
	}
	
	
	
}
