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
        contasPage.setNome("Conta do Teste");
        contasPage.salvar();
        
        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());

    }

    @Test
    public void testAlterarConta(){
        menuPage.acessarTelaListarConta();
        contasPage.clicarAlterarConta("Conta do Teste");
        contasPage.setNome("Conta do Teste alterada");
        contasPage.salvar();
        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void testInserirContaMesmoNome(){
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Conta do Teste alterada");
        contasPage.salvar();
        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
    }
}
