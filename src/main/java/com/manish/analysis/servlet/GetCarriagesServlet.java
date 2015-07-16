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
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.manish.analysis.db.Connection;
import com.manish.analysis.model.BasicRateJson;
import com.manish.analysis.model.Data;
import com.manish.analysis.model.Metadata;
import com.manish.analysis.model.TableData;
import com.manish.analysis.util.BaseRateUtil;
import com.manish.analysis.util.Util;
import com.manish.model.Carriage;

/**
 * Servlet implementation class GetCarriagesServlet
 */
public class GetCarriagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCarriagesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter writer = response.getWriter();
		
		Data data = new Data();
		response.setContentType("application/json");     
		
		String json = BaseRateUtil.getCarriage();
		
		Type listType = new TypeToken<ArrayList<Carriage>>() {}.getType();
        
		List<Carriage> carriages = new Gson().fromJson(json, listType);
		data.setData(convert(carriages));
		
		String mode = request.getParameter("mode");
		
		List<Metadata> metadataList = new ArrayList<Metadata>();
		
		for(String columnName : Util.getBaseColumns())
		{
			Metadata metadata = new Metadata();
			metadata.setName(columnName);
			metadata.setLabel(columnName.toUpperCase());
			switch(columnName)
			{
				case "code":
				case "description":
				case "unit":
					metadata.setDatatype("string");
					break;
					//Rs,2,dot,comma,1
				case "quantity":
					metadata.setDatatype("double(,2,dot,comma,1)");
					break;
				case "price":
					metadata.setDatatype("double(Rs,2,dot,comma,1)");
				default:
					//metadata.setDatatype("double(m,2)");
			}
			metadata.setEditable(false);
			metadataList.add(metadata);
		}
		switch(mode)
		{
			case "view":
				break;
			case "edit":
				for(Metadata metadata : metadataList)
				{
					if(!metadata.getName().equalsIgnoreCase("code"))
					{
						metadata.setEditable(true);
					}
				}
				break;
		}
		data.setMetadata(metadataList);
		writer.write(new Gson().toJson(data));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private List<TableData> convert(List<Carriage> carriages)
	{
		int count = 0;
		List<TableData> carriageList = new ArrayList<TableData>();
		for(Carriage carriage : carriages)
		{
			TableData data = new TableData();
			data.setId(++count);
			BasicRateJson carriageObj = new BasicRateJson();
			carriageObj.setCode(carriage.getCode());
			carriageObj.setDescription(new String(carriage.getDescription()));
			carriageObj.setUnit(carriage.getUnit());
			carriageObj.setQuantity(carriage.getQuantity());
			carriageObj.setPrice(carriage.getPrice());
			
			data.setValues(carriageObj);
			carriageList.add(data);
		}
		return carriageList;
		
	}
	
	

}
