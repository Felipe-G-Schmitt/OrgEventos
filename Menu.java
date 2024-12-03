import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Date;
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
            System.out.println("\n-=-=-=-=--=-==-=-=-=-=");
            System.out.println("Menu Principal");
            System.out.println("-=-=-=-=--=-==-=-=-=-=");

            System.out.println("1 - Cadastros");
            System.out.println("2 - Enviar Notificação");
            System.out.println("3 - Alterações");
            System.out.println("4 - Listas");
            System.out.println("5 - Deletar");
            System.out.println("6 - Adicionar");
            System.out.println("7 - Sair");
            
            System.out.println("\nDigite a opção desejada:");
            opcao = scanner.nextLine();
        
            switch (opcao) {
                case "1": // Cadastro
                    try {
                        boolean voltarCadastro = false; 
                        do {
                            System.out.println("\n-=-=-=-=--=-==-=-=-=-=");
                            System.out.println("Cadastros");
                            System.out.println("-=-=-=-=--=-==-=-=-=-=");

                            System.out.println("1 - Participante");
                            System.out.println("2 - Organizador");
                            System.out.println("3 - Evento (Mínimo um local cadastrado)");
                            System.out.println("4 - Local");
                            System.out.println("5 - Voltar");

                            System.out.println("\nDigite a opção desejada:");
                            String opcaoCadastro = scanner.nextLine();
        
                            switch (opcaoCadastro) {
                                case "1": 
                                    System.out.println("Cadastro de Participante");

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
                                    System.out.println("Cadastro de Organizador");

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
                                    System.out.println("Cadastro de Evento");

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
                                    System.out.println("Cadastro de Local");

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
                                    System.out.println("Voltando...");
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
                try {
                    boolean voltarNotificacao = false;
                    do {
                    System.out.println("\n-=-=-=-=--=-==-=-=-=-=");
                    System.out.println("Enviar Notificação");
                    System.out.println("-=-=-=-=--=-==-=-=-=-=");

                    System.out.println("1 - Enviar notificação");
                    System.out.println("2 - Ver notifcação");
                    System.out.println("3 - Voltar");

                    System.out.println("\nDigite a opção desejada:");
                    String opcaoCadastro = scanner.nextLine();
                    System.out.println("\n");

                    switch (opcaoCadastro) {
                        case "1":
                        try {
                            System.out.println("Enviar Notificação");

                            System.out.println("Digite o ID do evento:");
                            int idEvento = scanner.nextInt();
                            scanner.nextLine(); // Come \n
                            System.out.println("Digite o ID do participante:");
                            int idParticipante = scanner.nextInt();
                            scanner.nextLine(); // Come \n
                            System.out.println("Digite a mensagem da notificação:");
                            String mensagem = scanner.nextLine();

                            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                                Statement statement = connection.createStatement();
                                statement.executeUpdate("INSERT INTO notificacaoenviada (id_evento, id_participante, mensagem) VALUES (" 
                                                        + idEvento + ", " + idParticipante + ", '" + mensagem + "')");
                                System.out.println("Notificação enviada com sucesso!");
                            } catch (SQLException e) {
                                System.out.println("Erro ao enviar a notificação: " + e.getMessage());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                        case "2":
                        try {   
                            System.out.println("Listagem de Notificações");
                        
                            Connection con = DriverManager.getConnection(url, user, password);
                            Statement stm = con.createStatement();
                            
                            ResultSet sql = stm.executeQuery("SELECT * FROM notificacaoenviada;");
                            
                            // Verificar se há notificações e exibir
                            while (sql.next()) {
                                Notificacaoenviada notificacao = new Notificacaoenviada(
                                    sql.getInt("id_evento"),
                                    sql.getInt("id_participante"),
                                    sql.getString("mensagem")
                                );
                                
                                System.out.println("ID Evento: " + notificacao.getIdEvento() +
                                                   " | ID Participante: " + notificacao.getIdParticipante() +
                                                   " | Mensagem: " + notificacao.getMensagem());
                            }
                            
                            con.close();
                        } catch (SQLException e) {
                            System.out.println("Erro ao listar notificações: " + e.getMessage());
                        }                        
                        break;

                        case "3":
                        System.out.println("Voltando...");
                        voltarNotificacao = true;
                        break;
                    }


                } while (!voltarNotificacao);
                } catch (Exception e) {
                    System.out.println("");
                }
                break;

                case "3": // Alterações
                try {
                    boolean voltarAlteracoes = false;
                    do {
                    System.out.println("\n-=-=-=-=--=-==-=-=-=-=");
                    System.out.println("Alterações");
                    System.out.println("-=-=-=-=--=-==-=-=-=-=");

                    System.out.println("1 - Participante");
                    System.out.println("2 - Organizador");
                    System.out.println("3 - Evento");
                    System.out.println("4 - Local");
                    System.out.println("5 - Voltar");

                    System.out.println("\nDigite a opção desejada:");
                    String opcaoCadastro = scanner.nextLine();
                    System.out.println("\n"); 

                    switch (opcaoCadastro) {
                        case "1":
                        try {
                            System.out.println("Alteração de Participante");

                            System.out.println("Informe o ID de alteração: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                
                            Connection con = DriverManager.getConnection(url, user, password);
                            Statement stm = con.createStatement();
                            ResultSet rs = stm.executeQuery("SELECT p.id, p.nome, pa.telefone, pa.id_notificacao " +
                                                            "FROM pessoa p " +
                                                            "LEFT JOIN participante pa ON p.id = pa.id " +
                                                            "WHERE p.id = " + id);
                
                            if (!rs.next()) {
                                throw new Exception("ID inválido");
                            }
                
                            Pessoa pessoa = new Pessoa(
                                rs.getInt("id"),
                                rs.getString("nome")
                            );
                
                            String telefoneAtual = rs.getString("telefone");
                            int idNotificacaoAtual = rs.getInt("id_notificacao");
                
                            Participante participante = new Participante(
                                pessoa.getId(),
                                pessoa.getNome(),
                                telefoneAtual,
                                idNotificacaoAtual
                            );
                
                            con.close();
                
                            System.out.println("Informe o nome da pessoa (Deixar vazio para manter):");
                            String nome = scanner.nextLine();
                            if (!nome.isEmpty()) {
                                participante.setNome(nome);
                            }
                
                            System.out.println("Informe o telefone do participante (Deixar vazio para manter):");
                            String telefone = scanner.nextLine();
                            if (!telefone.isEmpty()) {
                                participante.setTelefone(telefone);
                            }
                
                            System.out.println("Informe o ID de notificação do participante (Deixar vazio para manter):");
                            String idNotificacaoInput = scanner.nextLine();
                            if (!idNotificacaoInput.isEmpty()) {
                                participante.setIdNotificacao(Integer.parseInt(idNotificacaoInput));
                            }
                
                            con = DriverManager.getConnection(url, user, password);
                            stm = con.createStatement();
                
                            boolean sqlPessoa = stm.execute("UPDATE pessoa SET "
                                    + "nome = '" + participante.getNome() + "' "
                                    + "WHERE id = " + participante.getId());
                
                            boolean sqlParticipante = stm.execute("UPDATE participante SET "
                                    + "telefone = '" + participante.getTelefone() + "', "
                                    + "id_notificacao = " + participante.getIdNotificacao() + " "
                                    + "WHERE id = " + participante.getId());
                
                            if (sqlPessoa || sqlParticipante) {
                                System.out.println("Falha na execução");
                            }
                
                            con.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                        case "2":
                        try {
                            System.out.println("Alteração de Organizador");

                            System.out.println("Informe o ID de alteração: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                
                            Connection con = DriverManager.getConnection(url, user, password);
                            Statement stm = con.createStatement();
                            ResultSet rs = stm.executeQuery("SELECT p.id, p.nome, o.email, o.id_notificacao " +
                                                            "FROM pessoa p " +
                                                            "LEFT JOIN organizador o ON p.id = o.id " +
                                                            "WHERE p.id = " + id);
                
                            if (!rs.next()) {
                                throw new Exception("ID inválido");
                            }
                
                            Pessoa pessoa = new Pessoa(
                                rs.getInt("id"),
                                rs.getString("nome")
                            );
                
                            String emailAtual = rs.getString("email");
                            int idNotificacaoAtual = rs.getInt("id_notificacao");
                
                            Organizador organizador = new Organizador(
                                pessoa.getId(),
                                pessoa.getNome(),
                                emailAtual,
                                idNotificacaoAtual
                            );
                
                            con.close();
                
                            System.out.println("Informe o nome da pessoa (Deixar vazio para manter):");
                            String nome = scanner.nextLine();
                            if (!nome.isEmpty()) {
                                organizador.setNome(nome);
                            }

                            System.out.println("Informe o email do organizador (Deixar vazio para manter):");
                            String email = scanner.nextLine();
                            if (!email.isEmpty()) {
                                organizador.setEmail(email);
                            }

                            System.out.println("Informe o ID de notificação do organizador (Deixar vazio para manter):");
                            String idNotificacaoInput = scanner.nextLine();
                            if (!idNotificacaoInput.isEmpty()) {
                                organizador.setIdNotificacao(Integer.parseInt(idNotificacaoInput));
                            }

                            con = DriverManager.getConnection(url, user, password);
                            stm = con.createStatement();

                            boolean sqlPessoa = stm.execute("UPDATE pessoa SET "
                                    + "nome = '" + organizador.getNome() + "' "
                                    + "WHERE id = " + organizador.getId());

                            boolean sqlOrganizador = stm.execute("UPDATE organizador SET "
                                    + "email = '" + organizador.getEmail() + "', "
                                    + "id_notificacao = " + organizador.getIdNotificacao() + " "
                                    + "WHERE id = " + organizador.getId());

                            if (sqlPessoa || sqlOrganizador) {
                                System.out.println("Falha na execução");
                            }
                        
                            con.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                        case "3":
                        try {
                            System.out.println("Alteração de evento:");
                        
                            System.out.println("Informe o ID de alteração:");
                            int id = scanner.nextInt();
                            scanner.nextLine(); 
                        
                            Connection con = DriverManager.getConnection(url, user, password);
                            Statement stm = con.createStatement();
                            ResultSet rs = stm.executeQuery("SELECT * FROM evento WHERE id = " + id);
                        
                            if (!rs.next()) {
                                con.close();
                                throw new Exception("ID inválido");
                            }
                        
                            Evento evento = new Evento(
                                rs.getInt("id"),
                                rs.getInt("id_organizador"),
                                rs.getInt("id_local"),
                                rs.getDate("data"),
                                rs.getString("descricao"),
                                rs.getInt("vagas")
                            );
                        
                            con.close(); 
                        
                            System.out.println("Informe o ID do organizador do evento (Deixar vazio para manter):");
                            String idOrganizador = scanner.nextLine();
                            if (!idOrganizador.isEmpty()) {
                                con = DriverManager.getConnection(url, user, password); 
                                stm = con.createStatement();
                                rs = stm.executeQuery("SELECT id FROM organizador WHERE id = " + idOrganizador);
                                if (!rs.next()) {
                                    con.close();
                                    throw new Exception("ID do organizador inválido. Não existe no banco de dados.");
                                }
                                evento.setIdOrganizador(Integer.parseInt(idOrganizador));
                                con.close(); // Fechando conexão
                            }
                        
                            System.out.println("Informe o ID do local do evento (Deixar vazio para manter):");
                            String idLocal = scanner.nextLine();
                            if (!idLocal.isEmpty()) {
                                con = DriverManager.getConnection(url, user, password); 
                                stm = con.createStatement();
                                rs = stm.executeQuery("SELECT id FROM local WHERE id = " + idLocal);
                                if (!rs.next()) {
                                    con.close();
                                    throw new Exception("ID do local inválido. Não existe no banco de dados.");
                                }
                                evento.setIdLocal(Integer.parseInt(idLocal));
                                con.close();
                            }
                        
                            System.out.println("Informe a data do evento (formato yyyy-mm-dd, deixar vazio para manter):");
                            String dataInput = scanner.nextLine();
                            if (!dataInput.isEmpty()) {
                                try {
                                    Date novaData = Date.valueOf(dataInput);
                                    evento.setData(novaData);
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Formato de data inválido. Use o formato yyyy-mm-dd.");
                                }
                            }
                        
                            System.out.println("Informe a descrição do evento (Deixar vazio para manter):");
                            String descricao = scanner.nextLine();
                            if (!descricao.isEmpty()) {
                                evento.setDescricao(descricao);
                            }
                        
                            System.out.println("Informe a quantidade de vagas do evento (Deixar vazio para manter):");
                            String vagas = scanner.nextLine();
                            if (!vagas.isEmpty()) {
                                evento.setVagas(Integer.parseInt(vagas));
                            }
                        
                            // Atualização do evento no banco
                            con = DriverManager.getConnection(url, user, password);
                            stm = con.createStatement();
                        
                            String updateQuery = String.format(
                                "UPDATE evento SET id_organizador = %d, id_local = %d, data = '%s', descricao = '%s', vagas = %d WHERE id = %d",
                                evento.getIdOrganizador().intValue(),
                                evento.getIdLocal().intValue(),
                                evento.getData().toString(),
                                evento.getDescricao(),
                                evento.getVagas().intValue(),
                                evento.getId().intValue()
                            );
                        
                            int rowsAffected = stm.executeUpdate(updateQuery);
                        
                            if (rowsAffected > 0) {
                                System.out.println("Evento atualizado com sucesso!");
                            } else {
                                System.out.println("Falha na atualização do evento.");
                            }
                        
                            con.close(); 
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        
                        break;

                        case "4":
                        try {
                            System.out.println("Alteração de Local");

                            System.out.println("Informe o ID de alteração: ");
                            int id = scanner.nextInt();
                            scanner.nextLine(); 
                
                            Connection con = DriverManager.getConnection(url, user, password);
                            Statement stm = con.createStatement();
                            ResultSet rs = stm.executeQuery("SELECT * FROM local WHERE id = " + id);
                
                            if (!rs.next()) {
                                throw new Exception("ID inválido");
                            }
                
                            Local local = new Local(
                                rs.getInt("id"),
                                rs.getString("descricao"),
                                rs.getInt("vagas")
                            );
                
                            con.close();
                
                            System.out.println("Informe a descrição do local (Deixar vazio para manter):");
                            String descricao = scanner.nextLine();
                            if (!descricao.isEmpty()) {
                                local.setDescricao(descricao);
                            }
                
                            System.out.println("Informe a quantidade de vagas do local (Deixar vazio para manter):");
                            String vagas = scanner.nextLine();
                            if (!vagas.isEmpty()) {
                                local.setVagas(Integer.parseInt(vagas));
                            }

                            con = DriverManager.getConnection(url, user, password);
                            stm = con.createStatement();

                            boolean sqlLocal = stm.execute("UPDATE local SET "
                                    + "descricao = '" + local.getDescricao() + "', "
                                    + "vagas = " + local.getVagas() + " "
                                    + "WHERE id = " + local.getId());

                            if (sqlLocal) {
                                System.out.println("Falha na execução");
                            }

                            con.close();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                        case "5":
                        System.out.println("Voltando...");
                        voltarAlteracoes = true;
                        break;
                    } 
                    } while (!voltarAlteracoes);
                } catch (Exception e) {
                    System.out.println("");
                }
                break;

                case "4": // Listas
                try {
                    boolean voltarListas = false;
                    do {
                    System.out.println("\n-=-=-=-=--=-==-=-=-=-=");
                    System.out.println("Listas");
                    System.out.println("-=-=-=-=--=-==-=-=-=-=");

                    System.out.println("1 - Participante");
                    System.out.println("2 - Organizador");
                    System.out.println("3 - Evento");
                    System.out.println("4 - Local");
                    System.out.println("5 - Listar participantes em eventos");
                    System.out.println("6 - Listar organizadores em eventos");
                    System.out.println("7 - Voltar");
                    String opcaoCadastro = scanner.nextLine();
                    switch (opcaoCadastro) {
                        case "1":
                        try {
                            System.out.println("Listagem de Participantes");

                            Connection con = DriverManager.getConnection(url, user, password);
                            Statement stm = con.createStatement();
                            
                            ResultSet sql = stm.executeQuery("SELECT p.id, p.nome, pa.telefone, pa.id_notificacao " +
                                                             "FROM pessoa p " +
                                                             "INNER JOIN participante pa ON p.id = pa.id;");
                        
                            while (sql.next()) {
                                Participante participante = new Participante(
                                    sql.getInt("id"),
                                    sql.getString("nome"),
                                    sql.getString("telefone"),
                                    sql.getInt("id_notificacao")
                                );
                        
                                System.out.println("ID: " + participante.getId() +
                                                   " | Nome: " + participante.getNome() +
                                                   " | Telefone: " + participante.getTelefone() +
                                                   " | Notificação: " + participante.getIdNotificacao());
                            }
                            
                            con.close();
                        } catch (SQLException e) {
                            System.out.println("Erro ao listar participantes: " + e.getMessage());
                        }
                        
                        break;

                        case "2":
                        try {
                            System.out.println("Listagem de Organizadores");

                            Connection con = DriverManager.getConnection(url, user, password);
                            Statement stm = con.createStatement();
                            
                            ResultSet sql = stm.executeQuery("SELECT p.id, p.nome, o.email, o.id_notificacao " +
                                                             "FROM pessoa p " +
                                                             "INNER JOIN organizador o ON p.id = o.id;");
                        
                            while (sql.next()) {
                                Organizador organizador = new Organizador(
                                    sql.getInt("id"),
                                    sql.getString("nome"),
                                    sql.getString("email"),
                                    sql.getInt("id_notificacao")
                                );
                        
                                System.out.println("ID: " + organizador.getId() +
                                                   " | Nome: " + organizador.getNome() +
                                                   " | Email: " + organizador.getEmail() +
                                                   " | Notificação: " + organizador.getIdNotificacao());
                            }
                            
                            con.close();
                        } catch (SQLException e) {
                            System.out.println("Erro ao listar organizadores: " + e.getMessage());
                        }
                        break;

                        case "3":
                        try {
                            System.out.println("Listagem de Eventos");
                            
                            Connection con = DriverManager.getConnection(url, user, password);
                            Statement stm = con.createStatement();
                            
                            ResultSet sql = stm.executeQuery("SELECT * FROM evento;");
                            
                            while (sql.next()) {
                                Evento evento = new Evento(
                                    sql.getInt("id"),
                                    sql.getInt("id_organizador"),
                                    sql.getInt("id_local"),
                                    sql.getDate("data"),
                                    sql.getString("descricao"),
                                    sql.getInt("vagas")
                                );
                                
                                System.out.println(evento);
                            }
                            
                            con.close();
                        } catch (SQLException e) {
                            System.out.println("Erro ao listar eventos: " + e.getMessage());
                        }
                                      
                        break;

                        case "4":
                        try {   
                            System.out.println("Listagem de Locais");

                            Connection con = DriverManager.getConnection(url, user, password);
                            Statement stm = con.createStatement();
                            
                            ResultSet sql = stm.executeQuery("SELECT * FROM local;");
                        
                            while (sql.next()) {
                                Local local = new Local(
                                    sql.getInt("id"),
                                    sql.getString("descricao"),
                                    sql.getInt("vagas")
                                );
                        
                                System.out.println("ID: " + local.getId() +
                                                   " | Descrição: " + local.getDescricao() +
                                                   " | Vagas: " + local.getVagas());
                            }
                            
                            con.close();
                        } catch (SQLException e) {
                            System.out.println("Erro ao listar locais: " + e.getMessage());
                        }
                        break;

                        case "5":
                        try {
                            System.out.println("Listar participantes de um evento:");

                            System.out.println("Informe o ID do evento:");
                            int idEvento = scanner.nextInt();
                            scanner.nextLine(); 

                            try (Connection con = DriverManager.getConnection(url, user, password);
                                Statement stm = con.createStatement()) {

                                ResultSet rs = stm.executeQuery("SELECT * FROM evento WHERE id = " + idEvento);
                                if (!rs.next()) {
                                    throw new Exception("Evento não encontrado com o ID informado.");
                                }

                                System.out.println("Evento encontrado:");
                                System.out.println("ID: " + rs.getInt("id"));
                                System.out.println("Descrição: " + rs.getString("descricao"));
                                System.out.println("Data: " + rs.getDate("data"));
                                System.out.println("Local: " + rs.getInt("id_local"));

                                String query = "SELECT pe.id, pe.nome, pa.telefone " +
                                            "FROM evento_participante ep " +
                                            "JOIN participante pa ON ep.id_participante = pa.id " +
                                            "JOIN pessoa pe ON pa.id = pe.id " +
                                            "WHERE ep.id_evento = " + idEvento;

                                rs = stm.executeQuery(query);

                                System.out.println("\nParticipantes no evento:");
                                boolean hasParticipants = false;

                                while (rs.next()) {
                                    hasParticipants = true;
                                    System.out.println("- ID: " + rs.getInt("id"));
                                    System.out.println("  Nome: " + rs.getString("nome"));
                                    System.out.println("  Telefone: " + rs.getString("telefone"));
                                    System.out.println();
                                }

                                if (!hasParticipants) {
                                    System.out.println("Nenhum participante encontrado neste evento.");
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }                        
                        break;

                        case "6":
                        try {
                            System.out.println("Listar organizadores de um evento:");

                            System.out.println("Informe o ID do evento:");
                            int idEvento = scanner.nextInt();
                            scanner.nextLine(); 

                            try (Connection con = DriverManager.getConnection(url, user, password);
                                Statement stm = con.createStatement()) {

                                ResultSet rs = stm.executeQuery("SELECT * FROM evento WHERE id = " + idEvento);
                                if (!rs.next()) {
                                    throw new Exception("Evento não encontrado com o ID informado.");
                                }

                                System.out.println("Evento encontrado:");
                                System.out.println("ID: " + rs.getInt("id"));
                                System.out.println("Descrição: " + rs.getString("descricao"));
                                System.out.println("Data: " + rs.getDate("data"));
                                System.out.println("Local: " + rs.getInt("id_local"));

                                String query = "SELECT pe.id, pe.nome, o.email " +
                                            "FROM evento_organizador eo " +
                                            "JOIN organizador o ON eo.id_organizador = o.id " +
                                            "JOIN pessoa pe ON o.id = pe.id " +
                                            "WHERE eo.id_evento = " + idEvento;

                                rs = stm.executeQuery(query);

                                System.out.println("\nOrganizadores no evento:");
                                boolean hasOrganizers = false;

                                while (rs.next()) {
                                    hasOrganizers = true;
                                    System.out.println("- ID: " + rs.getInt("id"));
                                    System.out.println("  Nome: " + rs.getString("nome"));
                                    System.out.println("  Email: " + rs.getString("email"));
                                    System.out.println();
                                }

                                if (!hasOrganizers) {
                                    System.out.println("Nenhum organizador encontrado neste evento.");
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                        case "7":
                        System.out.println("Voltando...");
                        voltarListas = true;
                        break;
                    } 
                    } while (!voltarListas);
                } catch (Exception e) {
                    System.out.println("");
                }
                break;

                case "5": //Deletar
                try {
                    boolean voltarDelete = false;
                    do {
                    System.out.println("\n-=-=-=-=--=-==-=-=-=-=");
                    System.out.println("Deletar");
                    System.out.println("-=-=-=-=--=-==-=-=-=-=");

                    System.out.println("1 - Participante");
                    System.out.println("2 - Organizador");
                    System.out.println("3 - Evento");
                    System.out.println("4 - Local");
                    System.out.println("5 - Voltar");
                    String opcaoDeletar = scanner.nextLine();
                    switch (opcaoDeletar) {
                        case "1":
                            try {
                                System.out.println("Deletar Participante");

                                System.out.println("Informe o ID do participante:");
                                int idParticipante = scanner.nextInt();
                                scanner.nextLine(); 

                                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                                    Statement statement = connection.createStatement();
                                    statement.executeUpdate("DELETE FROM participante WHERE id = " + idParticipante);
                                    statement.executeUpdate("DELETE FROM pessoa WHERE id = " + idParticipante);
                                    System.out.println("Participante deletado com sucesso!");
                                } catch (SQLException e) {
                                    System.out.println("Erro ao deletar participante no banco de dados: " + e.getMessage());
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case "2":
                            try {
                                System.out.println("Deletar Organizador");

                                System.out.println("Informe o ID do organizador:");
                                int idOrganizador = scanner.nextInt();
                                scanner.nextLine(); 

                                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                                    Statement statement = connection.createStatement();
                                    statement.executeUpdate("DELETE FROM organizador WHERE id = " + idOrganizador);
                                    statement.executeUpdate("DELETE FROM pessoa WHERE id = " + idOrganizador);
                                    System.out.println("Organizador deletado com sucesso!");
                                } catch (SQLException e) {
                                    System.out.println("Erro ao deletar organizador no banco de dados: " + e.getMessage());
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case "3":
                            try {
                                System.out.println("Deletar Evento");

                                System.out.println("Informe o ID do evento:");
                                int idEvento = scanner.nextInt();
                                scanner.nextLine(); 

                                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                                    Statement statement = connection.createStatement();
                                    statement.executeUpdate("DELETE FROM evento WHERE id = " + idEvento);
                                    System.out.println("Evento deletado com sucesso!");
                                } catch (SQLException e) {
                                    System.out.println("Erro ao deletar evento no banco de dados: " + e.getMessage());
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case "4":
                            try {
                                System.out.println("Deletar Local");

                                System.out.println("Informe o ID do local:");
                                int idLocal = scanner.nextInt();
                                scanner.nextLine(); 

                                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                                    Statement statement = connection.createStatement();
                                    statement.executeUpdate("DELETE FROM local WHERE id = " + idLocal);
                                    System.out.println("Local deletado com sucesso!");
                                } catch (SQLException e) {
                                    System.out.println("Erro ao deletar local no banco de dados: " + e.getMessage());
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case "5":
                            System.out.println("Voltando...");
                            voltarDelete = true;
                            break;
                        }
                    } while (!voltarDelete);
                } catch (Exception e) {
                    System.out.println("");
                }
                break;

                case "6": // Adicionar
                boolean AddCadastro = false; 
                do {
                    System.out.println("\n-=-=-=-=--=-==-=-=-=-=");
                    System.out.println("Adicionar ao Evento");
                    System.out.println("-=-=-=-=--=-==-=-=-=-=");
        
                    System.out.println("1 - Participante");
                    System.out.println("2 - Organizador");
                    System.out.println("3 - Sair");
                    
                    String opcaoAdd = "0";
                    System.out.println("\nDigite a opção desejada:");
                    opcaoAdd = scanner.nextLine();
                    
                    switch (opcaoAdd) {
                        case "1": // Adicionar Participante
                            try {
                                try {
                                    System.out.println("Adicionando participante a um evento:");
                                
                                    System.out.println("Informe o ID do evento:");
                                    int idEvento = scanner.nextInt();
                                    scanner.nextLine(); 
                                
                                    System.out.println("Informe o ID do participante:");
                                    int idParticipante = scanner.nextInt();
                                    scanner.nextLine(); 
                                
                                    Connection con = DriverManager.getConnection(url, user, password);
                                    Statement stm = con.createStatement();
                                    ResultSet rs = stm.executeQuery("SELECT * FROM evento WHERE id = " + idEvento);
                                
                                    if (!rs.next()) {
                                        con.close();
                                        throw new Exception("Evento não encontrado com o ID informado.");
                                    }
                                
                                    rs = stm.executeQuery("SELECT * FROM participante WHERE id = " + idParticipante);
                                
                                    if (!rs.next()) {
                                        con.close();
                                        throw new Exception("Participante não encontrado com o ID informado.");
                                    }
                                
                                    rs = stm.executeQuery("SELECT * FROM evento_participante WHERE id_evento = " + idEvento + " AND id_participante = " + idParticipante);
                                
                                    if (rs.next()) {
                                        con.close();
                                        throw new Exception("O participante já está registrado neste evento.");
                                    }
                                
                                    String insertQuery = String.format(
                                        "INSERT INTO evento_participante (id_evento, id_participante) VALUES (%d, %d)",
                                        idEvento, idParticipante
                                    );
                                
                                    int rowsAffected = stm.executeUpdate(insertQuery);
                                
                                    if (rowsAffected > 0) {
                                        System.out.println("Participante adicionado ao evento com sucesso!");
                                    } else {
                                        System.out.println("Falha ao adicionar o participante ao evento.");
                                    }
                                
                                    con.close(); 
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }                                
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        case "2": // Adicionar Organizador
                            try {
                                System.out.println("Adicionando organizador a um evento:");
                                
                                System.out.println("Informe o ID do evento:");
                                int idEvento = scanner.nextInt();
                                scanner.nextLine(); 
                                
                                System.out.println("Informe o ID do organizador:");
                                int idOrganizador = scanner.nextInt();
                                scanner.nextLine(); 
                                
                                Connection con = DriverManager.getConnection(url, user, password);
                                Statement stm = con.createStatement();
                                ResultSet rs = stm.executeQuery("SELECT * FROM evento WHERE id = " + idEvento);
                                
                                if (!rs.next()) {
                                    con.close();
                                    throw new Exception("Evento não encontrado com o ID informado.");
                                }
                                
                                rs = stm.executeQuery("SELECT * FROM organizador WHERE id = " + idOrganizador);
                                
                                if (!rs.next()) {
                                    con.close();
                                    throw new Exception("Organizador não encontrado com o ID informado.");
                                }
                                
                                rs = stm.executeQuery("SELECT * FROM evento_organizador WHERE id_evento = " + idEvento + " AND id_organizador = " + idOrganizador);
                                
                                if (rs.next()) {
                                    con.close();
                                    throw new Exception("O organizador já está registrado neste evento.");
                                }
                                
                                String insertQuery = String.format(
                                    "INSERT INTO evento_organizador (id_evento, id_organizador) VALUES (%d, %d)",
                                    idEvento, idOrganizador
                                );
                                
                                int rowsAffected = stm.executeUpdate(insertQuery);
                                
                                if (rowsAffected > 0) {
                                    System.out.println("Organizador adicionado ao evento com sucesso!");
                                } else {
                                    System.out.println("Falha ao adicionar o organizador ao evento.");
                                }
                                
                                con.close(); 
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        case "3": // Sair
                            System.out.println("\nVoltando...");
                            AddCadastro = true;
                            break;
                    }   	
                } while (!AddCadastro);
                break;             

                case "7": // Sair
                System.out.println("\nSaindo...");
                break;

                default:
                    System.out.println("\nOpção inválida");
                    break;
            }
        } while (opcao != "6");
        scanner.close();
    }
} 