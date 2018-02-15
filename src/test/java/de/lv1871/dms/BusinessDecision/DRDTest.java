package de.lv1871.dms.BusinessDecision;

import static org.junit.Assert.assertEquals;

import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.spring.boot.starter.test.helper.AbstractProcessEngineRuleTest;
import org.junit.Test;

import de.lv1871.dms.BusinessDecision.domain.DmnDefintionKey;
import de.lv1871.dms.BusinessDecision.domain.DokumentDecisionVariablesAccessor;
import de.lv1871.dms.BusinessDecision.domain.Klasse;
import de.lv1871.dms.BusinessDecision.domain.Version;

public class DRDTest extends AbstractProcessEngineRuleTest {

	@Test
	@Deployment(resources = { "decision.dmn" })
	public void testSBUPremiumBeiKlasseAAA() {
		// @formatter:off
			DokumentDecisionVariablesAccessor variables =
				DokumentDecisionVariablesAccessor
					.create()
					.withTarif("SBU")
					.withVersion(Version._16)
					.withKlasse(Klasse.AAA);
			// @formatter:on

		String result = getResult(variables);
		assertEquals("SBU Premium", result);
	}

	@Test
	@Deployment(resources = { "decision.dmn" })
	public void testSBUPremiumBeiBeitrag602() {
		// @formatter:off
		DokumentDecisionVariablesAccessor variables =
			DokumentDecisionVariablesAccessor
				.create()
				.withTarif("SBU")
				.withVersion(Version._16)
				.withBeitrag(602.0);
		// @formatter:on

		String result = getResult(variables);
		assertEquals("SBU Premium", result);
	}

	@Test
	@Deployment(resources = { "decision.dmn" })
	public void testKlasseAAABeiBeitrag102() {
		// @formatter:off
		DokumentDecisionVariablesAccessor variables =
			DokumentDecisionVariablesAccessor
				.create()
				.withTarif("SBU")
				.withVersion(Version._16)
				.withBeitrag(101.55);
		// @formatter:on

		String result = getResult(variables);
		assertEquals("SBU Premium", result);
	}

	@Test
	@Deployment(resources = { "decision.dmn" })
	public void testKlasseAAABeiJahresbeitragBeitrag1200() {
		// @formatter:off
		DokumentDecisionVariablesAccessor variables =
			DokumentDecisionVariablesAccessor
				.create()
				.withTarif("SBU")
				.withVersion(Version._16)
				.withJahresbeitrag(1200.0);
		// @formatter:on

		String result = getResult(variables);
		assertEquals("SBU_STD", result);
	}

	private String getResult(DokumentDecisionVariablesAccessor variables) {
		return processEngine.getDecisionService()
				.evaluateDecisionTableByKey(DmnDefintionKey.DOKUMENT_DECISION.getKey(), variables.toMap())
				.getFirstResult().getFirstEntry();
	}
}
