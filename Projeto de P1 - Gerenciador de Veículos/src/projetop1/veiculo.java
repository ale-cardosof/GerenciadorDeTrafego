package projetop1;
/**
 * Esta é a super-classe veículo.
 * Ela é a base para criação de qualquer objeto de locomoção.
 * @author Alexandre
 */
public class veiculo {
    /**
     * Funções de get e set dos atributos principais da classe. 
     * @return 
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @return
     */
    public int getVelocidade() {
        return velocidade;
    }

    /**
     *
     * @param velocidade
     */
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    /**
     *
     * @return
     */
    public Boolean getFabrica() {
        return fabrica;
    }

    /**
     *
     * @param fabrica
     */
    public void setFabrica(Boolean fabrica) {
        this.fabrica = fabrica;
    }

    /**
     *
     * @return
     */
    public String getCor() {
        return cor;
    }

    /**
     *
     * @param cor
     */
    public void setCor(String cor) {
        this.cor = cor;
    }    
    /**
     * Construtor de veículos 
     * @param x Posição inicial do veículo no eixo X
     * @param y Posição inicial do veículo no eixo Y
     * @param cor Cor do veículo na interface gráfica
     * @param velo Velocidade de movimento do veículo no mapa
     */
    public veiculo(int x, int y, String cor, int velo){
       this.x = x;
       this.y = y;
       this.cor = cor;
       this.velocidade = velo;
   } 
    private int x; 
    private int y;
    private int velocidade;
    private Boolean fabrica;
    private String cor;
}
