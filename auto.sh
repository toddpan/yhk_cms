#/bin/bash

killall java
echo $(pwd)
mvn clean
mvn package -Dmaven.test.skip=true
rm -rf /Users/ant_shake_tree/Documents/apache-tomcat-8.0.23/webapps/yhk_cms*
mv $(pwd)/target/ykh_cms*.war /Users/ant_shake_tree/Documents/apache-tomcat-8.0.23/webapps/yhk_cms.war

/Users/ant_shake_tree/Documents/apache-tomcat-8.0.23/bin/startup.sh

mvn compile