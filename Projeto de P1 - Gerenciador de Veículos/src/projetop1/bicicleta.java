package projetop1;
import static projetop1.Mundo.ANSI_PURPLE_BACKGROUND;
/**
 * Esta é a sub-classe carro, que é derivada da super-classe veículo.
 * @author Alexandre
 */
public class bicicleta extends veiculo{

    /**
     *
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    /**
     * Construtor do objeto
     * @param x Posição Inicial em X
     * @param y Posição Inicial em Y
     */
    public bicicleta(int x, int y) {
        super(x, y, ANSI_PURPLE_BACKGROUND, 1); // Incluir forma de ficar parado em 1 iteração
    }
    private String tipo;
}
