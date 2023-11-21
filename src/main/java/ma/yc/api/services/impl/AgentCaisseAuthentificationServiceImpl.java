package ma.yc.api.services.impl;

import ma.yc.api.dto.AgentCaisseDto;
import ma.yc.api.entity.AgentCaisse;
import ma.yc.api.exceptions.business.BadRequestExcpetion;
import ma.yc.api.mapper.AgentCaisseMapper;
import ma.yc.api.repository.AgentRepository;
import ma.yc.api.services.AuthentificationService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service("AgentCaisseAuthentificationServiceImpl")
public class AgentCaisseAuthentificationServiceImpl implements AuthentificationService<AgentCaisseDto> {


    AgentRepository agentRepository;
    AgentCaisseMapper agentCaisseMapper;

    public AgentCaisseAuthentificationServiceImpl(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
        this.agentCaisseMapper = AgentCaisseMapper.INSTANCE;
    }

    @Override
    public boolean logout() {
        // TODO: 21/11/2023  logout
        return false;
    }

    @Override
    public AgentCaisseDto register(AgentCaisseDto agentCaisseDto) {
        AgentCaisse agentCaisse = this.agentRepository.save(this.agentCaisseMapper.toEntity(agentCaisseDto));
        return this.agentCaisseMapper.toDto(agentCaisse) ;
    }

    @Override
    public AgentCaisseDto login(AgentCaisseDto agentCaisseDto) {
        // : 21/11/2023 ajouter un agent de caisse
        Optional<AgentCaisse> agentCaisse =  this.agentRepository.findByEmail(agentCaisseDto.getEmail());
        agentCaisse.orElseThrow(
                () -> new BadRequestExcpetion("Agent de caisse not found")
        );

        // TODO: 21/11/2023 verify password return token when security is available
        if(agentCaisse.get().getPassword().equals(agentCaisseDto.getPassword())){

            return this.agentCaisseMapper.toDto(agentCaisse.get());
        }
        throw new BadRequestExcpetion("Password is incorrect");


    }
}
