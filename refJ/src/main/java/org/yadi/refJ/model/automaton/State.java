package org.yadi.refJ.model.automaton;

import java.util.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class State {
	
	public final static State EMPTY_STATE = new State("EMPTY_STATE");

	private String name;
	private Map<Object, State> nexts;
	
	public State() {
		this.nexts = new HashMap<Object, State>();
	}
	
	public State(String name){
		this.name = name;
		this.nexts = new HashMap<Object, State>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Object, State> getNexts() {
		return nexts;
	}

	public void setNexts(Map<Object, State> nexts) {
		this.nexts = nexts;
	}
}
