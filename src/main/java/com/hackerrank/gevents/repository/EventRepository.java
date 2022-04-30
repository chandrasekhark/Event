package com.hackerrank.gevents.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackerrank.gevents.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

	List<Event> findByRepoId(Integer repoId);
}
