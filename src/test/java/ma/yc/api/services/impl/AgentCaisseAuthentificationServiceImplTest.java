package ma.yc.api.services.impl;

import ma.yc.api.dto.AgentCaisseDto;
import ma.yc.api.entity.AgentCaisse;
import ma.yc.api.repository.AgentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgentCaisseAuthentificationServiceImplTest {



    @Mock
    AgentRepository agentRepository;


    AgentCaisseDto agentCaisseDto;
    AgentCaisse agentCaisse;


    @BeforeEach
    void setUp() {
        agentCaisseDto = new AgentCaisseDto();
        agentCaisseDto.setEmail("email@example.com");
        agentCaisseDto.setNom("nom");
        agentCaisseDto.setPrenom("prenom");
        agentCaisseDto.setPassword("password");
        agentCaisseDto.setTelephone("+212600000000");


        agentCaisse = new AgentCaisse();
        agentCaisse.setEmail("email@example.com");
        agentCaisse.setNom("nom");
        agentCaisse.setPrenom("prenom");
        agentCaisse.setPassword("password");
        agentCaisse.setTelephone("+212600000000");

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void logout() {
        assertNotNull(this.agentCaisseDto.getPassword());
    }

    @Test
    void register() {
        // : 21/11/2023 mock the repository and test the register method
        when(agentRepository.save(this.agentCaisse)).thenReturn(agentCaisse);

        assertEquals(agentCaisse,agentRepository.save(agentCaisse));
        verify(agentRepository).save(agentCaisse);

        assertEquals(agentCaisseDto.getEmail(),agentCaisse.getEmail());
        assertEquals(agentCaisseDto.getNom(),agentCaisse.getNom());
        assertEquals(agentCaisseDto.getPrenom(),agentCaisse.getPrenom());
        assertEquals(agentCaisseDto.getPassword(),agentCaisse.getPassword());
        assertEquals(agentCaisseDto.getTelephone(),agentCaisse.getTelephone());


    }

    @Test
    void login() {
    }
}