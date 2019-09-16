package by.itacademy.laboratory.week.sixth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {

    private String bookName;
    private Integer creationYear;
    private String genreName;
    private String authorName;
}
