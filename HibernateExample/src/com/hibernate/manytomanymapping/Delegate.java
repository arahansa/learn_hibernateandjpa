package com.hibernate.manytomanymapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Delegate {

	private int delegated;
	private String delegateName;
	
	private List<Event> events = new ArrayList<Event>();

	@Id
	@GeneratedValue
	public int getDelegated() {
		return delegated;
	}

	public void setDelegated(int delegated) {
		this.delegated = delegated;
	}

	public String getDelegateName() {
		return delegateName;
	}

	public void setDelegateName(String delegateName) {
		this.delegateName = delegateName;
	}

	@ManyToMany
	@JoinTable(name="JOIN_DELEGATE_EVENT", 
	joinColumns={@JoinColumn(name="delegateId")}, 
	inverseJoinColumns={@JoinColumn(name="eventId")})
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	
	
}
