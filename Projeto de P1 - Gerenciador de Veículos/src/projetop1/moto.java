package projetop1;
import static projetop1.Mundo.ANSI_BLUE_BACKGROUND;
/**
 * Esta é a sub-classe caminhão, que é derivada da super-classe veículo.
 * @author Alexandre
 */
public class moto extends veiculo{

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
    public moto(int x, int y) {
        super(x, y, ANSI_BLUE_BACKGROUND, 3);
    }
    private String tipo;
}
