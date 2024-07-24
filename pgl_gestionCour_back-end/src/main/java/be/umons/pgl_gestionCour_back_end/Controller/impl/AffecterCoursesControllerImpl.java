package be.umons.pgl_gestionCour_back_end.Controller.impl;

import be.umons.pgl_gestionCour_back_end.Controller.AffecterCoursesController;
import be.umons.pgl_gestionCour_back_end.dtos.ControllerResponse.*;
import be.umons.pgl_gestionCour_back_end.models.Courses;
import be.umons.pgl_gestionCour_back_end.services.impl.AffecterCoursesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;


@RestController
@RequiredArgsConstructor
public class AffecterCoursesControllerImpl implements AffecterCoursesController {

    private final AffecterCoursesImpl affecterCourses;
    public final ResponseDetails responseDetails;

    @Override
    public ResponseEntity<ResponseDto> allocateCourses(@RequestBody AffecterCoursesDto affecterCoursesDto) {
        try {
            var newAllocate = affecterCourses.serviceAllocateCourses(affecterCoursesDto);
            return new ResponseEntity<>(ResponseDto.builder()
                    .data(newAllocate)
                    .errors(null)
                    .meta(MetaDto.builder().message("new allocate created")
                            .statusCode(HttpStatus.OK.value()).statusDescription("Success").build())
                    .pagination(PaginationDto.builder().count(0).total(0).build())
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            // Log the error
            System.err.println("Error allocating course: " + e.getMessage());
            e.printStackTrace();

            return new ResponseEntity<>(ResponseDto.builder()
                    .data(null)
                    .errors(String.valueOf(Collections.singletonList(e.getMessage())))
                    .meta(MetaDto.builder().message("Error allocating course")
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).statusDescription("Failure").build())
                    .pagination(PaginationDto.builder().count(0).total(0).build())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

