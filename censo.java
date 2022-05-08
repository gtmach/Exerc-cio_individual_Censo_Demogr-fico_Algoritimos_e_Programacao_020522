import java.util.InputMismatchException; //importa exception que pode ocorrer no codigo, ao entrar com dados em formato incorreto
import java.util.Scanner; //importa o scanner para receber entradas

public class censo { //inicia a classe
    public static void main(String[] args) { //inicia o metodo main
        try {
            Scanner sc = new Scanner(System.in); //inicia o scanner
            int genero; //inicia a variavel int genero
            int i = 0, sexoFtotal = 0, sexoMtotal = 0, sexoOutroTotal = 0, idadeDigitada, idadeFTotal = 0, idadeMTotal = 0, idadeOutroTotal = 0, idadeTotal = 0, nJovensAdultos = 0; //inicia ints que precisam de valor previo
            double alturaFTotal = 0, alturaMTotal = 0, alturaOutroTotal = 0, alturaDigitada; //inicia douvles que precisam de valor previo

            System.out.println("Numero de pessoas entrevistadas:"); //exibe na tela um texto com instrucao
            int n = sc.nextInt(); //arvazena o valor digitado na variavel n, com o numero de pessoas utilizadas para limitar o contador

            if (n <= 0) { //inicia um if para verificar se n e menor ou igual a zero
                System.err.println("O numero de entrevistado deve ser maior do que zero!"); //exibe o texto eo forma de erro caso verdadeiro
                censo.main(args); //reinicia o programa para que seja digitado novamente o valor
            }

            do { //inicia o loop do-while
                System.out.println("digite o genero do intrevistado: <0 = Feminino, 1 = Masculino , 2 = Outro>"); //exibe texto com instrucoes
                genero = sc.nextInt(); //armazena o valor digitado na variavel genero
                switch (genero) { //inicia o seletor switch com e verifica qual opcao corresponde ao genero digitado
                    case 0 -> { //opcao caso genero seja 0
                        sexoFtotal++; //soma 1 ao total de F
                        System.out.println("digite a altura:"); //exibe instrucao em texto
                        alturaDigitada = sc.nextDouble(); //armazena altura digitada na variavel altura
                        System.out.println("digite a idade:"); //exibe instrucao em texto
                        idadeDigitada = sc.nextInt(); //armazena a idade digitada na variavel idade

                        if (alturaDigitada <= 0 || idadeDigitada < 0){ //verifica se altura é menor ou igual a zero ou se idade é menor do que zero
                            System.err.println("Altura nao pode ser menor ou igual a zero, e idade nao pode ser menor que zero!"); //exibe texto em formato de erro
                            continue; //volta ao inicio da selecao, sem completar o loop
                        };

                        alturaFTotal = alturaFTotal + alturaDigitada; //adiciona a alguta digitada ao total de alturas
                        idadeFTotal = idadeDigitada + idadeFTotal; //soma a idade digitada na idade F total
                        idadeTotal = idadeDigitada + idadeTotal; //soma a idade digitada na idade total (nao especifico para genero)
                    }
                    case 1 -> { //opcao caso genero seja 1
                        sexoMtotal++; //soma 1 ao total de M
                        System.out.println("digite a altura:"); //exibe instrucao em texto
                        alturaDigitada = sc.nextDouble(); //armazena altura digitada na variavel altura
                        System.out.println("digite a idade:"); //exibe instrucao em texto
                        idadeDigitada = sc.nextInt(); //armazena a idade digitada na variavel idade

                        if (alturaDigitada <= 0 || idadeDigitada < 0){ //verifica se altura é menor ou igual a zero ou se idade é menor do que zero
                            System.err.println("Altura nao pode ser menor ou igual a zero, e idade nao pode ser menor que zero!"); //exibe texto em formato de erro
                            continue; //volta ao inicio da selecao, sem completar o loop
                        };

                        alturaMTotal = alturaMTotal + alturaDigitada; //soma a altura digitada ao total de altura do sexo M
                        idadeMTotal = idadeDigitada + idadeMTotal; //soma idade digitada ao total de idade de M
                        idadeTotal = idadeDigitada + idadeTotal; //soma idade digitada ao total de idades geral (nao espeficico para genero)
                    }
                    case 2 -> { //opcao caso genero seja 2
                        sexoOutroTotal++; //adiciona 1 ao total de outro
                        System.out.println("digite a altura:"); //exibe instrucao em texto
                        alturaDigitada = sc.nextDouble(); //armazena altura digitada na variavel altura
                        System.out.println("digite a idade:"); //exibe instrucao em texto
                        idadeDigitada = sc.nextInt(); //armazena a idade digitada na variavel idade

                        if (alturaDigitada <= 0 || idadeDigitada < 0){ //verifica se altura é menor ou igual a zero ou se idade é menor do que zero
                            System.err.println("Altura nao pode ser menor ou igual a zero, e idade nao pode ser menor que zero!"); //exibe texto em formato de erro
                            continue; //volta ao inicio da selecao, sem completar o loop
                        };

                        alturaOutroTotal = alturaOutroTotal + alturaDigitada; //soma altura digitada ao total de altura de outro
                        idadeOutroTotal = idadeDigitada + idadeOutroTotal; //soma a idade digitada ao total de idade de outro
                        idadeTotal = idadeDigitada + idadeTotal; //soma a idade digitada ao total geral de idades
                    }
                    default -> { //opcao caso um valor nao especificado seja digitado
                        System.err.println("Opcao invalida!"); //exibe texto em formato de erro
                        continue; //volta ao inicio da selecao, sem completar o loop
                    }
                }
                if (idadeDigitada >= 18 && idadeDigitada <= 35) nJovensAdultos++; //verifica se a idade digitada esta no intervalo desejado e soma 1 a variavel jovens adultos
                i++; //adiciona 1 ao contador
            } while (i < n); //verifica se o contador ja chegou ao valor de i

            System.out.println("--Dados do censo--"); //exibe texto

            System.out.println("Media de idade do grupo: " + idadeTotal / n); //calcula e exibe a media de idade do grupo

            if (sexoFtotal == 0) System.out.println("foram entrevistadas zero pessoas do sexo feminino"); //verifica se existem pessoas entrevistadas do sexo F, para nao ocorrer divisao por zero
            else System.out.println("Media da altura do sexo feminino:  " + (String.format("%.2f",alturaFTotal / sexoFtotal))); //calcula e exibe a media de altura do sexo F, arredondado para duas casas decimais

            if (sexoMtotal == 0) System.out.println("foram entrevistadas zero pessoas do sexo masculino"); //verifica se existem pessoas entrevistadas do sexo M, para nao ocorrer divisao por zero
            else System.out.println("Media da idade do sexo masculino: " + idadeMTotal / sexoMtotal); //calcula e exibe a media de idades do sexo M, sem casas decimais por serem dois valores inteiros, resultando tambem em um inteiro

            System.out.println("Numero de pessoas que nao se identificam como M ou F: " + sexoOutroTotal); //exibe texto e a quantidade do genero outro

            System.out.println("Percentual de pessoas com idade entre 18 e 35 anos: " + nJovensAdultos / n * 100 + "%"); //calcula e exibe a porcentagem de jovens adultos

        } catch (InputMismatchException ex) { //trata esta exeption, caso nao seja digitado um formato de entrada que o codigo trabalhe (entrada nao seja numero inteiro ou decimal)
            System.out.println("\n"); //pula linha
            System.err.println("Entrada invalida."); //retorna texto em formato de erro
            System.err.println("Erro: InputMismatchException"); //retorna o texto em formato de erro
            System.out.println("\n"); //pula linha
            censo.main(args); //executa o metodo main novamente (reinicia o programa), possibilitando o usuario digitar entradas adequadas

        }
    }
}