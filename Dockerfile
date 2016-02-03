FROM ubuntu:14.04

RUN \
  apt-get update && \
  apt-get install -y software-properties-common && \
  echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
  add-apt-repository -y ppa:webupd8team/java && \
  apt-get update && \
  apt-get install -y oracle-java8-installer && \
  rm -rf /var/cache/oracle-jdk8-installer

ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

RUN apt-get install -y maven

COPY src /opt/src
COPY pom.xml /opt/pom.xml

WORKDIR /opt

RUN mvn install

CMD java -jar target/SpringRestDBS-1.0.jar