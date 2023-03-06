package pu.fmi.wordle.logic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import pu.fmi.wordle.model.Game;
import pu.fmi.wordle.model.GameRepo;
import pu.fmi.wordle.model.Guess;
import pu.fmi.wordle.model.WordRepo;

@Component // V1 SpringBean
public class GameServiceImpl implements GameService {

	private static final String GREEN_BACKGROUND = "\u001B[42m";
	private static final String YELLOW_BACKGROUND = "\u001B[43m";
	private static final String COLOR_RESET = "\u001B[0m";

	// @Autowired // V1; Reflection final option. Izbqgvai
	final GameRepo gameRepo;

	final WordRepo wordRepo;

	public GameServiceImpl(GameRepo gameRepo, WordRepo wordRepo) {
		this.gameRepo = gameRepo;
		this.wordRepo = wordRepo;
	}

//	public GameRepo getGameRepo() {
//		return gameRepo;
//	}
//
//	@Autowired // V2
//	public void setGameRepo(GameRepo gameRepo) {
//		this.gameRepo = gameRepo;
//
//	}

	@PostConstruct // sled konstroiraneto dava signal
	public void init() {
		System.out.println("------ I was here! ------"); // syso;
		// var gameRepo = new GameRepoHashMap(); // Old way
		// gameRepo.get(null); // = Err
		wordRepo.list().stream().forEach(System.out::println);
	}

	@Override
	public Game startNewGame() {
		// TODO Auto-generated method stub
		var game = new Game(); // var vmesto Game zaradi konstruktora: Game game = new Game();

//		var gameId = UUID.randomUUID().toString();
//		game.setId(gameId);

		game.setId(UUID.randomUUID().toString());
		game.setStartedOn(LocalDateTime.now());
		game.setWord(wordRepo.getRandom());
		game.setGuesses(new ArrayList<>(game.getMaxGuesses()));
		return game;
	}

	@Override
	public Game getGame(String id) {

		var game = gameRepo.get(id);

		if (game == null) {
			throw new GameNotFoundException("Game not found!" + id);
		}
		return game;
	}

	@Override
	public Game makeTry(String id, String word) {
		// TODO Auto-generated method stub: Implement here!
		if (!wordRepo.exists(word)) {
			throw new UnknownWordException("Word is not valid." + word);
		}

		var game = getGame(id);

		var guess = new Guess();
		guess.setWord(word);
		guess.setMadeAt(LocalDateTime.now());
		var matches = new char[game.getWord().length()];

		for (int i = 0; i < word.length(); i++) {

			var letter = word.charAt(i);
			var index = game.getWord().indexOf(letter);
			if (index == i) {
				matches[i] = Guess.PLACE_MATCH;
				System.out.println(GREEN_BACKGROUND + matches[i] + COLOR_RESET);
			} else if (index >= 0) {
				matches[i] = Guess.LETTER_MATCH;
				System.out.println(YELLOW_BACKGROUND + matches[i] + COLOR_RESET);
			} else {
				matches[i] = Guess.NO_MATCH;
				System.err.println(matches[i]);
			}
		}

		guess.setMatches(new String(matches));

		game.getGuesses().add(guess);

		if (guess.getMatches().equals(String.valueOf(Guess.PLACE_MATCH).repeat(matches.length))) {
			game.setStartedOn(LocalDateTime.now());
		}
		
		gameRepo.save(game);

		return game;
	}
	// TODO end
}
