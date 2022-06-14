package Page;

import Core.BasePage;
import Core.DriverFactory;

public class LoginPage extends BasePage{
    
    public void acessarTelaInicial(){
        DriverFactory.getDriver().get("https://seubarriga.wcaquino.me");
    }

    public void setEmail(String email){
        escreve("email", email);
    }

    public void setSenha(String senha){
        escreve("senha", senha);
    }

    public void entrar(){
        clicarBotaoPorTexto("Entrar");
    }

    public void logar(String email, String senha){
        setEmail(email);
        setSenha(senha);
        entrar();
    }
}
