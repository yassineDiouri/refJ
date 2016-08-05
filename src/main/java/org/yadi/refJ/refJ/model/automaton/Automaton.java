package org.yadi.refJ.model.automaton;

import java.util.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class Automaton {

	private State starterState;
	private State currentState;
	private List<State> states;
	private List<State> finalStates;
	private Language language;

	public State getStarterState() {
		return starterState;
	}

	public void setStarterState(State starterState) {
		this.starterState = starterState;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public List<State> getFinalStates() {
		return finalStates;
	}

	public void setFinalStates(List<State> finalStates) {
		this.finalStates = finalStates;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
}
