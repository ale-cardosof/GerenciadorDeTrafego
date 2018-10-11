package projetop1;

import java.util.ArrayList;
import java.util.Random;
/**
 * Esta é a classe principal. Ela gerência toda a interface.
 * @author Alexandre
 */
public class Mundo {
    /**
     * Aqui declaramos as constantes de cor, usadas posteriormente.
     */
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m"; // CARRO

    /**
     *
     */
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m"; // CAMINHAO

    /**
     *
     */
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m"; // MOTO

    /**
     *
     */
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m"; // BICICLETA

    /**
     *
     */
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m"; // FABRICA

    /**
     *
     */
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m"; // MURO

    /**
     *
     */
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m"; // CHÃO

    /**
     *
     */
    public static final String ANSI_RESET = "\u001B[0m";
    /**
     * Trata-se do atributo mais importante do Mundo, pois com base nese teremos
     * acesso a interface gráfica, ao sistema de movimentação e colisão de veículos, além
     * do sistema de criação.
     * 
     * Legenda:
     * 120 - Muro
     * -5 - Fábrica
     * 0 - Chão
     * 2 - Carro
     * 3 - Caminhão
     * 8 - Moto
     * 10 - Bicicleta
     */
    public int mapa[][]={
        {120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,0,0,0,0,0,0,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,-5,-5,-5,-5,-5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,-5,-5,-5,-5,-5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,-5,-5,-5,-5,-5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,-5,-5,-5,-5,-5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,-5,-5,-5,-5,-5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,-5,-5,-5,-5,-5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-5,-5,-5,-5,-5,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,120},
        {120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120}
    };
    /**
     * Atributos de tamanho da matriz mapa.
     */
    public int tamanho_y =29;

    /**
     *
     */
    public int tamanho_x =59;
    
    /**
     * Aqui, criamos quatro vetores, um para cada tipo de veículo.
     * Neles, ficaram armazenados todos os veículos existentes.
     */
    public ArrayList<carro> Carros = new ArrayList<>();

    /**
     *
     */
    public ArrayList<moto> Motos = new ArrayList<>();

    /**
     *
     */
    public ArrayList<caminhao> Caminhoes = new ArrayList<>();

    /**
     *
     */
    public ArrayList<bicicleta> Bicicletas = new ArrayList<>();
    /**
     * Criamos a variável geraRandow para que seja posição utilizar as funções
     * da biblioteca Random.
     */
    public Random geraRandow = new Random();
    /**
     * Criamos a variável contadorMoves que servirá como contagem de frames
     */
    public int contadorMoves = 0;
    /**
     * Função que inicializa o mundo.
     * Tem como função criar os veículos iniciais e chamar pela primeira vez
     * a função atualiza.
     */
    public void inicializa(){
        /**
         * Cria variáveis provisórias
         */
        int provX, provY, resp;
        /**
         * Cria os 10 veículos iniciais de cada tipo em posição aleatoria
         */
        for (int a=0;a<10;a++){
            /**
             * CRIAÇÃO DOS CARROS INICIAIS
             */
            /**
             *  Gera valores aleatórios para a posição dos carros
             */
            provX = geraRandow.nextInt(60);
            provY = geraRandow.nextInt(30);
            /**
             * Verifica o que há no local sorteado
             */
            resp = verificaMundo(provX, provY);
            /**
             * Caso haja algo diferente de chão, sorteamos denovo,
             * evitando assim a sobreposição de itens.
             */
            while (resp != 0){
                provX = geraRandow.nextInt(60);
                provY = geraRandow.nextInt(30);
                resp = verificaMundo(provX, provY);
            }
            /**
             * Após confirmarmos que o local está vazio, criamos de fato
             * o carro na ArrayList e adicionamos ao mapa.
             * Lembrando: usamos o número 2 para representar um carro no mapa.
             */
            Carros.add(new carro(provX,provY));
            this.mapa[provY][provX] = 2;
            /**
             * Daqui a linha 176 o código segue a mesma dinâmica para a criação
             * dos outros tipos de veículos, alterando apenas o número de representação
             * e o vetor onde o objeto é adicionado.
             */
             /**
             * CRIAÇÃO DOS CAMINHÕES INICIAIS
             */
            provX = geraRandow.nextInt(60);
            provY = geraRandow.nextInt(30);
            resp = verificaMundo(provX, provY);
            while (resp != 0){
                provX = geraRandow.nextInt(60);
                provY = geraRandow.nextInt(30);
                resp = verificaMundo(provX, provY);
            }
            Caminhoes.add(new caminhao(provX,provY));
            this.mapa[provY][provX] = 3;
            /**
             * CRIAÇÃO DAS MOTOS INICIAIS
             */
            provX = geraRandow.nextInt(60);
            provY = geraRandow.nextInt(30);
            resp = verificaMundo(provX, provY);
            while (resp != 0){
                provX = geraRandow.nextInt(60);
                provY = geraRandow.nextInt(30);
                resp = verificaMundo(provX, provY);
            }
            Motos.add(new moto(provX,provY));
            this.mapa[provY][provX] = 8;
            /**
             * CRIAÇÃO DAS MOTOS INICIAIS
             */
            provX = geraRandow.nextInt(60);
            provY = geraRandow.nextInt(30);
            resp = verificaMundo(provX, provY);
            while (resp != 0){
                provX = geraRandow.nextInt(60);
                provY = geraRandow.nextInt(30);
                resp = verificaMundo(provX, provY);
            }
            Bicicletas.add(new bicicleta(provX,provY));
            this.mapa[provY][provX] = 10;
        }   
        /**
         * Chamada da função atualiza.
         */
        this.atualiza();
        
    }
    
    /**
     * Função de atualização.
     * Todas as funções principais presentes no mundo são chamadas infinitamente aqui
     */
    public void atualiza(){
        boolean a = true;
        while(a){
            /**
             * Chama a função responsável por desenhar o mundo.
             */
            this.desenhaMundo();
            try {Thread.sleep(500);} catch (InterruptedException ex) {}
            for(int i=0;i<99;i++){
                System.out.println();
            } 
            /**
             * Adiciona um ao contador de frames.
             */
            contadorMoves++;
            /**
             * Chama a função responsável por mover os veículos existentes.
             */
            this.moveVeiculos();
            /**
             * Chama a função responsável por resolver os conflitos gerados pela
             * última iteração da função moveVeiculos.
             */
            this.verificaColisoes();
            
        }
    
    }
    
    /** 
     * Função responsável pela parte gráfica do programa.
     */
    public void desenhaMundo(){
        /**
         * Exibe um contador acima do mapa com o número atual de veículos para cada tipo
         */
        System.out.println("CARROS: " + this.Carros.size() + "  MOTOS: " + this.Motos.size() + "  CAMINHOES: " + this.Caminhoes.size() + "  BICICLETAS: " + this.Bicicletas.size());
        /**
        * Loop que percorre toda a matriz mapa, imprimindo uma cor diferente dependendo
        * do código encontrado.
        */
        for(int i=0;i<=tamanho_y;i++){
            for(int j=0;j<=tamanho_x;j++){
                if (this.mapa[i][j] == 0){ 
                    System.out.print(ANSI_WHITE_BACKGROUND + " ");
                } else if(this.mapa[i][j] == 120){ // MURO
                    System.out.print(ANSI_CYAN_BACKGROUND + " ");
                } else if(this.mapa[i][j] == 2){ // CARRO
                    System.out.print(ANSI_RED_BACKGROUND + " ");
                } else if(this.mapa[i][j] == 3){ // CAMINHAO
                    System.out.print(ANSI_YELLOW_BACKGROUND + " ");
                } else if(this.mapa[i][j] == 8){ // MOTO
                    System.out.print(ANSI_BLUE_BACKGROUND + " ");
                } else if(this.mapa[i][j] == 10){ // BICICLETA
                    System.out.print(ANSI_PURPLE_BACKGROUND + " ");
                } else if(this.mapa[i][j] == -5){ // FABRICA
                    System.out.print(ANSI_GREEN_BACKGROUND + " ");
                }
            }
            System.out.println(" ");
        }
    }
    
    /**
     * Recebe uma posição do mundo e retorna o que há nela
     * @param provX Posição x em questão
     * @param provY Posição y em questão
     * @return Número correspondente ao tipo de item no local recebido
     */ 
    public int verificaMundo(int provX, int provY){
       int resp;
       /**
        * Caso alguma das posições recebidas exceda o tamanho da matriz mapa
        * Retornamos um código de erro 505
        */
       if ((provX <= 0) || (provY <= 0) || (provX >= 59) || (provY >= 29)){
           return 505;
       }else{
           /**
            * Caso contrário, retornamos o que já naquele local.
            */
           resp = this.mapa[provY][provX];
           return resp;
       }
       
}
    
    /**
     * Função responsável pela movimentação dos veículos.
     */
    public void moveVeiculos(){
        /**
         * Declarando variaveis auxiliares
         */
        int direcao, xAtual, yAtual, xProv, yProv, resp;  
        /* Laço que percorre todo o vetor de Carros */
        for(int i=0;i < Carros.size(); i++){
                    /* Gera direção aleatória, 0 - baixo, 1 - cima, 2 - direita, 3 - esquerda */
                    direcao = geraRandow.nextInt(4);
                    xAtual = Carros.get(i).getX();
                    yAtual = Carros.get(i).getY();
                    xProv = Carros.get(i).getX();
                    yProv = Carros.get(i).getY();
                    int provX;
                    int provY;
                    resp = 0;
                    /**
                     * Calcula a próxima posição do carro
                     */
                    if (direcao == 0){
                        yProv = yProv+Carros.get(i).getVelocidade();
                        /**
                         * Verifica se o próximo local não estoura a matriz mapa
                         * Se estourar, setamos a variável para que ele apareça do outro lado.
                         * Se não estourar, setamos a variável calculada anteriormente
                         */
                        if(verificaMundo(xProv,yProv) == 505){
                            if (yProv > 26){
                                yProv= 1;
                                resp = verificaMundo(xProv,yProv);
                            }
                        }else{
                            resp = verificaMundo(xProv,yProv);
                        }
                    }else if(direcao == 1){
                        yProv = yProv-Carros.get(i).getVelocidade();
                        if(verificaMundo(xProv,yProv) == 505){
                            if (yProv <= 0){
                                yProv= 28;
                                resp = verificaMundo(xProv,yProv);
                            }
                        }else{
                            resp = verificaMundo(xProv,yProv);
                        }
                    }else if(direcao == 2){
                        xProv = xProv+Carros.get(i).getVelocidade();
                        if(verificaMundo(xProv,yProv) == 505){
                            if (xProv >= 58){
                                xProv= 1;
                                resp = verificaMundo(xProv,yProv);
                            }
                        }else{
                            resp = verificaMundo(xProv,yProv);
                        }
                    }else if(direcao == 3){
                        xProv = xProv-Carros.get(i).getVelocidade();
                        if(verificaMundo(xProv,yProv) == 505){
                            if (xProv <= 0){
                                xProv= 58;
                                resp = verificaMundo(xProv,yProv);
                            }
                        }else{
                            resp = verificaMundo(xProv,yProv);
                        }
                    }
                    /**
                     * Agora, com a posição futura do objeto, podemos identificar
                     * se o que está no próximo movimento é uma fábrica. Se for,
                     * Criamos outro objeto do mesmo tipo.
                     */
                    if (resp == -5){
                        /* Gera valores aleatórios para a posição dos carros */
                        provX = geraRandow.nextInt(60);
                        provY = geraRandow.nextInt(30);
                        /* Verifica se estão num lugar vazio */
                        resp = verificaMundo(provX, provY);
                        /* Se houver algo diferente do chão, roda denovo até não ter */
                        while (resp != 0){
                            provX = geraRandow.nextInt(60);
                            provY = geraRandow.nextInt(30);
                            resp = verificaMundo(provX, provY);
                        }
                        /* Cria um novo carro com a posição indicada */
                        Carros.add(new carro(provX,provY));
                        /* Adiciona no mundo a posição indicada */
                        this.mapa[provY][provX] = 2;
                    }else{
                        /* Se há chão, mova o carro */
                        this.mapa[yProv][xProv] = 2;
                        /* Libera posição anterior */
                        this.mapa[yAtual][xAtual] = 0;
                        /* Muda x e Y no objeto */
                        Carros.get(i).setY(yProv);
                        Carros.get(i).setX(xProv);
                    }
        }
        /* Laço que percorre todo o vetor de Motos
        * Possui funcionamento semelhante a movimentação dos carros.
        */
        for(int i=0;i < Motos.size(); i++){
                    direcao = geraRandow.nextInt(4);
                    xAtual = Motos.get(i).getX();
                    yAtual = Motos.get(i).getY();
                    xProv = Motos.get(i).getX();
                    yProv = Motos.get(i).getY();
                    int provX;
                    int provY;
                    resp = 0;
                    if (direcao == 0){
                        yProv = yProv+Motos.get(i).getVelocidade();
                        if(verificaMundo(xProv,yProv) == 505){
                            if (yProv > 26){
                                yProv= 1;
                                resp = verificaMundo(xProv,yProv);
                            }
                        }else{
                            resp = verificaMundo(xProv,yProv);
                        }
                    }else if(direcao == 1){
                        yProv = yProv-Motos.get(i).getVelocidade();
                        if(verificaMundo(xProv,yProv) == 505){
                            if (yProv <= 0){
                                yProv= 28;
                                resp = verificaMundo(xProv,yProv);
                            }
                        }else{
                            resp = verificaMundo(xProv,yProv);
                        }
                    }else if(direcao == 2){
                        xProv = xProv+Motos.get(i).getVelocidade();
                        if(verificaMundo(xProv,yProv) == 505){
                            if (xProv >= 58){
                                xProv= 1;
                                resp = verificaMundo(xProv,yProv);
                            }
                        }else{
                            resp = verificaMundo(xProv,yProv);
                        }
                    }else if(direcao == 3){
                        xProv = xProv-Motos.get(i).getVelocidade();
                        if(verificaMundo(xProv,yProv) == 505){
                            if (xProv <= 0){
                                xProv= 58;
                                resp = verificaMundo(xProv,yProv);
                            }
                        }else{
                            resp = verificaMundo(xProv,yProv);
                        }
                    }
                    if (resp == -5){
                        provX = geraRandow.nextInt(60);
                        provY = geraRandow.nextInt(30);
                        resp = verificaMundo(provX, provY);
                        while (resp != 0){
                            provX = geraRandow.nextInt(60);
                            provY = geraRandow.nextInt(30);
                            resp = verificaMundo(provX, provY);
                        }
                        Motos.add(new moto(provX,provY));
                        this.mapa[provY][provX] = 8;
                    }else{
                        this.mapa[yProv][xProv] = 8;
                        this.mapa[yAtual][xAtual] = 0;
                        Motos.get(i).setY(yProv);
                        Motos.get(i).setX(xProv);
                    }
        }
        /* Laço que percorre todo o vetor de Caminhão
        * Possui funcionamento semelhante a movimentação dos carros.
        */
        for(int i=0;i < Caminhoes.size(); i++){
                    direcao = geraRandow.nextInt(4);
                    xAtual = Caminhoes.get(i).getX();
                    yAtual = Caminhoes.get(i).getY();
                    xProv = Caminhoes.get(i).getX();
                    yProv = Caminhoes.get(i).getY();
                    int provX;
                    int provY;
                    resp = 0;
                    if (direcao == 0){
                        yProv = yProv+Caminhoes.get(i).getVelocidade();
                        if(verificaMundo(xProv,yProv) == 505){
                            if (yProv > 26){
                                yProv= 1;
                                resp = verificaMundo(xProv,yProv);
                            }
                        }else{
                            resp = verificaMundo(xProv,yProv);
                        }
                    }else if(direcao == 1){
                        yProv = yProv-Caminhoes.get(i).getVelocidade();
                        if(verificaMundo(xProv,yProv) == 505){
                            if (yProv <= 0){
                                yProv= 28;
                                resp = verificaMundo(xProv,yProv);
                            }
                        }else{
                            resp = verificaMundo(xProv,yProv);
                        }
                    }else if(direcao == 2){
                        xProv = xProv+Caminhoes.get(i).getVelocidade();
                        if(verificaMundo(xProv,yProv) == 505){
                            if (xProv >= 58){
                                xProv= 1;
                                resp = verificaMundo(xProv,yProv);
                            }
                        }else{
                            resp = verificaMundo(xProv,yProv);
                        }
                    }else if(direcao == 3){
                        xProv = xProv-Caminhoes.get(i).getVelocidade();
                        if(verificaMundo(xProv,yProv) == 505){
                            if (xProv <= 0){
                                xProv= 58;
                                resp = verificaMundo(xProv,yProv);
                            }
                        }else{
                            resp = verificaMundo(xProv,yProv);
                        }
                    }
                    if (resp == -5){
                        provX = geraRandow.nextInt(60);
                        provY = geraRandow.nextInt(30);
                        resp = verificaMundo(provX, provY);
                        while (resp != 0){
                            provX = geraRandow.nextInt(60);
                            provY = geraRandow.nextInt(30);
                            resp = verificaMundo(provX, provY);
                        }
                        Caminhoes.add(new caminhao(provX,provY));
                        this.mapa[provY][provX] = 3;
                    }else{
                        this.mapa[yProv][xProv] = 3;
                        this.mapa[yAtual][xAtual] = 0;
                        Caminhoes.get(i).setY(yProv);
                        Caminhoes.get(i).setX(xProv);
                    }
        }
        /* Laço que percorre todo o vetor de Bicicletas
        * Possui funcionamento semelhante a movimentação dos carros.
        */
        for(int i=0;i < Bicicletas.size(); i++){
                    direcao = geraRandow.nextInt(4);
                    xAtual = Bicicletas.get(i).getX();
                    yAtual = Bicicletas.get(i).getY();
                    xProv = Bicicletas.get(i).getX();
                    yProv = Bicicletas.get(i).getY();
                    int provX;
                    int provY;
                    resp = 0;
                    if (direcao == 0){
                        yProv = yProv+Bicicletas.get(i).getVelocidade();
                        if(verificaMundo(xProv,yProv) == 505){
                            if (yProv > 26){
                                yProv= 1;
                                resp = verificaMundo(xProv,yProv);
                            }
                        }else{
                            resp = verificaMundo(xProv,yProv);
                        }
                    }else if(direcao == 1){
                        yProv = yProv-Bicicletas.get(i).getVelocidade();
                        if(verificaMundo(xProv,yProv) == 505){
                            if (yProv <= 0){
                                yProv= 28;
                                resp = verificaMundo(xProv,yProv);
                            }
                        }else{
                            resp = verificaMundo(xProv,yProv);
                        }
                    }else if(direcao == 2){
                        xProv = xProv+Bicicletas.get(i).getVelocidade();
                        if(verificaMundo(xProv,yProv) == 505){
                            if (xProv >= 58){
                                xProv= 1;
                                resp = verificaMundo(xProv,yProv);
                            }
                        }else{
                            resp = verificaMundo(xProv,yProv);
                        }
                    }else if(direcao == 3){
                        xProv = xProv-Bicicletas.get(i).getVelocidade();
                        if(verificaMundo(xProv,yProv) == 505){
                            if (xProv <= 0){
                                xProv= 58;
                                resp = verificaMundo(xProv,yProv);
                            }
                        }else{
                            resp = verificaMundo(xProv,yProv);
                        }
                    }
                    if (resp == -5){
                        provX = geraRandow.nextInt(60);
                        provY = geraRandow.nextInt(30);
                        resp = verificaMundo(provX, provY);
                        while (resp != 0){
                            provX = geraRandow.nextInt(60);
                            provY = geraRandow.nextInt(30);
                            resp = verificaMundo(provX, provY);
                        }
                        Bicicletas.add(new bicicleta(provX,provY));
                        this.mapa[provY][provX] = 10;
                    }else{
                        this.mapa[yProv][xProv] = 10;
                        this.mapa[yAtual][xAtual] = 0;
                        Bicicletas.get(i).setY(yProv);
                        Bicicletas.get(i).setX(xProv);
                    }
        }
                    }
    
    /**
     * Função responsável pela tomada de atitude pós-colisão dos veículos.
     */
    public void verificaColisoes(){
        /**
         * Faz todas as colisões que envolvam Caminhões
         */
        for (int i = 0; i < Caminhoes.size() && !Caminhoes.isEmpty(); i++){
            for(int j = i +1; j < (Caminhoes.size() - 1); j++){
                if(Caminhoes.get(i).getY() == Caminhoes.get(j).getY() && Caminhoes.get(i).getX() == Caminhoes.get(j).getX()){
                        this.mapa[Caminhoes.get(j).getY()][Caminhoes.get(j).getX()] = 0;
                        Caminhoes.remove(j);
                        this.mapa[Caminhoes.get(i).getY()][Caminhoes.get(i).getX()] = 0;
                        Caminhoes.remove(i); 
                        j = i +1;
                }
            }
            for(int k = 0; k < Carros.size() && !Carros.isEmpty(); k++){
                if(Caminhoes.get(i).getY() == Carros.get(k).getY() && Caminhoes.get(i).getX() == Carros.get(k).getX()){
                        this.mapa[Carros.get(k).getY()][Carros.get(k).getX()] = 0;
                        Carros.remove(k);
                        k--;
                }
            }
            for(int l = 0; l < Motos.size() && !Motos.isEmpty(); l++){
                if(Caminhoes.get(i).getY() == Motos.get(l).getY() && Caminhoes.get(i).getX() == Motos.get(l).getX()){
                        this.mapa[Motos.get(l).getY()][Motos.get(l).getX()] = 0;
                        Motos.remove(l);
                        l--;
                }
            }
            for(int m = 0; m < Bicicletas.size() && !Bicicletas.isEmpty(); m++){
                if(Caminhoes.get(i).getY() == Bicicletas.get(m).getY() && Caminhoes.get(i).getX() == Bicicletas.get(m).getX()){
                        this.mapa[Bicicletas.get(m).getY()][Bicicletas.get(m).getX()] = 0;
                        Bicicletas.remove(m);
                        m--;
                }
            }
        }
        /**
         * Faz todas as colisões que envolvam Carros (exceto Caminhões x Carros)
         */
        for (int i = 0; i < Carros.size() && !Carros.isEmpty(); i++){
            for(int j = i +1; j < (Carros.size() - 1); j++){
                if(Carros.get(i).getY() == Carros.get(j).getY() && Carros.get(i).getX() == Carros.get(j).getX()){
                        this.mapa[Carros.get(j).getY()][Carros.get(j).getX()] = 0;
                        Carros.remove(j);
                        this.mapa[Carros.get(i).getY()][Carros.get(i).getX()] = 0;
                        Carros.remove(i); 
                        j = i +1;
                }
            }
            for(int l = 0; l < Motos.size() && !Motos.isEmpty(); l++){
                if(Carros.get(i).getY() == Motos.get(l).getY() && Carros.get(i).getX() == Motos.get(l).getX()){
                        this.mapa[Motos.get(l).getY()][Motos.get(l).getX()] = 0;
                        Motos.remove(l);
                        l--;
                }
            }
            for(int m = 0; m < Bicicletas.size() && !Bicicletas.isEmpty(); m++){
                if(Carros.get(i).getY() == Bicicletas.get(m).getY() && Carros.get(i).getX() == Bicicletas.get(m).getX()){
                        this.mapa[Bicicletas.get(m).getY()][Bicicletas.get(m).getX()] = 0;
                        Bicicletas.remove(m);
                        m--;
                }
            }
        }
        /**
         * Faz todas as colisões que envolvam Motos (exceto Caminhões x Motos e Carros x Motos)
         */
        for (int i = 0; i < Motos.size() && !Motos.isEmpty(); i++){
            for(int j = i +1; j < (Motos.size() - 1); j++){
                if(Motos.get(i).getY() == Motos.get(j).getY() && Motos.get(i).getX() == Motos.get(j).getX()){
                        this.mapa[Motos.get(j).getY()][Motos.get(j).getX()] = 0;
                        Motos.remove(j);
                        this.mapa[Motos.get(i).getY()][Motos.get(i).getX()] = 0;
                        Motos.remove(i); 
                        j = i +1;
                }
            }
            for(int m = 0; m < Bicicletas.size() && !Bicicletas.isEmpty(); m++){
                if(Motos.get(i).getY() == Bicicletas.get(m).getY() && Motos.get(i).getX() == Bicicletas.get(m).getX()){
                        this.mapa[Bicicletas.get(m).getY()][Bicicletas.get(m).getX()] = 0;
                        Bicicletas.remove(m);
                        m--;
                }
            }
        }
        /**
         * Faz colisão de bicicleta e bicicleta
         */
        for (int i = 0; i < Bicicletas.size() && !Bicicletas.isEmpty(); i++){
            for(int j = i +1; j < (Bicicletas.size() - 1); j++){
                if(Bicicletas.get(i).getY() == Bicicletas.get(j).getY() && Bicicletas.get(i).getX() == Bicicletas.get(j).getX()){
                        this.mapa[Bicicletas.get(j).getY()][Bicicletas.get(j).getX()] = 0;
                        Bicicletas.remove(j);
                        this.mapa[Bicicletas.get(i).getY()][Bicicletas.get(i).getX()] = 0;
                        Bicicletas.remove(i); 
                        j = i +1;
                }
            }
        }
    
    }
}
    