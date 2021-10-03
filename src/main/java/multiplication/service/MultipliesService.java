package multiplication.service;

import java.util.ArrayList;
import java.util.List;

import multiplication.calculator.Calculation;
import multiplication.domain.Number;
import multiplication.domain.NumberRange;
import multiplication.domain.MultipliesRange;

public class MultipliesService {
	public static final String MULTIPLIES = "*";

	public static MultipliesRange multipliesRange(Number number, NumberRange numberRange) {
		List<Number> numbers = new ArrayList<>();
		for(int i=1; i<=numberRange.getNumberRange(); i++){
			numbers.add(new Number(multiplies(number.getNumber(), i)));
		}
		return new MultipliesRange(numbers);
	}

	private static int multiplies(int number, int numberRange){
		return Calculation.calculateValue(MULTIPLIES, number, numberRange);
	}

}
