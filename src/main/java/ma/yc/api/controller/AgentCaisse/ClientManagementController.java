package ma.yc.api.controller.AgentCaisse;


import ma.yc.api.dto.ClientDto;
import ma.yc.api.services.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/agenets-caisse/clients")
public class ClientManagementController {
    private ClientService clientService;
    public ClientManagementController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ClientDto ajouterClient(@RequestBody ClientDto clientDto , @RequestHeader("Authorization") String token){
        // TODO: 21/11/2023 verify token then create client when security is available
        // : 21/11/2023 ajouter client
        return this.clientService.ajouterClient(clientDto);
    }
}
