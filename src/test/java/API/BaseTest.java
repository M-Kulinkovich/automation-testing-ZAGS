package API;

import API.config.Specifications;
import io.qameta.allure.Epic;
import org.testng.annotations.BeforeClass;

@Epic ("API tests")
public abstract class BaseTest {

    @BeforeClass
    public void setup() {
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpecOK200());
    }

}
