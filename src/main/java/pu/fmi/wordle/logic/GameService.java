package pu.fmi.wordle.logic;

import pu.fmi.wordle.model.Game;

public interface GameService { // CTRL+SHIFT+C i/ili CTRL+7

	Game startNewGame();

	Game makeTry(String id, String word);

	Game getGame(String id);
	// TODO end
}