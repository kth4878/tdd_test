package multiplication.domain;

import java.util.Collections;
import java.util.List;

public class MultipliesRange {
	private final List<Number> multipliesRange;

	public MultipliesRange(List<Number> multipliesRange) {
		this.multipliesRange = Collections.unmodifiableList(multipliesRange);
	}

	public int findSize() {
		return this.multipliesRange.size();
	}

	public Number findNumber(int number) {
		return this.multipliesRange.get(number);
	}
}
