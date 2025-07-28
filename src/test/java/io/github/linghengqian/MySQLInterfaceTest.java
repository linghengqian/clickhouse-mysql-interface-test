package io.github.linghengqian;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.MountableFile;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SuppressWarnings({"resource", "SqlNoDataSourceInspection"})
class MySQLInterfaceTest {
    @Test
    void assertShardingInLocalTransactions() throws SQLException {
        try (GenericContainer<?> container = new GenericContainer<>("clickhouse/clickhouse-server:25.6.5.41")
                .withEnv("CLICKHOUSE_SKIP_USER_SETUP", "1")
                .withCopyFileToContainer(
                        MountableFile.forHostPath(Paths.get("src/test/resources/xml/interface.xml").toAbsolutePath()),
                        "/etc/clickhouse-server/config.d/interface.xml")
                .withExposedPorts(9004, 8123)) {
            container.start();
            String mysqlJdbcUrl = "jdbc:mysql://localhost:" + container.getMappedPort(9004) + "/default";
            String clickhouseJdbcUrl = "jdbc:ch://localhost:" + container.getMappedPort(8123) + "/default";
            await().atMost(1L,TimeUnit.MINUTES).ignoreExceptions().until(()->{
                DriverManager.getConnection(clickhouseJdbcUrl,"default","").close();
                return true;
            });
            try (Connection connection = DriverManager.getConnection(mysqlJdbcUrl,"default","")) {
                ResultSet resultSet = connection.createStatement().executeQuery("SHOW VARIABLES LIKE 'version_comment'");
                while (resultSet.next()) {
                    assertNotNull(resultSet.getString("Value"));
                }
            }
        }
    }
}
