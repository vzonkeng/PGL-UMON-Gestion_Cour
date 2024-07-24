package be.umons.pgl_gestionCour_back_end.repositories;

import be.umons.pgl_gestionCour_back_end.models.AffecterCours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AffecterCoursesRepository extends JpaRepository<AffecterCours,Integer> {
}
