package br.com.senac.api_manage_customer_registration_at_employers.service;

import br.com.senac.api_manage_customer_registration_at_employers.dto.ClientRepresentationDTO;
import br.com.senac.api_manage_customer_registration_at_employers.dto.request.ClientCreateRequest;
import br.com.senac.api_manage_customer_registration_at_employers.dto.request.ClientUpdateRequest;
import br.com.senac.api_manage_customer_registration_at_employers.dto.response.ClientResponse;
import br.com.senac.api_manage_customer_registration_at_employers.exception.ClientRequestException;
import br.com.senac.api_manage_customer_registration_at_employers.model.Client;
import br.com.senac.api_manage_customer_registration_at_employers.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client searchbyId(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientRequestException("Cliente não encontrado."));
    }

    public List<Client> searchAll() {
        return clientRepository.findAll();
    }

    public Client register(ClientCreateRequest representation) {
        Client client = representation.toEntity();
        return clientRepository.save(client);
    }

    public ClientResponse update(Long id, ClientUpdateRequest request) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new ClientRequestException("Cliente não encontrado."));
        BeanUtils.copyProperties(request, existingClient);
        existingClient = clientRepository.save(existingClient);
        return ClientResponse.fromEntity(existingClient);
    }

    public void exclude(Long id) {
        clientRepository.deleteById(id);
    }
}
