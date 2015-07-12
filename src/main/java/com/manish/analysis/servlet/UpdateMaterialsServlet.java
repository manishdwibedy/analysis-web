package com.manish.analysis.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.manish.analysis.db.Connection;
import com.manish.model.Material;
import com.manish.test.orm.Account;

/**
 * Servlet implementation class UpdateMaterialsServlet
 */
public class UpdateMaterialsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMaterialsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		PrintWriter writer = response.getWriter();
		Response responseObj = new Response();
		
		String json = request.getParameter("changes");
		
		Type listType = new TypeToken<ArrayList<Changes>>() {}.getType();
		
		List<Changes> changes = gson.fromJson(json, listType);
		
		String column = "";
		responseObj.success = true;
		for(Changes change : changes)
		{
			column = "";
			UpdateBuilder<Material, ?> updateBuilder = Connection.getMaterialDao().updateBuilder();
			// update the password to be "none"
			switch(change.column)
			{
				case 1:
					column = "description";
					break;
				case 2:
					column = "unit";
					break;
				case 3:
					column = "quantity";
					break;
				case 4:
					column = "price";
					break;
			}
			try {
				updateBuilder.updateColumnValue(column, change.value);
				
				updateBuilder.where().eq("code", String.valueOf(change.code));
				updateBuilder.update();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				responseObj.success = false;
				responseObj.response = e.getMessage();
				break;
			}
		}
		
		if(responseObj.success)
		{
			responseObj.response = changes.size() + " Materials Updated.";
		}
		
		
		writer.write(gson.toJson(responseObj));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}

class Changes{
	int code;
	int column;
	String value;
}

class Response{
	boolean success;
	String response;
}