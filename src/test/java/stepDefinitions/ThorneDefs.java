package stepDefinitions;

import POM.AIChatWindowPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class ThorneDefs {
	AIChatWindowPage aiChatWindowPage=null;

	@Given("I am a user accessing thorne website")
	public void I_am_a_user_accessing_thorne_website() {
		aiChatWindowPage = new AIChatWindowPage();
		System.out.println("I am already on thorne website");

	}
	
	@When("I click on product assistant icon")
	public void I_click_on_product_assistant_icon() {
		if(aiChatWindowPage.isOverLayFrameDisplayed()){
			aiChatWindowPage.closeModal();
		}
		aiChatWindowPage.clickOnTaiaIcon();
		System.out.println("Clicking on taia icon");
	}
	
	@Then("AI Chat window should get opened")
	public void AI_Chat_window_should_get_opened() throws Exception {
		if(aiChatWindowPage.isChatWindowFrameDisplayed()){
			aiChatWindowPage.switchToFrame();
			Assert.assertTrue(aiChatWindowPage.isWelcomeTextDisplayed());
			Assert.assertTrue(aiChatWindowPage.isTextBoxDisplayed());
		}else{
          throw new Exception("AI Chat window is not displayed");
		}
	}

}
