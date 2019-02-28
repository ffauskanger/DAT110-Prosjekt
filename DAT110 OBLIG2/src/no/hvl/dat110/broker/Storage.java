package no.hvl.dat110.broker;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import no.hvl.dat110.common.Logger;
import no.hvl.dat110.messages.MessageType;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.messagetransport.Connection;

public class Storage {

	protected ConcurrentHashMap<String, Set<String>> subscriptions;
	protected ConcurrentHashMap<String, PublishMsg> messagebuf;
	protected ConcurrentHashMap<String, ClientSession> clients;
	protected ConcurrentHashMap<String, ClientSession> disconnectedclients;

	public Storage() {
		subscriptions = new ConcurrentHashMap<String, Set<String>>();
		clients = new ConcurrentHashMap<String, ClientSession>();
		disconnectedclients = new ConcurrentHashMap<String, ClientSession>();
		messagebuf = new ConcurrentHashMap<String, PublishMsg>();
	}

	public Collection<ClientSession> getSessions() {
		return clients.values();
	}

	public Set<String> getTopics() {

		return subscriptions.keySet();

	}
	
	public PublishMsg getMessageBuf(String user) {

		return messagebuf.get(user);

	}

	public ClientSession getSession(String user) {

		ClientSession session = clients.get(user);

		return session;
	}
	
	public ClientSession getDisconnectedSession(String user) {

		ClientSession session = disconnectedclients.get(user);

		return session;
	}

	public Set<String> getSubscribers(String topic) {

		return (subscriptions.get(topic));

	}

	public void addClientSession(String user, Connection connection) {

		// TODO: add corresponding client session to the storage
		if(disconnectedclients.contains(user))
		{
			System.out.println("Reconnected:" + user);
			clients.put(user, disconnectedclients.get(user));
			disconnectedclients.remove(user);
		}
		else {
			ClientSession clientsession = new ClientSession(user, connection);
			clients.put(user, clientsession);
			System.out.println("New:" + user);
		}

		
	}

	public void removeClientSession(String user) {

		// TODO: remove client session for user from the storage

		disconnectedclients.put(user, clients.get(user));
		clients.remove(user);
	}

	public void createTopic(String topic) {

		// TODO: create topic in the storage
		
		subscriptions.put(topic, new HashSet<String>());

	
	}

	public void deleteTopic(String topic) {

		// TODO: delete topic from the storage
		
		subscriptions.remove(topic);

		
	}

	public void addSubscriber(String user, String topic) {

		// TODO: add the user as subscriber to the topic

		subscriptions.get(topic).add(user);
		
		
	}

	public void removeSubscriber(String user, String topic) {

		// TODO: remove the user as subscriber to the topic
		
		subscriptions.get(topic).remove(user);
		
	}
}
