liquibase  --defaultsFile=src/main/resources/liquibase/liquibase.properties \
           --classpath="d:\mysql-connector-java-5.1.6.jar;D:\spring-learning\liquibase-helloworld-demo\target\liquibase-helloworld-demo.jar"  \
           --changeLogFile=liquibase/db-changelog-master.xml   \
           update