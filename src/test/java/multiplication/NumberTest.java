package multiplication;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import multiplication.calculator.Calculation;
import multiplication.domain.Number;

public class NumberTest {

	public static final String TYPE_ERROR_MESSAGE = "숫자만 입력 가능합니다.";

	@Test
	@DisplayName("구구단 숫자 생성")
	public void createNumber() {
		Number number = new Number(2);
		assertThat(number).isEqualTo(new Number(2));
	}

	@Test
	@DisplayName("아라비아 숫자 검증")
	public void checkNumberType() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			checkInputNumberType("5a");

			fail("숫자 에러가 발생해야한다.");
		});
	}

	private void checkInputNumberType(String number) {
		boolean checkNumber = !Pattern.matches("^[0-9]*$", number);
		if (checkNumber) {
			throw new IllegalArgumentException(TYPE_ERROR_MESSAGE);
		}
	}

}
