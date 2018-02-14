package de.lv1871.dms.BusinessDecision.domain;

public enum Version {
	_18(18), _16(16), _20(20);

	private final Integer version;

	private Version(Integer version) {
		this.version = version;
	}

	public Integer getVersion() {
		return version;
	}

}
