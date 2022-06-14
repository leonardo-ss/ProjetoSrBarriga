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
        contasPage.setNome("Conta do");
        contasPage.salvar();
        
        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());

    }

    @Test
    public void testAlterarConta(){
        menuPage.acessarTelaListarConta();
        contasPage.clicarAlterarConta("Conta do");
        contasPage.setNome("Conta do Teste al");
        contasPage.salvar();
        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void testInserirContaMesmoNome(){
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Conta do Teste al");
        contasPage.salvar();
        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
    }

    @Test
    public void excluirContaComMovimentacao(){
        menuPage.acessarTelaListarConta();

        contasPage.clicarExcluirConta("Conta do Teste alterada");
        Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
    }
}
