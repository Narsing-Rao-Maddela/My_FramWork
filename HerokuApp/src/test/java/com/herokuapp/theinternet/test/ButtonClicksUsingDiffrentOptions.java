package com.herokuapp.theinternet.test;

import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.PressButtonUsingKeysActions;

public class ButtonClicksUsingDiffrentOptions extends BaseTest {

	
	

	@Test(priority = 0, groups = {  "stable" })
	public void clickByUsingKeys() {
		PressButtonUsingKeysActions actions = new PressButtonUsingKeysActions(driver, log);
		actions.pressButtonUsingKeys();
	}

	@Test(priority = 1, groups = {  "stable" })
	public void clickByUsingJSExe() {
		PressButtonUsingKeysActions actions = new PressButtonUsingKeysActions(driver, log);
		actions.clickUsingJSExe();
	}

	@Test(priority = 3, groups = {  "stable" })
	public void clickByUsingAct() {
		PressButtonUsingKeysActions actions = new PressButtonUsingKeysActions(driver, log);
		actions.clickUsingAct();
	}
	

}
