/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;

import buscas.Largura;
import buscas.Profundidade;
import logica.No;
import estrutura.Busca;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tg 
 */
public class Class_principal {
    
    private int proximo;
    private Busca busca;
    private No no;
    private List<logica.Celula> lista;
    private List<No> solucao;
    private int estado[][];
    private int objetivo[][];
    
    /*
      Configura os possíveis estados iniciais do quebra cabeça
    */



    public Class_principal() {
        lista = new ArrayList<>();
        lista = new ArrayList<>();
        no = new No();
        proximo = 0;
    }
    
    
    public int escolher_estado_inicial(int num ){
        
        Scanner ler = new Scanner(System.in);

        int opcao_estado_inicial;
        System.out.println("Selecione um estado inicial");
        int[][] quebra_cabeca_inicial = ler.nextInt();
        estado = quebra_cabeca_inicial;
        no.setPai(null);
        no.setEstados(estado);
        return 0;

    }

    public int escolher_estado_meta(int num ){

        Scanner ler = new Scanner(System.in);

        int opcao_estado_inicial;
        System.out.println("Selecione um estado meta");
        System.out.println("Digite 1 para => {7, 1, 3}, {2, 6, 0}, {5, 4, 8}");
        int[][] quebra_cabeca_meta = ler.nextInt();
        objetivo = quebra_cabeca_meta;
        busca.setObjetivo(objetivo);
        return 0;

    }
    
    public void menu(){
        
        Scanner ler = new Scanner(System.in);
        int n;
        int proximo;
        int estado_inicial;

        System.out.println("Escolha uma opção!");
        System.out.println("Escolha 1 para busca em profundidade");
        System.out.println("Escolha 2 para busca em largura");
        n = ler.nextInt();
        
        if (n == 1){
                escolher_estado_inicial(0);
                escolher_estado_meta(0);
                busca = new Profundidade();
                busca.solucionar(no);
                System.out.println("Quantidade de nos expandidos: " + busca.getContador());
                System.out.println("Movimentos: " + busca.getMovimentos());
                solucao = busca.getSolucao();
                busca.setContador(0);

            } else {
                System.out.println("Fim");
            }
         if (n == 2){
            System.out.println("Busca por Largura");

                escolher_estado_inicial(0);
                escolher_estado_meta(0);
                busca = new Largura();
                busca.solucionar(no);
                System.out.println("Quantidade de nos expandidos: " + busca.getContador());
                System.out.println("Total de movimentações: " + busca.getMovimentos());
                solucao = busca.getSolucao();
                busca.setContador(0);
                

                
            } else {
                System.out.println("Fim");
            }

    }
    
    
}
