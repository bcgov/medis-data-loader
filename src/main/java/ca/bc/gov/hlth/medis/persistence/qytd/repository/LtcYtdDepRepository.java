package ca.bc.gov.hlth.medis.persistence.qytd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdDep;

@Repository
public interface LtcYtdDepRepository extends JpaRepository<LtcYtdDep, Long> {
}
