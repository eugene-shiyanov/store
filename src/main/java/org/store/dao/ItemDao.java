package org.store.dao;

import java.sql.*;
import java.util.*;
import org.store.models.Item;

public class ItemDao extends AbstractDao {
    private Connection conn;

    public ItemDao() {
        this.conn = getConnection();
    }

    public List<Item> getAll() {
        List<Item> items = new ArrayList<Item>();
        try {
            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery("select * from items order by id");
            while (result.next()) {
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

    public Item getById(Long id) {
        Item item = null;
        try {
            String query = "select * from items where id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, id);
            ResultSet result = st.executeQuery();
            if (result.next()) {
                item = new Item();
                item.setId(result.getLong(1));
                item.setName(result.getString(2));
                item.setPrice(result.getDouble(3));
            }
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return item;
    }

    private void update(Item item) {
        try {
            String query = "update items set name = ?, price = ? where id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(3, item.getId());
            st.setString(1, item.getName());
            st.setDouble(2, item.getPrice());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void save(Item item) {
        try {
            String query = "insert into items(name, price) values (?, ?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, item.getName());
            st.setDouble(2, item.getPrice());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void saveOrUpdate(Item item) {
        if (item != null) {
            if (item.getId() == null) {
                save(item);
            } else {
                update(item);
            }
        }
    }

    public void removeById(Long id) {
        try {
            String query = "delete from items where id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, id);
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
