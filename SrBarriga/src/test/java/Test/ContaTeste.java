package Test;

import org.junit.Assert;
import org.junit.Test;

import Core.BaseTest;
import Page.ContasPage;
import Page.MenuPage;

public class ContaTeste extends BaseTest{

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();
    
    @Test
    public void testeInserirConta(){
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Teste 1");
        contasPage.salvar();
        
        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());

    }

    @Test
    public void testAlterarConta(){
        menuPage.acessarTelaListarConta();
        contasPage.clicarAlterarConta("Teste 1");
        contasPage.setNome("Alterada");
        contasPage.salvar();
        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }
}
