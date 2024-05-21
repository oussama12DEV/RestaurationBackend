package org.example.backendrestauration.Exception;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String itemNotFound) {
        super(itemNotFound);
    }
}
