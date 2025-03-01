package ca.bc.gov.hlth.medis.persistence.qytd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdCompSalSubtotals;

@Repository
public interface LtcYtdCompSalSubtotalsRepository extends JpaRepository<LtcYtdCompSalSubtotals, Long> {

}
