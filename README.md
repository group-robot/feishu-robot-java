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

# pom

```xml

<dependency>
    <groupId>io.github.group-robot</groupId>
    <artifactId>feishu-robot-core</artifactId>
    <version>${version}</version>
</dependency>
```

# example

## text

```java
TextMessage message = TextMessage
        .builder()
        .content("test")
        .atAll(false)
        .build();
String webhok = System.getenv("webhok");
String secret = System.getenv("secret");
FeishuRobotClient send = new FeishuRobotClient();
        send.

setSecret(secret);
        send.

setWebhook(webhok);

FeishuRobotResponse feiShuRobotResponse = send.sendMessage(message);
```

## image

```java
ImageMessage message = ImageMessage
        .builder()
        .imageKey("img_7ea74629-9191-4176-998c-2e603c9c5e8g")
        .build();
String webhok = System.getenv("webhok");
String secret = System.getenv("secret");
FeishuRobotClient send = new FeishuRobotClient();
        send.

setSecret(secret);
        send.

setWebhook(webhok);

FeishuRobotResponse feiShuRobotResponse = send.sendMessage(message);
```

## post

```java
PostMessage message = PostMessage.build().lang(
        PostLang.builder()
                .lang("zh_cn")
                .unit(
                        PostUnit.build()
                                .title("项目更新通知")
                                .addTags(
                                        PostTags.build().addTags(
                                                TextTag.builder().text("项目有更新: ").build(),
                                                ATag.builder().text("请查看").href("http://www.example.com/").build(),
                                                AtTag.builder().atAll(true).build()
                                        )
                                )
                )
                .build()
);
String webhok = System.getenv("webhok");
String secret = System.getenv("secret");
FeishuRobotClient send = new FeishuRobotClient();
        send.

setSecret(secret);
        send.

setWebhook(webhok);

FeishuRobotResponse feiShuRobotResponse = send.sendMessage(message);
```

## interactive

```java
InteractiveMessage message = InteractiveMessage.build();
        message.

config(CardConfig.builder().

wideScreenMode(true).

build());
        message.

setHeader(CardHeader.builder().

title(CardTitle.build().

content("\uD83D\uDC08 英国短毛猫")).

template("indigo").

build());
        message.

addElements(
        ContentModule.build()
        .

text(Text.builder().

tag(TextTag.LARK_MD).

content("英国短毛猫，体形圆胖，四肢短粗发达，毛短而密，头大脸圆，对人友善。 "+
                "\n其历史可追溯至古罗马时期的家猫，由于拥有悠久的育种历史，称得上是猫家族中的典范。").

build())
        .

extra(Image.builder().

imgKey("img_70558e3a-2eef-4e8f-9a07-a701c165431g").

alt(
        Text.builder().

tag(TextTag.PLAIN_TEXT).

content("图片").

build()).

build()),
        ContentModule.

build()
        .

addField(
        Field.builder().

isShort(true).

text(Text.builder().

tag(TextTag.LARK_MD).

content("**中文学名：**\n英国短毛猫").

build()).

build(),
        Field.

builder().

isShort(true).

text(Text.builder().

tag(TextTag.LARK_MD).

content("**拉丁学名：**\nFelinae").

build()).

build(),
        Field.

builder().

isShort(false).

text(Text.builder().

tag(TextTag.LARK_MD).

content(" ").

build()).

build(),
        Field.

builder().

isShort(true).

text(Text.builder().

tag(TextTag.LARK_MD).

content("**体形：**\n圆胖").

build()).

build(),
        Field.

builder().

isShort(true).

text(Text.builder().

tag(TextTag.LARK_MD).

content("**被毛：**\n短而浓密、俗称地毯毛").

build()).

build()
        ),
                HrModule.

builder().

build(),
        ContentModule.

build()
        .

text(Text.builder().

tag(TextTag.LARK_MD).

content("**1 形态特征**\n\n 🔵 外形：身体厚实，胸部饱满宽阔，腿部粗壮，爪子浑圆，尾巴的根部粗壮，尾尖钝圆。\n\n🔵 毛色：共有十五种品种被承认，其中最著名的是蓝色系的英国短毛猫。 ").

build())
        .

extra(Image.builder().

imgKey("img_70558e3a-2eef-4e8f-9a07-a701c165431g").

alt(Text.builder().

tag(TextTag.PLAIN_TEXT).

content("图片").

build()).

build()),
        NoteModule.

build().

addElement(
        Image.builder().

imgKey("img_e61db329-2469-4da7-8f13-2d2f284c3b1g").

alt(Text.builder().

tag(TextTag.PLAIN_TEXT).

content("图片").

build()).

build(),
        Text.

builder().

tag(TextTag.PLAIN_TEXT).

content("以上资料来自百度百科").

build()
        )
                );
String webhok = System.getenv("webhok");
String secret = System.getenv("secret");
FeishuRobotClient send = new FeishuRobotClient();
        send.

setSecret(secret);
        send.

setWebhook(webhok);

FeishuRobotResponse feiShuRobotResponse = send.sendMessage(message);
```

```java
   String json = "{\"config\":{\"enable_forward\":true,\"wide_screen_mode\":true}," +
        "\"elements\":[{\"extra\":{\"alt\":{\"content\":\"图片\",\"tag\":\"plain_text\"},\"compact_width\":false,\"img_key\":\"img_1cad0e51-26f6-492a-8280-a47057b09a0g\",\"mode\":\"crop_center\",\"preview\":true,\"tag\":\"img\"},\"fields\":null,\"tag\":\"div\",\"text\":{\"content\":\"英国短毛猫，体形圆胖，四肢短粗发达，毛短而密，头大脸圆，对人友善。 \\n其历史可追溯至古罗马时期的家猫，由于拥有悠久的育种历史，称得上是猫家族中的典范。\",\"tag\":\"lark_md\"}},{\"fields\":[{\"is_short\":true,\"text\":{\"content\":\"**中文学名：**\\n英国短毛猫\",\"tag\":\"lark_md\"}},{\"is_short\":true,\"text\":{\"content\":\"**拉丁学名：**\\nFelinae\",\"tag\":\"lark_md\"}},{\"is_short\":false,\"text\":{\"content\":\"\",\"tag\":\"lark_md\"}},{\"is_short\":true,\"text\":{\"content\":\"**体形：**\\n圆胖\",\"tag\":\"lark_md\"}},{\"is_short\":true,\"text\":{\"content\":\"**被毛：**\\n短而浓密、俗称地毯毛\",\"tag\":\"lark_md\"}}],\"tag\":\"div\"},{\"tag\":\"hr\"},{\"extra\":{\"alt\":{\"content\":\"图片\",\"tag\":\"plain_text\"},\"compact_width\":false,\"img_key\":\"img_70558e3a-2eef-4e8f-9a07-a701c165431g\",\"mode\":\"crop_center\",\"preview\":true,\"tag\":\"img\"},\"fields\":null,\"tag\":\"div\",\"text\":{\"content\":\"**1 形态特征**\\n\\n \uD83D\uDD35 外形：身体厚实，胸部饱满宽阔，腿部粗壮，爪子浑圆，尾巴的根部粗壮，尾尖钝圆。\\n\\n\uD83D\uDD35 毛色：共有十五种品种被承认，其中最著名的是蓝色系的英国短毛猫。 \",\"tag\":\"lark_md\"}},{\"elements\":[{\"alt\":{\"content\":\"图片\",\"tag\":\"plain_text\"},\"compact_width\":false,\"img_key\":\"img_7ea74629-9191-4176-998c-2e603c9c5e8g\",\"mode\":\"crop_center\",\"preview\":true,\"tag\":\"img\"},{\"content\":\"以上资料来自百度百科\",\"tag\":\"plain_text\"}],\"tag\":\"note\"}],\"header\":{\"template\":\"indigo\",\"title\":{\"content\":\"\uD83D\uDC08 英国短毛猫\",\"tag\":\"plain_text\"}}}";
InteractiveMessage message = InteractiveMessage.build().cardJsonStr(json);
String webhok = System.getenv("webhok");
String secret = System.getenv("secret");
FeishuRobotClient send = new FeishuRobotClient();
        send.

setSecret(secret);
        send.

setWebhook(webhok);

FeishuRobotResponse feiShuRobotResponse = send.sendMessage(message);
```

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
