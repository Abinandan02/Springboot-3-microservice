# Springboot-3-microservice

Architecture for a simple Employee and Department micro service connecting to service-registry, config-server, api-gateway and zipkin tracing.

![ms1](https://github.com/Abinandan02/springboot-3-microservice/assets/82743546/f0b5160c-2de0-44c2-94d9-4bee4956c94b)

To run the application:
1. Clone the application into your local.
2. Build the project using mvn clean install.
3. Run each service using mvn spring-boot:run.

Step used to run Zipkin in local:

# get the latest source
git clone https://github.com/openzipkin/zipkin
cd zipkin
# Build the server and also make its dependencies
./mvnw -DskipTests --also-make -pl zipkin-server clean install
# Run the server
java -jar ./zipkin-server/target/zipkin-server-*exec.jar

Reference: https://zipkin.io/pages/quickstart.html.
