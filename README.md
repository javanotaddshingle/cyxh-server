# 次元星河后端服务

## 项目简介

次元星河是一个面向二次元爱好者的综合平台，提供作品展示、创作工坊、交易市场、社交圈和语言学习等功能。

## 技术栈

- Spring Boot 3.2.5
- Spring Data JPA
- H2 In-Memory Database
- Spring Security
- JWT

## 后端服务配置

### 端口配置
- 后端服务运行在 `http://localhost:8080`

### 数据库配置
- 使用 H2 内存数据库
- 自动初始化测试数据

## 前端项目配置

### 1. 修改API服务配置

打开前端项目中的 `lib/api/api_service.dart` 文件，将 `baseUrl` 修改为：

```dart
static const String baseUrl = 'http://localhost:8080/api';
```

### 2. 启动前端项目

在前端项目目录中运行：

```bash
flutter pub get
flutter run
```

## 可用的API接口

### 作品模块
- 作品列表：`GET /api/works`
- 作品详情：`GET /api/works/{id}`
- 分类筛选：`GET /api/works/category/{category}`
- 用户作品：`GET /api/works/user/{userId}`
- 搜索功能：`GET /api/works/search/{keyword}`
- 点赞功能：`POST /api/works/{id}/like`
- 收藏功能：`POST /api/works/{id}/favorite`
- 排行榜：`GET /api/works/ranking`

### 创作工坊模块
- 绘画作品：`GET /api/drawings`
- 保存绘画：`POST /api/drawings`
- 用户绘画：`GET /api/drawings/user/{userId}`

### 交易市场模块
- 商品列表：`GET /api/trades`
- 商品详情：`GET /api/trades/{id}`
- 分类筛选：`GET /api/trades/category/{category}`

### 社交模块
- 帖子列表：`GET /api/posts`
- 发布帖子：`POST /api/posts`
- 点赞帖子：`POST /api/posts/{id}/like`
- 评论帖子：`POST /api/posts/{id}/comment`

### 语言学习模块
- 课程列表：`GET /api/courses`
- 课程详情：`GET /api/courses/{id}`
- 学习记录：`GET /api/learning-records/user/{userId}`

### 用户模块
- 用户列表：`GET /api/users`
- 用户详情：`GET /api/users/{id}`
- 消息列表：`GET /api/messages/user/{userId}`
- 发送消息：`POST /api/messages`

### 工坊模块
- 工坊列表：`GET /api/workshops`
- 加入工坊：`POST /api/workshops/{id}/join`

## 数据说明

后端数据库已经填充了以下数据：
- **3个用户**：二次元爱好者、画师小明、日语学习者
- **5个作品**：鬼灭之刃、你的名字、进击的巨人、夏目友人帐、Re:从零开始
- **4个交易商品**：初音手办、日轮刀模型、派蒙抱枕、动漫海报
- **4个课程**：日语五十音、动漫日语、日语台词赏析、二次元插画入门
- **4个社交帖子**：动漫推荐、插画分享、学习打卡、求推荐
- **3个工坊活动**：绘画基础班、剧本创作、Cosplay制作
- **2个绘画作品**：初音未来、猫咪老师
- **3条消息**：用户间的互动消息

## 如何启动后端服务

1. 确保已安装 Maven
2. 在项目根目录运行：

```bash
mvn spring-boot:run
```

3. 后端服务将在 `http://localhost:8080` 启动

## 注意事项

- 后端服务使用 H2 内存数据库，每次重启服务都会重新初始化数据
- 前端项目需要添加 `http: ^1.2.1` 依赖
- 确保后端服务已经启动，然后再启动前端项目
- 所有API接口都已经实现，可以直接调用
