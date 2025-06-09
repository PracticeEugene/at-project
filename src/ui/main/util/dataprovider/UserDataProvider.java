package src.ui.main.util.dataprovider;

import org.testng.annotations.DataProvider;

import static src.ui.main.commom.UserCredentials.*;

public class UserDataProvider {

    @DataProvider
    public Object[][] getAllUsers() {
        return new Object[][]{
                {STANDARD_USER},
                {LOCKED_OUT_USER},
                {INVALID_USER}
        };
    }
}