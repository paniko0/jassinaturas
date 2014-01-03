package sdk.jassinaturas.clients.attributes;

public class Trial {
	private int days;
	private boolean enabled;
	
	public Trial withDays(int days) {
		this.days = days;
		return this;
	}
	
	public Trial enabled() {
		this.enabled = true;
		return this;
	}
	
	public Trial disabled() {
		this.enabled = false;
		return this;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
