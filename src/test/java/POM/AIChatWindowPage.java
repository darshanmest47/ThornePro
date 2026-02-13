package POM;

import Utilities.DriverFactory;
import Utilities.Waits.WaitClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AIChatWindowPage {


    public AIChatWindowPage(){
        PageFactory.initElements(DriverFactory.getWebDriver(),this);
    }

    @FindBy(xpath="(//img[@class='button-icon'])[1]")
    private WebElement taiaIcon;

    @FindBy(id="widget-iframe")
    private WebElement chatWindowFrame;

    @FindBy(xpath ="//p[contains(text(),'Hello, I’m Taia, your AI')]" )
    private WebElement welcomeText;

    @FindBy(xpath="//textarea[@aria-label='chat with taia']")
    private WebElement textBox;

    @FindBy(xpath="//iframe[@aria-label='Modal Overlay Box Frame']")
    private WebElement overlayFrame;

    @FindBy(xpath="//div[@id='button2_wrapper']/button[@aria-label='Open Another Modal']")
    private WebElement closeModalIcon;

    public void closeModal(){
        closeModalIcon.click();
    }
    public boolean isOverLayFrameDisplayed(){
        try{
            WebDriverWait wait = WaitClass.webDriverWait();
            wait.until(ExpectedConditions.visibilityOf(overlayFrame));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
           return false;
        }


    }

    public boolean isTextBoxDisplayed(){
        return textBox.isDisplayed();
    }

    public boolean isWelcomeTextDisplayed(){
        return welcomeText.isDisplayed();
    }

    public boolean isChatWindowFrameDisplayed(){
        return chatWindowFrame.isDisplayed();
    }

    public void switchToFrame(){
        DriverFactory.getWebDriver().switchTo().frame(chatWindowFrame);
    }

    public void clickOnTaiaIcon(){
        WebDriverWait wait = WaitClass.webDriverWait();
        wait.until(ExpectedConditions.visibilityOf(taiaIcon));
        taiaIcon.click();
    }


}
