package com.hackerrank.gevents.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hackerrank.gevents.model.Event;

@Service
public interface EventService {
  public Event createEvent(Event event);
  
  public List<Event> getEvents();

  public List<Event> getEventsByRepoId(Integer repoId);
  
  public Event getEventById(Integer id);
} 