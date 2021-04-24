package principal;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RubricaTest {

    private final Rubrica r = new Rubrica(false, "Aluguel", 514.23);

    // Pré-condição
    @BeforeAll
    static void preCondicaoGeral() {
        System.out.println("00 - Pre condicao geral");
    }

    @Test
    void obtemValor() {
        System.out.println("teste obtem valor");
        assertThat(r.getValor(), is(514.23));
    }

    @BeforeEach
    void preCondicaoTeste() {
        System.out.println("0 - Pre condicao TESTE");
    }

    @Test
    @DisplayName("Altera o valor")
    void alteraValor() {
        System.out.println("altera valor");
        r.setValor(14);
        assertThat(r.getValor(), is(14.0));
//        Rubrica rMocked = Mockito.spy(r);
//        Mockito.doReturn(true).when(rMocked).save();
//        assertThat(rMocked.save(), is(true));
    }

    double v;

    @ParameterizedTest
    @CsvFileSource(resources = "/dados.csv", numLinesToSkip = 1, delimiter = ';')
    void testParam(String valor1) {
        v = Double.parseDouble(valor1);
        System.out.println("Valor: " + valor1);
        r.setValor(v);
        assertThat(r.getValor(), is(v));
    }

    @AfterEach
    void posCondicaoTeste() {
        System.out.println("9 - Pos condicao teste");
    }

    @AfterAll
    static void posCondicaoGeral() {
        System.out.println("99 - Pos condicao GERAL");
    }

}

