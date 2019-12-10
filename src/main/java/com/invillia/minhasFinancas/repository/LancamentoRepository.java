package com.invillia.minhasFinancas.repository;

import com.invillia.minhasFinancas.model.entity.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository <Lancamento, Long> {
}
