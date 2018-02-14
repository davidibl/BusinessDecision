package de.lv1871.dms.BusinessDecision.service;

import java.util.Map;

import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.engine.DecisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.lv1871.dms.BusinessDecision.domain.DmnDefintionKey;
import de.lv1871.dms.BusinessDecision.domain.DokumentDecisionVariablesAccessor;
import de.lv1871.dms.BusinessDecision.domain.Version;

@Service
public class DokumentDecisionService {

	@Autowired
	private DecisionService decisionService;

	public String getDokumenteByVersion(String tarif, Version version) {

		// @formatter:off
		Map<String, Object> variables = DokumentDecisionVariablesAccessor
			.create()
			.withVersion(version)
			.withTarif(tarif)
			.toMap();
		// @formatter:on

		DmnDecisionTableResult decisionTableResult = decisionService
				.evaluateDecisionTableByKey(DmnDefintionKey.DOKUMENT_DECISION.getKey(), variables);

		return decisionTableResult.getFirstResult().getFirstEntry();
	}

}
