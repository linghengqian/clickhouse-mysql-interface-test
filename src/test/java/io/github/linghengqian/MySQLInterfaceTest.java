package io.github.linghengqian;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.MountableFile;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SuppressWarnings({"resource", "SqlNoDataSourceInspection"})
class MySQLInterfaceTest {
    @Test
    void assertShardingInLocalTransactions() throws SQLException {
        try (GenericContainer<?> container = new GenericContainer<>("clickhouse/clickhouse-server:25.4.5.24")
                .withEnv("CLICKHOUSE_USER", "changeme")
                .withEnv("CLICKHOUSE_DEFAULT_ACCESS_MANAGEMENT", "1")
                .withEnv("CLICKHOUSE_PASSWORD", "changeme")
                .withEnv("CLICKHOUSE_DB", "my_database")
                .withCopyFileToContainer(
                        MountableFile.forHostPath(Paths.get("src/test/resources/xml/mysql-interface.xml").toAbsolutePath()),
                        "/etc/clickhouse-server/config.d/mysql-interface.xml")
                .withExposedPorts(9004)) {
            container.start();
            String jdbcUrl = "jdbc:mysql://localhost:" + container.getMappedPort(9004) + "/my_database";
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setJdbcUrl(jdbcUrl);
            hikariConfig.setUsername("changeme");
            hikariConfig.setPassword("changeme");
            Awaitility.await().timeout(2L, TimeUnit.MINUTES).pollDelay(1L, TimeUnit.MINUTES).until(() -> true);
            try (HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
                 Connection connection = hikariDataSource.getConnection()) {
                ResultSet resultSet = connection.createStatement().executeQuery("SHOW VARIABLES LIKE 'version_comment'");
                while (resultSet.next()) {
                    assertNotNull(resultSet.getString("Value"));
                }
            }
        }
    }
}
