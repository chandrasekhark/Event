package com.hackerrank.gevents.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.gevents.model.Event;
import com.hackerrank.gevents.repository.EventRepository;
import com.hackerrank.gevents.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;
	
	/**
	 * 
	 */
	@Override
	public Event createEvent(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public List<Event> getEvents() {
		return eventRepository.findAll();
	}

	@Override
	public List<Event> getEventsByRepoId(Integer repoId) {
		return eventRepository.findByRepoId(repoId);
	}

	@Override
	public Event getEventById(Integer id) {
		Optional<Event> event = eventRepository.findById(id);
		if(event.isPresent()) {
			return event.get();
		} else {
			return null;
		}
	}

	
}
