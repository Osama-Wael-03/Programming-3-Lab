/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;

/**
 *
 * @author acer
 */
public class ViewManager {

    public static LoginPage logPage;
    public static CurrencyConversionPage conversionPage;

    private ViewManager() {
    }

    public static void openLoginPage() {
        if (logPage == null) {
            logPage = new LoginPage();
            logPage.show();
        } else {
            logPage.show();
        }

    }

    public static void closeRLoginPage() {
        if (logPage != null) {
            logPage.close();
        }
    }

    public static void openConversionPage() throws IOException {
        if (conversionPage == null) {
            conversionPage = new CurrencyConversionPage();
            conversionPage.show();
        } else {
            conversionPage.show();
        }

    }

    public static void closeConversionPage() {
        if (conversionPage != null) {
            conversionPage.close();
            
        }
    }
}
