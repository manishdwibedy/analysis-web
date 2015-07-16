package com.manish.analysis.model;

import java.util.List;

public class ItemJson extends BasicRateJson{
	
	private List<BasicRateJson> inputs;
	private List<BasicRateJson> constants;

	public List<BasicRateJson> getConstants() {
		return constants;
	}

	public void setConstants(List<BasicRateJson> constants) {
		this.constants = constants;
	}

	public List<BasicRateJson> getInputs() {
		return inputs;
	}

	public void setInputs(List<BasicRateJson> inputs) {
		this.inputs = inputs;
	}

}
