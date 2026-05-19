package veterinaria;


public class FinalizadoState implements SituacaoAtendimento {
    @Override
    public void iniciar(Atendimento atendimento) {
        throw new IllegalStateException("O atendimento já foi finalizado.");
    }

    @Override
    public void finalizar(Atendimento atendimento) {
        throw new IllegalStateException("O atendimento já foi finalizado.");
    }

    @Override
    public void cancelar(Atendimento atendimento) {
        throw new IllegalStateException("Um atendimento Finalizado não pode ser cancelado.");
    }

    @Override
    public String getNome() {
        return "Finalizado";
    }
}