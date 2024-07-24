package be.umons.pgl_gestionCour_back_end.services.impl;

import be.umons.pgl_gestionCour_back_end.dtos.ControllerResponse.CourseDto;
import be.umons.pgl_gestionCour_back_end.exception.CustomException;
import be.umons.pgl_gestionCour_back_end.mapper.CourseMapper;
import be.umons.pgl_gestionCour_back_end.models.Courses;
import be.umons.pgl_gestionCour_back_end.repositories.CourseRepository;
import be.umons.pgl_gestionCour_back_end.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    @Override
    public List<Courses> serviceGetAllCourses() {
        var courses = courseRepository.findAll();
        if(courses==null){
            throw  new CustomException("1001");
        }
        return courses;
    }

    @Override
    public Courses serviceCreateCourse(CourseDto courseDto) {
        try {
            var courseToSave = courseMapper.convertCourseDtoToCourse(courseDto);
            if (courseDto != null) {
                Courses courseCreated = courseRepository.save(courseToSave);
                return  courseCreated;
            } else {
                throw new CustomException("CourseDto is null");
            }
        } catch (Exception e) {
            throw new CustomException("Failed to save course: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<Courses> serviceFindCourseById(int id) {
        Optional<Courses> course = courseRepository.findById(id);

        if (course.isPresent()) {
            return course;
        } else {
            throw new CustomException("Person with id: "+id+" is not present");
        }
    }

    @Override
    public Courses serviceUpdateCourse(int id, CourseDto courseDetails) {
        Optional<Courses> courses = courseRepository.findById(id);
        if (courses.isPresent()) {
            Courses existingCourse = courses.get();
            existingCourse.setTitle(courseDetails.getTitle());
            Courses courseUpdated = courseRepository.save(existingCourse);
            return courseUpdated;
        } else {
            throw new CustomException("Coursedto is null");
        }
    }

    @Override
    public Void serviceDeleteCourse(int id) {
        Optional<Courses> course = courseRepository.findById(id);
        if (course.isPresent()) {
            courseRepository.delete(course.get());
        } else {
            System.out.println("deletion error");
        }
        return null;
    }


}
