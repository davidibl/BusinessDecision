package de.lv1871.dms.BusinessDecision;

import static org.junit.Assert.assertEquals;

import org.camunda.bpm.engine.test.Deployment;
import org.junit.Test;

import de.lv1871.dms.BusinessDecision.domain.DmnDefintionKey;
import de.lv1871.dms.BusinessDecision.domain.DokumentDecisionVariablesAccessor;
import de.lv1871.dms.BusinessDecision.domain.Version;

public class DecisionTest extends DecisionTestBase {

	public DecisionTest() {
		super("decision.dmn", DmnDefintionKey.DOKUMENT_DECISION);
	}

	@Test
	@Deployment(resources = { "decision.dmn" })
	public void testSBU() {
		// @formatter:off
		DokumentDecisionVariablesAccessor variables =
			DokumentDecisionVariablesAccessor
				.create()
				.withTarif("SBU");
		// @formatter:off
		
		String result = getResult(variables);
		assertEquals("SBU_STD", result);
	}

	@Test
	@Deployment(resources = { "decision.dmn" })
	public void testFRV() {
		// @formatter:off
		DokumentDecisionVariablesAccessor variables =
			DokumentDecisionVariablesAccessor
				.create()
				.withTarif("FRV")
				.withVersion(Version._16);
		// @formatter:off
		
		String result = getResult(variables);
		assertEquals("FRV_OLD", result);
	}

	@Test
	@Deployment(resources = { "decision.dmn" })
	public void testSBU20() {
		// @formatter:off
		DokumentDecisionVariablesAccessor variables = 
			DokumentDecisionVariablesAccessor
				.create()
				.withTarif("SBU")
				.withVersion(Version._20);
		// @formatter:on

		String result = getResult(variables);
		assertEquals("SBU_NEW", result);
	}

	@Test
	@Deployment(resources = { "decision.dmn" })
	public void testSBUGroeßer20ImmerSBU_NEW() {
		// @formatter:off
		DokumentDecisionVariablesAccessor variables =
			DokumentDecisionVariablesAccessor
				.create()
				.withTarif("SBU")
				.withVersion(Version._20);
		// @formatter:on

		String result = getResult(variables);
		assertEquals("SBU_NEW", result);

		// @formatter:off
		DokumentDecisionVariablesAccessor variables2 =
			DokumentDecisionVariablesAccessor
				.create()
				.withTarif("SBU")
				.withVersion(Version._21);
		// @formatter:on

		String result2 = getResult(variables2);
		assertEquals("SBU_NEW", result2);

	}

}
