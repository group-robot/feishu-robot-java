<h1 align="center"><a href="https://github.com/group-robot/java-feishu-robot" target="_blank">feishu-robot-core</a></h1>
<p align="center">
<a href="https://search.maven.org/artifact/io.github.group-robot/feishu-robot-core">
<img alt="Maven Central" src="https://img.shields.io/maven-central/v/io.github.group-robot/feishu-robot-core?style=flat-square">
</a>
<a href="https://github.com/group-robot/java-feishu-robot/blob/master/LICENSE">
<img alt="GitHub" src="https://img.shields.io/github/license/group-robot/java-feishu-robot?style=flat-square">
</a>
<a href="https://github.com/group-robot/java-feishu-robot/actions">
<img alt="GitHub Workflow Status" src="https://img.shields.io/github/actions/workflow/status/group-robot/java-feishu-robot/release.yml?style=flat-square">
</a>
<a href="https://www.oracle.com/java/technologies/javase-downloads.html">
<img alt="jdk" src="https://img.shields.io/badge/jdk-8%2B-green?style=flat-square">
</a>
</p>


**v1与v2版本存在差异，v1版本为原始版本，v2版本为重构版本，v2版本支持更多消息类型，更加灵活，v1版本不再维护，建议使用v2版本**

# pom

```xml

<dependency>
    <groupId>io.github.group-robot</groupId>
    <artifactId>feishu-robot-core</artifactId>
    <version>${version}</version>
</dependency>
```

# 功能列表

- [x] 发送文本消息
- [x] 发送富文本消息
- [x] 发送群名片消息
- [x] 发送图片消息

<!-- @formatter:off -->
# example

## 发送文本消息

```java
TextMessage message = TextMessage.of("新更新提醒");
String secret = "";
String webhook = "";
FeishuRobotClient send = new FeishuRobotClient();
send.setSecret(secret);
send.setWebhook(webhook);

FeishuRobotResponse feiShuRobotResponse = send.sendMessage(message);
```

## 发送富文本消息

```java 
 PostMessage message = PostMessage.of()
        .addContent(Paragraph
                .of()
                .setTitle("项目更新通知")
                .newLine()
                .addContent(TextTag.of("项目有更新: "))
                .addContent(ATag.of("请查看", "http://www.example.com/"))
                .addContent(AtTag.of().atAll()));

String webhook = "";
String secret = "";
FeishuRobotClient send = new FeishuRobotClient();
send.setSecret(secret);
send.setWebhook(webhook);

FeishuRobotResponse feiShuRobotResponse = send.sendMessage(message);
```

## 发送群名片消息

```java
 ShareChatMessage message = ShareChatMessage.of("oc_f5b1a7eb27ae2****339ff");
String webhook = "";
String secret = "";
FeishuRobotClient send = new FeishuRobotClient();
send.setSecret(secret);
send.setWebhook(webhook);
FeishuRobotResponse feiShuRobotResponse = send.sendMessage(message);
```

## 发送图片消息

```java
 ImageMessage message = ImageMessage.of("img_7ea74629-9191-4176-998c-2e603c9c5e8g");
String webhook = "";
String secret = "";
FeishuRobotClient send = new FeishuRobotClient();
send.setSecret(secret);
send.setWebhook(webhook);
FeishuRobotResponse feiShuRobotResponse = send.sendMessage(message);
```

## 发送卡片消息

```java
 CardHeader cardHeader = CardHeader.of(
        CardTitle
                .builder()
                .setTitle(Title.of("今日旅游推荐"))
                .build()
);
CardBody cardBody = CardBody
        .of()
        .add(Text.builder().setText(TextEl.builder()
                .setContent(ContentI18n.of(TextTag.LARK_MD, "**西湖**，位于浙江省杭州市西湖区龙井路1号，杭州市区西部，景区总面积49平方千米，汇水面积为21" +
                        ".22平方千米，湖面面积为6.38平方千米。"))
                .build()).build())
        .add(Button.builder()
                .setText("更多景点介绍 :玫瑰:")
                .setType(ButtonType.DEFAULT)
                .build());


CardV2Message cardV2Message = CardV2Message
        .builder()
        .setHeader(cardHeader)
        .setBody(cardBody)
        .build();

String webhok = "";
String secret = "";
FeishuRobotClient send = new FeishuRobotClient();
send.setSecret(secret);
send.setWebhook(webhok);
FeishuRobotResponse feiShuRobotResponse = send.sendMessage(cardV2Message);
```

<!-- @formatter:on -->

# Http,JSON Library 选择

## JSON

由 [hb0730/jsons](https://github.com/hb0730/jsons) 提供多JSON选择

优先级 `Jackson > Gson > jsonb`

```xml
<!--gson-->
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <optional>true</optional>
</dependency>
        <!--jackson-->
<dependency>
<groupId>com.fasterxml.jackson.core</groupId>
<artifactId>jackson-databind</artifactId>
<optional>true</optional>
</dependency>
        <!--json-b-->
<dependency>
<groupId>jakarta.json.bind</groupId>
<artifactId>jakarta.json.bind-api</artifactId>
<optional>true</optional>
</dependency>
```

## HTTP

由 [hb0730/jhttps](https://github.com/hb0730/jhttps) 提供多HTTP选择

优先级 `Hutool-http > Okhttp3 > Apache HttpClient`

```xml

<dependency>
    <groupId>org.apache.httpcomponents</groupId>
    <artifactId>httpclient</artifactId>
    <optional>true</optional>
</dependency>
<dependency>
<groupId>com.squareup.okhttp3</groupId>
<artifactId>okhttp</artifactId>
<optional>true</optional>
</dependency>
<dependency>
<groupId>cn.hutool</groupId>
<artifactId>hutool-http</artifactId>
<optional>true</optional>
</dependency>
```

# 相关问题

- [发送POST请求 中文乱码](https://github.com/group-robot/java-feishu-robot/issues/4)
