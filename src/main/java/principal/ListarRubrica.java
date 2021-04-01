package principal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Código-fonte escrito foi baseado no código de Rosicléia Frasson
 * Disponível em: https://www.devmedia.com.br/jtable-utilizando-o-componente-em-interfaces-graficas-swing/28857
 */
public class ListarRubrica extends JFrame {

    private JPanel painelFundo;
    private JPanel painelBotoes;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private JButton btInserir;
    private JButton btExcluir;
    private JButton btEditar;
    private DefaultTableModel modelo = new DefaultTableModel();

    static MesOrcamento mesMarco;

    boolean receita = false;
    boolean despesa = true;

    public ListarRubrica() {
        super("Rúbricas");
        criaJTable();
        criaJanela();
    }

    public void criaJanela() {
        btInserir = new JButton("Inserir");
        btExcluir = new JButton("Excluir");
        btEditar = new JButton("Editar");
        painelBotoes = new JPanel();
        barraRolagem = new JScrollPane(tabela);
        painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        painelFundo.add(BorderLayout.CENTER, barraRolagem);
        painelBotoes.add(btInserir);
        painelBotoes.add(btEditar);
        painelBotoes.add(btExcluir);
        painelFundo.add(BorderLayout.SOUTH, painelBotoes);

        getContentPane().add(painelFundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 320);
        setVisible(true);
        btInserir.addActionListener(new BtInserirListener());
//        btEditar.addActionListener(new BtEditarListener());
//        btExcluir.addActionListener(new BtExcluirListener());
    }

    private void criaJTable() {
        tabela = new JTable(modelo);
        modelo.addColumn("D?");
        modelo.addColumn("Rúbrica");
        modelo.addColumn("Valor");
        tabela.getColumnModel().getColumn(0)
                .setPreferredWidth(2);
        tabela.getColumnModel().getColumn(1)
                .setPreferredWidth(15);
        tabela.getColumnModel().getColumn(2)
                .setPreferredWidth(15);
        pesquisar(modelo);
    }

    public void pesquisar(DefaultTableModel modelo) {
        modelo.setNumRows(0);

        for(int i=0;i<mesMarco.getQuantidadeRubricas(receita);i++)
            modelo.addRow(new Object[]{"D", mesMarco.receitas.get(i).getNome(), mesMarco.receitas.get(i).getValor()} );

        for(int i=0;i<mesMarco.getQuantidadeRubricas(despesa);i++)
            modelo.addRow(new Object[]{"R", mesMarco.despesas.get(i).getNome(), mesMarco.despesas.get(i).getValor()} );
    }

    private class BtInserirListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            InserirContato ic = new InserirContato(modelo);
            ic.setVisible(true);
        }
    }

//    private class BtEditarListener implements ActionListener {
//
//        public void actionPerformed(ActionEvent e) {
//            int linhaSelecionada = -1;
//            linhaSelecionada = tabela.getSelectedRow();
//            if (linhaSelecionada >= 0) {
//                int idContato = (int) tabela
//                        .getValueAt(linhaSelecionada, 0);
////                AtualizarContato ic =
////                        new AtualizarContato(modelo, idContato, linhaSelecionada);
////                ic.setVisible(true);
//            } else {
//                JOptionPane.showMessageDialog(null,
//                        "É necesário selecionar uma linha.");
//            }
//        }
//    }

//    private class BtExcluirListener implements ActionListener {
//
//        public void actionPerformed(ActionEvent e) {
//            int linhaSelecionada = -1;
//            linhaSelecionada = tabela.getSelectedRow();
//            if (linhaSelecionada >= 0) {
//                int idContato = (int)
//                        tabela.getValueAt(linhaSelecionada, 0);
////                ContatoDao dao = new ContatoDao();
////                dao.remover(idContato);
//                modelo.removeRow(linhaSelecionada);
//            } else {
//                JOptionPane.showMessageDialog(null,
//                        "É necesário selecionar uma linha.");
//            }
//        }
//    }

    public static void main(String[] args) {
        mesMarco = new MesOrcamento(3);
        ListarRubrica lc = new ListarRubrica();
        lc.setVisible(true);
    }
}
