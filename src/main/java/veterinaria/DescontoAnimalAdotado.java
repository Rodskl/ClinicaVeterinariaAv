package veterinaria;

public class DescontoAnimalAdotado extends PrecoDecorator {
    private final double percentualDesconto = 0.10; // 10% de desconto

    public DescontoAnimalAdotado(ComponentePreco precoEnvelopado) {
        super(precoEnvelopado);
    }

    @Override
    public double getValor() {
        return this.precoEnvelopado.getValor() * (1 - percentualDesconto);
    }

    @Override
    public String getDescricao() {
        return this.precoEnvelopado.getDescricao() + " [Desconto Animal Adotado -10%]";
    }
}