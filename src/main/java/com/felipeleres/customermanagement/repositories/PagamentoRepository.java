package com.felipeleres.customermanagement.repositories;

import com.felipeleres.customermanagement.entities.Pagamento;
import com.felipeleres.customermanagement.entities.Processo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento,Long > {

}
