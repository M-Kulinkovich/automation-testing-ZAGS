package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("URL");
            driver.manage().window().maximize();

//        Login page
            WebElement login_user = driver.findElement(By.xpath("//*/button[text()='Войти как пользователь']"));
            login_user.click();

//       Applicants details
            WebElement lastname = driver.findElement(By.id("TextInputField-1"));
            lastname.sendKeys("Orlov");
            WebElement firstname = driver.findElement(By.id("TextInputField-2"));
            firstname.sendKeys("Pavel");
            WebElement surname = driver.findElement(By.id("TextInputField-3"));
            surname.sendKeys("Valentinovich");
            WebElement phone_number = driver.findElement(By.id("TextInputField-4"));
            phone_number.sendKeys("3752922233344");
            WebElement passport_number = driver.findElement(By.id("TextInputField-5"));
            passport_number.sendKeys("MP1234567");
            WebElement address = driver.findElement(By.id("TextInputField-6"));
            address.sendKeys("street 2");
            WebElement next_button = driver.findElement(By.xpath("//*/button[text()='Далее']"));
            next_button.click();

//        Service selection
            WebElement birthday_button = driver.findElement(By.xpath("//*/button[text()='Регистрация рождения']"));
            birthday_button.click();

//        Citizen data
            WebElement lastname_citizen = driver.findElement(By.id("TextInputField-7"));
            lastname_citizen.sendKeys("Orlov");
            WebElement firstname_citizen = driver.findElement(By.id("TextInputField-8"));
            firstname_citizen.sendKeys("Evgeniy");
            WebElement surname_citizen = driver.findElement(By.id("TextInputField-9"));
            surname_citizen.sendKeys("Pavlovich");
            WebElement date_birth = driver.findElement(By.id("TextInputField-10"));
            date_birth.sendKeys("2024-11-25");
            WebElement passport_number_citizen = driver.findElement(By.id("TextInputField-11"));
            passport_number_citizen.sendKeys("AB1234567");
            WebElement sex = driver.findElement(By.id("TextInputField-12"));
            sex.sendKeys("Male");
            WebElement next_button_citizen = driver.findElement(By.xpath("//*/button[text()='Далее']"));
            next_button_citizen.click();

//        Service data
            WebElement place_birth = driver.findElement(By.id("TextInputField-13"));
            place_birth.sendKeys("Moskow");
            WebElement mother_name = driver.findElement(By.id("TextInputField-14"));
            mother_name.sendKeys("Olga");
            WebElement father_name = driver.findElement(By.id("TextInputField-15"));
            father_name.sendKeys("Pavel");
            WebElement finish_button = driver.findElement(By.xpath("//*/button[text()='Завершить']"));
            finish_button.click();

            WebElement successMessage = driver.findElement(By.xpath("//*/span[text()='Ваша заявка отправлена на рассмотрение.']"));
            String successText = successMessage.getText();

            if (successText.equals("Ваша заявка отправлена на рассмотрение.")) {
                System.out.println("Test Passed!");
            } else {
                System.out.println("Test Failed!");
            }


        } catch (Exception e) {
            System.out.println("Test failed");
        } finally {
            driver.quit();
        }

    }
}