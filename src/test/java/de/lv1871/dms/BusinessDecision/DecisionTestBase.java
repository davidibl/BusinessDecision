package de.lv1871.dms.BusinessDecision;

import java.io.InputStream;

import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.test.DmnEngineRule;
import org.junit.Before;
import org.junit.Rule;

import de.lv1871.dms.BusinessDecision.domain.DmnDefintionKey;
import de.lv1871.dms.BusinessDecision.domain.DokumentDecisionVariablesAccessor;

public class DecisionTestBase {

	private String decisionName;
	private DmnDefintionKey key;

	public DecisionTestBase(String decisionName, DmnDefintionKey key) {
		this.decisionName = decisionName;
		this.key = key;
	}

	@Rule
	public DmnEngineRule dmnEngineRule = new DmnEngineRule();
	DmnDecision decision;

	@Before
	public void setup() {
		DmnEngine dmnEngine = dmnEngineRule.getDmnEngine();
		InputStream stream = this.getClass().getResourceAsStream("/" + decisionName);
		decision = dmnEngine.parseDecision(key.getKey(), stream);
	}

	<T> T getResult(DokumentDecisionVariablesAccessor variables) {
		return dmnEngineRule.getDmnEngine().evaluateDecision(decision, variables.toMap()).getSingleEntry();
	}
}
