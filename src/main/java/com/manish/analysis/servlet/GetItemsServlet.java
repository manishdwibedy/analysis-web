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
import com.manish.analysis.model.BaseRateJson;
import com.manish.analysis.model.Data;
import com.manish.analysis.model.Metadata;
import com.manish.analysis.model.TableData;
import com.manish.analysis.util.Util;
import com.manish.model.Item;

/**
 * Servlet implementation class GetItemsServlet
 */
public class GetItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetItemsServlet() {
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
		
		String mode = request.getParameter("mode");
		String unit = request.getParameter("unit");
		String json = getItems(unit);
		
		Type listType = new TypeToken<ArrayList<Item>>() {}.getType();
        
		List<Item> items = new Gson().fromJson(json, listType);
		data.setData(convert(items));
		
		
		
		List<Metadata> metadataList = new ArrayList<Metadata>();
		
		for(String columnName : Util.getColumns())
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
	
	private List<TableData> convert(List<Item> items)
	{
		int count = 0;
		List<TableData> itemList = new ArrayList<TableData>();
		for(Item item : items)
		{
			TableData data = new TableData();
			data.setId(++count);
			BaseRateJson itemObj = new BaseRateJson();
			itemObj.setCode(item.getCode());
			itemObj.setDescription(new String(item.getDescription()));
			itemObj.setUnit(item.getUnit());
			itemObj.setQuantity(item.getQuantity());
			itemObj.setPrice(item.getPrice());
			
			data.setValues(itemObj);
			itemList.add(data);
		}
		return itemList;
		
	}
	
	public static String getItems(String unit) {
		// TODO Auto-generated method stub
		// get our query builder from the DAO
		QueryBuilder<Item, ?> queryBuilder = Connection.getItemDao().queryBuilder();
		// the 'title' field must be equal to title (a variable)
		try {
			if(unit!=null)
			{
				queryBuilder.where().like("code", unit+"%");
			}
			
			// prepare our sql statement
			PreparedQuery<Item> preparedQuery = queryBuilder.prepare();
			
			// query for all stories that have that title
			List<Item> itemsList = Connection.getItemDao().query(preparedQuery);

			return new Gson().toJson(itemsList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
