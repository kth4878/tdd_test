package multiplication;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import multiplication.domain.Name;

public class NameTest {

	@Test
	@DisplayName("구구단 실행자 이름생성")
	public void createName() {
		Name name = new Name("aaa");
		assertThat(name).isEqualTo(new Name("aaa"));
	}

	@Test
	@DisplayName("영문이름 검증")
	public void checkNameEnglish() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Name name = new Name("한글");

			fail("영문이 아닌 이름은 에러가 발생해야 한다.");
		});
	}

	@Test
	@DisplayName("이름 길이 검증")
	public void checkNameLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Name name = new Name("abcdef");

			fail("이름 길이 에러가 발생해야 한다.");
		});
	}

}
