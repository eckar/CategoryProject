package service;

import model.Categories;
import model.CategoryKeywords;
import provider.CategoryProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class CategoriesService {

    private static final String ROOT = "Root";


    private CategoryProvider categoryProvider;

    public CategoriesService(CategoryProvider categoryProvider) {
        this.categoryProvider = categoryProvider;
    }

    public List<String> getKeywordsFromCategory(String categoryId) {
        return Optional.of(getCategory(categoryId).getKeywordsList().stream()
                .map(CategoryKeywords::getKeywordName)
                .collect(Collectors.toList()))
                .orElse(List.of(ROOT));
    }

    public List<String> getCategoryLevel(String categoryId) {
        List<String> categoryLevels = new ArrayList<>();
        categoryLevels.add(categoryProvider.rootCategory().getCategoryLevel());
        categoryLevels.add(getCategory(categoryId).getCategoryLevel());
        return categoryLevels;
    }

    private Categories getCategory(String categoryId) {
        return categoryProvider.getListOfCategories().stream()
                .filter(categories -> categories.getCategoryId().equals(categoryId))
                .findFirst().orElse(categoryProvider.rootCategory());
    }
}
