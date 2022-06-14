package Test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Core.BaseTest;
import Page.ContasPage;
import Page.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTeste extends BaseTest{

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();
    
    @Test
    public void teste1_InserirConta(){
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Conta Suite");
        contasPage.salvar();
        
        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());

    }

    @Test
    public void teste2_AlterarConta(){
        menuPage.acessarTelaListarConta();
        contasPage.clicarAlterarConta("Conta Suite");
        contasPage.setNome("Conta Suite Alterada");
        contasPage.salvar();
        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void teste3_InserirContaMesmoNome(){
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Conta Suite Alterada");
        contasPage.salvar();
        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
    }
   
}
