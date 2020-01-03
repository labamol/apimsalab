echo on
E:\\
set JAVA_HOME="C:\\Java\\jdk"
set PATH=%PATH%;"E:\\apache-maven-3.3.9\\bin"
cd E:\\git-dvcs\\apimsalab\\servicerequest
mvn package -P daemon
PAUSE