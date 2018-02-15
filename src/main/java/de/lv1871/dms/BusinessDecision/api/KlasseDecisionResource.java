package de.lv1871.dms.BusinessDecision.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.lv1871.dms.BusinessDecision.domain.Klasse;
import de.lv1871.dms.BusinessDecision.service.KlasseDecisionService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/klasse")
public class KlasseDecisionResource {

	@Autowired
	private KlasseDecisionService klasseService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal ServerError"),
			@ApiResponse(code = 406, message = "Data Not Acceptable"),
			@ApiResponse(code = 403, message = "Not Authorized") })
	public Klasse getDokumente(@RequestParam(value = "beitrag", required = false) Double beitrag,
			@RequestParam(value = "jahresbeitrag", required = false) Double jahresbeitrag) {
		return klasseService.getKlasseByBeitrag(beitrag, jahresbeitrag);

	}

}
