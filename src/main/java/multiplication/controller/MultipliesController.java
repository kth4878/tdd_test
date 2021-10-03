package multiplication.controller;

import multiplication.domain.Name;
import multiplication.domain.Number;
import multiplication.domain.NumberRange;
import multiplication.domain.Range;
import multiplication.service.MultipliesService;
import multiplication.view.InputView;
import multiplication.view.ResultView;

public class MultipliesController {
	public void run() {
		Name name = new Name(InputView.inputName());
		Number number = new Number(InputView.inputNumber());
		NumberRange numberRange = new NumberRange(InputView.inputNumberRange());

		Range range = MultipliesService.multipliesRange(number, numberRange);

		ResultView.resultMultiplies(number, range);
		ResultView.resultPlayerAct(name, number);
	}
}
