package be.umons.pgl_gestionCour_back_end.Controller;

import be.umons.pgl_gestionCour_back_end.dtos.ControllerResponse.AffecterCoursesDto;
import be.umons.pgl_gestionCour_back_end.dtos.ControllerResponse.ResponseDto;
import be.umons.pgl_gestionCour_back_end.models.Courses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("PGL/")
public interface AffecterCoursesController {

    @PostMapping("allocate/course")
    ResponseEntity<ResponseDto> allocateCourses(@RequestBody AffecterCoursesDto affecterCoursesDto);}