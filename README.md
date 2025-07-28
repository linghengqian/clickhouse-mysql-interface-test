# clickhouse-mysql-interface-test

- For https://github.com/apache/shardingsphere/issues/36081 .
- Execute the following command on the Windows 11 instance with `PowerShell/PowerShell`,
  `version-fox/vfox`, `git-for-windows/git` and `rancher-sandbox/rancher-desktop` installed.

```shell
vfox add java
vfox install java@24.0.2-graalce
vfox use --global java@24.0.2-graalce

git clone git@github.com:linghengqian/clickhouse-mysql-interface-test.git
cd ./clickhouse-mysql-interface-test/
./mvnw -T 1C clean test
```

The log is as follows,

```shell

```
