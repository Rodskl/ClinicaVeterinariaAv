package veterinaria;

public class ServicoBanhoPosConsulta extends PrecoDecorator {
    private final double valorBanho = 40.0; // Acréscimo de R$40

    public ServicoBanhoPosConsulta(ComponentePreco precoEnvelopado) {
        super(precoEnvelopado);
    }

    @Override
    public double getValor() {
        return this.precoEnvelopado.getValor() + valorBanho;
    }

    @Override
    public String getDescricao() {
        return this.precoEnvelopado.getDescricao() + " [Banho Pós-Consulta +R$40.0]";
    }
}