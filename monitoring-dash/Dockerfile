FROM java:8-jre
MAINTAINER Alexander Lukyanchikov <sqshq@sqshq.com>

ADD ./target/monitoring-dash.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/monitoring-dash.jar"]

EXPOSE 9999