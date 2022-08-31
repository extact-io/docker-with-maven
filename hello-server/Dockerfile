FROM eclipse-temurin:17-jre-alpine
WORKDIR /

# ホストOSのMavenのビルド成果物をコンテナイメージに格納
COPY ./target/hello-server.jar ./
COPY ./target/libs ./libs

# Executable Jarなのでjavaコマンドでサーバを起動
CMD ["java", "-jar", "hello-server.jar"]

EXPOSE 7001
