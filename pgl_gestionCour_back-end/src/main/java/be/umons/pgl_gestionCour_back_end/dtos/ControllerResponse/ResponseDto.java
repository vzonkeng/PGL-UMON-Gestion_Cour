package be.umons.pgl_gestionCour_back_end.dtos.ControllerResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ResponseDto {
    private MetaDto meta; //header
    private Object data;//body
    private String errors;
    private PaginationDto pagination;// permet de faire un get par lot
}
