package tests;

import framework.ConfigTest;
import org.junit.Test;
import pageObject.GooglePO;

import java.util.ArrayList;
import java.util.List;

public class TestsExecution extends ConfigTest {

    static String sUrl = "https://www.google.com.br";
    static String sDirectorName = "Steven Spielberg";
    static String sMovieName = "Jurassic Park";

    static GooglePO po = new GooglePO();

    @Test
    public void testCadastro() {
        driver = setUpDriver();
        openBrowser(sUrl);
        po.setTxtSearch(sDirectorName,sMovieName);
        po.clickBtnSearch();
        String sResult = po.getResult();
        System.out.println("Resultado esperado:"+sResult);
        closeBrowser();
    }

}
