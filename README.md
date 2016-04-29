# REST API サンプル

## 2016-4-29 リリースノート

* Swaggerを使った API ドキュメント生成／画面からのテストツールを組み込み
* http://localhost:8080/swagger_ui.html で Swagger UI を表示

## 2016-4-27 リリース

## 概要

* JSONベースの REST API サンプル using Spring Boot @RestController
* 挨拶(greeting)の REQUESTとRESPONSE
* greeting の REQUEST の記録と、履歴(history)の参照

## ビューモデル 層

モデル層とは別にビューモデル層を用意する。

* JSON <--> オブジェクトの変換用のクラス群
* モデル層は、ドメインの表現手段に専念する（JSONの構造から分離する）
* ビューモデルのオブジェクトのフィールドは、原則 public 宣言（jackson用）
* ビューモデルからモデルへの変換は、ビューモデルが責任を持つ
* モデルからビューモデルへの変換も、ビューモデルが責任を持つ

## End to End integration test

Spring の @WebIntegrationTest を使い End to End のAPI テストを組み込む。

gradle test タスクまたは、IntelliJ Idea の Run テスト

## REST-Assured

テストは、REST-Assured を使って記述する。
(Java DSL for easy testing of REST services)

###参考ドキュメント
[REST Assured Usage](https://github.com/jayway/rest-assured/wiki/Usage)

##実行方法
###アプリケーション起動
./gradlew clean bootRun
###テスト
./gradlew test
