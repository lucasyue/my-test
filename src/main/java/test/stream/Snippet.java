package test.stream;

import java.util.stream.Stream;

public class Snippet {
	public static void main(String[] args) {
		// 使用Stream.forEach()迭代
		Stream<String> stream = Stream.of("I", "love", "you", "too");
		stream.forEach(str -> System.out.println(str));
	}
}
