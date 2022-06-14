package Test;

import org.junit.Assert;
import org.junit.Test;

import Core.BaseTest;
import Page.ContasPage;
import Page.MenuPage;

public class RemoverContaMovimentacaoContaTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();
    
    @Test
    public void testeExcluirContaComMovimentacao(){
        menuPage.acessarTelaListarConta();

        contasPage.clicarExcluirConta("Conta Suite Alterada");
        Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
    }
}
