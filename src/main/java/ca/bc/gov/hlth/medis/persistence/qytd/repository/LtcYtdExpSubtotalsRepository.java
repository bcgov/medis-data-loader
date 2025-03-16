package ca.bc.gov.hlth.medis.persistence.qytd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdExpSubTotals;

@Repository
public interface LtcYtdExpSubtotalsRepository extends JpaRepository<LtcYtdExpSubTotals, Long> {


}
