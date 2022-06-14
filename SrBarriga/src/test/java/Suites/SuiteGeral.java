package Suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Test.ContaTeste;
import Test.MovimentacaoTest;
import Test.RemoverContaMovimentacaoContaTest;
import Test.ResumoMensalTeste;
import Test.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
    ContaTeste.class,
    MovimentacaoTest.class,
    RemoverContaMovimentacaoContaTest.class,
    SaldoTest.class,
    ResumoMensalTeste.class
})
public class SuiteGeral {
    
}
