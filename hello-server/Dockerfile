# ベースイメージはeclipse-temurin(旧OpenJDK)のJava17を使用
FROM eclipse-temurin:17-jre-alpine

# ホストOSのMavenのビルド成果物をコンテナイメージに格納
WORKDIR /
COPY ./target/hello-server.jar ./
COPY ./target/libs ./libs

# Executable Jarなのでjavaコマンドでサーバを起動
CMD ["java", "-jar", "hello-server.jar"]

# 公開ポートの指定
EXPOSE 7001
