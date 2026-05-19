package veterinaria;

public class TaxaAtendimentoDomiciliar extends PrecoDecorator {
    private final double taxaFixa = 50.0; // Acréscimo de R$50

    public TaxaAtendimentoDomiciliar(ComponentePreco precoEnvelopado) {
        super(precoEnvelopado);
    }

    @Override
    public double getValor() {
        return this.precoEnvelopado.getValor() + taxaFixa;
    }

    @Override
    public String getDescricao() {
        return this.precoEnvelopado.getDescricao() + " [Taxa Domiciliar +R$50.0]";
    }
}