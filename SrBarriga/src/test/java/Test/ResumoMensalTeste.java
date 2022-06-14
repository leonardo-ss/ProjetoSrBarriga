package Test;

import org.junit.Assert;
import org.junit.Test;

import Core.BaseTest;
import Core.DriverFactory;
import Page.MenuPage;
import Page.ResumoPage;

public class ResumoMensalTeste extends BaseTest{
    private MenuPage menuPage = new MenuPage();
    private ResumoPage resumoPage = new ResumoPage();

    @Test
    public void testeExcluirMovimentacao(){
       menuPage.acessarTelaResumo();
       
       resumoPage.excluirMovimentacao();
       Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
    }

    @Test
    public void testResumoMensal(){
        menuPage.acessarTelaResumo();

        Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());
    }
}
