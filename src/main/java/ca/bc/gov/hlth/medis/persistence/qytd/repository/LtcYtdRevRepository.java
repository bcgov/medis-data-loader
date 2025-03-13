package ca.bc.gov.hlth.medis.persistence.qytd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdRev;

@Repository
public interface LtcYtdRevRepository extends JpaRepository<LtcYtdRev, Long> {


}
