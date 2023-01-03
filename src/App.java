import java.util.Locale;
import java.util.Scanner;

import entity.Pessoas;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(new Locale("us", "US"));
        Scanner leitor = new Scanner(System.in);

        System.out.println("Quantas pessoas você quer calcular a média de altura?");
        int numeroDePessoas = leitor.nextInt();

        Pessoas[] pessoas = new Pessoas[numeroDePessoas];

        int posicao = 0;
        for (int i = 0; i < pessoas.length; i++) {
            System.out.printf("Digite o nome da pessoa na posição: %d %n", posicao++);
            leitor.nextLine();
            String nome = leitor.nextLine();

            System.out.printf("Digite a idade do(a): %s %n", nome);
            int idade = leitor.nextInt();

            System.out.println("Por fim forneça a altura por favor:");
            double altura = leitor.nextDouble();

            pessoas[i] = new Pessoas(nome, idade, altura);
            System.out.println("---------------------------------------");

        }

        double soma = 0.0;

        for (int i = 0; i < pessoas.length; i++) {
            soma += pessoas[i].getAltura();
        }

        double alturaMedia = soma / numeroDePessoas;

        System.out.printf("Altura média é %.2f %n", alturaMedia);

        int contador = 0;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getIdade() < 16) {
              contador += 1;
            }
        }

        double porcentagem = contador * 100.0 / numeroDePessoas;

        System.out.printf("Pessoas com menos de 16 anos: %.1f%% %n" , porcentagem);

        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getIdade() < 16) {
                System.out.println(pessoas[i].getNome());
            }
        }

        leitor.close();

    }
}
