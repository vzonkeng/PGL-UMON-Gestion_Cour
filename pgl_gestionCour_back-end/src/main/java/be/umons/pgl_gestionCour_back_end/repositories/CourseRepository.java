package be.umons.pgl_gestionCour_back_end.repositories;

import be.umons.pgl_gestionCour_back_end.models.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Courses,Integer> {
}
