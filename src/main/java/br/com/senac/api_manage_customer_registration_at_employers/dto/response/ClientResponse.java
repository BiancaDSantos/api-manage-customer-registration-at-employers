package br.com.senac.api_manage_customer_registration_at_employers.dto.response;
import br.com.senac.api_manage_customer_registration_at_employers.model.Client;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
public class ClientResponse {
    String nome;
    String sobrenome;
    String documento;
    String email;
    int idade;
    String sexo;
    LocalDate dataNascimento;
    String telefoneCompleto;

    public static ClientResponse fromEntity(Client client) {
        return new ClientResponse(
                client.getNome(),
                client.getSobrenome(),
                client.getDocumento(),
                client.getEmail(),
                client.getIdade(),
                client.getSexo(),
                client.getDataNascimento(),
                formatarTelefone(client.getDdd(), client.getTelefone())
        );
    }

    public static List<ClientResponse> fromEntity(List<Client> clients) {
        return clients.stream().map(ClientResponse::fromEntity).toList();
    }

    private static String formatarTelefone(int ddd, int telefone) {
        String num = String.valueOf(telefone);
        return String.format("(%d) %s-%s", ddd, num.substring(0, 5), num.substring(5));
    }
}
