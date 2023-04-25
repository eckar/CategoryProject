package model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Categories {

    private String categoryId;
    private String categoryName;
    private String categoryLevel;
    private List<CategoryKeywords> keywordsList;
}
