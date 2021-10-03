package multiplication.view;

import multiplication.domain.Name;
import multiplication.domain.Number;
import multiplication.domain.MultipliesRange;

public class ResultView {
	public static final String MULTIPLY_RESULT = "실행결과";

	public static void resultMultiplies(Number number, MultipliesRange multipliesRange) {
		System.out.println(MULTIPLY_RESULT);
		for (int i = 0; i < multipliesRange.findSize(); i++) {
			System.out.println(number.getNumber() + " * " + (i + 1) + " = " + multipliesRange.findNumber(i).getNumber());
		}
	}

	public static void resultPlayerAct(Name name, Number number){
		System.out.println(name.getName() + "가 " + number.getNumber() + "단을 실행 했습니다.");
	}
}
