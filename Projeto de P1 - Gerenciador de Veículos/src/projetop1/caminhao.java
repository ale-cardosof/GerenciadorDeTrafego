package projetop1;
import static projetop1.Mundo.ANSI_YELLOW_BACKGROUND;
/**
 * Esta é a sub-classe caminhão, que é derivada da super-classe veículo.
 * @author Alexandre
 */
public class caminhao extends veiculo{

    /**
     *
     * @return
     */
    public int getCapacidade_carga() {
        return capacidade_carga;
    }

    /**
     *
     * @param capacidade_carga
     */
    public void setCapacidade_carga(int capacidade_carga) {
        this.capacidade_carga = capacidade_carga;
    }
        /**
     * Construtor do objeto
     * @param x Posição Inicial em X
     * @param y Posição Inicial em Y
     */
    public caminhao(int x, int y) {
        super(x, y, ANSI_YELLOW_BACKGROUND, 1);
    }
    private int capacidade_carga;
}
