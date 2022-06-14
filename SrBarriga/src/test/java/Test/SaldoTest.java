package Test;

import org.junit.Assert;
import org.junit.Test;

import Core.BaseTest;
import Page.HomePage;

public class SaldoTest extends BaseTest{
    HomePage homePage = new HomePage();


    @Test
    public void testSaldoConta(){
        Assert.assertEquals("200.00", homePage.obterSaldoConta("Conta Suite Alterada"));
    }
    
}
