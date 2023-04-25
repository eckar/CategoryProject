package model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SubCategories {

    private String subCategoryId;
    private String subCategoryName;
    private String categoryId;
    private List<CategoryKeywords> keywordsList;
}
