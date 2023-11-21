package ma.yc.api.controller.AdminCentre;

import ma.yc.api.dto.AgentCaisseDto;
import ma.yc.api.services.AuthentificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin-centre/agents-caisse")
public class AgentCaisseManagementController {


    private AuthentificationService<AgentCaisseDto> authentificationService ;

    public AgentCaisseManagementController(@Qualifier("AgentCaisseAuthentificationServiceImpl") AuthentificationService<AgentCaisseDto> authentificationService) {
        this.authentificationService = authentificationService;
    }

    @PostMapping
    public AgentCaisseDto createAgentCaisse(@RequestBody @Validated AgentCaisseDto agentCaisseDto){
        return this.authentificationService.register(agentCaisseDto);
    }


}
