/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.poo;

/**
 * @author mateus
 *
  Documento do Codigo em Portugues/Brazil
                                           
O código é um programa em Java que simula um sistema bancário básico, com as funcionalidades de cadastro de usuários,
login, consulta de dados do usuário, alteração de senha e celular, adição e retirada de saldo, e exclusão de conta.
 
O programa começa criando um ArrayList vazio de usuários. Em seguida, entra em um loop que exibe um menu de opções para o usuário.
As opções são: fazer cadastro, fazer login ou sair.

Se o usuário escolher fazer cadastro, o programa solicita informações básicas do usuário, como nome, CPF, celular e senha.
A senha é criptografada antes de ser armazenada no objeto do usuário.
Após a validação das informações, um novo objeto de usuário é criado e adicionado ao ArrayList.

Se o usuário escolher fazer login, o programa solicita o ID e a senha do usuário.
A senha é criptografada e comparada com a senha armazenada no objeto de usuário correspondente.
Se as informações estiverem corretas, o usuário é logado no sistema e um menu de opções é exibido com as funcionalidades disponíveis.

Se o usuário estiver logado, ele pode escolher uma das opções disponíveis. Se escolher mostrar dados, o programa exibe as informações do usuário.
Se escolher alterar senha ou celular,o programa solicita a nova informação e atualiza o objeto do usuário correspondente.
Se escolher adicionar ou retirar saldo, o programa solicita o valor e atualiza o saldo do usuário correspondente.
Se escolher deletar conta, o objeto de usuário correspondente é removido do ArrayList.

O loop continua até que o usuário escolha sair do programa.

Este código utiliza um método simples de criptografia, deslocando cada caractere da string de senha em uma posição na tabela ASCII. Veja como funciona:
1- A string de senha é primeiro convertida em um array de caracteres usando o método toCharArray().
2-Um loop itera através de cada caractere no array.
3-Cada caractere é deslocado em uma posição, adicionando 1 ao seu valor inteiro usando a expressão (char) (chars[i] + 1).
4-Os caracteres criptografados são armazenados de volta no mesmo array.
5-Por fim, o array de caracteres criptografados é convertido de volta em uma string.


                                           Code documentation in English 

The code is a Java program that simulates a basic banking system, with functionalities such as user registration, login, user data retrieval,
password and phone number change, adding and withdrawing balance, and account deletion.

The program starts by creating an empty ArrayList of users. Then, it enters a loop that displays a menu of options for the user.
The options are to register, log in, or exit.

If the user chooses to register, the program asks for basic user information such as name, CPF (Brazilian ID number), phone number, and password.
The password is encrypted before being stored in the user object.
After validating the information, a new user object is created and added to the ArrayList.

If the user chooses to log in, the program asks for the user ID and password.
The password is encrypted and compared to the stored password in the corresponding user object. If the information is correct,
the user is logged into the system, and a menu of options is displayed with the available functionalities.

If the user is logged in, they can choose one of the available options. If they choose to show data, the program displays the user's information.
If they choose to change their password or phone number,
the program prompts for the new information and updates the corresponding user object.
If they choose to add or withdraw balance, the program prompts for the value and updates the corresponding user's balance.
If they choose to delete their account, the corresponding user object is removed from the ArrayList.

The loop continues until the user chooses to exit the program.

This code uses a simple encryption method by shifting each character in the password string by one in the ASCII table. Here is how it works:
1-The password string is first converted into a character array using the toCharArray() method.
2-A loop iterates through each character in the array.
3-Each character is shifted by one position by adding 1 to its integer value using the (char) expression (chars[i] + 1).
4-The encrypted characters are stored back in the same array.
5-Finally, the encrypted character array is converted.
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Poo {

    public static void main(String[] args) {
        ArrayList<User> usuarios = new ArrayList<>();
        boolean sair = false;
        while (!sair) {
            String opcao = JOptionPane.showInputDialog("Escolha uma opção:\n1. Fazer cadastro\n2. Fazer login\n3. Sair");

            switch (opcao) {
                case "1":
                    cadastrar(usuarios);
                    break;
                case "2":
                    User usuarioLogado = fazerLogin(usuarios);
                    if (usuarioLogado != null) {
                        boolean logado = true;
                        while (logado) {
                            String opcaoLogado = JOptionPane.showInputDialog("Escolha uma opção:\n1. Mostrar dados do cliente\n2. Alterar senha\n3. Alterar celular\n4. Adicionar saldo\n5. Retirar saldo\n6. Deletar conta\n7. Voltar ao menu principal");
                            switch (opcaoLogado) {
                                case "1":
                                    mostrarDados(usuarioLogado);
                                    break;
                                case "2":
                                    alterarSenha(usuarioLogado);
                                    break;
                                case "3":
                                    alterarCelular(usuarioLogado);
                                    break;
                                case "4":
                                    adicionarSaldo(usuarioLogado);
                                    break;
                                case "5":
                                    retirarSaldo(usuarioLogado);
                                    break;
                                case "6":
                                    deletarConta(usuarios, usuarioLogado);
                                    logado = false;
                                    break;
                                case "7":
                                    logado = false;
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Dados incorretos ou usuário não existe!");
                    }
                    break;
                case "3":
                    sair = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    public static void cadastrar(ArrayList<User> usuarios) {
        String nome = JOptionPane.showInputDialog("Digite seu nome:");
        String cpf = "";
        while (cpf.length() != 11) {
            cpf = JOptionPane.showInputDialog("Digite seu CPF (11 dígitos):");
            boolean cpfCadastrado = false;
            for (User usuario : usuarios) {
                if (usuario.getCpf().equals(cpf)) {
                    cpfCadastrado = true;
                    break;
                }
            }
            if (cpfCadastrado) {
                JOptionPane.showMessageDialog(null, "CPF já cadastrado. Digite outro CPF.");
                cpf = "";
            }
        }
        String celular = "";
        while (celular.length() != 11) {
            celular = JOptionPane.showInputDialog("Digite seu celular (11 dígitos):");
            boolean celularCadastrado = false;
            for (User usuario : usuarios) {
                if (usuario.getCelular().equals(celular)) {
                    celularCadastrado = true;
                    break;
                }
            }
            if (celularCadastrado) {
                JOptionPane.showMessageDialog(null, "Celular já cadastrado. Digite outro celular.");
                celular = "";
            }
        }
        int id = usuarios.size();
        String senha = "";
        while (senha.length() != 4) {
            senha = JOptionPane.showInputDialog("Digite sua senha (4 dígitos):");
        }
        senha = criptografarSenha(senha);
        User novoUsuario = new User(nome, cpf, celular, String.valueOf(id), senha, 0.0);
        usuarios.add(novoUsuario);
        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso! Seu ID é " + id);
    }

    public static User fazerLogin(ArrayList<User> usuarios) {
        String id = JOptionPane.showInputDialog("Digite seu ID:");
        String senha = JOptionPane.showInputDialog("Digite sua senha:");
        for (User usuario : usuarios) {
            if (usuario.getId().equals(id) && usuario.getSenha().equals(criptografarSenha(senha))) {
                JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
                return usuario;
            }
        }
        return null;
    }

    public static void mostrarDados(User usuario) {
        JOptionPane.showMessageDialog(null, "Nome: " + usuario.getNome() + "\nCPF: " + usuario.getCpf() + "\nCelular: "
                + usuario.getCelular() + "\nSaldo: R$" + usuario.getSaldo());
    }

    public static void alterarSenha(User usuario) {
        String novaSenha = criptografarSenha(JOptionPane.showInputDialog("Digite sua nova senha:"));
        usuario.setSenha(novaSenha);
        JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
    }

    public static void alterarCelular(User usuario) {
        String novoCelular = JOptionPane.showInputDialog("Digite seu novo celular:");
        usuario.setCelular(novoCelular);
        JOptionPane.showMessageDialog(null, "Celular alterado com sucesso!");
    }

    public static void adicionarSaldo(User usuario) {
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser adicionado:"));
        usuario.depositar(valor);
        JOptionPane.showMessageDialog(null, "Saldo adicionado com sucesso!");
    }

    public static void retirarSaldo(User usuario) {
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser retirado:"));
        if (valor > usuario.getSaldo()) {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
        } else {
            usuario.sacar(valor);
            JOptionPane.showMessageDialog(null, "Saldo retirado com sucesso!");
        }
    }

    public static void deletarConta(ArrayList<User> usuarios, User usuario) {
        usuarios.remove(usuario);
        JOptionPane.showMessageDialog(null, "Conta deletada com sucesso!");
    }

    public static String criptografarSenha(String senha) {
        char[] chars = senha.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + 1);
        }
        return new String(chars);
    }
}
