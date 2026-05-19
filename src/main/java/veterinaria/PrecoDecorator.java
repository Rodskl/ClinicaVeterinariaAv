package veterinaria;

public abstract class PrecoDecorator implements ComponentePreco {
    protected ComponentePreco precoEnvelopado;

    public PrecoDecorator(ComponentePreco precoEnvelopado) {
        this.precoEnvelopado = precoEnvelopado;
    }
}