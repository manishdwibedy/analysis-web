package com.manish.analysis.servlet;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.manish.analysis.db.Connection;
import com.manish.model.Material;

public class FetchMaterials {
	
	public static String getMaterials() {
		// TODO Auto-generated method stub
		// get our query builder from the DAO
		QueryBuilder<Material, ?> queryBuilder = Connection.getMaterialDao().queryBuilder();
		// the 'title' field must be equal to title (a variable)
		try {

			// prepare our sql statement
			
			PreparedQuery<Material> preparedQuery = queryBuilder.prepare();
			

			// query for all stories that have that title
			List<Material> materialsList = Connection.getMaterialDao().query(preparedQuery);

			return new Gson().toJson(materialsList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
