package no.hvl.dat110.messages;

public class PublishMsg extends Message {
	
	// TODO: 
	// Implement objectvariables, constructor, get/set-methods, and toString method
	private String message;
	private String topic;

	
	public PublishMsg(String user, String topic, String message)
	{
		super(MessageType.PUBLISH, user);
		this.topic = topic;
		this.message = message;
	}
	
	public String getTopic()
	{
		return this.topic;
	}
	
	public void setTopic(String topic)
	{
		this.topic = topic;
	}
	
	
	
	public String getMessage()
	{
		return this.message;
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	
	@Override
	public String toString()
	{
		return "publishMsg [topic=" + this.topic + " user=" + getUser() + " msg=" + this.message + "]";
	}
}
