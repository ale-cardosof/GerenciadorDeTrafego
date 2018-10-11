package projetop1;
import static projetop1.Mundo.ANSI_RED_BACKGROUND;
/**
 * Esta é a sub-classe carro, que é derivada da super-classe veículo.
 * @author Alexandre
 */
public class carro extends veiculo{

    /**
     *
     * @param num_passageiros
     */
    public void setNum_passageiros(int num_passageiros) {
        this.num_passageiros = num_passageiros;
    }

    /**
     *
     * @return
     */
    public int getNum_passageiros() {
        return num_passageiros;
    }
    /**
     * Construtor do objeto
     * @param x Posição Inicial em X
     * @param y Posição Inicial em Y
     */
    public carro(int x, int y) {
        super(x, y, ANSI_RED_BACKGROUND, 2);
    }
    private int num_passageiros;
}
