FROM propheter/ubuntu:bert
ARG JAR_PATH=build/libs/pokemon-0.0.1-SNAPSHOT.jar
ARG PORT=3000
COPY ${JAR_PATH} app.jar
RUN mkdir upload


ENV SPRING_PROFILES_ACTIVE=default,prod,email,dl
ENV FILE_PATH=/uploads/
ENV FILE_URL=/uploads/
ENV PYTHON_RUN_PATH=...
ENV PYTHON_SCRIPT_PATH=...
ENV DL_DATA_URL=...
ENV PYTHON_SCRIPT2_PATH=...
ENV PYTHON_BERT_PATH=...
ENV REDIS_PORT=6379
ENV DDL_AUTO=none
ENTRYPOINT ["java", "-jar", "-Ddb.host=${DB_HOST}", "-Ddb.password=${DB_PASSWORD}", "-Ddb.username=${DB_USERNAME}", "-Dddl.auto=${DDL_AUTO}", "-Ddl.data.url=${DL_DATA_URL}", "-Dpython.run.path=${PYTHON_RUN_PATH}", "-Dpython.script.path=${PYTHON_SCRIPT_PATH}", "-Dredis.host=${REDIS_HOST}", "-Dredis.port=${REDIS_PORT}", "-Dmail.username=${MAIL_USERNAME}", "-Dmail.password=${MAIL_PASSWORD}", "-Dpthon.script2.path=${PYTHON_SCRIPT2_PATH}","-Dpthon.bety.path=${PYTHON_BERT_PATH}","app.jar"]
EXPOSE ${PORT}