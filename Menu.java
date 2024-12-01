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
            
            System.out.println("\nDigite a opção desejada:");
            opcao = scanner.nextLine(); 
        
            switch (opcao) {
                case "1": // Cadastro
                    try {
                        boolean voltarCadastro = false; 
                        do {
                            System.out.println("1 - Participante");
                            System.out.println("2 - Organizador");
                            System.out.println("3 - Evento");
                            System.out.println("4 - Local");
                            System.out.println("5 - Voltar");

                            System.out.println("\nDigite a opção desejada:");
                            String opcaoCadastro = scanner.nextLine();
        
                            switch (opcaoCadastro) {
                                case "1": 
                                    System.out.println("Digite o ID do participante:");
                                    int idParticipante = scanner.nextInt();
                                    scanner.nextLine(); 
                                    System.out.println("Digite o nome do participante:");
                                    String nomeParticipante = scanner.nextLine();
                                    System.out.println("Digite o telefone do participante:");
                                    String telefoneParticipante = scanner.nextLine();
                                    System.out.println("Digite o ID de notificação do participante:");
                                    String idNotificacao = scanner.nextLine();
        
                                    try (Connection connection = DriverManager.getConnection(url, user, password)) {
                                        Statement statement = connection.createStatement();
                                        statement.executeUpdate("INSERT INTO pessoa (id, nome) VALUES (" + idParticipante + ", '" + nomeParticipante + "')");
                                        System.out.println("Pessoa inserida com sucesso!");
                                    }
        
                                    try (Connection connection = DriverManager.getConnection(url, user, password)) {
                                        Statement statement = connection.createStatement();
                                        statement.executeUpdate("INSERT INTO participante (id, telefone, id_notificacao) VALUES (" + idParticipante + ", '" + telefoneParticipante + "', '" + idNotificacao + "')");
                                        System.out.println("Participante inserido com sucesso!");
                                    } catch (SQLException e) {
                                        System.out.println("Erro ao inserir participante no banco de dados: " + e.getMessage());
                                    }
                                    break;
        
                                case "2": // Cadastro de Organizador
                                    System.out.println("Digite o ID do organizador:");
                                    int idOrganizador = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Digite o nome do organizador:");
                                    String nomeOrganizador = scanner.nextLine();
                                    System.out.println("Digite o email do organizador:");
                                    String emailOrganizador = scanner.nextLine();
                                    System.out.println("Digite o ID de notificação do organizador:");
                                    String idNotificacaoOrganizador = scanner.nextLine();

                                    try (Connection connection = DriverManager.getConnection(url, user, password)) {
                                        Statement statement = connection.createStatement();
                                        statement.executeUpdate("INSERT INTO pessoa (id, nome) VALUES (" + idOrganizador + ", '" + nomeOrganizador + "')");
                                        System.out.println("Pessoa inserida com sucesso!");
                                    }

                                    try (Connection connection = DriverManager.getConnection(url, user, password)) {
                                        Statement statement = connection.createStatement();
                                        statement.executeUpdate("INSERT INTO organizador (id, email, id_notificacao) VALUES (" + idOrganizador + ", '" + emailOrganizador + "', '" + idNotificacaoOrganizador + "')");
                                        System.out.println("Organizador inserido com sucesso!");
                                    } catch (SQLException e) {
                                        System.out.println("Erro ao inserir organizador no banco de dados: " + e.getMessage());
                                    }

                                    break;
        
                                case "3": // Cadastro de Evento
                                    System.out.println("Digite o ID do evento:");
                                    int idEvento = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Digite o ID do organizador do evento:");
                                    int idOrganizadorEvento = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Digite o ID do local do evento:");
                                    int idLocalEvento = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Digite a data do evento (formato: yyyy-mm-dd):");
                                    String dataEvento = scanner.nextLine();
                                    System.out.println("Digite a descrição do evento:");
                                    String descricaoEvento = scanner.nextLine();
                                    System.out.println("Digite a quantidade de vagas do evento:");
                                    int vagasEvento = scanner.nextInt();
                                    scanner.nextLine();

                                    try (Connection connection = DriverManager.getConnection(url, user, password)) {
                                        Statement statement = connection.createStatement();
                                        statement.executeUpdate("INSERT INTO evento (id, id_organizador, id_local, data, descricao, vagas) VALUES (" + idEvento + ", " + idOrganizadorEvento + ", " + idLocalEvento + ", '" + dataEvento + "', '" + descricaoEvento + "', " + vagasEvento + ")");
                                        System.out.println("Evento inserido com sucesso!");
                                    } catch (SQLException e) {
                                        System.out.println("Erro ao inserir evento no banco de dados: " + e.getMessage());
                                    }
                                    break;
        
                                case "4": // Cadastro de Local
                                    System.out.println("Digite o ID do local:");
                                    int idLocal = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Digite a descrição do local:");
                                    String descricaoLocal = scanner.nextLine();
                                    System.out.println("Digite a quantidade de vagas do local:");
                                    int vagasLocal = scanner.nextInt();
                                    scanner.nextLine();

                                    try (Connection connection = DriverManager.getConnection(url, user, password)) {
                                        Statement statement = connection.createStatement();
                                        statement.executeUpdate("INSERT INTO local (id, descricao, vagas) VALUES (" + idLocal + ", '" + descricaoLocal + "', " + vagasLocal + ")");
                                        System.out.println("Local inserido com sucesso!");
                                    } catch (SQLException e) {
                                        System.out.println("Erro ao inserir local no banco de dados: " + e.getMessage());
                                    }
                                    break;
        
                                case "5": // Voltar ao menu principal
                                    voltarCadastro = true;
                                    break;
        
                                default:
                                    System.out.println("Opção inválida. Tente novamente.");
                                    break;
                            }
                        } while (!voltarCadastro);
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
        
                case "2": // Enviar Notificação

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