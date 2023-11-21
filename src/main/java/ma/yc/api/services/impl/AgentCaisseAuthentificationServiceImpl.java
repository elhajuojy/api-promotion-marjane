package ma.yc.api.services.impl;

import ma.yc.api.dto.AgentCaisseDto;
import ma.yc.api.services.AuthentificationService;
import org.springframework.stereotype.Service;


@Service("AgentCaisseAuthentificationServiceImpl")
public class AgentCaisseAuthentificationServiceImpl<AgentCaisseDto> implements AuthentificationService<AgentCaisseDto> {

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public AgentCaisseDto register(AgentCaisseDto agentCaisseDto) {
        return null;
    }

    @Override
    public AgentCaisseDto login(AgentCaisseDto agentCaisseDto) {
        return null;
    }
}
