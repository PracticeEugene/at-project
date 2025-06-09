package ui.util.dataprovider;

import org.testng.annotations.DataProvider;

import static ui.commom.UserCredentials.*;

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