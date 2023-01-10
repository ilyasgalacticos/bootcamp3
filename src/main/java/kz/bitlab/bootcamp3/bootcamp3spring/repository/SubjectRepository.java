package kz.bitlab.bootcamp3.bootcamp3spring.repository;

import kz.bitlab.bootcamp3.bootcamp3spring.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
