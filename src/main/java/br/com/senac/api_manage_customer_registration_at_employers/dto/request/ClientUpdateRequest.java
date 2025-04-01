package br.com.senac.api_manage_customer_registration_at_employers.dto.request;
import jakarta.validation.constraints.*;
import lombok.Value;

import java.time.LocalDate;

@Value
public class ClientUpdateRequest {
    @NotNull(message = "O campo não pode ser nulo.")
    @Size(max = 100, message = "O campo não pode ter mais que 100 caracteres")
    String nome;

    @NotNull(message = "O campo não pode ser nulo.")
    @Size(max = 100, message = "O campo não pode ter mais que 100 caracteres")
    String sobrenome;

    @NotNull(message = "O campo não pode ser nulo.")
    @Size(max = 100, message = "O campo não pode ter mais que 100 caracteres")
    @Email(message = "O campo deve ser um e-mail válido.")
    String email;

    int idade;
    String sexo;
    LocalDate dataNascimento;
    int ddd;
    int telefone;
}
