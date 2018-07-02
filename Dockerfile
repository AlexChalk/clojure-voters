FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/clojure-voters.jar /clojure-voters/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/clojure-voters/app.jar"]
