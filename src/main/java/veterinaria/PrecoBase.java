package veterinaria;

public class PrecoBase implements ComponentePreco {
    private double valorBase;

    public PrecoBase(double valorBase) {
        this.valorBase = valorBase;
    }

    @Override
    public double getValor() {
        return this.valorBase;
    }

    @Override
    public String getDescricao() {
        return "Consulta Base (R$ " + this.valorBase + ")";
    }
}