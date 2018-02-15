package de.lv1871.dms.BusinessDecision.service;

import java.util.Map;

import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.engine.DecisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.lv1871.dms.BusinessDecision.domain.DmnDefintionKey;
import de.lv1871.dms.BusinessDecision.domain.DokumentDecisionVariablesAccessor;
import de.lv1871.dms.BusinessDecision.domain.Klasse;

@Service
public class KlasseDecisionService {

	@Autowired
	private DecisionService decisionService;

	public Klasse getKlasseByBeitrag(Double beitrag, Double jahresbeitrag) {

		// @formatter:off
		Map<String, Object> variables = DokumentDecisionVariablesAccessor
			.create()
			.withBeitrag(beitrag)
			.withJahresbeitrag(jahresbeitrag)
			.toMap();
		// @formatter:off
		
		DmnDecisionTableResult decisionTableResult = decisionService
				.evaluateDecisionTableByKey(DmnDefintionKey.KLASSE_DECISION.getKey(), variables);

		return Klasse.valueOf(decisionTableResult.getFirstResult().getFirstEntry());
	}

}
