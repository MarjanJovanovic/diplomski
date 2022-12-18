package it.marjanjovanovicbe.dto;
import it.marjanjovanovicbe.util.TitleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDto extends PersonDto{

    private String phone;
    private LocalDate reelectionDate;
    private TitleDto title;

}
