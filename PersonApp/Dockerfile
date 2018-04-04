FROM jboss/wildfly

MAINTAINER Dr. Aldo Dall'Aglio

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin!1223 --silent

EXPOSE 8080
EXPOSE 9990

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]



COPY target/PersonApp.war /opt/jboss/wildfly/standalone/deployments/
