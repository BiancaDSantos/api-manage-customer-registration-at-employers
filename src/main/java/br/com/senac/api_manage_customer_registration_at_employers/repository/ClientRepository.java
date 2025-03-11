package br.com.senac.api_manage_customer_registration_at_employers.repository;

import br.com.senac.api_manage_customer_registration_at_employers.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository  extends JpaRepository<Client, Long> {
}
