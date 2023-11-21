package ma.yc.api.controller.AgentCaisse;


import ma.yc.api.dto.ClientRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/agenets-caisse/clients")
public class ClientManagementController {
    @PostMapping
    public ClientRequestDto createClient(@RequestBody ClientRequestDto clientDto , @RequestHeader("Authorization") String token){
        // TODO: 21/11/2023 create client
        return null;
    }
}
