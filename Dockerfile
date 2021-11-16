FROM reg.int.it2000.com.cn/library/adoptopenjdk/openjdk8:latest 
#FROM reg.int.it2000.com.cn/library/busybox:latest

MAINTAINER Jeking Yang

# setting time zone
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
 
# Add the service itself
ARG JAR_FILE

COPY ${JAR_FILE} /usr/local/myapp.jar

EXPOSE 8080
ENV JAVA_OPTS=$JAVA_OPTS

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /usr/local/myapp.jar"]