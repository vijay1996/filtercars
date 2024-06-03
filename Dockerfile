FROM maven:3.8.3-openjdk-17

WORKDIR /petpass-service
COPY . .
RUN mvn -U clean install -DskipTests

CMD mvn spring-boot:run