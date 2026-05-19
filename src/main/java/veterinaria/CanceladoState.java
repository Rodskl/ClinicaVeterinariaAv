package veterinaria;

public class CanceladoState implements SituacaoAtendimento {
    @Override
    public void iniciar(Atendimento atendimento) {
        throw new IllegalStateException("Não é possível iniciar um atendimento cancelado.");
    }

    @Override
    public void finalizar(Atendimento atendimento) {
        throw new IllegalStateException("Não é possível finalizar um atendimento cancelado.");
    }

    @Override
    public void cancelar(Atendimento atendimento) {
        throw new IllegalStateException("O atendimento já está cancelado.");
    }

    @Override
    public String getNome() {
        return "Cancelado";
    }
}