package veterinaria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AtendimentoTest {

    @Test
    public void devePermitirMudancaValidaDeSituacao() {
        Atendimento atendimento = new Atendimento("Carlos", "Rex", "Consulta", 100.0);
        
        assertEquals("Agendado", atendimento.getSituacao().getNome());

        atendimento.iniciar();
        assertEquals("Em Atendimento", atendimento.getSituacao().getNome());

        atendimento.finalizar();
        assertEquals("Finalizado", atendimento.getSituacao().getNome());
    }

    @Test
    public void deveBloquearMudancaInvalidaDeSituacao() {
        Atendimento atendimento = new Atendimento("Maria", "Mimi", "Vacina", 100.0);
        
        assertEquals("Agendado", atendimento.getSituacao().getNome());

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            atendimento.finalizar();
        });

        assertEquals("Não é possível finalizar um atendimento que está apenas Agendado.", exception.getMessage());
    }

    @Test
    public void deveEnviarAvisoAutomaticoAoMudarSituacao() {
        Atendimento atendimento = new Atendimento("Ana", "Thor", "Exame Sangue", 150.0);
        
        final boolean[] notificado = { false };
        
        Interessado observadorTeste = new Interessado() {
            @Override
            public void atualizar(Atendimento a) {
                notificado[0] = true;
            }
        };

        atendimento.adicionarInteressado(observadorTeste);
        atendimento.iniciar();

        assertTrue(notificado[0], "O observador deveria ter sido notificado da mudança de estado.");
    }

    @Test
    public void deveCalcularValorFinalComMaisDeUmaRegraAplicada() {
        Atendimento atendimento = new Atendimento("Pedro", "Luna", "Cirurgia", 100.0);
        
        atendimento.aplicarModificadorPreco(new DescontoAnimalAdotado(atendimento.getPrecoComponente()));
        atendimento.aplicarModificadorPreco(new TaxaAtendimentoDomiciliar(atendimento.getPrecoComponente()));
        atendimento.aplicarModificadorPreco(new ServicoBanhoPosConsulta(atendimento.getPrecoComponente()));
        
        assertEquals(180.0, atendimento.getValorFinal(), 0.001);
        
        assertTrue(atendimento.getExtratoPreco().contains("Desconto Animal Adotado -10%"));
        assertTrue(atendimento.getExtratoPreco().contains("Taxa Domiciliar +R$50.0"));
        assertTrue(atendimento.getExtratoPreco().contains("Banho Pós-Consulta +R$40.0"));
    }
}