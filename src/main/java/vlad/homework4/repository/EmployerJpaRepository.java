package vlad.homework4.repository;

import vlad.homework4.domain.Employer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployerJpaRepository extends JpaRepository<Employer, Long> {
}
