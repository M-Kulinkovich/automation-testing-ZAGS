package org.example.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AdminTablePage {
    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger(AdminTablePage.class);

    @Getter
    @FindBy (css = ".MuiTable-root.MuiTable-stickyHeader")
    private WebElement adminTable;
    @FindBy (css = ".MuiTableRow-root")
    private List<WebElement> rows;
    @FindBy (xpath = "//*/button[text()='Обновить']")
    private WebElement updateButton;
    @FindBy (xpath = "//*/button[text()='Закрыть']")
    private WebElement exitButton;

    public AdminTablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Нажатие кнопки 'Одобрить заявку'")
    public void clickApproveButton(int rowIndex) {
        logger.info("Changing status to approve");

        String xpath = String.format("//table/tr[%d]/td[6]/div/button[1]", rowIndex);
        WebElement approveButton = driver.findElement(By.xpath(xpath));
        approveButton.click();
    }

    @Step("Нажатие кнопки 'Отклонить заявку'")
    public void clickRejectButton(int rowIndex) {
        logger.info("Changing status to reject");

        String xpath = String.format("//table/tr[%d]/td[6]/div/button[2]", rowIndex);
        WebElement rejectButton = driver.findElement(By.xpath(xpath));
        rejectButton.click();
    }

    @Step("Получение всех строк в таблице с заявками")
    public List<String> getRowData(int rowIndex) {
        logger.info("getting all request rows");

        List<String> rowData = new ArrayList<>();
        WebElement row = rows.get(rowIndex - 1);
        List<WebElement> cells = row.findElements(By.tagName("td"));
        for (WebElement cell : cells) {
            rowData.add(cell.getText());
        }
        return rowData;
    }

    @Step ("Получения статуса заявки")
    public String getStatus(int rowIndex) {
        logger.info("getting status");

        String xpath = String.format("//table/tr[%d]/td[5]", rowIndex);
        WebElement statusCell = driver.findElement(By.xpath(xpath));
        return statusCell.getText();
    }
}