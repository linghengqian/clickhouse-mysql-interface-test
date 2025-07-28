package io.github.linghengqian;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.MountableFile;

import java.nio.file.Paths;
import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SuppressWarnings({"resource", "SqlNoDataSourceInspection"})
@Testcontainers
class MySQLInterfaceTest {
    @Container
    private final GenericContainer<?> container = new GenericContainer<>("clickhouse/clickhouse-server:25.6.5.41")
            .withEnv("CLICKHOUSE_USER", "alice")
            .withEnv("CLICKHOUSE_DEFAULT_ACCESS_MANAGEMENT", "1")
            .withEnv("CLICKHOUSE_PASSWORD", "changeme")
            .withEnv("CLICKHOUSE_DB", "my_database")
            .withCopyFileToContainer(
                    MountableFile.forHostPath(Paths.get("src/test/resources/xml/interface.xml").toAbsolutePath()),
                    "/etc/clickhouse-server/config.d/interface.xml")
            .withExposedPorts(9004, 8123);

    @Test
    void test() {
        var mysqlJdbcUrl = "jdbc:mysql://localhost:" + container.getMappedPort(9004) + "/my_database";
        var clickhouseJdbcUrl = "jdbc:ch://localhost:" + container.getMappedPort(8123) + "/my_database";
        await().atMost(1L, TimeUnit.MINUTES).ignoreExceptions().until(() -> {
            DriverManager.getConnection(clickhouseJdbcUrl, "alice", "changeme").close();
            return true;
        });
        assertDoesNotThrow(() -> DriverManager.getConnection(mysqlJdbcUrl, "alice", "changeme").close());
    }
}
