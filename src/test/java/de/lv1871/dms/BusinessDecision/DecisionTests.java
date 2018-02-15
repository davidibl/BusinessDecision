package de.lv1871.dms.BusinessDecision;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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

	// Das Spiel beginnt
	@Test
	@Deployment(resources = { "decision.dmn" })
	public void testFRV() {
		String result = null;
		assertEquals("FRV_OLD", result);
	}

	// Oha!
	@Test
	@Deployment(resources = { "decision.dmn" })
	public void testSBU20() {
		DokumentDecisionVariablesAccessor variables = DokumentDecisionVariablesAccessor.create().withTarif("SBU")
				.withVersion(Version._20);

		String result = getResult(variables);
		assertEquals("SBU_NEW", result);
		fail();
	}

	// Eine neue Version (21) kommt dazu. SBU soll ab einschl. Version 20 immer
	// SBU_NEW als result haben. Erweitert die Entscheidungstabelle
	// entsprechend.
	// Eine Zeile zu ändern sollte hierbei genügen.
	@Test
	@Deployment(resources = { "decision.dmn" })
	public void testSBUGroeßer20ImmerSBU_NEW() {
		DokumentDecisionVariablesAccessor variables = DokumentDecisionVariablesAccessor.create().withTarif("SBU")
				.withVersion(Version._20);

		String result = getResult(variables);
		assertEquals("SBU_NEW", result);
		fail();
		// DokumentDecisionVariablesAccessor variables2 =
		// DokumentDecisionVariablesAccessor.create().withTarif("SBU")
		// .withVersion(Version._21);

		// String result2 = getResult(variables2);
		// assertEquals("SBU_NEW", result2);

	}

	// Eine neue Anforderung! Die Dokumentenmatrix soll um ein Kriterium
	// "Klasse"
	// erweitert werden. Die Klasse hat drei Ausprägungen A, AA, AAA. Legt einen
	// entsprechenden Enum an und erweitert alles dahingehend dass die Klasse
	// AAA
	// bei SBU Version kleiner 20 immer SBU_PREMIUM als result liefert. Die
	// Klasse
	// wird als zusätzlicher Requestparameter übergeben. Der Parameter ist
	// Optional.
	@Test
	@Deployment(resources = { "decision.dmn" })
	public void testSBUPremiumBeiKlasseAAA() {
		// assertEquals(Klasse.AAA, result);
	}

	// Die Klasse soll als weitere Entscheidung abgebildet werden, da sie sich
	// aus
	// dem Beitrag ergibt. Diese Entscheidung muss entsprechend in einer eigenen
	// Tabelle abgebildet werden.
	// Erweitert das DMN daingehend dass die Dokumentenentscheidung auf einer
	// Klassenentscheidungstabelle basiert. In der zweiten Entscheidungstabelle
	// gelten folgende Regeln für den Beitrag:
	// < 100 = A
	// 101 und 102 = AAA
	// > 102 < 500 = AA
	// > 500 AAA
	@Test
	@Deployment(resources = { "decision.dmn" })
	public void testSBUPremiumBeiBeitrag102() {
		fail();
	}

	// Eine Ressource um die Klasse anhand des Beitrags abzurufen existiert
	// bereits.
	// Implementiert dies. Und testet die Entscheidungstabelle einzeln.
	@Test
	@Deployment(resources = { "decision.dmn" })
	public void testKlasseAAABeiBeitrag102() {

		// assertEquals(Klasse.AAA, result);
		fail();
	}

	// Ein weiterer Parameter wird hinzugefügt. Dieser Parameter gibt an ob es
	// sich
	// um einen Jahresbeitrag oder einen Monatsbeitrag beim übergebenen Beitrag
	// handelt. Bildet das entsprechend in der Kalssenentscheidung ab. Wie kann
	// das
	// optimal gelöst werden?
	@Test
	@Deployment(resources = { "decision.dmn" })
	public void testKlasseAAABeiMonatsBeitrag200() {

		// assertEquals(Klasse.AAA, result);
		fail();
	}

	// Schafft weitere Decision Tables, die als Input nur ein Komplexes Objekt
	// bekommen. Greift auf die entsprechenden Felder des Objektes mit der
	// eingebauten Expression Language zu um die Werte für die Entscheidung zu
	// bekommen.
	// Tip: Als Variablen kann einfach eine Hashmap übergeben werden. So muss
	// kein
	// neuer VariableAccessor übergeben werden.
	@Test
	@Deployment(resources = { "decision.dmn" })
	public void testSBUPremiumBeiBeitrag102ParameterIstEinKomplexesObjekt() {
		fail();
	}

}
