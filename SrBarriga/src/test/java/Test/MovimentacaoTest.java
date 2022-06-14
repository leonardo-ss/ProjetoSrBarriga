package Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Core.BaseTest;
import Page.MenuPage;
import Page.MovimentacaoPage;
import Utils.DataUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest{

    private MenuPage menuPage = new MenuPage();
    private MovimentacaoPage movPage = new MovimentacaoPage();

    @Test
    public void teste1_inserirMovimentacao(){
        menuPage.acessarTelaCriarMovimentacao();

        movPage.setDataMovimentacao(DataUtils.obterDataFormatada(new Date()));
        movPage.setDataPagamento(DataUtils.obterDataFormatada(new Date()));
        movPage.setDescricao("Movimentação do Teste");
        movPage.setInteressado("Conta do Teste");
        movPage.setValor("200");
        movPage.setConta("Conta Suite Alterada");
        movPage.setStatusPago();
        movPage.salvar();

        Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
    }

    @Test
    public void teste2_CamposObrigatorios(){
        menuPage.acessarTelaCriarMovimentacao();

        movPage.salvar();
        List<String> erros = movPage.obterErros();
    //  desse modo tem que colocar os erros em ordem começando com o index 0
    //  Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
    
    //  dessa forma tera que fazer uma linha para cada erro mas não importa a ordem
    //  Assert.assertTrue(erros.contains( "mas talvez seja pq as Dr.a não querem que seja home tbm"));

        Assert.assertTrue(erros.containsAll(Arrays.asList(
            "Data da Movimentação é obrigatório",
            "Data do pagamento é obrigatório",
            "Descrição é obrigatório",
            "Interessado é obrigatório",
            "Valor é obrigatório",
            "Valor deve ser um número"
        )));
        Assert.assertEquals(6, erros.size());    
    }

    @Test
    public void teste3_MovimentacaoFutura(){
        menuPage.acessarTelaCriarMovimentacao();

        Date dataFutura = DataUtils.obterDataComDiferencaDeDias(5);

        String obterDataFormatada = DataUtils.obterDataFormatada(dataFutura);
        movPage.setDataMovimentacao(obterDataFormatada);
        movPage.setDataPagamento(obterDataFormatada);
        movPage.setDescricao("Movimentação do Teste");
        movPage.setInteressado("Conta do Teste");
        movPage.setValor("5000");
        movPage.setConta("Conta Suite Alterada");
        movPage.setStatusPago();
        movPage.salvar();

        List<String> erros = movPage.obterErros();
        Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
        Assert.assertEquals(1, erros.size());
    }
    
}
