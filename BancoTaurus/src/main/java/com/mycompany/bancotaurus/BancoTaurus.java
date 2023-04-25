/*Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.bancotaurus;

/**  imcompleto
 *
 * @author mateus
 */
import java.util.Random;
import java.util.Scanner;

public class BancoTaurus {

    static Scanner t1 = new Scanner(System.in);
    static Scanner t2 = new Scanner(System.in);
    static Random random = new Random();

    public static Conta Cadastro(Conta[] conta) {
        int i = 0;
        int numero = 0;
        double saldo = 0;
        System.out.println("Digite seu nome:");
        String nome = t2.nextLine();

        System.out.println("Digite seu cpf:");
        String cpf = t2.nextLine();
        while (cpf.length() != 11) {
            System.out.println("CPF inválido!(deve conter 11 numeros) Digite novamente:");
            cpf = t2.nextLine();
        }

        System.out.println("Digite seu celular:");
        String celular = t2.nextLine();

        String numeroc = Integer.toString(random.nextInt(1000000));
        System.out.println("Seu número de conta é: " + numeroc);

        System.out.println("Digite sua senha de 4 dígitos:");
        String senha = t2.nextLine();
        while (senha.length() != 4) {
            System.out.println("Senha inválida! Digite novamente:");
            senha = t2.nextLine();
            numero = Integer.parseInt(numeroc);
        }
        System.out.println("seu saldo e R$0,00" + saldo);
        conta[i] = new Conta(nome, cpf, senha, numero, celular, saldo);
        System.out.println("Cadastro realizado com sucesso!");
        i++;
        return null;
    }

    public static Conta Login(Conta[] conta) {
        int i = 0;
        System.out.println("Digite seu CPF ou seu nome:");
        String cpfOuNome = t2.nextLine();

        while (i < conta.length && conta[i] != null) {
            if (conta[i].getNome().equalsIgnoreCase(cpfOuNome) || conta[i].getCpf().equals(cpfOuNome)) {
                System.out.println("Digite sua senha:");
                String senha = t2.nextLine();
                int tentativas = 0;
                do {
                    if (conta[i].getSenha().equals(senha)) {
                        System.out.println("Login realizado com sucesso!");
                        int opcao;
                        do {
                            System.out.println("Bem-vindo, " + conta[i].getNome() + "!");
                            System.out.println("Escolha uma das opções:");
                            System.out.println("1 - Visualizar dados da conta");
                            System.out.println("2 - Adicionar saldo");
                            System.out.println("3 - Retirar saldo");
                            System.out.println("4 - Trocar número");
                            System.out.println("5 - Voltar para o menu principal");
                            System.out.print("Opção: ");
                            opcao = t1.nextInt();
                            switch (opcao) {
                                case 1:
                                    System.out.print("-------------------------");
                                    System.out.println("Dados da conta:");
                                    System.out.println("Número da conta: " + conta[i].getNumero());
                                    System.out.println("Nome: " + conta[i].getNome());
                                    System.out.println("CPF: " + conta[i].getCpf());
                                    System.out.println("Celular: " + conta[i].getCelular());
                                    System.out.print("-------------------------");
                                    break;

                                case 2:
                                    System.out.println("Digite o valor a ser adicionado:");
                                    double valorAdicionado = t2.nextDouble();
                                    conta[i].maisSaldo(valorAdicionado);
                                    System.out.println("Saldo atualizado: " + conta[i].getSaldo());
                                    break;

                                case 3:
                                    System.out.println("Digite o valor a ser retirado:");
                                    double valorRetirado = t2.nextDouble();
                                    if (conta[i].getSaldo() < valorRetirado) {
                                        System.out.println("Saldo insuficiente!");
                                    } else {
                                        conta[i].menosSaldo(valorRetirado);
                                        System.out.println("Saldo atualizado: " + conta[i].getSaldo());
                                    }
                                    break;

                                case 4:
                                    System.out.println("Digite o novo número de celular:");
                                    String celular = t2.nextLine();
                                    conta[i].setCelular(celular);
                                    System.out.println("Número de celular atualizado para: " + conta[i].getCelular());
                                    break;

                                case 5:
                                    System.out.println("Voltando para o menu principal...");
                                    break;

                                default:
                                    System.out.println("Opção inválida.");
                            }
                        } while (opcao != 5);
                        return conta[i];
                    } else {
                        tentativas++;
                        System.out.println("Senha incorreta! Tente novamente:");
                        senha = t2.nextLine();
                    }
                } while (tentativas < 3);

                System.out.println("Você excedeu o número máximo de tentativas de login.");
                return null;
            }
            i++;
        }

        System.out.println("CPF ou nome inválido!");
        return null;
    }

    public static void main(String[] args) {
        Conta[] conta = new Conta[10];
        int opcao = 0;
        while (opcao != 3) {
            System.out.println("O que você gostaria de fazer?");
            System.out.println("1. Cadastrar-se");
            System.out.println("2. Fazer login");
            System.out.println("3. Sair");
            System.out.print("Opção: ");
            opcao = t1.nextInt();
            switch (opcao) {
                case 1:
                    Cadastro(conta);
                    break;
                case 2:
                    Login(conta);
                    break;
                case 3:
                    System.out.println("Obrigado por usar o nosso banco!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
