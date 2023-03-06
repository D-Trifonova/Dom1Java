package pu.fmi.wordle.model;

public interface GameRepo { // CRUD i ThreadSafe
	Game get(String id); // Read

	void save(Game game);

	void update(Game game);

	Game delete(String id);
	// TODO end
}