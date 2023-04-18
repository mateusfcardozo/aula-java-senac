/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bancotaurus;

/**
 *
 * @author mateus
 * 
 *                                Documentação do codigo
 * 
 * O código em questão é um programa básico de um sistema bancário, que permite que os usuários se cadastrem,
 * façam login e realizem algumas operações bancárias básicas.
 * 
 * Ao executar o programa, o usuário tem três opções: cadastrar-se, fazer login ou sair.
 * Ao escolher a opção de cadastrar-se, o usuário informa seus dados básicos (nome, CPF e celular) e define uma senha.
 * A partir disso, o sistema gera um código de acesso que será usado para fazer login posteriormente.
 * 
 * Ao escolher a opção de fazer login, o usuário informa seu número de conta e senha, e caso os dados estejam corretos,
 * é exibido um menu com quatro opções: atualizar dados, depositar dinheiro, sacar dinheiro ou sair. A partir dessas opções,
 * o usuário pode realizar algumas operações básicas em sua conta.
 * 
 * O programa utiliza a classe Conta para armazenar as informações de cada usuário.
 * A classe Conta possui atributos para nome, CPF, celular, número da conta, senha e saldo,
 * e métodos para realizar depósitos, saques e atualização de informações.
 * O programa armazena as contas em um array e as manipula de acordo com as operações selecionadas pelo usuário.
 * 
 *                                Code documentation
 * 
 * The code in question is a basic program of a banking system, which allows users to sign up, log in,
 * and perform some basic banking operations.
 * 
 * When running the program, the user has three options: sign up, log in, or exit.
 * When choosing the sign-up option, the user provides their basic information (name, CPF, and phone number)
 * and sets a password. From that, the system generates an access code that will be used to log in later.
 * 
 * When choosing the log-in option, the user provides their account number and password, and if the data is correct,
 * a menu with four options is displayed: update data, deposit money, withdraw money, or exit. From these options,
 * the user can perform some basic operations on their account.
 * 
 * The program uses the Account class to store the information of each user.
 * The Account class has attributes for name, CPF, phone number, account number, password, and balance,
 * and methods to perform deposits, withdrawals, and information updates.
 * The program stores the accounts in an array and manipulates them according to the operations selected by the user.
 */
import java.util.Scanner;

public class BancoTaurus {
    static Scanner t = new Scanner(System.in);
    static int i=0,j, count = 0;
    static int[] senha = new int[10];
    static float[] valor = new float[10];
    static String[] conta = new String[10], nome = new String[10], cpf = new String[10], celular = new String[10];

    public static void Cadastro() {
        System.out.println("Central de Cadastro");

        System.out.print("Nome: ");
        nome[i] = t.next();
        System.out.print("CPF: ");
        cpf[i] = t.next();
        System.out.print("Celular: ");
        celular[i] = t.next();
        System.out.println("Cliente cadastrado com sucesso.");
        System.out.println("Seu código de acesso é: " + count);
        System.out.print("Seu número da conta: ");
        conta[i] = t.next();
        System.out.print("Defina a sua senha para login (4 dígitos): ");
        senha[i] = t.nextInt();

        i++;
        count++;
    }

    public static void Login() {

        System.out.println("Central de Login");
        System.out.print("Número da conta: ");
        int numeroConta = t.nextInt();
        System.out.print("Senha: ");
        int senhaLogin = t.nextInt();

         j = 0;
        while (j < i) {
            if (conta[j] != null && conta[j].equals(Integer.toString(numeroConta)) && senha[j] == senhaLogin) {
                System.out.println("Bem-vindo(a), " + nome[j] + ".");
                System.out.println("CPF: " + cpf[j]);
                System.out.println("Celular: " + celular[j]);
                System.out.println("Saldo: R$" + valor[j]);
                int opcao;

                do {
                    System.out.println("Escolha uma das opções:");
                    System.out.println("1 - Atualizar seus dados");
                    System.out.println("2 - Depositar dinheiro");
                    System.out.println("3 - Sacar dinheiro");
                    System.out.println("4 - Sair");
                    System.out.print("Opção: ");
                    opcao = t.nextInt();

                    switch (opcao) {
                        case 1:
                            System.out.print("Celular: ");
                            celular[j] = t.next();

                            System.out.println("Dados atualizados com sucesso.");
                            break;

                        case 2:
                            System.out.print("Valor a depositar: R$");
                            float valorDeposito = t.nextFloat();
                            valor[j] += valorDeposito;
                            System.out.println("Depósito realizado com sucesso.");
                            break;

                        case 3:
                            System.out.print("Valor a sacar: R$");
                            float valorSaque = t.nextFloat();
                            if (valor[j] >= valorSaque) {
                                valor[j] -= valorSaque;
                                System.out.println("Saque realizado com sucesso.");
                            } else {
                                System.out.println("Saldo insuficiente para realizar o saque.");
                            }
                            break;

                        case 4:
                            System.out.println("Saindo...");
                            break;

                        default:
                            System.out.println("Opção inválida.");
                    }
                } while (opcao != 4);
                break;
            } else {
                j++;
            }
        }

        if (j == i) {
            System.out.println("Número da conta ou senha inválidos. Tente novamente.");
        }
    }

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("Escolha uma das opções:");
            System.out.println("1 - Cadastrar novo cliente");
            System.out.println("2 - Login");
            System.out.println("3 - Sair");
            System.out.print("Opção: ");
            opcao = t.nextInt();

            switch (opcao) {
                case 1:
                    Cadastro();
                    break;

                case 2:
                    Login();
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3);
    }
}
