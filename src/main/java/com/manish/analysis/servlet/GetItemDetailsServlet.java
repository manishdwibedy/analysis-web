package com.manish.analysis.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manish.analysis.model.BasicRateJson;
import com.manish.analysis.model.Data;
import com.manish.analysis.model.ItemJson;
import com.manish.analysis.util.ItemUtil;
import com.manish.model.Item;

/**
 * Servlet implementation class GetItemDetailsServlet
 */
public class GetItemDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetItemDetailsServlet() {
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
		response.setContentType("text/xhtml");     
		
		String code = request.getParameter("code");
		Item item = ItemUtil.getItem(code);
		
		
		ItemJson itemJson = ItemUtil.convertItem(item);
		
		writer.write(generateTable(itemJson));
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private String generateTable(ItemJson item)
	{
		DecimalFormat twoPlaces = new DecimalFormat();
		twoPlaces.setMinimumFractionDigits(2);
		twoPlaces.setMaximumFractionDigits(2);
		
		DecimalFormat threePlaces = new DecimalFormat();
		threePlaces.setMinimumFractionDigits(2);
		threePlaces.setMaximumFractionDigits(3);
		
		
		String tableContent = "<div class='row'><div class='col-md-12'>";
		
		tableContent += "<div class='row'><div class='col-md-1'>" + item.getCode() + "</div><div class='col-md-11'>" + item.getDescription() + "</div></div>";
		
		tableContent += "<br/><hr class='item'><div class='row'><div class='col-md-1'>Code</div><div class='col-md-7'>Description</div><div class='col-md-1'>Unit</div>"+
							"<div class='col-md-1'>Quantity</div><div class='col-md-1'>Rate</div><div class='col-md-1'>Amount</div></div><hr class='item'><br/>";
		
		float price = 0.0f;
		for(BasicRateJson input : item.getInputs())
		{
			float inputPrice = input.getQuantity() * input.getPrice();
			tableContent += "<div class='row'><div class='col-md-1'>"+ getPaddedCode(input.getCode()) + "</div><div class='col-md-7'>" + input.getDescription() 
					+ "</div><div class='col-md-1'>" + input.getUnit() + "</div><div class='col-md-1'>" + threePlaces.format(input.getQuantity()) 
					+ "</div><div class='col-md-1'>" + twoPlaces.format(input.getPrice()) + "</div><div class='col-md-1'><span class='pull-right'>" + twoPlaces.format(inputPrice) + "</span></div></div>";
			price += inputPrice;
		}
		tableContent += "<div class='row'><div class='col-md-8'><span class='pull-right'>Total</span></div><div class='col-md-4'><span class='pull-right'>Rs. "+ twoPlaces.format(price) + "</span></div></div>";
		
		if(item.getConstants()!=null)
		{
			for(BasicRateJson constant : item.getConstants())
			{
				float constantPrice = constant.getPrice() / 100 * price;
				tableContent += "<div class='row'><div class='col-md-8'><span class='pull-right'>Adding for " + constant.getDescription() + " @ "+ constant.getPrice() 
						+"%</span></div><div class='col-md-4'><span class='pull-right'>Rs. "+ twoPlaces.format(constantPrice) + "</span></div></div>";
				price += constantPrice;
				tableContent += "<div class='row'><div class='col-md-8'><span class='pull-right'>Total " + "</span></div><div class='col-md-4'><span class='pull-right'>Rs. " +
							twoPlaces.format(price) + "</span></div></div>";
			}
		}
		
		tableContent += "<div class='row'><div class='col-md-8'><span class='pull-right'>Cost for " + item.getQuantity() + " " + item.getUnit() + 
				"</span></div><div class='col-md-4'><span class='pull-right'>Rs. "+ twoPlaces.format(price) + "</span></div></div>";
		
		if(item.getQuantity()>1)
		{
			tableContent += "<div class='row'><div class='col-md-8'><span class='pull-right'>Cost for 1 " + item.getUnit() 
					+ "</span></div><div class='col-md-4'><span class='pull-right'>Rs. "+ twoPlaces.format(price/item.getQuantity()) + "</span></div></div>";
		}
		
		tableContent += "</div></div>";
		
		return tableContent;
	}
	
	private String getPaddedCode(String code)
	{
		String pad = "";
		for(int len = code.length() ; len <= 4 ; len++)
		{
			pad += "0";
		}
		return pad + code;
	}

}
