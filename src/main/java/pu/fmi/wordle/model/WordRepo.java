package pu.fmi.wordle.model;

import java.util.Collection;

public interface WordRepo { // Link k1m Gist
	Collection<String> list();

	String getRandom();

	boolean exists(String word);
	// TODO end
}