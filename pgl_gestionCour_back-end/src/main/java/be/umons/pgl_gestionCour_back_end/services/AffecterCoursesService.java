package be.umons.pgl_gestionCour_back_end.services;

import be.umons.pgl_gestionCour_back_end.dtos.ControllerResponse.AffecterCoursesDto;
import be.umons.pgl_gestionCour_back_end.dtos.ControllerResponse.CourseDto;
import be.umons.pgl_gestionCour_back_end.models.AffecterCours;
import be.umons.pgl_gestionCour_back_end.models.Courses;

import java.util.List;
import java.util.Optional;

public interface AffecterCoursesService {

    AffecterCours serviceAllocateCourses(AffecterCoursesDto affecterCoursesDto);

}
