wget http://dl.bintray.com/vertx/downloads/vert.x-2.1.3.tar.gz
tar -zxf vert.x-2.1.3.tar.gz
export PATH=$PATH:vert.x-2.1.3/bin/

vim Server.java



wget -O jdk-7u25-linux-x64.rpm --no-cookies --no-check-certificate --header 'Cookie:gpw_e24=http://www.oracle.com; oraclelicense=accept-securebackup-cookie' 'http://download.oracle.com/otn-pub/java/jdk/7u51-b13/jdk-7u51-linux-x64.rpm'      
sudo rpm -Uvh /home/ec2-user/jdk-7u25-linux-x64.rpm
sudo alternatives --install /usr/bin/java java /usr/java/default/bin/java 3
sudo alternatives --set java /usr/java/default/bin/java
java -version

export JAVA_HOME=/usr/java/default




#undertow
wget http://download.jboss.org/wildfly/8.1.0.Final/wildfly-8.1.0.Final.tar.gz



#java 1.8
cd /opt/
sudo wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u20-b26/jdk-8u20-linux-i586.tar.gz"
sudo tar xzf jdk-8u20-linux-i586.tar.gz
cd /opt/jdk1.8.0_20/
sudo alternatives --install /usr/bin/java java /opt/jdk1.8.0_20/bin/java 2
sudo alternatives --config java

#input 2

sudo alternatives --install /usr/bin/jar jar /opt/jdk1.8.0_20/bin/jar 2
sudo alternatives --install /usr/bin/javac javac /opt/jdk1.8.0_20/bin/javac 2
sudo alternatives --set jar /opt/jdk1.8.0_20/bin/jar
sudo alternatives --set javac /opt/jdk1.8.0_20/bin/javac 



export JAVA_HOME=/opt/jdk1.8.0_20
export JRE_HOME=/opt/jdk1.8.0_20/jre
export PATH=$PATH:/opt/jdk1.8.0_20/bin:/opt/jdk1.8.0_20/jre/bin


sudo yum install glibc.i686