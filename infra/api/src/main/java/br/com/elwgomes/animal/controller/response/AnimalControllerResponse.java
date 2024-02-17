package br.com.elwgomes.animal.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnimalControllerResponse<D> {
    private String status;
    private String code;
    private String message;
    private D data;
    public AnimalControllerResponse(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
    public AnimalControllerResponse(String status, String code, D data) {
        this.status = status;
        this.code = code;
        this.data = data;
    }

}
