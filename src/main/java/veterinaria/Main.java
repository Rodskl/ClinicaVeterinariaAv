package veterinaria;

public class Main {
    public static void main(String[] args) {
        Atendimento atendimento = new Atendimento("João Silva", "Pipoca", "Consulta de Rotina", 150.0);

        atendimento.adicionarInteressado(new TutorObserver());
        atendimento.adicionarInteressado(new VeterinarioObserver());
        atendimento.adicionarInteressado(new RecepcaoObserver());

        atendimento.aplicarModificadorPreco(new DescontoAnimalAdotado(atendimento.getPrecoComponente()));
        atendimento.aplicarModificadorPreco(new TaxaAtendimentoDomiciliar(atendimento.getPrecoComponente()));

        System.out.println("Situação inicial: " + atendimento.getSituacao().getNome());
        atendimento.iniciar(); 
        atendimento.finalizar(); 
    }
}