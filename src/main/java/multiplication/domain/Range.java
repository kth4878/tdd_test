package multiplication.domain;

import java.util.Collections;
import java.util.List;

public class Range {
	private final List<Number> range;

	public Range(List<Number> range) {
		this.range = Collections.unmodifiableList(range);
	}

	public int findSize() {
		return this.range.size();
	}

	public Number findNumber(int number) {
		return this.range.get(number);
	}
}
