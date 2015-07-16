package com.manish.analysis.util;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.manish.analysis.db.Connection;
import com.manish.analysis.model.BasicRateJson;
import com.manish.model.Carriage;
import com.manish.model.Constants;
import com.manish.model.Hire;
import com.manish.model.ItemInput;
import com.manish.model.Labour;
import com.manish.model.Material;
import com.manish.util.ItemUtils;

public class BaseRateUtil {
	public static Material convert2Material(ItemInput input) {
		// TODO Auto-generated method stub
		Material material = new Material();
		material.setCode(ItemUtils.stripZeroes(input.getCode()));
		material.setQuantity(input.getQuantity());
		return material;
	}

	public static Carriage convert2Carriage(ItemInput input) {
		// TODO Auto-generated method stub
		Carriage carriage = new Carriage();
		carriage.setCode(ItemUtils.stripZeroes(input.getCode()));
		carriage.setQuantity(input.getQuantity());
		return carriage;
	}

	public static Labour convert2Labour(ItemInput input) {
		// TODO Auto-generated method stub
		Labour labour = new Labour();
		labour.setCode(ItemUtils.stripZeroes(input.getCode()));
		labour.setQuantity(input.getQuantity());
		return labour;
	}

	public static Hire convert2Hire(ItemInput input) {
		// TODO Auto-generated method stub
		Hire hire = new Hire();
		hire.setCode(ItemUtils.stripZeroes(input.getCode()));
		hire.setQuantity(input.getQuantity());
		return hire;
	}
	
	public static Constants convert2Constant(ItemInput input) {
		// TODO Auto-generated method stub
		Constants constant = new Constants();
		constant.setCode(input.getCode());
		return constant;
	}
	
	public static String getMaterial() {
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
	
	public static List<Material> getMaterial(List<String> codes) {
		// TODO Auto-generated method stub
		// get our query builder from the DAO
		QueryBuilder<Material, ?> queryBuilder = Connection.getMaterialDao().queryBuilder();
		// the 'title' field must be equal to title (a variable)
		try {
			queryBuilder.where().in("code", codes);
			
			// prepare our sql statement
			PreparedQuery<Material> preparedQuery = queryBuilder.prepare();

			// query for all stories that have that title
			List<Material> materialsList = Connection.getMaterialDao().query(preparedQuery);

			return materialsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static String getCarriage() {
		// TODO Auto-generated method stub
		// get our query builder from the DAO
		QueryBuilder<Carriage, ?> queryBuilder = Connection.getCarriageDao().queryBuilder();
		// the 'title' field must be equal to title (a variable)
		try {
			// prepare our sql statement
			PreparedQuery<Carriage> preparedQuery = queryBuilder.prepare();

			// query for all stories that have that title
			List<Carriage> carriagesList = Connection.getCarriageDao().query(preparedQuery);

			return new Gson().toJson(carriagesList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static List<Carriage> getCarriage(List<String> codes) {
		// TODO Auto-generated method stub
		// get our query builder from the DAO
		QueryBuilder<Carriage, ?> queryBuilder = Connection.getCarriageDao().queryBuilder();
		// the 'title' field must be equal to title (a variable)
		try {
			queryBuilder.where().in("code", codes);
			// prepare our sql statement
			PreparedQuery<Carriage> preparedQuery = queryBuilder.prepare();

			// query for all stories that have that title
			List<Carriage> carriagesList = Connection.getCarriageDao().query(preparedQuery);

			return carriagesList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static String getConstant() {
		// TODO Auto-generated method stub
		// get our query builder from the DAO
		QueryBuilder<Constants, ?> queryBuilder = Connection.getConstantDao().queryBuilder();
		// the 'title' field must be equal to title (a variable)
		try {
			// prepare our sql statement
			PreparedQuery<Constants> preparedQuery = queryBuilder.prepare();

			// query for all stories that have that title
			List<Constants> constantsList = Connection.getConstantDao().query(preparedQuery);

			return new Gson().toJson(constantsList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static List<Constants> getConstant(List<String> codes) {
		// TODO Auto-generated method stub
		// get our query builder from the DAO
		QueryBuilder<Constants, ?> queryBuilder = Connection.getConstantDao().queryBuilder();
		// the 'title' field must be equal to title (a variable)
		try {
			queryBuilder.where().in("description", codes);
			// prepare our sql statement
			PreparedQuery<Constants> preparedQuery = queryBuilder.prepare();

			// query for all stories that have that title
			List<Constants> constantsList = Connection.getConstantDao().query(preparedQuery);

			return constantsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public static String getHire() {
		// TODO Auto-generated method stub
		// get our query builder from the DAO
		QueryBuilder<Hire, ?> queryBuilder = Connection.getHireDao().queryBuilder();
		// the 'title' field must be equal to title (a variable)
		try {
			// prepare our sql statement
			PreparedQuery<Hire> preparedQuery = queryBuilder.prepare();

			// query for all stories that have that title
			List<Hire> hiresList = Connection.getHireDao().query(preparedQuery);

			return new Gson().toJson(hiresList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static List<Hire> getHire(List<String> codes) {
		// TODO Auto-generated method stub
		// get our query builder from the DAO
		QueryBuilder<Hire, ?> queryBuilder = Connection.getHireDao().queryBuilder();
		// the 'title' field must be equal to title (a variable)
		try {
			queryBuilder.where().in("code", codes);
			// prepare our sql statement
			PreparedQuery<Hire> preparedQuery = queryBuilder.prepare();

			// query for all stories that have that title
			List<Hire> hiresList = Connection.getHireDao().query(preparedQuery);

			return hiresList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static String getLabour() {
		// TODO Auto-generated method stub
		// get our query builder from the DAO
		QueryBuilder<Labour, ?> queryBuilder = Connection.getLabourDao().queryBuilder();
		// the 'title' field must be equal to title (a variable)
		try {
			// prepare our sql statement
			PreparedQuery<Labour> preparedQuery = queryBuilder.prepare();

			// query for all stories that have that title
			List<Labour> laboursList = Connection.getLabourDao().query(preparedQuery);

			return new Gson().toJson(laboursList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static List<Labour> getLabour(List<String> codes) {
		// TODO Auto-generated method stub
		// get our query builder from the DAO
		QueryBuilder<Labour, ?> queryBuilder = Connection.getLabourDao().queryBuilder();
		// the 'title' field must be equal to title (a variable)
		try {
			queryBuilder.where().in("code", codes);
			// prepare our sql statement
			PreparedQuery<Labour> preparedQuery = queryBuilder.prepare();

			// query for all stories that have that title
			List<Labour> laboursList = Connection.getLabourDao().query(preparedQuery);

			return laboursList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
