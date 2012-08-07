package org.store.dao;

import java.sql.*;
import java.util.*;
import org.store.models.*;

public class StoreDao {
	private Connection conn;
	
	public StoreDao(Connection conn) {
	this.conn = conn;
	}
	
	public List<Store> getAll() {
		List<Store> stores = new ArrayList<Store>();
		try {
			Statement stat = conn.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM Stores ORDER BY Stores_id");
			while (result.next()) {
				Store store = new Store();
				store.setId(result.getLong(1));
				store.setName(result.getString(2));
				stores.add(store);
			}
			stat.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return stores;
	}	










}