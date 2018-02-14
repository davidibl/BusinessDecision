package de.lv1871.dms.BusinessDecision;

import static org.junit.Assert.assertEquals;

import org.camunda.bpm.engine.test.Deployment;
import org.junit.Test;

import de.lv1871.dms.BusinessDecision.domain.DmnDefintionKey;
import de.lv1871.dms.BusinessDecision.domain.DokumentDecisionVariablesAccessor;
import de.lv1871.dms.BusinessDecision.domain.Version;

public class DecisionTests extends DecisionTestBase {

	public DecisionTests() {
		super("decision.dmn", DmnDefintionKey.DOKUMENT_DECISION);
	}

	@Test
	@Deployment(resources = { "decision.dmn" })
	public void testSBU() {
		DokumentDecisionVariablesAccessor variables = DokumentDecisionVariablesAccessor.create().withTarif("SBU")
				.withVersion(null);

		String result = getResult(variables);
		assertEquals("SBU_STD", result);
	}

	@Test
	@Deployment(resources = { "decision.dmn" })
	public void testSBU20() {
		DokumentDecisionVariablesAccessor variables = DokumentDecisionVariablesAccessor.create().withTarif("SBU")
				.withVersion(Version._20);

		String result = getResult(variables);
		assertEquals("SBU_NEW", result);
	}

	@Test
	@Deployment(resources = { "decision.dmn" })
	public void testRFV() {

	}

}
