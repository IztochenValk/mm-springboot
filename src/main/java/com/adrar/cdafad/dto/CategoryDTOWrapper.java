package com.adrar.cdafad.dto;

import com.adrar.cdafad.entity.Category;

public class CategoryDTOWrapper {

    public static CategoryDTO wrapCategoryToCategoryDTO(Category category)
    {
        return new CategoryDTO(category.getName());
    }
}
