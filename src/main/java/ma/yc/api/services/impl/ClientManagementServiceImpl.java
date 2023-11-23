package ma.yc.api.services.impl;

import ma.yc.api.dto.ClientDto;
import ma.yc.api.entity.Client;
import ma.yc.api.entity.Fidelite;
import ma.yc.api.exceptions.business.BadRequestExcpetion;
import ma.yc.api.mapper.ClientRequestMapper;
import ma.yc.api.repository.ClientRepository;
import ma.yc.api.services.ClientService;
import ma.yc.api.services.EmailService;
import ma.yc.api.util.Utils;
import org.springframework.stereotype.Service;

@Service
public class ClientManagementServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final EmailService emailService;
    private final ClientRequestMapper clientRequestMapper;
    public ClientManagementServiceImpl(ClientRepository clientRepository, EmailService emailService) {
        this.clientRepository = clientRepository;
        this.clientRequestMapper = ClientRequestMapper.INSTANCE;
        this.emailService = emailService;
    }

    @Override
    public ClientDto ajouterClient(ClientDto clientDto) {
        // : 21/11/2023 ajouter client apres la validation du donnnées si email existe et si le client est deja existant
        clientRepository.findByEmail(clientDto.getEmail()).orElseThrow(
                () -> new BadRequestExcpetion("Client already exist")
        );

        Client client = clientRequestMapper.toEntity(clientDto);
        Fidelite fidelite = new Fidelite();
        fidelite.setCode(Utils.generateRandomNumber(10).toString());
        client.setFidelite(fidelite);
        fidelite.setClient(client);
//       :   Un client marjane recoit par email son code de carte fidélité avec l'historique de son achat
        this.emailService.sendSimpleMessage
                (client.getEmail(),
                        "Bienvenue chez Marjane",
                        "Votre code de carte fidelité est : <b>" + fidelite.getCode() + "</b>  Merci pour votre confiance "

                );

        // : 21/11/2023 mapper clientRequestDto to client entity
        return clientRequestMapper.toDto(
                this.clientRepository.save(
                        clientRequestMapper.toEntity(clientDto)
                )
        );
    }


}
