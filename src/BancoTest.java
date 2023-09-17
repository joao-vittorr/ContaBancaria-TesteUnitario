import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BancoTest {
    private Banco banco;
    private ContaBancaria conta1;
    private ContaBancaria conta2;

    @BeforeEach
    public void setUp() {
        banco = new Banco();
        conta1 = new ContaBancaria("Titular1", 1000.0);
        conta2 = new ContaBancaria("Titular2", 1500.0);
        banco.adicionarConta(conta1);
        banco.adicionarConta(conta2);
    }

    @Test
    public void testAdicionarConta() {
        assertEquals(2, banco.getContas().size());
    }

    @Test
    public void testRemoverConta() {
        banco.removerConta(conta1);
        assertEquals(1, banco.getContas().size());
    }

    @Test
    public void testCalcularSaldoTotal() {
        assertEquals(2500.0, banco.calcularSaldoTotal(), 0.001);
    }

    @Test
    public void testTransferir() {
        ContaBancaria conta3 = new ContaBancaria("Titular3", 500.0);
        banco.adicionarConta(conta3);

        conta1.transferir(conta3, 500.0);

        assertEquals(500.0, conta1.getSaldo(), 0.001);
        assertEquals(1000.0, conta3.getSaldo(), 0.001);
    }
}
