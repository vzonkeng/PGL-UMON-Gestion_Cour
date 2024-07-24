package be.umons.pgl_gestionCour_back_end.Controller.impl;

import be.umons.pgl_gestionCour_back_end.Controller.CourseController;
import be.umons.pgl_gestionCour_back_end.dtos.ControllerResponse.*;
import be.umons.pgl_gestionCour_back_end.services.impl.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CourseControllerImpl implements CourseController {

    private final CourseServiceImpl courseService;
    public final ResponseDetails responseDetails;
    @Override
    public ResponseEntity<ResponseDto> getAllCourses() {
        try {
            var courses = courseService.serviceGetAllCourses();
            return new ResponseEntity<>(ResponseDto.builder()
                    .data(courses)
                    .errors(null)
                    .meta(MetaDto.builder().message("list of courses")
                            .statusCode(HttpStatus.OK.value()).statusDescription("Succes").build())
                    .pagination(PaginationDto.builder().count(0).total(0).build())
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            // Construit une réponse d'erreur en cas d'exception.
            if(e.getMessage().equals("1001")){
                return new ResponseEntity<>(ResponseDto.builder()
                        .data(null)
                        .errors("list of courses is empty in the BD")
                        .meta(MetaDto.builder().message("list of courses is empty in the BD")
                                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).statusDescription("Echec").build())
                        .pagination(PaginationDto.builder().count(0).total(0).build())
                        .build(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(responseDetails.GetErrorResponseDetails("not object in the BD",
                    HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseDto> createCourse(@RequestBody CourseDto courseDto) {
        var newCourse = courseService.serviceCreateCourse(courseDto);
        return new ResponseEntity<>(ResponseDto.builder()
                .data(newCourse)
                .errors(null)
                .meta(MetaDto.builder().message("Course created")
                        .statusCode(HttpStatus.OK.value()).statusDescription("Success").build())
                .pagination(PaginationDto.builder().count(0).total(0).build())
                .build(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDto> getCourseById(int id) {
        try {
            //@PathVariable parce que c'est variable qui est dan le chemin fournis
            return new ResponseEntity<>(ResponseDto.builder()
                    .data(courseService.serviceFindCourseById(id).get())
                    .errors(null)
                    .meta(MetaDto.builder().message("Obtaining a course")
                            .statusCode(HttpStatus.OK.value()).statusDescription("Success").build())
                    .pagination(PaginationDto.builder().count(0).total(0).build())
                    .build(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(responseDetails.GetErrorResponseDetails(e.getMessage(),
                    HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
    }
    @Override
    public ResponseEntity<ResponseDto> updateCourse(int id, CourseDto courseDetail) {

        try {
            var updateCourse = courseService.serviceUpdateCourse(id,courseDetail);
            return new ResponseEntity<>(ResponseDto.builder()
                    .data(updateCourse)
                    .errors(null)
                    .meta(MetaDto.builder().message("updated person")
                            .statusCode(HttpStatus.OK.value()).statusDescription("Réussi").build())
                    .pagination(PaginationDto.builder().count(0).total(0).build())
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(responseDetails.GetErrorResponseDetails(e.getMessage(),
                    HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<ResponseDto> deleteCourse(@PathVariable int id) {
        try {
            courseService.serviceDeleteCourse(id);
        } catch (Exception e) {
            return new ResponseEntity<>(responseDetails.GetErrorResponseDetails(e.getMessage(),
                    HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
        return null;
    }

}
