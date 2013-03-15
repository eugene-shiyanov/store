package org.store.validation;

import org.store.models.Item;

public class ItemValidator extends AbstractValidator{

	@Override
    public void validate(Object obj) {
		if (obj == null) {
			addMessage("item", "Item is absent!");
			return;
		}
		if (!(obj instanceof Item)) {
			addMessage("item", "It is not item");
			return;
		}
		Item item = (Item) obj;
		if (item.getName() == null || item.getName().isEmpty()) {
		    addMessage("item.name", "name is required");
		} else {
		    if (item.getName().length() >= 255) {
		    	addMessage("item.name", "name must be less than 255 signs");
		    }
		}
		if (item.getPrice() == null ) {
		    addMessage("item.price", "price is required");
		} else {
		    if (item.getPrice().doubleValue() < 0) {
		    	addMessage("item.price", "price must be greater or equal zero");
		    }
		}
    }

}
 
