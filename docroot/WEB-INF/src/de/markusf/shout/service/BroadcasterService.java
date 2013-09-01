package de.markusf.shout.service;

public interface BroadcasterService {
	void subscribe(Object id);
	void broadcast(Object id, Object o);
}
