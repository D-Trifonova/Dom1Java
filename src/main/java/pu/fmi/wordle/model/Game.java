package pu.fmi.wordle.model;

import java.time.LocalDateTime;
import java.util.List;

public class Game {
	String id;
	String word;
	LocalDateTime startedOn;

	/* String originalWord; */

	/*
	 * int maxTries = 6; List<Try> tries;
	 */
	int maxGuesses = 6; // 6 ili 7 s testa
	List<Guess> guesses;
	/*
	 * List<Guess> guesses = new List<Guess>() {
	 * 
	 * @Override public <T> T[] toArray(T[] a) { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public Object[] toArray() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public List<Guess> subList(int fromIndex, int toIndex) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public int size() { // TODO Auto-generated method stub return 0; }
	 * 
	 * @Override public Guess set(int index, Guess element) { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public boolean retainAll(Collection<?> c) { // TODO Auto-generated
	 * method stub return false; }
	 * 
	 * @Override public boolean removeAll(Collection<?> c) { // TODO Auto-generated
	 * method stub return false; }
	 * 
	 * @Override public Guess remove(int index) { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public boolean remove(Object o) { // TODO Auto-generated method
	 * stub return false; }
	 * 
	 * @Override public ListIterator<Guess> listIterator(int index) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public ListIterator<Guess> listIterator() { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public int lastIndexOf(Object o) { // TODO Auto-generated method
	 * stub return 0; }
	 * 
	 * @Override public Iterator<Guess> iterator() { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * @Override public boolean isEmpty() { // TODO Auto-generated method stub
	 * return false; }
	 * 
	 * @Override public int indexOf(Object o) { // TODO Auto-generated method stub
	 * return 0; }
	 * 
	 * @Override public Guess get(int index) { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public boolean containsAll(Collection<?> c) { // TODO
	 * Auto-generated method stub return false; }
	 * 
	 * @Override public boolean contains(Object o) { // TODO Auto-generated method
	 * stub return false; }
	 * 
	 * @Override public void clear() { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public boolean addAll(int index, Collection<? extends Guess> c) {
	 * // TODO Auto-generated method stub return false; }
	 * 
	 * @Override public boolean addAll(Collection<? extends Guess> c) { // TODO
	 * Auto-generated method stub return false; }
	 * 
	 * @Override public void add(int index, Guess element) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 * 
	 * @Override public boolean add(Guess e) { // TODO Auto-generated method stub
	 * return false; } };
	 */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public LocalDateTime getStartedOn() {
		return startedOn;
	}

	public void setStartedOn(LocalDateTime startedOn) {
		this.startedOn = startedOn;
	}

	public int getMaxGuesses() {
		return maxGuesses;
	}

	public void setMaxGuesses(int maxGuesses) {
		this.maxGuesses = maxGuesses;
	}

	public List<Guess> getGuesses() {
		return guesses;
	}

	public void setGuesses(List<Guess> guesses) {
		this.guesses = guesses;
	}
	// TODO end
}