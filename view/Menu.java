package view;

import model.funcionario;
import service.gerenciamentoRH;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        gerenciamentoRH service = new gerenciamentoRH();
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- MENU FUNCIONÁRIOS ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Remover");
            System.out.println("3 - Dar Aumento (%)");
            System.out.println("4 - Listar Todos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // Limpa o buffer
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Salário: ");
                    double salario = sc.nextDouble();
                    
                    funcionario funcionario = new funcionario(id, nome, salario);
                    service.cadastrar(funcionario);
                    System.out.println("Cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("ID para remover: ");
                    int idRemover = sc.nextInt();
                    if (service.remover(idRemover)) {
                        System.out.println("Removido!");
                    } else {
                        System.out.println("ID não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("ID do funcionário: ");
                    int idAumento = sc.nextInt();
                    System.out.print("Porcentagem de aumento: ");
                    double porc = sc.nextDouble();
                      boolean funcionou = service.darAumento(idAumento, porc);

                     if (funcionou) {
                         System.out.println("Aumento aplicado com sucesso!");
                    } else {
                        System.out.println("ERRO: O funcionário " + idAumento + " não existe!");
                    }
                    break;

                case 4:
                    System.out.println("\n--- LISTA DE FUNCIONÁRIOS ---");
                    for (funcionario f : service.listarTodos()) {
                        System.out.println("ID: " + f.getId() + " | Nome: " + f.getNome() + " | Salário: R$ " + f.getSalario());
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        sc.close();
    }
}

