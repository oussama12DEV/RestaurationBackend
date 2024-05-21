package org.example.backendrestauration.Exception;

public class IngredientNotFoundException extends Exception {
    public IngredientNotFoundException(String ingredientNotFound) {
        super(ingredientNotFound);
    }
}
