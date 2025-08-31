package br.com.dio.persistence.migration;

import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.AllArgsConstructor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;

import static br.com.dio.persistence.config.ConnectionConfig.getConnection;

@AllArgsConstructor
public class MigrationStrategy
{
    private final Connection connection;

    public void executeMigration()
    {
        // Guarda os fluxos originais de saída para restaurar depois
        var originalOut = System.out;
        var originalErr = System.err;

        try (var fos = new FileOutputStream("liquibase.log"))
        {
            // Redireciona stdout e stderr para o arquivo de log
            System.setOut(new PrintStream(fos));
            System.setErr(new PrintStream(fos));

            // Conexão com o banco e adaptação para Liquibase
            try (
                    var connection = getConnection();
                    var jdbcConnection = new JdbcConnection(connection);
            )
            {
                // Criação do objeto Liquibase apontando para o changelog principal
                var liquibase = new Liquibase(
                        "/db/changelog/db.changelog-master.yml",
                        new ClassLoaderResourceAccessor(),
                        jdbcConnection
                );

                // Executa todas as migrations pendentes
                liquibase.update();
            }
            catch (SQLException | LiquibaseException e)
            {
                // Log da exceção para o arquivo
                e.printStackTrace();
                System.setErr(originalErr);
            }
        }
        catch (IOException ex)
        {
            // Captura problemas com o arquivo de log
            ex.printStackTrace();
        }
        finally
        {
            // Restaura os fluxos de saída originais
            System.setOut(originalOut);
            System.setErr(originalErr);
        }
    }
}
