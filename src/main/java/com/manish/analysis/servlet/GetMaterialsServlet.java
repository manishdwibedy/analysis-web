package com.manish.analysis.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.manish.analysis.model.GenericModel;
import com.manish.analysis.model.MaterialJson;
import com.manish.analysis.model.Metadata;
import com.manish.model.Material;


/**
 * Servlet implementation class GetMaterialsServlet
 */
public class GetMaterialsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private String[] columns = new String[]{"code","description","unit","quantity","price"};
    public GetMaterialsServlet() {
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
		
		String json = FetchMaterials.getMaterials();
		
		Type listType = new TypeToken<ArrayList<Material>>() {}.getType();
        
		List<Material> materials = new Gson().fromJson(json, listType);
		data.data = convert(materials);
		
		//GenericModel model = convert(materials);
		//writer.print(new Gson().toJson(model));
		String mode = request.getParameter("mode");
		
		List<Metadata> metadataList = new ArrayList<Metadata>();
		
		for(String columnName : columns)
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
		data.metadata = metadataList;
		writer.write(new Gson().toJson(data));
		/*PrintWriter writer = response.getWriter();
		
		response.setContentType("application/json");     
		
		String json = FetchMaterials.getMaterials();
		
		Type listType = new TypeToken<ArrayList<Material>>() {}.getType();
        
		List<Material> materials = new Gson().fromJson(json, listType);
		
		
		GenericModel model = convert(materials);
		writer.print(new Gson().toJson(model));*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private List<TableData> convert(List<Material> materials)
	{
		int count = 0;
		List<TableData> materialList = new ArrayList<TableData>();
		for(Material material : materials)
		{
			TableData data = new TableData();
			data.id = ++count;
			//String[] materialData = new String[5];
			MaterialJson materialObj = new MaterialJson();
			materialObj.setCode(material.getCode());
			materialObj.setDescription(new String(material.getDescription()));
			materialObj.setUnit(material.getUnit());
			materialObj.setQuantity(material.getQuantity());
			materialObj.setPrice(material.getPrice());
			
			data.values = materialObj;
			materialList.add(data);
		}
		return materialList;
		
	}
	
	

}

class Data{
	List<Metadata> metadata;
	List<TableData> data;
}

class TableData{
	int id;
	MaterialJson values;
}