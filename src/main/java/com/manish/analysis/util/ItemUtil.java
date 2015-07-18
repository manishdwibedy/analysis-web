package com.manish.analysis.util;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.manish.analysis.db.Connection;
import com.manish.analysis.model.BasicRateJson;
import com.manish.analysis.model.ItemJson;
import com.manish.model.Carriage;
import com.manish.model.Constants;
import com.manish.model.Hire;
import com.manish.model.Item;
import com.manish.model.ItemInput;
import com.manish.model.Labour;
import com.manish.model.Material;
import com.manish.util.ItemUtils;
import com.manish.util.ParsingItemsUtils;

public class ItemUtil {

	private static String numbersPresentPattern = "(.)*(\\d)+(.)*";
	private static Pattern numbersPresentRegex;
	
	static{
		numbersPresentRegex = Pattern.compile(numbersPresentPattern);
	}
	
	public static Item getItem(String code) {
		// TODO Auto-generated method stub
		// get our query builder from the DAO
		QueryBuilder<Item, ?> queryBuilder = Connection.getItemDao().queryBuilder();
		// the 'title' field must be equal to title (a variable)
		try {
			queryBuilder.where().eq("code", code);
			
			// prepare our sql statement
			PreparedQuery<Item> preparedQuery = queryBuilder.prepare();
			
			// query for all stories that have that title
			List<Item> itemsList = Connection.getItemDao().query(preparedQuery);

			return itemsList.get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static ItemJson convertItem(Item item)
	{
		Map<String,Float> hireMap = new HashMap<String,Float>();
		Map<String,Float> labourMap = new HashMap<String,Float>();
		Map<String,Float> carriageMap = new HashMap<String,Float>();
		Map<String,Float> materialMap = new HashMap<String,Float>();
		
		List<Hire> hires = new ArrayList<Hire>();
		List<Labour> labours = new ArrayList<Labour>();
		List<Material> materials = new ArrayList<Material>();
		List<Carriage> carriages = new ArrayList<Carriage>();
		List<Constants> constants = new ArrayList<Constants>();
		
//		List<String> hireCodes = new ArrayList<String>();
//		List<String> labourCodes = new ArrayList<String>();
//		List<String> materialCodes = new ArrayList<String>();
//		List<String> carriageCodes = new ArrayList<String>();
		
		List<BasicRateJson> inputs = new ArrayList<BasicRateJson>();
		int count = 0;
		ItemJson itemJson = new ItemJson();
		
		itemJson.setCode(item.getCode());
		itemJson.setDescription(new String(item.getDescription()));
		itemJson.setQuantity(item.getQuantity());
		itemJson.setUnit(item.getUnit());
		itemJson.setPrice(item.getPrice());
		
		Type type = new TypeToken<List<ItemInput>>(){}.getType();
		ArrayList<ItemInput> inpList = new Gson().fromJson(new String(item.getItemInput()), type);
		
		for(ItemInput input : inpList)
		{
			try{
				int code = Integer.parseInt(input.getCode());
				if(code<100)
				{
					hireMap.put(input.getCode(), input.getQuantity());
				}
				else if (code<200)
				{
					labourMap.put(input.getCode(), input.getQuantity());
				}
				else if(code>=2200 && code<=2357)
				{
					carriageMap.put(input.getCode(), input.getQuantity());
				}
				else
				{
					materialMap.put(input.getCode(), input.getQuantity());	
				}
			}
			catch(NumberFormatException nfe)
			{
				if(!input.getCode().contains("."))
				{
					constants.add(BaseRateUtil.convert2Constant(input));
				}
				else
				{
					inputs.add(convert2Basic(input));
				}
			}
		}
		
		if(materialMap.size()>0)
		{
			Set<String> materialCodesSet = materialMap.keySet();
			List<String> materialCodes = new ArrayList<String>();
			materialCodes.addAll(materialCodesSet);
			List<Material> materialList = BaseRateUtil.getMaterial(materialCodes);
			
			for(Material material : materialList)
			{
				material.setQuantity(materialMap.get(material.getCode()));
				BasicRateJson materialInput = new BasicRateJson();
				materialInput.setCode(material.getCode());
				materialInput.setDescription(new String(material.getDescription()));
				materialInput.setPrice(material.getPrice());
				materialInput.setUnit(material.getUnit());
				materialInput.setQuantity(material.getQuantity());
				inputs.add(materialInput);
			}
		}
		if(labourMap.size()>0)
		{
			Set<String> labourCodesSet = labourMap.keySet();
			List<String> labourCodes = new ArrayList<String>();
			labourCodes.addAll(labourCodesSet);
			List<Labour> labourList = BaseRateUtil.getLabour(labourCodes);
			
			for(Labour labour : labourList)
			{
				labour.setQuantity(labourMap.get(labour.getCode()));
				BasicRateJson labourInput = new BasicRateJson();
				labourInput.setCode(labour.getCode());
				labourInput.setDescription(new String(labour.getDescription()));
				labourInput.setPrice(labour.getPrice());
				labourInput.setUnit(labour.getUnit());
				labourInput.setQuantity(labour.getQuantity());
				inputs.add(labourInput);
			}
		}
		if(hireMap.size()>0)
		{
			Set<String> hireCodesSet = hireMap.keySet();
			List<String> hireCodes = new ArrayList<String>();
			hireCodes.addAll(hireCodesSet);
			List<Hire> hireList = BaseRateUtil.getHire(hireCodes);
			
			for(Hire hire : hireList)
			{
				hire.setQuantity(hireMap.get(hire.getCode()));
				BasicRateJson hireInput = new BasicRateJson();
				hireInput.setCode(hire.getCode());
				hireInput.setDescription(new String(hire.getDescription()));
				hireInput.setPrice(hire.getPrice());
				hireInput.setUnit(hire.getUnit());
				hireInput.setQuantity(hire.getQuantity());
				inputs.add(hireInput);
			}
		}
		if(carriageMap.size()>0)
		{
			Set<String> carriageCodesSet = carriageMap.keySet();
			List<String> carriageCodes = new ArrayList<String>();
			carriageCodes.addAll(carriageCodesSet);
			List<Carriage> carriageList = BaseRateUtil.getCarriage(carriageCodes);
			
			for(Carriage carriage : carriageList)
			{
				carriage.setQuantity(carriageMap.get(carriage.getCode()));
				BasicRateJson carriageInput = new BasicRateJson();
				carriageInput.setCode(carriage.getCode());
				carriageInput.setDescription(new String(carriage.getDescription()));
				carriageInput.setPrice(carriage.getPrice());
				carriageInput.setUnit(carriage.getUnit());
				carriageInput.setQuantity(carriage.getQuantity());
				inputs.add(carriageInput);
			}
		}
		if(constants.size() > 0)
		{
			List<String> constantCodes = new ArrayList<String>();
			List<BasicRateJson> constantsList = new ArrayList<BasicRateJson>();
			for(Constants constant: constants)
			{
				constantCodes.add(constant.getCode());
			}
			
			List<Constants> constantList = BaseRateUtil.getConstant(constantCodes);
			for(Constants constant : constantList)
			{
				BasicRateJson input = new BasicRateJson();
				input.setDescription(new String(constant.getDescription()));
				input.setPrice(constant.getPrice());
				constantsList.add(input);
			}
			itemJson.setConstants(constantsList);
		}
		itemJson.setInputs(inputs);
		return itemJson;
		
	}
	

	public static BasicRateJson convert2Basic(ItemInput input) {
		// TODO Auto-generated method stub
		BasicRateJson inputObj = new BasicRateJson();
		
		Item item = ItemUtil.getItem(ItemUtils.stripZeroes(input.getCode()));
		inputObj.setCode(ItemUtils.stripZeroes(input.getCode()));
		inputObj.setDescription(new String(item.getDescription()));
		inputObj.setUnit(item.getUnit());
		inputObj.setPrice(item.getPrice());
		//inputObj.set
		inputObj.setQuantity(input.getQuantity());
		return inputObj;
	}
	

	public static boolean containsNumbers(String line)
	{
		return numbersPresentRegex.matcher(line).matches();
	}
	
}
