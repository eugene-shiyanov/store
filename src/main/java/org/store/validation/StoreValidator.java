package org.store.validation;

import org.store.models.Store;

public class StoreValidator extends AbstractValidator {

    @Override
    public void validate(Object obj) {
        if (obj == null) {
            addMessage("store", "Stre is absent!");
            return;
        }

        if (!(obj instanceof Store)) {
            addMessage("store", "It is not store");
            return;
        }

        Store store = (Store) obj;

        if (store.getName() == null || store.getName().isEmpty()) {
            addMessage("store.name", "name is required");
        } else {
            if (store.getName().length() >= 255) {
                addMessage("store.name", "name must be less than 255 signs");
            }
        }
    }

}
