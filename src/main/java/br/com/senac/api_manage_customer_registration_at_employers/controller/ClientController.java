package br.com.senac.api_manage_customer_registration_at_employers.controller;

import br.com.senac.api_manage_customer_registration_at_employers.dto.ClientRepresentatioDTO;
import br.com.senac.api_manage_customer_registration_at_employers.model.Client;
import br.com.senac.api_manage_customer_registration_at_employers.service.ClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<Client> searchOne(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.searchbyId(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Client>> searchAll() {
        return ResponseEntity.ok(clientService.searchAll());
    }

    @PostMapping("/criar")
    public ResponseEntity<Client> register(
            @Valid @RequestBody ClientRepresentatioDTO.Create representation
    ) {
        Client registeredClient = clientService.register(representation);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registeredClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(
            @PathVariable Long id,
            @Valid @RequestBody ClientRepresentatioDTO.Update representation
    ) {

        return ResponseEntity
                .ok(clientService.update(id, representation));
    }

    @DeleteMapping("/{id}")
    public void excludeclient (@PathVariable Long id) {
        clientService.exclude(id);
    }

}
