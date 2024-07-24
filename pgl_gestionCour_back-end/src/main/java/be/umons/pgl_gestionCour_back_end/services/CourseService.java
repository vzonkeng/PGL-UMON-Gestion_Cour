package be.umons.pgl_gestionCour_back_end.services;

import be.umons.pgl_gestionCour_back_end.dtos.ControllerResponse.CourseDto;
import be.umons.pgl_gestionCour_back_end.models.Courses;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Courses> serviceGetAllCourses();
     Courses serviceCreateCourse(CourseDto courseDto);
     Optional<Courses> serviceFindCourseById(int id);
     Courses serviceUpdateCourse(int id, CourseDto courseDto);

     Void serviceDeleteCourse(int id);
}
