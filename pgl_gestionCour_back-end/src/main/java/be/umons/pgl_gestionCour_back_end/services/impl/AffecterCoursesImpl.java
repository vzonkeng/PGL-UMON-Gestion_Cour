package be.umons.pgl_gestionCour_back_end.services.impl;

import be.umons.pgl_gestionCour_back_end.dtos.ControllerResponse.AffecterCoursesDto;
import be.umons.pgl_gestionCour_back_end.mapper.AffecterCoursesMapper;
import be.umons.pgl_gestionCour_back_end.models.AffecterCours;
import be.umons.pgl_gestionCour_back_end.models.Courses;
import be.umons.pgl_gestionCour_back_end.repositories.AffecterCoursesRepository;
import be.umons.pgl_gestionCour_back_end.repositories.CourseRepository;
import be.umons.pgl_gestionCour_back_end.services.AffecterCoursesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AffecterCoursesImpl implements AffecterCoursesService {

    private AffecterCoursesRepository affecterCoursesRepository;
    private CourseRepository courseRepository;
    private  AffecterCoursesMapper affecterCoursesMapper;

    @Override
    public AffecterCours serviceAllocateCourses(AffecterCoursesDto affecterCoursesDto) {
        try {
            Courses course = courseRepository.findById(affecterCoursesDto.getCourse_id())
                    .orElseThrow(() -> new RuntimeException("Course not found"));
            var  allocateCourseToSave = affecterCoursesMapper.converAffectertCourseDtoToAffecterCourse(affecterCoursesDto);
            return affecterCoursesRepository.save(allocateCourseToSave);
        } catch (Exception e) {
            // Log the error
            System.err.println("Error in serviceAllocateCourses: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
