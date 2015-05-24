# javaee-sandbox

- JavaSE 8
- JavaEE 7
- wildfly 8.2.0.Final
  - [Downloads · WildFly](http://wildfly.org/downloads/)
- PostgreSQL 9.4.1

## DBユーザの作成
```
createuser --username=postgres --createdb --encrypted --inherit --login --pwdprompt --createrole --superuser javaee
```
- DBユーザの削除
```
dropuser --username=postgres javaee
```
## DBの作成
```
createdb --username=javaee --encoding=UTF8 --locale=ja_JP.UTF-8 --owner=javaee --template=template0 javaee
```
- DBの削除
```
dropdb --username=postgres javaee
```

## データベースへの接続
psql --username=javaee javaee

- ¥d
 - テーブル一覧の表示
- ¥d _table_name_
 - テーブルの詳細表示

https://www.postgresql.jp/document/9.3/html/app-psql.html

## wildfly
JBOSS_HOMEにpathを通しておく

https://docs.jboss.org/author/display/WFLY8/Admin+Guide#AdminGuide-RunningtheCLI

接続
```
jboss-cli.bat --connect
```

終了
Ctrl+D または quit

停止
```
[standalone@localhost:9990 /] shutdown
```

JDBCドライバ情報
```
[standalone@localhost:9990 /] jdbc-driver-info
```

PostgreSQLドライバのデプロイ
```
[standalone@localhost:9990 /] deploy postgresql-9.2-1002-jdbc4.jar
```

JDBCの作成
```
[standalone@localhost:9990 /] data-source add --name=javaee --driver-name=postgresql-9.2-1002-jdbc4.jar --connection-url=jdbc:postgresql://localhost:5432/javaee --jndi-name=java:jboss/datasources/javaee --user-name=techno --password=javaee
```

デプロイ情報
```
[standalone@localhost:9990 /] deployment-info
```
