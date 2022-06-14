package Page;

import Core.BasePage;

public class MenuPage extends BasePage{

    public void acessarTelaInserirConta(){
        clicarLink("Contas");
        clicarLink("Adicionar");
    }

    public void acessarTelaListarConta(){
        clicarLink("Contas");
        clicarLink("Listar");
    }

    public void acessarTelaCriarMovimentacao(){
        clicarLink("Criar Movimentação");
    }

    public void acessarTelaResumo(){
        clicarLink("Resumo Mensal");
    }
    
}
