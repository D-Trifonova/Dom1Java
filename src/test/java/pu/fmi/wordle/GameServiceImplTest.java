package pu.fmi.wordle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pu.fmi.wordle.logic.GameServiceImpl;
import pu.fmi.wordle.model.Game;
import pu.fmi.wordle.model.GameRepo;
import pu.fmi.wordle.model.WordRepo;

@ExtendWith(MockitoExtension.class)
class GameServiceImplTest {

	@Mock
	GameRepo gameRepo;
	@Mock
	WordRepo wordRepo;
	@InjectMocks
	GameServiceImpl gameService;

	@Test
  void testStartNewGame() {
    when(wordRepo.getRandom()).thenReturn("мисля");

    var before = LocalDateTime.now();
    var game = gameService.startNewGame();
    assertThat(game.getId()).isNotNull();
    assertThat(game.getWord()).isEqualTo("мисля");
    assertThat(game.getGuesses()).isEmpty();
    assertThat(game.getStartedOn()).isAfter(before);
  }

	@Test
	void testMakeTry() {
		var game = new Game();
		game.setId("test");
		game.setWord("мисля");
		game.setGuesses(new ArrayList<>(game.getMaxGuesses()));
		when(gameRepo.get("test")).thenReturn(game);
		when(wordRepo.exists(anyString())).thenReturn(true);

		game = gameService.makeTry("test", "тегля");
		assertThat(game.getGuesses()).hasSize(1);
		var guess = game.getGuesses().get(0);
		assertThat(guess.getWord()).isEqualTo("тегля");
		assertThat(guess.getMatches()).isEqualTo("NNNPP");
//		System.out.println("Game id: \"" + game.getId() + "\"; get started on: \"" + game.getStartedOn()
//				+ "\"; get word -> \"" + guess.getWord() + "\" -> " + "get matches \"" + guess.getMatches()
//				+ "\"; made on: " + guess.getMadeOn());
		System.out.println("Get Started On: \"" + game.getStartedOn() + "\"; \"" + guess.getWord() + "\" -> \""
				+ guess.getMatches() + "\"; Made On: " + guess.getMadeOn());

		game = gameService.makeTry("test", "лягам");
		assertThat(game.getGuesses()).hasSize(2);
		guess = game.getGuesses().get(1);
		assertThat(guess.getWord()).isEqualTo("лягам");
		assertThat(guess.getMatches()).isEqualTo("LLNNL");
		System.out.println("Get Started On: \"" + game.getStartedOn() + "\"; \"" + guess.getWord() + "\" -> \""
				+ guess.getMatches() + "\"; Made On: " + guess.getMadeOn());

		game = gameService.makeTry("test", "мамин");
		assertThat(game.getGuesses()).hasSize(3);
		guess = game.getGuesses().get(2);
		assertThat(guess.getWord()).isEqualTo("мамин");
		assertThat(guess.getMatches()).isEqualTo("PNLLN");
		System.out.println("Get Started On: \"" + game.getStartedOn() + "\"; \"" + guess.getWord() + "\" -> \""
				+ guess.getMatches() + "\"; Made On: " + guess.getMadeOn());

		game = gameService.makeTry("test", "сусам");
		assertThat(game.getGuesses()).hasSize(4);
		guess = game.getGuesses().get(3);
		assertThat(guess.getWord()).isEqualTo("сусам");
		assertThat(guess.getMatches()).isEqualTo("LNPNL");
		System.out.println("Get Started On: \"" + game.getStartedOn() + "\"; \"" + guess.getWord() + "\" -> \""
				+ guess.getMatches() + "\"; Made On: " + guess.getMadeOn());

		game = gameService.makeTry("test", "мисля");
		assertThat(game.getGuesses().size()).isEqualTo(5);
		guess = game.getGuesses().get(4);
		assertThat(guess.getWord()).isEqualTo("мисля");
		assertThat(guess.getMatches()).isEqualTo("PPPPP");
//		System.out.println("Game id: \"" + game.getId() + "\"; Get Started On: \"" + game.getStartedOn()
//				+ "\"; Get Word -> \"" + guess.getWord() + "\" -> " + "Get Matches \"" + guess.getMatches()
//				+ "\"; Get Max Matches: " + game.getMaxGuesses() + "; Made On: " + guess.getMadeOn());
		System.out.println("Get Started On: \"" + game.getStartedOn() + "\"; \"" + guess.getWord() + "\" -> \""
				+ guess.getMatches() + "; Made On: " + guess.getMadeOn());
	}
	// TODO end
}