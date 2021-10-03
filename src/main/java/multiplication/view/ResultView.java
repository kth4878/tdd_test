package multiplication.view;

import multiplication.domain.Name;
import multiplication.domain.Number;
import multiplication.domain.Range;

public class ResultView {
	public static final String MULTIPLY_RESULT = "실행결과";

	public static void resultMultiplies(Number number, Range range) {
		System.out.println(MULTIPLY_RESULT);
		for (int i = 0; i < range.findSize(); i++) {
			System.out.println(number.getNumber() + " * " + (i + 1) + " = " + range.findNumber(i).getNumber());
		}
	}

	public static void resultPlayerAct(Name name, Number number){
		System.out.println(name.getName() + "가 " + number.getNumber() + "단을 실행 했습니다.");
	}
}
