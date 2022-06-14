package Test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Core.BaseTest;
import Core.DriverFactory;
import Page.MenuPage;
import Page.ResumoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoMensalTeste extends BaseTest{
    private MenuPage menuPage = new MenuPage();
    private ResumoPage resumoPage = new ResumoPage();

    @Test
    public void teste1_ExcluirMovimentacao(){
       menuPage.acessarTelaResumo();
       
       resumoPage.excluirMovimentacao();
       Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
    }

    @Test
    public void teste2_ResumoMensal(){
        menuPage.acessarTelaResumo();

        Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());
    }
}
