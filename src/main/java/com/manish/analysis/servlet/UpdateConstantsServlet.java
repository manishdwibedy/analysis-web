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
import com.j256.ormlite.stmt.UpdateBuilder;
import com.manish.analysis.db.Connection;
import com.manish.analysis.model.Changes;
import com.manish.analysis.model.Response;
import com.manish.model.Constants;
import com.manish.model.Material;

/**
 * Servlet implementation class UpdateConstantsServlet
 */
public class UpdateConstantsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateConstantsServlet() {
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
		responseObj.setSuccess(true);
		for(Changes change : changes)
		{
			column = "";
			UpdateBuilder<Constants, ?> updateBuilder = Connection.getConstantDao().updateBuilder();
			// update the password to be "none"
			switch(change.getColumn())
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
				updateBuilder.updateColumnValue(column, change.getValue());
				
				updateBuilder.where().eq("code", String.valueOf(change.getCode()));
				updateBuilder.update();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				responseObj.setSuccess(false);
				responseObj.setResponse(e.getMessage());
				break;
			}
		}
		
		if(responseObj.isSuccess())
		{
			responseObj.setResponse(changes.size() + " Materials Updated.");
		}
		
		
		writer.write(gson.toJson(responseObj));
	
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
