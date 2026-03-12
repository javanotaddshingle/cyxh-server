# 前端项目配置指南

## 1. 修改API服务配置

打开前端项目中的 `lib/api/api_service.dart` 文件，将 `baseUrl` 修改为：

```dart
static const String baseUrl = 'http://localhost:8083/api';
```

## 2. 启动前端项目

在前端项目目录中运行：

```bash
flutter pub get
flutter run
```

## 3. 测试API接口

前端项目现在应该能够正常调用后端API了。以下是可用的API接口：

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

### 语言学习模块
- 课程列表：`GET /api/courses`
- 课程详情：`GET /api/courses/{id}`
- 学习记录：`GET /api/learning-records/user/{userId}`

### 用户模块
- 用户列表：`GET /api/users`
- 用户详情：`GET /api/users/{id}`
- 消息列表：`GET /api/messages/user/{userId}`
- 发送消息：`POST /api/messages`

## 4. 数据说明

后端数据库已经填充了以下数据：
- **3个用户**：二次元爱好者、画师小明、日语学习者
- **5个作品**：鬼灭之刃、你的名字、进击的巨人、夏目友人帐、Re:从零开始
- **4个交易商品**：初音手办、日轮刀模型、派蒙抱枕、动漫海报
- **4个课程**：日语五十音、动漫日语、日语台词赏析、二次元插画入门
- **4个社交帖子**：动漫推荐、插画分享、学习打卡、求推荐
- **3个工坊活动**：绘画基础班、剧本创作、Cosplay制作
- **2个绘画作品**：初音未来、猫咪老师
- **3条消息**：用户间的互动消息

## 5. 注意事项

- 后端服务运行在 `http://localhost:8083`
- 前端项目需要添加 `http: ^1.2.1` 依赖
- 确保后端服务已经启动
- 如果遇到CORS问题，需要在后端添加CORS配置
