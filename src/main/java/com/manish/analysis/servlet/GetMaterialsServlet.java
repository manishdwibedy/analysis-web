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
import com.manish.model.Material;


/**
 * Servlet implementation class GetMaterialsServlet
 */
public class GetMaterialsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
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
		
		response.setContentType("application/json");     
		
		String json = FetchMaterials.getMaterials();
		
		Type listType = new TypeToken<ArrayList<Material>>() {}.getType();
        
		List<Material> materials = new Gson().fromJson(json, listType);
		
		
		GenericModel model = convert(materials);
		writer.print(new Gson().toJson(model));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private GenericModel convert(List<Material> materials)
	{
		GenericModel model = new GenericModel();
		String[][] data= new String [materials.size()][5];
		int count = 0;
		for(Material material : materials)
		{
			String[] materialData = new String[5];
			materialData[0] = material.getCode();
			materialData[1] = new String(material.getDescription());
			materialData[2] = material.getUnit();
			materialData[3] = String.valueOf(material.getQuantity());
			materialData[4] = String.valueOf(material.getPrice());
			
			data[count++] = materialData;
		}
		model.setData(data);
		return model;
		
	}

}
