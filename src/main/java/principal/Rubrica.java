package principal;

public class Rubrica {
    boolean despesa;
    String nome;
    double valor;

    public Rubrica(boolean d, String n, double v) {
        despesa = d;
        nome = n;
        valor = v;
    }

    public boolean isDespesa() {
        return despesa;
    }
    public void setDespesa(boolean despesa) {
        this.despesa = despesa;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getlabelAmigavelRubrica() {
        return this.getNome() + ": R$ ";
    }

    public boolean save() {
        //persistiria no banco de dados
        System.out.println("Banco de dados ainda não implementado");
        return false;
    }

}
