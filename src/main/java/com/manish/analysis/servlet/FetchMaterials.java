package com.manish.analysis.servlet;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.manish.model.Material;

public class FetchMaterials {
	/**
	 * @param args
	 */
	
	private static JdbcConnectionSource connectionSource;
	private static Dao<Material, ?> materialDao;
	
	public static String getMaterials() {
		// TODO Auto-generated method stub
		// get our query builder from the DAO
		try {
			createDB();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		QueryBuilder<Material, ?> queryBuilder = materialDao.queryBuilder();
		// the 'title' field must be equal to title (a variable)
		try {

			// prepare our sql statement
			
			PreparedQuery<Material> preparedQuery = queryBuilder.prepare();
			

			// query for all stories that have that title
			List<Material> materialsList = materialDao.query(preparedQuery);

			connectionSource.close();
			return new Gson().toJson(materialsList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				connectionSource.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
		
	}

	private static void createDB() throws SQLException {
		String databaseUrl = "jdbc:mysql://localhost:3306/rateanalysis";
		// create a connection source to our database
		connectionSource = new JdbcConnectionSource(databaseUrl);
		
		
		//TableUtils.createTableIfNotExists(connectionSource, Material.class);
		
		// create a connection source to our database
		connectionSource = new JdbcConnectionSource(databaseUrl);
		((JdbcConnectionSource) connectionSource).setUsername("root");
		// instantiate the dao
		materialDao = DaoManager.createDao(connectionSource, Material.class);
	}

	
	public static void main(String[] args)
	{
		System.out.println(getMaterials());
	}
}
