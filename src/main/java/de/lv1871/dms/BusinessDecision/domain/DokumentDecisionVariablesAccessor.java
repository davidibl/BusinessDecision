package de.lv1871.dms.BusinessDecision.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DokumentDecisionVariablesAccessor {

	private Map<String, Object> variables = new HashMap<>();

	public Map<String, Object> toMap() {
		return this.variables;
	}

	public static DokumentDecisionVariablesAccessor create() {
		return new DokumentDecisionVariablesAccessor();
	}

	public DokumentDecisionVariablesAccessor withVersion(Version version) {
		this.setVersion(version);
		return this;
	}

	public DokumentDecisionVariablesAccessor withTarif(String tarif) {
		this.setTarif(tarif);
		return this;
	}

	private void setVersion(Version version) {
		this.variables.put(DecisionVariableName.VERSION.get(),
				Optional.ofNullable(version).map(Version::getVersion).orElse(null));
	}

	private void setTarif(String tarif) {
		this.variables.put(DecisionVariableName.TARIF.get(), tarif);
	}
}
