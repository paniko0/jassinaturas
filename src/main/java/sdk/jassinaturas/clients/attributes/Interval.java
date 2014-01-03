package sdk.jassinaturas.clients.attributes;

public class Interval {
	private Unit unit;
	private int length;
	
	public Interval withUnit(Unit unit) {
		this.unit = unit;
		return this;
	}
	
	public Interval withLength(int length) {
		this.length = length;
		return this;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
