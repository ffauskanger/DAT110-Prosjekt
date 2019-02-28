package no.hvl.dat110.messages;

public class CreateTopicMsg extends Message {
	
	// TODO: 
	// Implement objectvariables, constructor, get/set-methods, and toString method
	
	private String topic;
	
	/**
	 * Konstrukt�r med topic
	 * 
	 * @param topic
	 */
	
	public CreateTopicMsg(String user,String topic)
	{
		super(MessageType.CREATETOPIC, user);
		this.topic = topic;
	}
	
	
	
	public String getTopic()
	{
		return this.topic;
	}
	
	public void setTopic(String topic)
	{
		this.topic = topic;
	}
	
	
	@Override
	public String toString()
	{
		return "createTopic [topic=" + this.topic + " user=" + getUser() + "]";
	}
	
}
