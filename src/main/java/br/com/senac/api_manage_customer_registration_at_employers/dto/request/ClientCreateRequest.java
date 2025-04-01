package br.com.senac.api_manage_customer_registration_at_employers.dto.request;


import br.com.senac.api_manage_customer_registration_at_employers.model.Client;
import jakarta.validation.constraints.*;
import lombok.Value;

import java.time.LocalDate;

@Value
public class ClientCreateRequest {
    @NotNull(message = "O campo não pode ser nulo.")
    @Size(max = 100, message = "O campo não pode ter mais que 100 caracteres")
    String nome;

    @NotNull(message = "O campo não pode ser nulo.")
    @Size(max = 100, message = "O campo não pode ter mais que 100 caracteres")
    String sobrenome;

    @NotNull(message = "O campo não pode ser nulo.")
    @Size(max = 100, message = "O campo não pode ter mais que 100 caracteres")
    String documento;

    @NotNull(message = "O campo não pode ser nulo.")
    @Size(max = 100, message = "O campo não pode ter mais que 100 caracteres")
    @Email(message = "O campo deve ser um e-mail válido.")
    String email;

    @PositiveOrZero(message = "A idade não pode ser negativa.")
    int idade;

    String sexo;

    LocalDate dataNascimento;

    @Min(value = 11, message = "DDD deve ter 2 dígitos.")
    @Max(value = 99, message = "DDD deve ter 2 dígitos.")
    int ddd;

    @Min(value = 100000000, message = "Telefone deve ter 9 dígitos.")
    @Max(value = 999999999, message = "Telefone deve ter 9 dígitos.")
    int telefone;

    // Converte DTO → Entidade
    public Client toEntity() {
        return Client.builder()
                .nome(this.nome)
                .sobrenome(this.sobrenome)
                .documento(this.documento)
                .email(this.email)
                .idade(this.idade)
                .sexo(this.sexo)
                .dataNascimento(this.dataNascimento)
                .ddd(this.ddd)
                .telefone(this.telefone)
                .build();
    }
}
