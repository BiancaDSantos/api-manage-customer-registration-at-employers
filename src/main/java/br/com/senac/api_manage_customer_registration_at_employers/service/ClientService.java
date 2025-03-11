package br.com.senac.api_manage_customer_registration_at_employers.service;

import br.com.senac.api_manage_customer_registration_at_employers.dto.ClientRepresentatioDTO;
import br.com.senac.api_manage_customer_registration_at_employers.exception.ClientRequestException;
import br.com.senac.api_manage_customer_registration_at_employers.model.Client;
import br.com.senac.api_manage_customer_registration_at_employers.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ClientService {

    private ClientRepository clientRepository;

    public Client searchbyId(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientRequestException("Cliente não encontrado."));
    }

    public List<Client> searchAll() {
        return clientRepository.findAll();
    }

    public Client register(ClientRepresentatioDTO.Create representation) {
        Client client = representation.createregistration();
        return clientRepository.save(client);
    }

    public Client update(Long id, ClientRepresentatioDTO.Update representation) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new ClientRequestException("Cliente não encontrado."));
        return clientRepository.save(existingClient);
    }

    public void exclude(Long id) {
        clientRepository.deleteById(id);
    }
}
