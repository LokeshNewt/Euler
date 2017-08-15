# euler
simple maven projects using orcale, spring-data, hibernate, sql, jax-rs

link to download oracle jar
http://www.oracle.com/technetwork/database/features/jdbc/index-091264.html
use this link to store to the local repository :
mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc14 -Dversion=10.2.0.4.0 -Dpackaging=jar -Dfile=ojdbc14.jar -DgeneratePom=true

or change dependency to :
<dependency>
 <groupId>com.oracle.jdbc</groupId>
 <artifactId>ojdbc7</artifactId>
 <version>12.1.0.2</version>
</dependency>

https://github.com/neerbans/Euler.git
