package com.oversight.dataprovider;

import com.oversight.utility.NewExcelLibrary;
import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.Map;

public class DataProviders {

    NewExcelLibrary obj = new NewExcelLibrary();

    @DataProvider(name = "loginCredentials")
    public Object[][] getLoginData() {
        return getDataFromSheet("credentials");
    }

    @DataProvider(name = "UnSuccessLoginCredentials")
    public Object[][] getUnSuccessLoginData() {
        return getDataFromSheet("WrongCredentials");
    }

    @DataProvider(name = "addBillNumberDetails")
    public Object[][] getBillNumberData() {
        return getDataFromSheet("billingAccount");
    }

    @DataProvider(name = "addBillingSpaceDetails")
    public Object[][] getAddBillingSpaceData() {
        return getDataFromSheet("billingSpace");
    }

    @DataProvider(name = "addSubSpaceDetails")
    public Object[][] getAddSubSpaceData() {
        return getDataFromSheet("subSpace");
    }

    @DataProvider(name = "addControllerDetails")
    public Object[][] getAddControllerData() {
        return getDataFromSheet("controller");
    }

    @DataProvider(name = "registerCredentials")
    public Object[][] getRegisterData() {
        return getMapDataSheet("register");
    }

    @DataProvider(name = "addDeviceDetails")
    public Object[][] getDeviceData() {
        return getMapDataSheet("device");
    }

    public Object[][] getDataFromSheet(String SheetName){

        int rows = obj.getRowCount(SheetName);
        int column = obj.getColumnCount(SheetName);
        int actRows = rows-1;

        Object [][] data = new Object[actRows][column];

        for(int i=0; i<actRows;i++){

            for(int j=0; j<column; j++){

                data[i][j] = obj.getCellData(SheetName, j, i + 2);

            }

        }
        return data;

    }

    public Object[][] getMapDataSheet(String sheet){

        int rows = obj.getRowCount(sheet);
        int column = obj.getColumnCount(sheet);
        int actRows = rows-1;

        Object [][] data = new Object[actRows][1];

        for (int i = 0; i < actRows; i++) {
            Map<String, String> hashMap = new HashMap<>();
            for (int j = 0; j < column; j++) {
                hashMap.put(obj.getCellData(sheet, j, 1),
                        obj.getCellData(sheet, j, i + 2));
            }
            data[i][0]=hashMap;

        }
        return data;

    }


}
