package pu.fmi.wordle.model;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary // Qualifier("hashMap")
//@Order(0)
@Component
public class GameRepoHashMap implements GameRepo {

	private ConcurrentHashMap<String, Game> games = new ConcurrentHashMap<>();

	@Override
	public Game get(String id) {
		// TODO Auto-generated method stub
		System.out.println("------ I was in GameRepo! ------");
		return games.get(id);
	}

	@Override
	public void save(Game game) {
		// TODO Auto-generated method stub
		games.put(game.getId(), game);
	}

	@Override
	public void update(Game game) {
		// TODO Auto-generated method stub
		save(game);
	}

	@Override
	public Game delete(String id) {
		// TODO Auto-generated method stub
		return games.remove(id);
	}
	// TODO end
}