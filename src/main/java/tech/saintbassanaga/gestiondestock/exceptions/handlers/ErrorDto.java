package tech.saintbassanaga.gestiondestock.exceptions.handlers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import tech.saintbassanaga.gestiondestock.exceptions.ErrorCode;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {

    private Integer httpCode;

    private ErrorCode code;

    private String message;

    private List<String> errors = new ArrayList<>();


}
