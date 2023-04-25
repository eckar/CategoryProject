package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import provider.CategoryProvider;

import java.util.List;

class CategoriesServiceTest {

    private static final String ROOT_CATEGORY = "0";
    private static final String CATEGORY_ID = "1";

    private CategoriesService categoriesService;

    @BeforeEach
    public void setUp() {
        CategoryProvider categoryProvider = new CategoryProvider();
        categoriesService = new CategoriesService(categoryProvider);
    }

    @Test
    void shouldGetKeywordsWhenCategoryExist() {
        List<String> keywordsFromCategory = categoriesService.getKeywordsFromCategory(CATEGORY_ID);
        Assertions.assertNotNull(keywordsFromCategory);
        Assertions.assertEquals("Home", keywordsFromCategory.get(0));
        Assertions.assertEquals(2, keywordsFromCategory.size());
    }

    @Test
    void shouldGetRootCategoryWhenCategoryNotExist() {
        List<String> rootCategory = categoriesService.getKeywordsFromCategory(ROOT_CATEGORY);
        Assertions.assertNotNull(rootCategory);
        Assertions.assertEquals(1, rootCategory.size());
    }

    @Test
    void shouldGetCategoryLevelForCategory() {
        List<String> categoryLevels = categoriesService.getCategoryLevel(CATEGORY_ID);
        Assertions.assertNotNull(categoryLevels);
        Assertions.assertEquals(2, categoryLevels.size());
    }
}