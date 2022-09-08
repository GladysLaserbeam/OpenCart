package com.test.orangehrm;

import org.testng.annotations.DataProvider;

public class OrangeHrmDataProviderClass {

    @DataProvider(name = "sentrifugologincheck")
    public Object[][]getloginPage() {
        return new Object[][]{
                {"EM01", "sentrifugo"},
                {"EM02", "sentrifugo"},
                {"EM03", "sentrifugo"},
                {"EM04", "sentrifugo"},
                {"EM05", "sentrifugo"},
                {"EM06", "sentrifugo"},
                {"EM07", "sentrifugo"},
                {"AGCY8", "sentrifugo"},
                {"US09", "sentrifugo"},


        };
    }
    @DataProvider(name = "HrmcreateAccount")
    public Object[][]getloginInfo(){
        return new Object[][]{
                {"ESS","Gladys","gladysL222","Disabled","gladyspass3412","gladyspass3412"},
                {"Admin","Tim","timothyawre23","Disabled","timtimbot23","timtimbot23"},
                {"ESS","Anna","annapanna45","Disabled","welovekel2345","welovekel2345"},

        };
    }
}
