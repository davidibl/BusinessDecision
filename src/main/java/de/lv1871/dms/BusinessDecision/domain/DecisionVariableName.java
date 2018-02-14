package de.lv1871.dms.BusinessDecision.domain;

public enum DecisionVariableName {

	VERSION("version"), TARIF("tarif");

	private final String name;

	private DecisionVariableName(String name) {
		this.name = name;
	}

	public String get() {
		return this.name;
	}
}
