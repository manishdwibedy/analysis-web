package com.manish.analysis.db;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.manish.model.Carriage;
import com.manish.model.Constants;
import com.manish.model.Hire;
import com.manish.model.Item;
import com.manish.model.Labour;
import com.manish.model.Material;

public class Connection {
	private static JdbcConnectionSource connectionSource;
	private static Dao<Material, ?> materialDao;
	private static Dao<Labour, String> labourDao;
	private static Dao<Hire, String> hireDao;
	private static Dao<Carriage, String> carriageDao;
	private static Dao<Constants, String> constantDao;
	private static Dao<Item, String> itemDao;
	
	private final String databaseUrl = "jdbc:mysql://localhost:3306/rateanalysis"; 
	public void createDB(boolean createTable) throws SQLException {
		// create a connection source to our database
		connectionSource = new JdbcConnectionSource(databaseUrl);
		// create a connection source to our database
		connectionSource = new JdbcConnectionSource(databaseUrl);
		((JdbcConnectionSource) connectionSource).setUsername("root");
		
		if(createTable)
		{
			TableUtils.createTableIfNotExists(connectionSource, Material.class);
			TableUtils.createTableIfNotExists(connectionSource, Labour.class);
			TableUtils.createTableIfNotExists(connectionSource, Hire.class);
			TableUtils.createTableIfNotExists(connectionSource, Carriage.class);
			TableUtils.createTableIfNotExists(connectionSource, Constants.class);	
		}
		
		// instantiate the dao
		materialDao = DaoManager.createDao(connectionSource, Material.class);
		labourDao = DaoManager.createDao(connectionSource, Labour.class);
	    hireDao = DaoManager.createDao(connectionSource, Hire.class);
	    carriageDao = DaoManager.createDao(connectionSource, Carriage.class);
	    constantDao = DaoManager.createDao(connectionSource, Constants.class);
	    
	    itemDao = DaoManager.createDao(connectionSource, Item.class);
	}
	
	public void closeDB() throws SQLException
	{
		connectionSource.close();
	}
	
	public static Dao<Labour, String> getLabourDao() {
		return labourDao;
	}

	public static Dao<Hire, String> getHireDao() {
		return hireDao;
	}

	public static Dao<Carriage, String> getCarriageDao() {
		return carriageDao;
	}

	public static Dao<Constants, String> getConstantDao() {
		return constantDao;
	}

	public static Dao<Item, String> getItemDao() {
		return itemDao;
	}

	public static JdbcConnectionSource getConnectionSource() {
		return connectionSource;
	}

	public static Dao<Material, ?> getMaterialDao() {
		return materialDao;
	}

}
