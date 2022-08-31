# docker-with-maven
> 豆蔵デベロッパーサイトのブログ記事で利用しているサンプルアプリ

## 利用している記事

|記事| 利用内容 |
|---|---|
|[今さら聞けないMaven – コンテナも一緒にビルドしたい。テスト実行前にコンテナを起動したい](https://developer.mamezou-tech.com/blogs/2022/08/31/docker_with_maven/)| コンテナ化するアプリとコンテナビルドとコンテナの起動を行うpomの定義 |


## contents 
|ディレクトリ|内容|
| ---------- | --- |
| [hello-server](hello-server/) |dockerプラグインでコンテナイメージをビルドするサンプル |
| [app-client](app-client//) |dockerプラグインでテスト実行前にコンテナを起動するサンプル |
| [goodbye-server](goodbye-server//) |複数コンテナを起動する例で使用するもう一つのRESTサーバアプリ |


## ビルドと実行
サンプルアプリのビルドにはDocker環境とMavenが必要です

### リポジトリのclone
``` shell
# Clone this repository
git clone https://github.com/extact-io/docker-with-maven.git
```

### コンテナイメージのビルド
``` shell
cd hello-server
mvn clean package docker:build
```

### コンテナを起動したテストの実行
``` shell
cd app-client
mvn clean verify
```
