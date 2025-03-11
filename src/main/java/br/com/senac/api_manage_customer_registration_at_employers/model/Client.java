package br.com.senac.api_manage_customer_registration_at_employers.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String documento;

    @NotNull
    @Column
    private String nome;

    @NotNull
    @Column
    private String sobrenome;

    @NotNull
    @Column
    private String email;

    @Column
    private int idade;

    @Column
    private String sexo;

    @Column
    private LocalDate dataNascimento;

    @Column
    private int ddd;

    @Column
    private int telefone;

}
