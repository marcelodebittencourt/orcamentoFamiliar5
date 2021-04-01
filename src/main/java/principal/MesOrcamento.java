package principal;

import java.util.ArrayList;
import java.util.List;

public class MesOrcamento {

    static boolean receita = false;
    static boolean despesa = true;

    int mes;

    List<Rubrica> receitas = new ArrayList<Rubrica>();

    List<Rubrica> despesas = new ArrayList<Rubrica>();

    //Valores padrão
    final double[] receitaValoresPadrao = {8000, 7000};
    final double[] despesaValoresPadrao = {-1000, -900, -800, -700, -600, -500, -400};

    //Receitas
    Rubrica salario1 = new Rubrica(false, "Salário 1", receitaValoresPadrao[0]);
    Rubrica salario2 = new Rubrica(false, "Salário 2", receitaValoresPadrao[1]);

    //Despesas
    Rubrica habitacao = new Rubrica(false, "Habitação", despesaValoresPadrao[0]);
    Rubrica saude = new Rubrica(false, "Saúde", despesaValoresPadrao[1]);
    Rubrica transporte = new Rubrica(false, "Transporte", despesaValoresPadrao[2]);
    Rubrica despesasPessoais = new Rubrica(false, "Despesas Pessoais", despesaValoresPadrao[3]);
    Rubrica educacao = new Rubrica(false, "Educação", despesaValoresPadrao[4]);
    Rubrica lazer = new Rubrica(false, "Lazer", despesaValoresPadrao[5]);
    Rubrica outros = new Rubrica(false, "Outros", despesaValoresPadrao[6]);


    public MesOrcamento(int m) {
        mes = m;

        receitas.add(salario1);
        receitas.add(salario2);

        despesas.add(habitacao);
        despesas.add(saude);
        despesas.add(transporte);
        despesas.add(despesasPessoais);
        despesas.add(educacao);
        despesas.add(lazer);
        despesas.add(outros);
    }

    public int getQuantidadeRubricas(boolean tipoRubrica) {
        if (tipoRubrica == despesa)
            return despesas.size();

        return receitas.size();
    }

    public double getTotalRubricas(boolean tipoRubrica) {
        double totalRubricas = 0;
        for (int i=0; i<getQuantidadeRubricas(tipoRubrica); i++) {
            if (tipoRubrica == despesa)
                totalRubricas += despesas.get(i).getValor();
            else
                totalRubricas += receitas.get(i).getValor();
        }
        return totalRubricas;
    }

    public double getValorRubricaPorIndice(boolean tipoRubrica, int indice) {
        if (tipoRubrica == despesa)
            return despesas.get(indice).getValor();

        return receitas.get(indice).getValor();
    }

    public void setValorRubricaPorIndice(boolean tipoRubrica, int indice, double valor) {
        if (tipoRubrica == despesa)
            despesas.get(indice).setValor(valor);
        else
            receitas.get(indice).setValor(valor);
    }

    public String getlabelAmigavelRubricaPorIndice(boolean tipoRubrica, int indice) {
        if (tipoRubrica == despesa)
            return despesas.get(indice).getlabelAmigavelRubrica();

        return receitas.get(indice).getlabelAmigavelRubrica();
    }

    public double getSaldoDisponivel() {
        return getTotalRubricas(receita) + getTotalRubricas(despesa);
    }

    public void restauraValoresOriginais() {
        double totalRubricas = 0;
        for (int i=0; i<getQuantidadeRubricas(despesa); i++)
            setValorRubricaPorIndice(despesa, i,despesaValoresPadrao[i]);
        for (int i=0; i<getQuantidadeRubricas(receita); i++)
            setValorRubricaPorIndice(receita, i,receitaValoresPadrao[i]);
    }

}
