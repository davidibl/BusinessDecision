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
		return new DokumentDecisionVariablesAccessor().withTarif(null).withVersion(null).withBeitrag(null)
				.withKlasse(null).withJahresbeitrag(null);
	}

	public DokumentDecisionVariablesAccessor withVersion(Version version) {
		setVersion(version);
		return this;
	}

	public DokumentDecisionVariablesAccessor withTarif(String tarif) {
		setTarif(tarif);
		return this;
	}

	public DokumentDecisionVariablesAccessor withKlasse(Klasse klasse) {
		setKlasse(klasse);
		return this;
	}

	public DokumentDecisionVariablesAccessor withBeitrag(Double beitrag) {
		setBeitrag(beitrag);
		return this;
	}

	public DokumentDecisionVariablesAccessor withJahresbeitrag(Double beitrag) {
		setJahresbeitrag(beitrag);
		return this;
	}

	private void setVersion(Version version) {
		variables.put(DecisionVariableName.VERSION.get(),
				Optional.ofNullable(version).map(Version::getVersion).orElse(null));
	}

	private void setTarif(String tarif) {
		variables.put(DecisionVariableName.TARIF.get(), tarif);
	}

	private void setKlasse(Klasse klasse) {
		variables.put(DecisionVariableName.KLASSE.get(), klasse);
	}

	private void setBeitrag(Double beitrag) {
		variables.put(DecisionVariableName.BEITRAG.get(), beitrag);
	}

	private void setJahresbeitrag(Double beitrag) {
		variables.put(DecisionVariableName.JAHRESBEITRAG.get(), beitrag);
	}
}
