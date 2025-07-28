# clickhouse-mysql-interface-test

- For,
  - https://github.com/apache/shardingsphere/issues/36081
  - https://github.com/testcontainers/testcontainers-java/issues/4456
- Execute the following command on the Windows 11 instance with `PowerShell/PowerShell`,
  `version-fox/vfox`, `git-for-windows/git` and `rancher-sandbox/rancher-desktop` installed.

```shell
vfox add java
vfox install java@24.0.2-graalce
vfox use --global java@24.0.2-graalce

git clone git@github.com:linghengqian/clickhouse-mysql-interface-test.git
cd ./clickhouse-mysql-interface-test/
./mvnw clean test
```

The log is as follows,

```shell
PS D:\TwinklingLiftWorks\git\public\clickhouse-mysql-interface-test> ./mvnw clean test
WARNING: A terminally deprecated method in sun.misc.Unsafe has been called
WARNING: sun.misc.Unsafe::staticFieldBase has been called by com.google.inject.internal.aop.HiddenClassDefiner (file:/C:/Users/lingh/.m2/wrapper/dists/apache-maven-3.9.11/d6d3cbd4012d4c1d840e93277aca316c/lib/guice-5.1.0-classes.jar)
WARNING: Please consider reporting this to the maintainers of class com.google.inject.internal.aop.HiddenClassDefiner
WARNING: sun.misc.Unsafe::staticFieldBase will be removed in a future release
[INFO] Scanning for projects...
[INFO] 
[INFO] -------< io.github.linghengqian:clickhouse-mysql-interface-test >-------
[INFO] Building clickhouse-mysql-interface-test 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ clickhouse-mysql-interface-test ---
[INFO] Deleting D:\TwinklingLiftWorks\git\public\clickhouse-mysql-interface-test\target
[INFO]
[INFO] --- resources:3.3.1:resources (default-resources) @ clickhouse-mysql-interface-test ---
[INFO] skip non existing resourceDirectory D:\TwinklingLiftWorks\git\public\clickhouse-mysql-interface-test\src\main\resources
[INFO]
[INFO] --- compiler:3.13.0:compile (default-compile) @ clickhouse-mysql-interface-test ---
[INFO] No sources to compile
[INFO]
[INFO] --- resources:3.3.1:testResources (default-testResources) @ clickhouse-mysql-interface-test ---
[INFO] Copying 2 resources from src\test\resources to target\test-classes
[INFO]
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ clickhouse-mysql-interface-test ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 2 source files with javac [debug release 24] to target\test-classes
[INFO] 
[INFO] --- surefire:3.5.3:test (default-test) @ clickhouse-mysql-interface-test ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running io.github.linghengqian.MySQLInterfaceTest
12:41:00.046 [main] INFO  org.testcontainers.images.PullPolicy - Image pull policy will be performed by: DefaultPullPolicy()
12:41:00.050 [main] INFO  org.testcontainers.utility.ImageNameSubstitutor - Image name substitution will be performed by: DefaultImageNameSubstitutor (composite of 'ConfigurationFileImageNameSubstitutor' and 'PrefixingImageNameSubstitutor')
12:41:00.122 [main] INFO  org.testcontainers.DockerClientFactory - Testcontainers version: 1.21.3
12:41:00.298 [main] INFO  org.testcontainers.dockerclient.DockerClientProviderStrategy - Loaded org.testcontainers.dockerclient.NpipeSocketClientProviderStrategy from ~/.testcontainers.properties, will try it first
12:41:00.521 [main] INFO  org.testcontainers.dockerclient.DockerClientProviderStrategy - Found Docker environment with local Npipe socket (npipe:////./pipe/docker_engine)
12:41:00.522 [main] INFO  org.testcontainers.DockerClientFactory - Docker host IP address is localhost
12:41:00.539 [main] INFO  org.testcontainers.DockerClientFactory - Connected to docker:
  Server Version: 27.3.1
  API Version: 1.47
  Operating System: Rancher Desktop WSL Distribution
  Total Memory: 15588 MB
12:41:00.573 [main] INFO  tc.testcontainers/ryuk:0.12.0 - Creating container for image: testcontainers/ryuk:0.12.0
12:41:00.631 [main] INFO  org.testcontainers.utility.RegistryAuthLocator - Credential helper/store (docker-credential-wincred) does not have credentials for https://index.docker.io/v1/
12:41:00.735 [main] INFO  tc.testcontainers/ryuk:0.12.0 - Container testcontainers/ryuk:0.12.0 is starting: 4c0e19d9845d0ff597fba71c671e70e4ae073909e442f42c6e709c9e1e1b289e
12:41:01.182 [main] INFO  tc.testcontainers/ryuk:0.12.0 - Container testcontainers/ryuk:0.12.0 started in PT0.6082835S
12:41:01.189 [main] INFO  org.testcontainers.utility.RyukResourceReaper - Ryuk started - will monitor and terminate Testcontainers containers on JVM exit
12:41:01.189 [main] INFO  org.testcontainers.DockerClientFactory - Checking the system...
12:41:01.189 [main] INFO  org.testcontainers.DockerClientFactory - ?? Docker server version should be at least 1.6.0
12:41:01.190 [main] INFO  tc.clickhouse/clickhouse-server:25.6.5.41 - Creating container for image: clickhouse/clickhouse-server:25.6.5.41
12:41:01.251 [main] INFO  tc.clickhouse/clickhouse-server:25.6.5.41 - Container clickhouse/clickhouse-server:25.6.5.41 is starting: 1d83cd5390aaa73b685b5d1b60edeaa28021fb055dd0396ba1bc3d1f2ec9f6b7
12:41:02.216 [main] INFO  tc.clickhouse/clickhouse-server:25.6.5.41 - Container clickhouse/clickhouse-server:25.6.5.41 started in PT1.0261646S
12:41:02.335 [awaitility-thread] INFO  com.clickhouse.jdbc.ClickHouseDriver - ClickHouse JDBC driver version: clickhouse-jdbc 0.9.0 (revision: 27ccb8e)
12:41:02.336 [awaitility-thread] INFO  com.clickhouse.jdbc.ClickHouseDriver - v2 driver
12:41:02.345 [awaitility-thread] INFO  com.clickhouse.jdbc.Driver - ClickHouse JDBC driver version: 0.9.0
12:41:02.346 [awaitility-thread] INFO  com.clickhouse.jdbc.ClickHouseDriver - ClickHouse JDBC driver version: clickhouse-jdbc 0.9.0 (revision: 27ccb8e)
12:41:02.346 [awaitility-thread] INFO  com.clickhouse.jdbc.ClickHouseDriver - v2 driver
12:41:02.353 [awaitility-thread] INFO  com.clickhouse.jdbc.ClickHouseDriver - v2 driver
12:41:02.602 [main] INFO  com.clickhouse.jdbc.ClickHouseDriver - v2 driver
7月 28, 2025 12:41:02 下午 org.junit.jupiter.engine.descriptor.AbstractExtensionContext lambda$createCloseAction$1
警告: Type implements CloseableResource but not AutoCloseable: org.testcontainers.junit.jupiter.TestcontainersExtension$StoreAdapter
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 3.521 s <<< FAILURE! -- in io.github.linghengqian.MySQLInterfaceTest
[ERROR] io.github.linghengqian.MySQLInterfaceTest.test -- Time elapsed: 3.246 s <<< FAILURE!
org.opentest4j.AssertionFailedError:
Unexpected exception thrown: com.mysql.cj.jdbc.exceptions.CommunicationsException: Communications link failure

The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.
        at org.junit.jupiter.api.AssertionFailureBuilder.build(AssertionFailureBuilder.java:152)
        at org.junit.jupiter.api.AssertDoesNotThrow.createAssertionFailedError(AssertDoesNotThrow.java:84)
        at org.junit.jupiter.api.AssertDoesNotThrow.assertDoesNotThrow(AssertDoesNotThrow.java:53)
        at org.junit.jupiter.api.AssertDoesNotThrow.assertDoesNotThrow(AssertDoesNotThrow.java:36)
        at org.junit.jupiter.api.Assertions.assertDoesNotThrow(Assertions.java:3199)
        at io.github.linghengqian.MySQLInterfaceTest.test(MySQLInterfaceTest.java:38)
        at java.base/java.lang.reflect.Method.invoke(Method.java:565)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
Caused by: com.mysql.cj.jdbc.exceptions.CommunicationsException: Communications link failure

The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.
        at com.mysql.cj.jdbc.exceptions.SQLError.createCommunicationsException(SQLError.java:165)
        at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:55)
        at com.mysql.cj.jdbc.ConnectionImpl.createNewIO(ConnectionImpl.java:833)
        at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:416)
        at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:238)
        at com.mysql.cj.jdbc.NonRegisteringDriver.connect(NonRegisteringDriver.java:180)
        at java.sql/java.sql.DriverManager.getConnection(DriverManager.java:613)
        at java.sql/java.sql.DriverManager.getConnection(DriverManager.java:199)
        at io.github.linghengqian.MySQLInterfaceTest.lambda$test$1(MySQLInterfaceTest.java:38)
        at org.junit.jupiter.api.AssertDoesNotThrow.assertDoesNotThrow(AssertDoesNotThrow.java:49)
        ... 6 more
Caused by: com.mysql.cj.exceptions.CJCommunicationsException: Communications link failure

The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.
        at java.base/jdk.internal.reflect.DirectConstructorHandleAccessor.newInstance(DirectConstructorHandleAccessor.java:62)
        at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:499)
        at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:483)
        at com.mysql.cj.exceptions.ExceptionFactory.createException(ExceptionFactory.java:52)
        at com.mysql.cj.exceptions.ExceptionFactory.createException(ExceptionFactory.java:95)
        at com.mysql.cj.exceptions.ExceptionFactory.createException(ExceptionFactory.java:140)
        at com.mysql.cj.exceptions.ExceptionFactory.createCommunicationsException(ExceptionFactory.java:156)
        at com.mysql.cj.protocol.a.NativeProtocol.readMessage(NativeProtocol.java:592)
        at com.mysql.cj.protocol.a.NativeProtocol.readServerCapabilities(NativeProtocol.java:516)
        at com.mysql.cj.protocol.a.NativeProtocol.beforeHandshake(NativeProtocol.java:411)
        at com.mysql.cj.protocol.a.NativeProtocol.connect(NativeProtocol.java:1331)
        at com.mysql.cj.NativeSession.connect(NativeSession.java:155)
        at com.mysql.cj.jdbc.ConnectionImpl.connectOneTryOnly(ConnectionImpl.java:957)
        at com.mysql.cj.jdbc.ConnectionImpl.createNewIO(ConnectionImpl.java:821)
        ... 13 more
Caused by: java.io.EOFException: Can not read response from server. Expected to read 4 bytes, read 0 bytes before connection was unexpectedly lost.
        at com.mysql.cj.protocol.FullReadInputStream.readFully(FullReadInputStream.java:58)
        at com.mysql.cj.protocol.a.SimplePacketReader.readHeaderLocal(SimplePacketReader.java:72)
        at com.mysql.cj.protocol.a.SimplePacketReader.readHeader(SimplePacketReader.java:54)
        at com.mysql.cj.protocol.a.SimplePacketReader.readHeader(SimplePacketReader.java:36)
        at com.mysql.cj.protocol.a.NativeProtocol.readMessage(NativeProtocol.java:586)
        ... 19 more

[INFO] Running io.github.linghengqian.PostgresInterfaceTest
12:41:03.367 [main] INFO  tc.clickhouse/clickhouse-server:25.6.5.41 - Creating container for image: clickhouse/clickhouse-server:25.6.5.41
12:41:03.418 [main] INFO  tc.clickhouse/clickhouse-server:25.6.5.41 - Container clickhouse/clickhouse-server:25.6.5.41 is starting: e1205cfe79cabd43e47675d6b5a33c4b3be390be76c393c326478f702980a794
12:41:04.276 [main] INFO  tc.clickhouse/clickhouse-server:25.6.5.41 - Container clickhouse/clickhouse-server:25.6.5.41 started in PT0.9089435S
12:41:04.378 [awaitility-thread] INFO  com.clickhouse.jdbc.ClickHouseDriver - v2 driver
12:41:04.402 [main] INFO  com.clickhouse.jdbc.ClickHouseDriver - v2 driver
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 1.768 s <<< FAILURE! -- in io.github.linghengqian.PostgresInterfaceTest
[ERROR] io.github.linghengqian.PostgresInterfaceTest.test -- Time elapsed: 1.765 s <<< FAILURE!
org.opentest4j.AssertionFailedError: Unexpected exception thrown: org.postgresql.util.PSQLException: 尝试连线已失败。
        at org.junit.jupiter.api.AssertionFailureBuilder.build(AssertionFailureBuilder.java:152)
        at org.junit.jupiter.api.AssertDoesNotThrow.createAssertionFailedError(AssertDoesNotThrow.java:84)
        at org.junit.jupiter.api.AssertDoesNotThrow.assertDoesNotThrow(AssertDoesNotThrow.java:53)
        at org.junit.jupiter.api.AssertDoesNotThrow.assertDoesNotThrow(AssertDoesNotThrow.java:36)
        at org.junit.jupiter.api.Assertions.assertDoesNotThrow(Assertions.java:3199)
        at io.github.linghengqian.PostgresInterfaceTest.test(PostgresInterfaceTest.java:38)
        at java.base/java.lang.reflect.Method.invoke(Method.java:565)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
Caused by: org.postgresql.util.PSQLException: 尝试连线已失败。
        at org.postgresql.core.v3.ConnectionFactoryImpl.openConnectionImpl(ConnectionFactoryImpl.java:385)
        at org.postgresql.core.ConnectionFactory.openConnection(ConnectionFactory.java:57)
        at org.postgresql.jdbc.PgConnection.<init>(PgConnection.java:277)
        at org.postgresql.Driver.makeConnection(Driver.java:448)
        at org.postgresql.Driver.connect(Driver.java:298)
        at java.sql/java.sql.DriverManager.getConnection(DriverManager.java:613)
        at java.sql/java.sql.DriverManager.getConnection(DriverManager.java:199)
        at io.github.linghengqian.PostgresInterfaceTest.lambda$test$1(PostgresInterfaceTest.java:38)
        at org.junit.jupiter.api.AssertDoesNotThrow.assertDoesNotThrow(AssertDoesNotThrow.java:49)
        ... 6 more
Caused by: java.net.SocketException: 你的主机中的软件中止了一个已建立的连接。
        at java.base/sun.nio.ch.SocketDispatcher.read0(Native Method)
        at java.base/sun.nio.ch.SocketDispatcher.read(SocketDispatcher.java:46)
        at java.base/sun.nio.ch.NioSocketImpl.tryRead(NioSocketImpl.java:255)
        at java.base/sun.nio.ch.NioSocketImpl.timedRead(NioSocketImpl.java:273)
        at java.base/sun.nio.ch.NioSocketImpl.implRead(NioSocketImpl.java:303)
        at java.base/sun.nio.ch.NioSocketImpl.read(NioSocketImpl.java:345)
        at java.base/sun.nio.ch.NioSocketImpl$1.read(NioSocketImpl.java:790)
        at java.base/java.net.Socket$SocketInputStream.implRead(Socket.java:983)
        at java.base/java.net.Socket$SocketInputStream.read(Socket.java:970)
        at org.postgresql.core.VisibleBufferedInputStream.readMore(VisibleBufferedInputStream.java:192)
        at org.postgresql.core.VisibleBufferedInputStream.ensureBytes(VisibleBufferedInputStream.java:159)
        at org.postgresql.core.VisibleBufferedInputStream.ensureBytes(VisibleBufferedInputStream.java:144)
        at org.postgresql.core.VisibleBufferedInputStream.read(VisibleBufferedInputStream.java:76)
        at org.postgresql.core.PGStream.receiveChar(PGStream.java:477)
        at org.postgresql.core.v3.ConnectionFactoryImpl.enableSSL(ConnectionFactoryImpl.java:627)
        at org.postgresql.core.v3.ConnectionFactoryImpl.tryConnect(ConnectionFactoryImpl.java:207)
        at org.postgresql.core.v3.ConnectionFactoryImpl.openConnectionImpl(ConnectionFactoryImpl.java:289)
        ... 14 more

[INFO] 
[INFO] Results:
[INFO]
[ERROR] Failures: 
[ERROR]   MySQLInterfaceTest.test:38 Unexpected exception thrown: com.mysql.cj.jdbc.exceptions.CommunicationsException: Communications link failure

The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.
[ERROR]   PostgresInterfaceTest.test:38 Unexpected exception thrown: org.postgresql.util.PSQLException: 尝试连线已失败。
[INFO]
[ERROR] Tests run: 2, Failures: 2, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  8.409 s
[INFO] Finished at: 2025-07-28T12:41:05+08:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.5.3:test (default-test) on project clickhouse-mysql-interface-test: There are test failures.
[ERROR] 
[ERROR] See D:\TwinklingLiftWorks\git\public\clickhouse-mysql-interface-test\target\surefire-reports for the individual test results.
[ERROR] See dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
```
