import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        final String url = "jdbc:mysql://localhost:3306/orgeventos";
        final String user = "root";
        final String password = "";
        System.out.println("Organizador de Eventos");
        Scanner scanner = new Scanner(System.in);
        String opcao = "0";

        do {
            System.out.println("1 - Cadastros");
            System.out.println("2 - Enviar Notificação");
            System.out.println("3 - Alterações");
            System.out.println("4 - Listas");
            System.out.println("5 - Sair");
            
            try {
                opcao = scanner.nextLine();
            } catch (Exception e) {
                opcao = "0"; 
            }

            switch (opcao) {
                case "1": // Cadastro
                    try {
                        do {
                        System.out.println("1 - Participante");
                        System.out.println("2 - Organizador");
                        System.out.println("3 - Evento");
                        System.out.println("4 - Local");
                        System.out.println("5 - Voltar");
                        String opcaoCadastro = scanner.nextLine();
                        switch (opcaoCadastro) {
                            case "1": // id, nome, telefone, notifica
                                System.out.println("Digite o ID do participante:");
                                int idParticipante = scanner.nextInt();
                                System.out.println("Digite o nome do participante:");
                                String nomeParticipante = scanner.nextLine();
                                System.out.println("Digite o telefone do participante:");
                                String telefoneParticipante = scanner.nextLine();
                                System.out.println("Digite o tipo de notificação do participante:");
                                String notificaParticipante = scanner.nextLine();
                                Pessoa pessoa = new Participante(idParticipante, nomeParticipante, telefoneParticipante, notificaParticipante);

                                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                                    Statement statement = connection.createStatement();
                                    statement.executeUpdate("INSERT INTO pessoa (id, nome) VALUES (" + idParticipante + ", '" + nomeParticipante + "')");
                                } catch (SQLException e) {
                                    System.out.println("Erro ao inserir pessoa no banco de dados");
                                }
                                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                                    Statement statement = connection.createStatement();
                                    statement.executeUpdate("INSERT INTO participante (id, telefone, notifica) VALUES (" + idParticipante + ", '" + nomeParticipante + "', '" + telefoneParticipante + "', '" + notificaParticipante + "')");
                                } catch (SQLException e) {
                                    System.out.println("Erro ao inserir participante no banco de dados");
                                }
                            break;

                            case "2":

                            break;

                            case "3":

                            break;

                            case "4":

                            break;

                            case "5":

                            break;
                        } 
                        } while (opcao != "5");
                    } catch (Exception e) {
                        System.out.println("");
                    }
                break;

                case "2": // Notificação
                try {
                    
                } catch (Exception e) {
                    System.out.println("");
                }
                break;

                case "3": // Alterações
                try {
                    do {
                    System.out.println("1 - Participante");
                    System.out.println("2 - Organizador");
                    System.out.println("3 - Evento");
                    System.out.println("4 - Local");
                    System.out.println("5 - Voltar");
                    String opcaoCadastro = scanner.nextLine();
                    switch (opcaoCadastro) {
                        case "1":

                        break;

                        case "2":

                        break;

                        case "3":

                        break;

                        case "4":

                        break;

                        case "5":
                        
                        break;
                    } 
                    } while (opcao != "5");
                } catch (Exception e) {
                    System.out.println("");
                }
                break;

                case "4": // Listas
                try {
                    do {
                    System.out.println("1 - Participante");
                    System.out.println("2 - Organizador");
                    System.out.println("3 - Evento");
                    System.out.println("4 - Local");
                    System.out.println("5 - Voltar");
                    String opcaoCadastro = scanner.nextLine();
                    switch (opcaoCadastro) {
                        case "1":

                        break;

                        case "2":

                        break;

                        case "3":

                        break;

                        case "4":

                        break;

                        case "5":
                        
                        break;
                    } 
                    } while (opcao != "5");
                } catch (Exception e) {
                    System.out.println("");
                }
                break;

                case "5": // Sair
                System.out.println("\nSaindo...");
                break;

                default:
                    System.out.println("\nOpção inválida");
                    break;
            }
        } while (opcao != "5");
        scanner.close();
    }
}