FROM maven:3.8.3-openjdk-17

WORKDIR /filtercars
COPY . .
RUN mvn -U clean install -DskipTests

CMD mvn spring-boot:run