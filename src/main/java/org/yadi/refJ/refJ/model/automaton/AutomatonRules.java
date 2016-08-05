package org.yadi.refJ.model.automaton;

import org.yadi.refJ.exceptions.*;
import org.yadi.refJ.test.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class AutomatonRules {
	
	/**
	 * Change the Current State of the given Automaton to a newer depending on the given word<br/>
	 * <i>Current == null     => use the starter State<br/>
	 * Current == EMPTY_STATE => stay on the EMPTY_STATE<br/>
	 * Current == Others      => go to the equivalent State</i>
	 * 
	 * @param automaton
	 * @param word
	 * @throws NotTheSameInstanceException
	 * @throws EmptyException
	 * @throws NullObjectsInTheArrayException
	 */
	public static void goToNextState(Automaton automaton, Object word) throws NotTheSameInstanceException, EmptyException, NullObjectsInTheArrayException{
		
		if(NullTestsUtils.isNull(automaton.getCurrentState())){
			goToNextStateFromStarterState(automaton, word);
		} else if(EqualTestsUtils.areEqual(automaton.getCurrentState(), State.EMPTY_STATE)){
			goToEmptyState(automaton);
		} else {
			goToNextStateFromCurrentState(automaton, word);
		}
	}

	/**
	 * Change the Current State of the Automaton from Starter State to a newer depending on the word given
	 * 
	 * @param automaton
	 * @param word
	 */
	public static void goToNextStateFromStarterState(Automaton automaton, Object word){
		
		State next = automaton.getStarterState().getNexts().get(word);
		automaton.setCurrentState(next);
	}

	/**
	 * Change the Current State of the Automaton from Current State to a newer depending on the word given
	 * 
	 * @param automaton
	 * @param word
	 */
	public static void goToNextStateFromCurrentState(Automaton automaton, Object word){
		
		State next = automaton.getCurrentState().getNexts().get(word);
		automaton.setCurrentState(next);
	}

	/**
	 * Change the Current State of the Automaton to the EMPTY STATE
	 * 
	 * @param automaton
	 */
	public static void goToEmptyState(Automaton automaton) {
		
		automaton.setCurrentState(State.EMPTY_STATE);
	}
}
