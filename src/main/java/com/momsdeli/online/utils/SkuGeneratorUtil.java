package com.momsdeli.online.utils;

import com.momsdeli.online.model.Category;

/**
 * Utility class for generating Stock Keeping Unit (SKU) codes.
 *
 * @author Shahbaz Khan
 * @date 23/10/2024
 */
public class SkuGeneratorUtil {

    /**
     * Generates an SKU based on the category name and a unique identifier.
     *
     * @param category     The category of the product.
     * @param productCount The current number of products in the given category.
     * @return The generated SKU string.
     */
    public static String generateSkuBasedOnCategory(Category category, long productCount) {
        String prefix = switch (category.getName().toLowerCase()) {
            case "sandwiches" -> "SAND";
            case "groceries" -> "GROC";
            case "drinks" -> "DRNK";
            case "chips & snacks" -> "SNCK";
            case "hygiene" -> "HYGN";
            default -> "GEN"; // General or unknown category
        };

        // Calculate the next number for the SKU
        int nextNumber = (int) productCount + 1;

        // Generate the SKU in the format: PREFIX-XXX (e.g., SAND-001)
        return prefix + "-" + String.format("%03d", nextNumber);
    }
}
