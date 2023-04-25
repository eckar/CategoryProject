package provider;

import model.Categories;
import model.CategoryKeywords;
import model.SubCategories;

import java.util.ArrayList;
import java.util.List;

public class CategoryProvider {
    public CategoryProvider() {
    }

    private static final String LEVEL_1 = "Level 1";

    public List<Categories> getListOfCategories() {
        List<Categories> categoriesList = new ArrayList<>();
        categoriesList.add(createCategory("1","Home Category"));
        categoriesList.add(createCategory("2","Electronics Category"));
        categoriesList.add(createCategory("3","Furniture Category"));
        return categoriesList;
    }

    private Categories createCategory(String id, String name) {
        return Categories.builder()
                .categoryId(id)
                .categoryName(name)
                .categoryLevel(LEVEL_1)
                .keywordsList(getKeywordsList())
                .build();
    }

    public List<SubCategories> getListOfSubCategories() {
        return List.of(homeSubCategory());
    }

    public Categories rootCategory(){
        return Categories.builder()
                .categoryId("0")
                .categoryName("Root Category")
                .categoryLevel("Level 0")
                .keywordsList(
                        List.of(CategoryKeywords.builder()
                                        .keywordId("0")
                                        .keywordName("Root")
                                .build())
                )
                .build();
    }

    private SubCategories homeSubCategory() {
        return SubCategories.builder()
                .subCategoryId("11")
                .subCategoryName("Major Appliances")
                .categoryId("1")
                .build();
    }

    private Categories homeCategory(){
        return Categories.builder()
                .categoryId("1")
                .categoryName("Home Appliances")
                .categoryLevel(LEVEL_1)
                .keywordsList(getKeywordsList())
                .build();
    }

    private List<CategoryKeywords> getKeywordsList() {
        CategoryKeywords home = CategoryKeywords.builder()
                .keywordId("1")
                .keywordName("Home")
                .build();
        CategoryKeywords appliances = CategoryKeywords.builder()
                .keywordId("2")
                .keywordName("Appliances")
                .build();
        return List.of(home, appliances);
    }
}
