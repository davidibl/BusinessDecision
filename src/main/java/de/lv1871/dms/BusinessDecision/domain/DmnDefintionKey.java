package de.lv1871.dms.BusinessDecision.domain;

public enum DmnDefintionKey {

	DOKUMENT_DECISION("dokumentDecision");

	private final String key;

	private DmnDefintionKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
