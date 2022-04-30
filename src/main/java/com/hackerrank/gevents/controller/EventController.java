package com.hackerrank.gevents.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.gevents.model.Event;
import com.hackerrank.gevents.service.EventService;

@RestController
public class EventController {

	@Autowired
	private EventService eventService;
	
  @PostMapping(value = "/events")
  public ResponseEntity<Event> createEvent(@RequestBody Event event) {
    return new ResponseEntity<Event>(eventService.createEvent(event), HttpStatus.CREATED) ;
  }
  
  @GetMapping(value = "/events")
  public ResponseEntity<List<Event>> getEvents() {
	  return new ResponseEntity<List<Event>>(eventService.getEvents(), HttpStatus.OK);
  }
  
  @GetMapping(value = "/repos/{repoId}/events")
  public ResponseEntity<List<Event>> getEventsByRepoId(@PathVariable Integer repoId) {
	  return new ResponseEntity<List<Event>>(eventService.getEventsByRepoId(repoId), HttpStatus.OK);
  }
  
  @GetMapping(value = "/events/{id}")
  public ResponseEntity<Event> getEventById(@PathVariable Integer id) {
	  final Event event = eventService.getEventById(id);
	  if(event != null) {
		  return new ResponseEntity<Event>(event, HttpStatus.OK);
	  } else {
		  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
  }
}
