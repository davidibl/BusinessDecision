package de.lv1871.dms.BusinessDecision.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.lv1871.dms.BusinessDecision.domain.Version;
import de.lv1871.dms.BusinessDecision.service.DokumentDecisionService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/dokumente")
public class DokumentDecisionResource {

	@Autowired
	private DokumentDecisionService decisionService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 406, message = "Data Not Acceptable"),
			@ApiResponse(code = 403, message = "Not Authorized") })
	public String getDokumente(@RequestParam("tarif") String tarif, @RequestParam("version") Version version) {
		return decisionService.getDokumenteByVersion(tarif, version);
	}

}
