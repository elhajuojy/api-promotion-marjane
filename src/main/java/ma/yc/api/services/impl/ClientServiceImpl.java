package ma.yc.api.services.impl;

import ma.yc.api.dto.ClientRequestDto;
import ma.yc.api.exceptions.business.BadRequestExcpetion;
import ma.yc.api.mapper.ClientRequestMapper;
import ma.yc.api.repository.ClientRepository;
import ma.yc.api.services.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;
    private ClientRequestMapper clientRequestMapper;
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
        this.clientRequestMapper = ClientRequestMapper.INSTANCE;
    }

    @Override
    public ClientRequestDto ajouterClient(ClientRequestDto clientRequestDto) {
        // : 21/11/2023 ajouter client apres la validation du donnnées si email existe et si le client est deja existant
        clientRepository.findByEmail(clientRequestDto.getEmail()).orElseThrow(
                () -> new BadRequestExcpetion("Client already exist")
        );

        // : 21/11/2023 mapper clientRequestDto to client entity
        return clientRequestMapper.toDto(
                this.clientRepository.save(
                        clientRequestMapper.toEntity(clientRequestDto)
                )
        );
    }
}
