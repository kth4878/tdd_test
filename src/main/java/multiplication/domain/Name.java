package multiplication.domain;

import java.util.Objects;

public class Name {
	private static final String NULL_ERROR_MESSAGE = "null은 입력할수 없습니다.";
	private static final String LENGTH_ERROR_MESSAGE = "이름은 1이상 5이하 길이만 입력할수 있습니다.";
	private static final String EMPTY_ERROR_MESSAGE = "공백은 입력할수 없습니다.";
	private static final String LANGUAGE_ERROR_MESSAGE = "이름은 영어만 입력가능합니다.";
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 5;
	private final String name;

	public Name(String name) {
		checkNameNull(name);
		checkNameLength(name);
		checkNameEmpty(name);
		checkNameEnglish(name);

		this.name = name;
	}

	private void checkNameNull(String name) {
		if (name == null) {
			throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
		}
	}

	private void checkNameLength(String name) {
		if (name.length() < MIN_NUMBER && name.length() > MAX_NUMBER) {
			throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
		}
	}

	private void checkNameEmpty(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
		}
	}

	private void checkNameEnglish(String name) {
		boolean english = !name.matches("^[a-zA-Z]*$");
		if (english) {
			throw new IllegalArgumentException(LANGUAGE_ERROR_MESSAGE);
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name name1 = (Name)o;
		return Objects.equals(name, name1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
