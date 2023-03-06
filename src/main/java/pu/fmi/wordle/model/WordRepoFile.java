package pu.fmi.wordle.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.random.RandomGenerator;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component // V1
//@Repository // V2
public class WordRepoFile implements WordRepo {
	HashSet<String> words = new HashSet<>(); // V1 nadolu
	RandomGenerator randomGen = new Random();

	@PostConstruct
	public void popularWordsFromFile() {
		var in = Thread.currentThread().getContextClassLoader().getResourceAsStream("wordle-bg-words-list.csv"); // InputStream
		var reader = new InputStreamReader(in, StandardCharsets.UTF_8);
		var lineReader = new BufferedReader(reader);
		lineReader.lines().forEach(words::add); // Metod referenciq
	}

	@Override
	public Collection<String> list() {
		// TODO Auto-generated method stub
		return words;
	}

	@Override
	public String getRandom() {
		int pos = randomGen.nextInt(words.size());
		return words.stream().skip(pos - 1).findFirst().get();
	}

	@Override
	public boolean exists(String word) {
		return words.contains(word);
	}

//	private static final String FILE_NAME = "words.csv"; // V2
//	private Set<String> words;
//
//	@PostConstruct
//	public void populateWordsFromFile() throws IOException {
//		InputStream fileContent = Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_NAME);
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileContent, StandardCharsets.UTF_8));
//
////		words = new ConcurrentHashSet<>();
//
//		String nextLine = null;
//		while ((nextLine = bufferedReader.readLine()) != null)
//			System.out.println(nextLine);
//	}
//
//	public Collection<String> list() {
//		return words;
//	}
	// TODO end
}