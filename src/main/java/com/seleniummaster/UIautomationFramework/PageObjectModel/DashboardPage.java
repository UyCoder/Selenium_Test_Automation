package com.seleniummaster.UIautomationFramework.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Ahmet Bughra
 * @create 2020-01-14-10:03 PM
 * @email bughra1991@gmail.com
 */
public class DashboardPage {
    WebDriver driver;
    @FindBy(linkText = "Admin Boss")
    WebElement adminLinkText;
    @FindBy(id = "user_nav_link")
    WebElement adminUserNavigationLink;
    @FindBy(css = "span[class=\"user-info\"]")
    WebElement commonUserInfoElement;
    @FindBy(css = "a[id='nav_clients']")
    WebElement clientLink;
    @FindBy(css = "a[id='menu_new_client_link']")
    WebElement newClientLink;
    @FindBy(id = "client_last_name")
    WebElement lastNameField;
    @FindBy(id = "client_first_name")
    WebElement firstNameField;
    @FindBy(css = "input[id='client_gender_male']")
    WebElement maleRadioButton;
    @FindBy(css = "input[id='client_gender_female']")
    WebElement femaleRadioButton;
    @FindBy(css = "input[id='client_is_vip']")
    WebElement vipCheckbox;
    @FindBy(css = "input[id='client_birth_date']")
    WebElement birthdateField;
    @FindBy(css = "input[id='client_medicare_number']")
    WebElement medicareNumberField;
    @FindBy(css = "select[name='client[private_health_fund_id]']")
    WebElement privateHealthFundDropdown;
    @FindBy(css = "input[name='client[mobile]']")
    WebElement mobileField;
    @FindBy(css = "input[id='client_email']")
    WebElement emailField;
    @FindBy(css = "input[id='client_address_line_1']")
    WebElement addressField;
    @FindBy(css = "input[id='client_suburb']")
    WebElement suburbField;
    @FindBy(css = "input[id='client_post_code']")
    WebElement postalCodeField;
    @FindBy(css = "select[id='client_referral_id'")
    WebElement referralSourceDropdown;
    @FindBy(css = "input[id='client_occupation']")
    WebElement occupationField;
    @FindBy(css = "input[id='client_notes']")
    WebElement noteField;
    @FindBy(css = "input[name='commit']")
    WebElement submitButton;
    @FindBy(css = "b.red")
    WebElement clientConfirmationText;
    int timetout = 30;
    PageFunctions pageFunctions;


    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
        pageFunctions = new PageFunctions(driver);
    }

    public void clickDashboardUserNavigationLink() {
        pageFunctions.waitForElementVisible(adminUserNavigationLink, timetout);
        adminUserNavigationLink.click();
    }

    public boolean isAdminUserLinkTextDisplayed() {
        pageFunctions.waitForElementVisible(adminLinkText, timetout);
        return adminLinkText.isDisplayed();
    }

    public boolean isCommonUserInfoElementDisplayed() {
        pageFunctions.waitForElementVisible(commonUserInfoElement, timetout);
        return commonUserInfoElement.isDisplayed();
    }

    public boolean waitForUserInfoLinkDisplayed() {
        pageFunctions.waitForElementVisible(commonUserInfoElement, timetout);
        boolean isUserInfoLinkDisplayed = commonUserInfoElement.isDisplayed();
        return isUserInfoLinkDisplayed;
    }

    public boolean addNewClient(String lastName, String firstName, boolean male, boolean vip,
                                String birthDate, String medicareNumber, String privateHealthFund,
                                String phone, String email, String address, String suburb,
                                int postCode, String referralSource, String occupation, String note) throws InterruptedException {

        //define add new client
        pageFunctions.waitForElementVisible(clientLink, timetout);
        clientLink.click();
        pageFunctions.waitForElementVisible(newClientLink, timetout);
        newClientLink.click();
        pageFunctions.waitForElementVisible(lastNameField, timetout);
        lastNameField.sendKeys(lastName);
        pageFunctions.waitForElementVisible(firstNameField, timetout);
        firstNameField.sendKeys(firstName);
        if (male) {
            pageFunctions.waitForElementVisible(maleRadioButton, timetout);
            maleRadioButton.click();
        } else {
            pageFunctions.waitForElementVisible(femaleRadioButton, timetout);
            femaleRadioButton.click();
        }
        if (vip) {
            pageFunctions.waitForElementVisible(vipCheckbox, timetout);
            vipCheckbox.click();
        }
        pageFunctions.waitForElementVisible(birthdateField, timetout);
        birthdateField.sendKeys(birthDate);

        pageFunctions.waitForElementVisible(medicareNumberField, timetout);
        medicareNumberField.sendKeys(medicareNumber);

        pageFunctions.waitForElementVisible(privateHealthFundDropdown, timetout);
        Select PrivatehealthFund = new Select(privateHealthFundDropdown);
        PrivatehealthFund.selectByVisibleText(privateHealthFund);

        pageFunctions.waitForElementVisible(mobileField, timetout);
        mobileField.sendKeys(phone);

        pageFunctions.waitForElementVisible(emailField, timetout);
        emailField.sendKeys(email);

        pageFunctions.waitForElementVisible(addressField, timetout);
        addressField.sendKeys(address);

        pageFunctions.waitForElementVisible(suburbField, timetout);
        suburbField.sendKeys(suburb);

        pageFunctions.waitForElementVisible(postalCodeField, timetout);
        postalCodeField.sendKeys(String.valueOf(postCode));

        pageFunctions.waitForElementVisible(referralSourceDropdown, timetout);
        Select ReferralSource = new Select(referralSourceDropdown);
        ReferralSource.selectByVisibleText(referralSource);

        pageFunctions.waitForElementVisible(occupationField, timetout);
        occupationField.sendKeys(occupation);

        pageFunctions.waitForElementVisible(noteField, timetout);
        noteField.sendKeys(note);

        pageFunctions.waitForElementVisible(submitButton, timetout);
        submitButton.click();

        pageFunctions.waitForElementVisible(clientConfirmationText, timetout);
        String confirmationText = clientConfirmationText.getText();

        System.out.println("confirmed name: " + confirmationText);
        if (confirmationText.contains(lastName))
            return true;
        else
            return false;

    }
}
