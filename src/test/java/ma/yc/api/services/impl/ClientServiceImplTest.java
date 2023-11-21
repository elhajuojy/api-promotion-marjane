package ma.yc.api.services.impl;

import ma.yc.api.entity.Client;
import ma.yc.api.repository.ClientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    Client client;
    @Mock
    ClientRepository clientRepository;
    @BeforeEach
    void setUp() {
        client = new Client();
        client.setNom("nom");
        client.setPrenom("prenom");
        client.setTelephone("+212600000000");
        client.setEmail("email@gmail.com");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void ajouterClient() {
        assertNotNull(client);
        when(clientRepository.save(client)).thenReturn(client);

        assertEquals(client,clientRepository.save(client));


    }
}