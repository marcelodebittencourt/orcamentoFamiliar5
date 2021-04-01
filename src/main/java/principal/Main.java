package principal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* Código-fonte escrito foi baseado no código de Rosicléia Frasson
* Disponível em: https://www.devmedia.com.br/jtable-utilizando-o-componente-em-interfaces-graficas-swing/28857
*
 */
public class Main extends JFrame{



    static Rubrica habitacao;
    static Rubrica saude;
    static Rubrica transporte;
    static Rubrica despesasPessoais;
    static Rubrica educacao;
    static Rubrica lazer;
    static Rubrica outros;

    static double totalReceitas = 0;

    static double totalDespesas = 0;

    static double saldoDisponivel = 0;

    static MesOrcamento mesMarco;

    static boolean receita = false;

    static boolean despesa = true;

    static String textoCopyright = "Projetado e codificado por Marcelo de Bittencourt";
    static String textoInspiradoEm = "Inspirado na planilha de orçamento familiar de Gustavo Cerbasi";

    public static void carregaDados() {
        mesMarco = new MesOrcamento(3);
    }

    public static void somaDados() {
        totalReceitas = mesMarco.getTotalRubricas(receita);

        totalDespesas = mesMarco.getTotalRubricas(despesa);

        saldoDisponivel = totalReceitas - totalDespesas;
    }

    static String labelReceitas = "Receitas : R$ ";
    static String labelDespesas = "Despesas: R$ ";
    static String labelSaldoDisponivel = "SALDO DISPONÍVEL: R$ ";

    private static void novaLinha() {
        System.out.println("\n");
    }

    private static void listaDadosNoConsole() {
        System.out.println("Orçamento familiar");
        novaLinha();

        System.out.println(labelReceitas + totalReceitas);
        novaLinha();

        for(int i=0;i<mesMarco.getQuantidadeRubricas(receita);i++)
            System.out.println(mesMarco.getlabelAmigavelRubricaPorIndice(receita, i) + mesMarco.getValorRubricaPorIndice(receita,i) );

        novaLinha();
        System.out.println(labelDespesas + totalDespesas);
        novaLinha();

        for(int i=0;i<mesMarco.getQuantidadeRubricas(despesa);i++)
            System.out.println(mesMarco.getlabelAmigavelRubricaPorIndice(despesa, i) + mesMarco.getValorRubricaPorIndice(despesa,i) );

        novaLinha();

        System.out.println(labelSaldoDisponivel + saldoDisponivel);

        novaLinha();

        System.out.println(textoCopyright);
        System.out.println(textoInspiradoEm);
    }

    final static int TAMANHO_CAMPO_EDITAVEL = 20;

    final static JTextField jTfReceitas = new JTextField(TAMANHO_CAMPO_EDITAVEL);

    final static JTextField jTfReceita0 = new JTextField(TAMANHO_CAMPO_EDITAVEL);
    final static JTextField jTfReceita1 = new JTextField(TAMANHO_CAMPO_EDITAVEL);

    final static JTextField[] listaReceitas= {jTfReceita0, jTfReceita1};

    final static JTextField jTfDespesas = new JTextField(TAMANHO_CAMPO_EDITAVEL);

    final static JTextField jTfDespesa0 = new JTextField(TAMANHO_CAMPO_EDITAVEL);
    final static JTextField jTfDespesa1 = new JTextField(TAMANHO_CAMPO_EDITAVEL);
    final static JTextField jTfDespesa2 = new JTextField(TAMANHO_CAMPO_EDITAVEL);
    final static JTextField jTfDespesa3 = new JTextField(TAMANHO_CAMPO_EDITAVEL);
    final static JTextField jTfDespesa4 = new JTextField(TAMANHO_CAMPO_EDITAVEL);
    final static JTextField jTfDespesa5 = new JTextField(TAMANHO_CAMPO_EDITAVEL);
    final static JTextField jTfDespesa6 = new JTextField(TAMANHO_CAMPO_EDITAVEL);

    final static JTextField[] listaDespesas= {jTfDespesa0, jTfDespesa1, jTfDespesa2, jTfDespesa3, jTfDespesa4, jTfDespesa5, jTfDespesa6};

    final static JTextField jTfSaldoDisponivel = new JTextField(TAMANHO_CAMPO_EDITAVEL);

    private static DefaultTableModel modelo = new DefaultTableModel();
    private static JTable tabela;
    private static JScrollPane barraRolagem;

    private static void listaDadosTelaGrafica() {
        //		JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Orçamento familiar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,800);
        frame.getContentPane().setLayout(new GridLayout(2,1));
        //		frame.getContentPane().setLayout(new GridLayout(13,2));

        JPanel panel = new JPanel(); // the panel is not visible in output
        panel.setLayout(new GridLayout(12,2));

        JLabel jLabelReceitas = new JLabel(labelReceitas);
        jTfReceitas.setEditable(false);
        jTfReceitas.setText(String.valueOf(totalReceitas));

        tabela = new JTable(modelo);
        modelo.addColumn("Rúbrica");
        modelo.addColumn("Valor");
        barraRolagem = new JScrollPane(tabela);



        JLabel jLabelReceita0 = new JLabel(mesMarco.getlabelAmigavelRubricaPorIndice(receita, 0));
        jTfReceita0.setText(String.valueOf(mesMarco.getValorRubricaPorIndice(receita, 0)));

        JLabel jLabelReceita1 = new JLabel(mesMarco.getlabelAmigavelRubricaPorIndice(receita, 1));
        jTfReceita1.setText(String.valueOf(mesMarco.getValorRubricaPorIndice(receita, 1)));

        JLabel jLabelDespesas = new JLabel(labelDespesas);
        jTfDespesas.setEditable(false);
        jTfDespesas.setText(String.valueOf(totalDespesas));

        JLabel jLabelDespesa0 = new JLabel(mesMarco.getlabelAmigavelRubricaPorIndice(despesa, 0));
        jTfDespesa0.setText(String.valueOf(mesMarco.getValorRubricaPorIndice(despesa, 0)));

        JLabel jLabelDespesa1 = new JLabel(mesMarco.getlabelAmigavelRubricaPorIndice(despesa, 1));
        jTfDespesa1.setText(String.valueOf(mesMarco.getValorRubricaPorIndice(despesa, 1)));

        JLabel jLabelDespesa2 = new JLabel(mesMarco.getlabelAmigavelRubricaPorIndice(despesa, 2));
        jTfDespesa2.setText(String.valueOf(mesMarco.getValorRubricaPorIndice(despesa, 2)));

        JLabel jLabelDespesa3 = new JLabel(mesMarco.getlabelAmigavelRubricaPorIndice(despesa, 3));
        jTfDespesa3.setText(String.valueOf(mesMarco.getValorRubricaPorIndice(despesa, 3)));

        JLabel jLabelDespesa4 = new JLabel(mesMarco.getlabelAmigavelRubricaPorIndice(despesa, 4));
        jTfDespesa4.setText(String.valueOf(mesMarco.getValorRubricaPorIndice(despesa, 4)));

        JLabel jLabelDespesa5 = new JLabel(mesMarco.getlabelAmigavelRubricaPorIndice(despesa, 5));
        jTfDespesa5.setText(String.valueOf(mesMarco.getValorRubricaPorIndice(despesa, 5)));

        JLabel jLabelDespesa6 = new JLabel(mesMarco.getlabelAmigavelRubricaPorIndice(despesa, 6));
        jTfDespesa6.setText(String.valueOf(mesMarco.getValorRubricaPorIndice(despesa, 6)));

        JLabel jLabelSaldoDisponivel = new JLabel(labelSaldoDisponivel);
        jTfSaldoDisponivel.setEditable(false);
        jTfSaldoDisponivel.setText(String.valueOf(saldoDisponivel));

        panel.add(jLabelReceitas);
        panel.add(jTfReceitas);

        panel.add(barraRolagem);

        panel.add(jLabelReceita0);
        panel.add(jTfReceita0);

        panel.add(jLabelReceita1);
        panel.add(jTfReceita1);

        panel.add(jLabelDespesas);
        panel.add(jTfDespesas);

        panel.add(jLabelDespesa0);
        panel.add(jTfDespesa0);

        panel.add(jLabelDespesa1);
        panel.add(jTfDespesa1);

        panel.add(jLabelDespesa2);
        panel.add(jTfDespesa2);

        panel.add(jLabelDespesa3);
        panel.add(jTfDespesa3);

        panel.add(jLabelDespesa4);
        panel.add(jTfDespesa4);

        panel.add(jLabelDespesa5);
        panel.add(jTfDespesa5);

        panel.add(jLabelDespesa6);
        panel.add(jTfDespesa6);

        panel.add(jLabelSaldoDisponivel);
        panel.add(jTfSaldoDisponivel);

        frame.getContentPane().add(panel);

        JPanel panelStatus = new JPanel();
        panelStatus.setLayout(new GridLayout(4,1));
        panelStatus.setPreferredSize(new Dimension(400,200));

        JButton buttonAtualizarTotais = new JButton("Atualizar totais");
        buttonAtualizarTotais.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for(int i=0;i<mesMarco.getQuantidadeRubricas(receita);i++)
                    mesMarco.setValorRubricaPorIndice(receita, i, Double.parseDouble(listaReceitas[i].getText()));

                for(int i=0;i<mesMarco.getQuantidadeRubricas(despesa);i++)
                    mesMarco.setValorRubricaPorIndice(despesa, i, Double.parseDouble(listaDespesas[i].getText()));

                somaDados();

                jTfReceitas.setText(String.valueOf(totalReceitas));
                jTfDespesas.setText(String.valueOf(totalDespesas));
                jTfSaldoDisponivel.setText(String.valueOf(saldoDisponivel));
            }
        });

        JButton buttonRestauraValoresOriginais = new JButton("Restaurar valores originais");
        buttonRestauraValoresOriginais.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                mesMarco.restauraValoresOriginais();

                for(int i=0;i<mesMarco.getQuantidadeRubricas(receita);i++)
                    listaReceitas[i].setText(String.valueOf(mesMarco.getValorRubricaPorIndice(receita, i)));

                for(int i=0;i<mesMarco.getQuantidadeRubricas(despesa);i++)
                    listaDespesas[i].setText(String.valueOf(mesMarco.getValorRubricaPorIndice(despesa, i)));

                somaDados();

                jTfReceitas.setText(String.valueOf(totalReceitas));
                jTfDespesas.setText(String.valueOf(totalDespesas));
                jTfSaldoDisponivel.setText(String.valueOf(saldoDisponivel));
            }
        });


        JLabel jLabelTextoCopyright = new JLabel(textoCopyright);
        JLabel jLabelTextoInspiradoEm = new JLabel(textoInspiradoEm);
        panelStatus.add(buttonAtualizarTotais);
        panelStatus.add(buttonRestauraValoresOriginais);
        panelStatus.add(jLabelTextoCopyright);
        panelStatus.add(jLabelTextoInspiradoEm);

        frame.getContentPane().add(panelStatus);

        frame.setVisible(true);
    }

    public static void main(String[] args) {

        carregaDados();

        somaDados();

        listaDadosNoConsole();

        listaDadosTelaGrafica();
    }
}
