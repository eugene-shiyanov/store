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
			ResultSet result = stat
					.executeQuery("SELECT * FROM stores ORDER BY id");
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

	public Store getById(Long id) {
		Store store = null;
		try {
			String query = "select * from stores where id = ? ";
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(1, id);
			ResultSet result = st.executeQuery();
			if (result.next()) {
				store = new Store();
				store.setId(result.getLong(1));
				store.setName(result.getString(2));
			}
			st.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return store;
	}

	public void update(Store store) {
		try {
			String query = "update stores set name = ? where id = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(2, store.getId());
			st.setString(1, store.getName());
			st.executeUpdate();
			st.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void save(Store store) {
		try {
			String query = "insert into stores(name) values(?)";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, store.getName());
			st.executeUpdate();
			st.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void removeById(Long id) {
		try {
			String query = "DELETE FROM stores WHERE id = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(1, id);
			st.executeUpdate();
			st.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}