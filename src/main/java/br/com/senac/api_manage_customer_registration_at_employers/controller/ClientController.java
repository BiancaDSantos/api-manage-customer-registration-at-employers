package br.com.senac.api_manage_customer_registration_at_employers.controller;

import br.com.senac.api_manage_customer_registration_at_employers.dto.ClientRepresentationDTO;
import br.com.senac.api_manage_customer_registration_at_employers.dto.request.ClientCreateRequest;
import br.com.senac.api_manage_customer_registration_at_employers.dto.request.ClientUpdateRequest;
import br.com.senac.api_manage_customer_registration_at_employers.dto.response.ClientResponse;
import br.com.senac.api_manage_customer_registration_at_employers.model.Client;
import br.com.senac.api_manage_customer_registration_at_employers.service.ClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> searchOne(@PathVariable Long id) {
        return ResponseEntity.ok(ClientResponse.fromEntity(clientService.searchbyId(id)));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ClientResponse>> searchAll() {
        return ResponseEntity.ok(clientService.searchAll());
    }

    @PostMapping("/criar")
    public ResponseEntity<ClientResponse> register(
            @Valid @RequestBody ClientCreateRequest representation
    ) {
        Client registeredClient = clientService.register(representation);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registeredClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody ClientUpdateRequest representation
    ) {
        return ResponseEntity
                .ok(clientService.update(id, representation));
    }

    @DeleteMapping("/{id}")
    public void excludeclient (@PathVariable Long id) {
        clientService.exclude(id);
    }

}
