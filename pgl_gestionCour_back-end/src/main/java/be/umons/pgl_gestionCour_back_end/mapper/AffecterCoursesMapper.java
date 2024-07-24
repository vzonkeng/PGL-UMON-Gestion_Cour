package be.umons.pgl_gestionCour_back_end.mapper;

import be.umons.pgl_gestionCour_back_end.dtos.ControllerResponse.AffecterCoursesDto;
import be.umons.pgl_gestionCour_back_end.models.AffecterCours;
import be.umons.pgl_gestionCour_back_end.models.Courses;
import be.umons.pgl_gestionCour_back_end.repositories.AffecterCoursesRepository;
import be.umons.pgl_gestionCour_back_end.repositories.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class AffecterCoursesMapper {

    private CourseRepository courseRepository;
    public AffecterCours converAffectertCourseDtoToAffecterCourse(AffecterCoursesDto affecterCoursesDto){
        Optional<Courses> course = courseRepository.findById(affecterCoursesDto.getCourse_id());
        List<Courses> courses = new ArrayList<>();
        courses.add(course.get());
        if(course.isPresent()){
            return AffecterCours.builder()
                    .login(affecterCoursesDto.getLogin())
                    .LastName(affecterCoursesDto.getLastName())
                    .FirstName(affecterCoursesDto.getLastName())
                    .address(affecterCoursesDto.getAddress())
                    .role(affecterCoursesDto.getRole())
                    .inscriptionDate(affecterCoursesDto.getInscriptionDate())
                    .password(affecterCoursesDto.getPassword())
                    .affectationDate(LocalDateTime.now())
                    .person_id(affecterCoursesDto.getPerson_id())
                    .courses(courses)
                    .build();
        }else {
            throw  new RuntimeException("course not found");
        }

    }
}