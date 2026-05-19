package veterinaria;

public class RecepcaoObserver implements Interessado {
    @Override
    public void atualizar(Atendimento atendimento) {
        if (atendimento.getSituacao() instanceof FinalizadoState) {
            System.out.println("[NOTIFICAÇÃO -> RECEPÇÃO] Atendimento concluído para '" 
                    + atendimento.getNomeAnimal() + "'. Emitir cobrança final.");
            System.out.println("    > Detalhamento: " + atendimento.getExtratoPreco());
            System.out.println("    > VALOR TOTAL A PAGAR: R$ " + atendimento.getValorFinal());
        }
    }
}