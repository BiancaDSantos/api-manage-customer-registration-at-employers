package br.com.senac.api_manage_customer_registration_at_employers.dto;

import br.com.senac.api_manage_customer_registration_at_employers.model.Client;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;


public interface ClientRepresentatioDTO {

    @Data
    class Create {
        @NotNull(message = "O campo não pode ser nulo.")
        @Size(max = 100, message = "O campo não pode ter mais que 100 caracteres")
        private String name;

        @NotNull(message = "O campo não pode ser nulo.")
        @Size(max = 100, message = "O campo não pode ter mais que 100 caracteres")
        private String sobrenome;

        @NotNull(message = "O campo não pode ser nulo.")
        @Size(max = 100, message = "O campo não pode ter mais que 100 caracteres")
        private String documento;

        @NotNull(message = "O campo não pode ser nulo.")
        @Size(max = 100, message = "O campo não pode ter mais que 100 caracteres")
        private String email;

        private int idade;
        private String sexo;
        private LocalDate dataNascimento;
        private int ddd;
        private int telefone;

        public Client createregistration() {
            return Client.builder()
                    .nome(this.name)
                    .documento(this.documento)
                    .sobrenome(this.sobrenome)
                    .email(this.email)
                    .idade(this.idade)
                    .sexo(this.sexo)
                    .dataNascimento(this.dataNascimento)
                    .ddd(this.ddd)
                    .telefone(this.telefone)
                    .build();
        }
    }

    @Data
    class Update {
        @NotNull(message = "O campo não pode ser nulo.")
        @Size(max = 100, message = "O campo não pode ter mais que 100 caracteres")
        private String documento;

        @NotNull(message = "O campo não pode ser nulo.")
        @Size(max = 100, message = "O campo não pode ter mais que 100 caracteres")
        private String nome;

        @NotNull(message = "O campo não pode ser nulo.")
        @Size(max = 100, message = "O campo não pode ter mais que 100 caracteres")
        private String sobrenome;

        @NotNull(message = "O campo não pode ser nulo.")
        @Size(max = 100, message = "O campo não pode ter mais que 100 caracteres")
        private String email;

        private int idade;
        private String sexo;
        private LocalDate dataNascimento;
        private int ddd;
        private int telefone;
    }
}
