package by.itacademy.laboratory.week.sixth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookFilter {

    private List<String> authors;
    private List<String> genres;
    private Integer fromYear;
    private Integer toYear;
}
