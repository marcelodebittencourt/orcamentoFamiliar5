package unittest;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import principal.Rubrica;

public class RubricaTest {

    //comentario

    /*
    Inclusão no campo Salário 1 valor textual (String)
Inclusão no campo Salário 1 valor com "," na decimal
Inclusão no campo Salário 1 valor negativo
Inclusão no campo Salário 1 sem valor (campo limpo)
Inclusão no campo Salário 1 com mais de 2 decimais
Inclusão no campo Salário 1 com caracteres especiais
Inclusão no campo Salário 1 com quantidade de digitos / tamanho do campo excedendo o limite / valores limite do campo double
Inclusão no campo Salário 1 com vogais acentuadas
Inclusão no campo Salário 1 com copia e cola (ctrl + c e ctrl + v)
Inclusão no campo Salário 1 com valor "000.1234.56"
Inclusão no campo Salário 1 com valor 100.00
Inclusão no campo Salário 1 com valor 100 (inteiro)
Inclusão no campo Salário 1 com valor 99999999999.99
     */

    @ParameterizedTest
    @CsvFileSource(resources = "/dados.csv", numLinesToSkip = 1, delimiter = ';')
    void criaRubricaComValoresDiversos(String valor) {
        System.out.println(valor);
        double valorDouble = Double.parseDouble(valor);
        Rubrica salario1 = new Rubrica(true, "Salario 1", valorDouble);
        assertThat(salario1.getValor(), equalTo(valorDouble));
    }

    @Test
    void criaRubricaComValor100Test() {
        Rubrica salario1 = new Rubrica(true, "Salario 1", 100.00);
        assertThat(salario1.getValor(), equalTo(100.00));
    }

    @Test
    void criaRubricaComValor100DTest() {
        Rubrica salario1 = new Rubrica(true, "Salario 1", 100D);
        assertThat(salario1.getValor(), equalTo(100D));
    }

    @Test
    void criaRubricaComValor100InteiroTest() {
        Rubrica salario1 = new Rubrica(true, "Salario 1", 100);
        assertThat(salario1.getValor(), equalTo(100));
    }

}