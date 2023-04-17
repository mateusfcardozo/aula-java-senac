/*A função banco possui um método main, que inicia a execução do programa, e outras três funções: cadastrarCliente, realizarLogin e atualizarCliente.

A função "cadastrarCliente" permite cadastrar um novo cliente no sistema bancário. Ele solicita ao usuário que informe o nome, CPF, senha e celular do cliente. Se o número de clientes cadastrados ultrapassar o limite de 10,
a função exibe uma mensagem informando que o limite foi atingido. Caso contrário, os dados do novo cliente são armazenados em uma matriz clientes.

A função "realizarLogin" permite que um cliente faça login no sistema. Ele solicita que o usuário informe seu CPF e senha, e verifica se há um cliente com esses dados cadastrado no sistema. Se houver, a função exibe o nome,
saldo e celular do cliente e chama a função atualizarCliente para permitir que o cliente atualize seus dados. Se não houver, a função exibe uma mensagem informando que o CPF ou a senha estão incorretos.

A função "atualizarCliente" permite que um cliente atualize seus dados cadastrados no sistema. Ele exibe um menu com as opções disponíveis: atualizar nome, atualizar senha, atualizar celular, adicionar saldo e voltar.
Cada opção chama um método específico que realiza a atualização correspondente. O método de adicionar saldo também atualiza o saldo do cliente na matriz clientes.

Em geral, o programa permite que novos clientes se cadastrem, que clientes existentes façam login e atualizem seus dados cadastrados, e que o saldo dos clientes seja atualizado.
Ele armazena os dados dos clientes em uma matriz e utiliza a classe Scanner para receber entradas do usuário.
*/
import java.util.Scanner;
public class banco{
    static Scanner scanner = new Scanner(System.in);
    static String[][] clientes = new String[10][5]; 
    static int auxiliar = 0;
    
    public static void cadastrarCliente(){
        System.out.println("\nCadastro de cliente");
        if (auxiliar >= clientes.length) {
            System.out.println("Limite de clientes atingido.");
        }
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Celular: ");
        String celular = scanner.nextLine();
        
        clientes[auxiliar][0] = nome;
        clientes[auxiliar][1] = cpf;
        clientes[auxiliar][2] = senha;
        clientes[auxiliar][3] = celular;
        clientes[auxiliar][4] = "0.00";
        auxiliar++;
        System.out.println("Cliente cadastrado com sucesso.");
    }
    
    public static void realizarLogin(){
        System.out.println("\nLogin");
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        
        for (int i = 0; i < auxiliar; i++) {
            if (clientes[i][1].equals(cpf) && clientes[i][2].equals(senha)){
                System.out.print("------------");
                System.out.println("Nome: " + clientes[i][0]);
                System.out.println("Saldo: R$" + clientes[i][4]);
                System.out.println("Celular: " + clientes[i][3]);
                atualizarCliente(i);
            }
        }
        System.out.println("CPF ou senha incorretos.");
    }
    
   public static void atualizarCliente(int auxiliarCliente){
        int opcao;
        System.out.println("\nAtualizar dados");
        System.out.println("1 - Nome");
        System.out.println("2 - Senha");
        System.out.println("3 - Celular");
        System.out.println("4 - Adicionar saldo");
        System.out.println("5 - Voltar");
        System.out.print("Opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine();
    
        switch(opcao){
            case 1:
                System.out.print("Novo nome: ");
                clientes[auxiliarCliente][0] = scanner.nextLine();
                System.out.println("Nome atualizado.");
                atualizarCliente(auxiliarCliente);
                break;
            case 2:
                System.out.print("Insira a nova senha: ");
                clientes[auxiliarCliente][2] = scanner.nextLine();
                System.out.println("Senha atualizada.");
                atualizarCliente(auxiliarCliente);
                break;
            case 3:
                System.out.print("Novo celular: ");
                clientes[auxiliarCliente][3] = scanner.nextLine();
                System.out.println("Celular atualizado.");
                atualizarCliente(auxiliarCliente);
                break;
            case 4:
                System.out.print("Valor a adicionar: R$");
                String valor = scanner.nextLine();
                double saldoAnterior = Double.parseDouble(clientes[auxiliarCliente][4]);
                double novoSaldo = saldoAnterior + Double.parseDouble(valor);
                clientes[auxiliarCliente][4] = String.format("%.2f", novoSaldo);
                System.out.println("Saldo atualizado.");
                atualizarCliente(auxiliarCliente);
                break;
            case 5:
                System.out.println("Voltando...");
                break;
            default:
                System.out.println("Opção inválida.");
                atualizarCliente(auxiliarCliente);
        }
    }
    
    public static void main(String[] args){
        int opcao;
        do {
            System.out.println("\nbanco Turus");
            System.out.println("\nEscolha uma das opções");
            System.out.println("1 - Cadastrar-se");
            System.out.println("2 - Fazer login");
            System.out.println("3 - Sair");
            System.out.print("Opção: ");
    
            opcao = scanner.nextInt();
            scanner.nextLine();
    
            switch (opcao){
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    realizarLogin();
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
