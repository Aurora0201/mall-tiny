# mall-tiny

借鉴[GitHub](https://github.com/macrozheng/mall)开源项目经验的学习版本，使用的SpringBoot版本为3.0，MySQL为8.0版本，将从头开始构建一个具有前台展示和后台管理功能的商城系统



# 需求分析

## 用户登录/注册

用户注册和登录是每个系统必备的功能

**注册功能**

注册必须的字段如下表

| 字段     | 要求                                    | 说明                   |
| -------- | --------------------------------------- | ---------------------- |
| username | 不能重复，必须大于6个字符且小于20个字符 | 用户名，作为登录时账号 |
| phone    | 必须符合中国手机号的标准                | 手机号，消息提醒使用   |
| password | 8-20位，至少包含数字与字母              | 密码，作为登录时密码   |
| gender   | 必须选择男或者女                        | 性别                   |

**点击注册后，应该出现相应的提示，并且防止用户发送重复的请求**

后端实现：在前端发送请求后，先验证所有字段是否不为空，存在为空则抛出异常，然后验证是否存在同名用户，存在则抛出异常，不存在则插入数据库



**登录功能**

使用字段

| 字段     | 说明         |
| -------- | ------------ |
| username | 注册时用户名 |
| password | 注册时密码   |

