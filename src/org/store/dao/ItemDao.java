package org.store.dao;

import java.sql.*;
import java.util.*;
import org.store.models.Item;

public class ItemDao {
	private Connection conn;
	
	public ItemDao(Connection conn) {
		this.conn = conn;
	}
	
	public List<Item> getAll(){
		List<Item> items = new ArrayList<Item>();
		try {
			Statement stat = conn.createStatement();
			ResultSet result = stat.executeQuery("select * from Items");
			while(result.next()) {
				Item item = new Item();
				item.setId(result.getLong(1));
				item.setName(result.getString(2));
				item.setPrice(result.getDouble(3));
				items.add(item);
			}
			stat.close();		
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return items;
	}
}
