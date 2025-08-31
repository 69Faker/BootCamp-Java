package br.com.dio.persistence.config;

import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class ConnectionConfig
{
    // Fornece conexão JDBC com MySQL, desativando autocommit para controle manual de transações
    public static Connection getConnection() throws SQLException
    {
        var url = "jdbc:mysql://localhost/board";
        var user = "board";
        var password = "board";

        var connection = DriverManager.getConnection(url, user, password);

        // Configuração importante para gerenciar commits e rollbacks manualmente
        connection.setAutoCommit(false);

        return connection;
    }
}
