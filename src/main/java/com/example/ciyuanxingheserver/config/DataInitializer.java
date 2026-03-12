package com.example.ciyuanxingheserver.config;

import com.example.ciyuanxingheserver.entity.*;
import com.example.ciyuanxingheserver.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(
            UserRepository userRepository,
            WorkRepository workRepository,
            TradeRepository tradeRepository,
            CourseRepository courseRepository,
            PostRepository postRepository,
            WorkshopRepository workshopRepository,
            DrawingRepository drawingRepository,
            MessageRepository messageRepository) {
        return args -> {
            // 初始化用户数据
            if (userRepository.count() == 0) {
                User user1 = new User();
                user1.setUsername("二次元爱好者");
                user1.setEmail("user1@example.com");
                user1.setPassword("password123");
                user1.setAvatar("https://api.dicebear.com/7.x/avataaars/svg?seed=user1");
                user1.setBio("热爱动漫、游戏和二次元文化");
                user1.setCreatedAt(new Date());
                user1.setUpdatedAt(new Date());
                userRepository.save(user1);

                User user2 = new User();
                user2.setUsername("画师小明");
                user2.setEmail("user2@example.com");
                user2.setPassword("password123");
                user2.setAvatar("https://api.dicebear.com/7.x/avataaars/svg?seed=user2");
                user2.setBio("专业二次元插画师，喜欢画萌妹子");
                user2.setCreatedAt(new Date());
                user2.setUpdatedAt(new Date());
                userRepository.save(user2);

                User user3 = new User();
                user3.setUsername("日语学习者");
                user3.setEmail("user3@example.com");
                user3.setPassword("password123");
                user3.setAvatar("https://api.dicebear.com/7.x/avataaars/svg?seed=user3");
                user3.setBio("正在学习日语，喜欢看动漫学语言");
                user3.setCreatedAt(new Date());
                user3.setUpdatedAt(new Date());
                userRepository.save(user3);
            }

            // 初始化作品数据
            if (workRepository.count() == 0) {
                Work work1 = new Work();
                work1.setTitle("鬼灭之刃：无限列车篇");
                work1.setDescription("炎柱炼狱杏寿郎的壮烈战斗，为了保护乘客和炭治郎等人，他独自面对强大的上弦之鬼...");
                work1.setContent("第一章：炎柱的觉悟\n\n炼狱杏寿郎站在无限列车的车顶，月光洒在他那火焰般的头发上。他的眼神坚定，手中紧握着日轮刀...\n\n第二章：上弦之参\n\n猗窝座的出现打破了夜晚的宁静，这位上弦之鬼的实力远超想象...");
                work1.setCategory("漫画");
                work1.setCoverImage("https://images.unsplash.com/photo-1578632767115-351597cf2477?w=400");
                work1.setUserId(2L);
                work1.setLikes(1256);
                work1.setViews(8934);
                work1.setCreatedAt(new Date());
                work1.setUpdatedAt(new Date());
                workRepository.save(work1);

                Work work2 = new Work();
                work2.setTitle("你的名字：时空之恋");
                work2.setDescription("立花泷和宫水三叶的奇妙邂逅，跨越时空的爱情故事，新海诚导演的巅峰之作...");
                work2.setContent("第一章：梦中的交换\n\n每天早上醒来，我发现自己在一个陌生的身体里，在一个陌生的小镇...\n\n第二章：寻找彼此\n\n我开始寻找那个在梦中出现的女孩，尽管我不知道她是否真的存在...");
                work2.setCategory("小说");
                work2.setCoverImage("https://images.unsplash.com/photo-1518709268805-4e9042af9f23?w=400");
                work2.setUserId(1L);
                work2.setLikes(2341);
                work2.setViews(12567);
                work2.setCreatedAt(new Date());
                work2.setUpdatedAt(new Date());
                workRepository.save(work2);

                Work work3 = new Work();
                work3.setTitle("进击的巨人：自由之翼");
                work3.setDescription("人类与巨人的史诗级战斗，艾伦·耶格尔追求自由的征程，震撼人心的结局...");
                work3.setContent("第一章：墙壁之外\n\n那一天，人类终于回想起了，曾经一度被巨人支配的恐惧...\n\n第二章：调查兵团\n\n为了人类的自由，我们愿意献出心脏，探索墙壁外的世界...");
                work3.setCategory("动画");
                work3.setCoverImage("https://images.unsplash.com/photo-1541562232579-512a21360020?w=400");
                work3.setUserId(2L);
                work3.setLikes(3422);
                work3.setViews(18765);
                work3.setCreatedAt(new Date());
                work3.setUpdatedAt(new Date());
                workRepository.save(work3);

                Work work4 = new Work();
                work4.setTitle("夏目友人帐：温柔的妖怪");
                work4.setDescription("夏目贵志与妖怪的温馨故事，我想成为一个温柔的人，因为曾被温柔的人那样对待...");
                work4.setContent("第一章：外婆的遗物\n\n我在整理外婆的遗物时，发现了一本奇怪的册子，上面写满了名字...\n\n第二章：猫咪老师\n\n那只胖胖的猫咪突然开口说话了，它说要当我的保镖...");
                work4.setCategory("漫画");
                work4.setCoverImage("https://images.unsplash.com/photo-1513364776144-60967b0f800f?w=400");
                work4.setUserId(1L);
                work4.setLikes(1876);
                work4.setViews(9876);
                work4.setCreatedAt(new Date());
                work4.setUpdatedAt(new Date());
                workRepository.save(work4);

                Work work5 = new Work();
                work5.setTitle("Re:从零开始的异世界生活");
                work5.setDescription("菜月昴的死亡回归能力，为了拯救心爱的雷姆和艾米莉亚，他不断重复着死亡...");
                work5.setContent("第一章：异世界召唤\n\n当我回过神来，发现自己已经不在日本了，而是在一个完全不同的世界...\n\n第二章：死亡回归\n\n我发现自己拥有死亡后回到过去的能力，但这能力带来的痛苦远超想象...");
                work5.setCategory("小说");
                work5.setCoverImage("https://images.unsplash.com/photo-1534447677768-be436bb09401?w=400");
                work5.setUserId(2L);
                work5.setLikes(2987);
                work5.setViews(15678);
                work5.setCreatedAt(new Date());
                work5.setUpdatedAt(new Date());
                workRepository.save(work5);
            }

            // 初始化交易数据
            if (tradeRepository.count() == 0) {
                Trade trade1 = new Trade();
                trade1.setTitle("初音未来手办 田园风");
                trade1.setDescription("精致初音未来手办，田园风格设计，高度约25cm，细节丰富，适合收藏");
                trade1.setPrice(299.0);
                trade1.setCategory("手办");
                trade1.setCoverImage("https://images.unsplash.com/photo-1566576912321-d58ddd7a6088?w=400");
                trade1.setStatus("在售");
                trade1.setUserId(1L);
                trade1.setCreatedAt(new Date());
                trade1.setUpdatedAt(new Date());
                tradeRepository.save(trade1);

                Trade trade2 = new Trade();
                trade2.setTitle("鬼灭之刃 日轮刀模型");
                trade2.setDescription("炭治郎日轮刀1:1模型，木质刀身，可挂墙展示，长度约100cm");
                trade2.setPrice(158.0);
                trade2.setCategory("周边");
                trade2.setCoverImage("https://images.unsplash.com/photo-1589254065878-42c9da997008?w=400");
                trade2.setStatus("在售");
                trade2.setUserId(2L);
                trade2.setCreatedAt(new Date());
                trade2.setUpdatedAt(new Date());
                tradeRepository.save(trade2);

                Trade trade3 = new Trade();
                trade3.setTitle("原神 派蒙抱枕");
                trade3.setDescription("超软派蒙抱枕，50cm尺寸，双面印刷，可当靠垫使用");
                trade3.setPrice(89.0);
                trade3.setCategory("周边");
                trade3.setCoverImage("https://images.unsplash.com/photo-1558618666-fcd25c85cd64?w=400");
                trade3.setStatus("在售");
                trade3.setUserId(1L);
                trade3.setCreatedAt(new Date());
                trade3.setUpdatedAt(new Date());
                tradeRepository.save(trade3);

                Trade trade4 = new Trade();
                trade4.setTitle("动漫海报套装（10张）");
                trade4.setDescription("包含鬼灭之刃、进击的巨人、你的名字等热门动漫海报，A3尺寸");
                trade4.setPrice(39.9);
                trade4.setCategory("海报");
                trade4.setCoverImage("https://images.unsplash.com/photo-1612036782180-6f0b6cd846fe?w=400");
                trade4.setStatus("在售");
                trade4.setUserId(2L);
                trade4.setCreatedAt(new Date());
                trade4.setUpdatedAt(new Date());
                tradeRepository.save(trade4);
            }

            // 初始化课程数据
            if (courseRepository.count() == 0) {
                Course course1 = new Course();
                course1.setTitle("日语入门：五十音图");
                course1.setDescription("从零开始学习日语，掌握五十音图发音和写法，为日语学习打下坚实基础");
                course1.setContent("第一课：あ行\nあ(a) い(i) う(u) え(e) お(o)\n\nあ - 发音类似'啊'，口型自然张开\nい - 发音类似'衣'，嘴角向两边展开\nう - 发音类似'乌'，嘴唇微微收圆\nえ - 发音类似'诶'，嘴角向两边展开\nお - 发音类似'哦'，嘴唇收圆\n\n第二课：か行\nか(ka) き(ki) く(ku) け(ke) こ(ko)");
                course1.setLanguage("日语");
                course1.setCoverImage("https://images.unsplash.com/photo-1528164344705-47542687000d?w=400");
                course1.setEnrollments(1234);
                course1.setUserId(3L);
                course1.setCreatedAt(new Date());
                course1.setUpdatedAt(new Date());
                courseRepository.save(course1);

                Course course2 = new Course();
                course2.setTitle("动漫日语：日常用语");
                course2.setDescription("学习动漫中常见的日语表达，让你能听懂动漫对话，轻松学日语");
                course2.setContent("第一课：问候语\n\nおはようございます (Ohayou gozaimasu) - 早上好\nこんにちは (Konnichiwa) - 你好/下午好\nこんばんは (Konbanwa) - 晚上好\nさようなら (Sayounara) - 再见\n\n第二课：常用表达\n\nありがとうございます (Arigatou gozaimasu) - 谢谢\nすみません (Sumimasen) - 对不起/不好意思\nお願いします (Onegaishimasu) - 拜托了/请\nわかりました (Wakarimashita) - 明白了");
                course2.setLanguage("日语");
                course2.setCoverImage("https://images.unsplash.com/photo-1541963463532-d68292c34b19?w=400");
                course2.setEnrollments(987);
                course2.setUserId(3L);
                course2.setCreatedAt(new Date());
                course2.setUpdatedAt(new Date());
                courseRepository.save(course2);

                Course course3 = new Course();
                course3.setTitle("日语动漫台词赏析");
                course3.setDescription("学习经典动漫台词，感受日语的魅力，提升语言学习兴趣");
                course3.setContent("第一课：《你的名字》\n\n「重要な人、忘れたくない人、絶対に忘れちゃダメな人、名前が思い出せなくても、ずっとずっと探し続ける」\n\n中文：重要的人，不想忘记的人，绝对不能忘的人，就算我不记得你的名字，我也会一直一直拼命的寻找你。\n\n第二课：《夏目友人帐》\n\n「優しい人になりたいです。優しい人に優しくしてもらったので、その優しさを知っています」\n\n中文：我想成为一个温柔的人，因为曾被温柔的人那样对待，深深了解那种被温柔相待的感觉。");
                course3.setLanguage("日语");
                course3.setCoverImage("https://images.unsplash.com/photo-1513364776144-60967b0f800f?w=400");
                course3.setEnrollments(756);
                course3.setUserId(3L);
                course3.setCreatedAt(new Date());
                course3.setUpdatedAt(new Date());
                courseRepository.save(course3);

                Course course4 = new Course();
                course4.setTitle("二次元插画入门");
                course4.setDescription("学习二次元风格插画基础，掌握人物比例、线条绘制和上色技巧");
                course4.setContent("第一课：二次元人物比例\n\n二次元人物通常采用7-8头身比例，头部较大，眼睛占据脸部较大面积。\n\n第二课：眼睛的画法\n\n二次元眼睛是表达情感的关键，通常包括：\n1. 上眼睑线条\n2. 瞳孔和高光\n3. 眼睫毛\n4. 下眼睑\n\n第三课：基础上色\n\n二次元插画通常使用平涂风格，色彩饱和度较高，阴影处理简洁。");
                course4.setLanguage("中文");
                course4.setCoverImage("https://images.unsplash.com/photo-1513364776144-60967b0f800f?w=400");
                course4.setEnrollments(1543);
                course4.setUserId(2L);
                course4.setCreatedAt(new Date());
                course4.setUpdatedAt(new Date());
                courseRepository.save(course4);
            }

            // 初始化社交帖子数据
            if (postRepository.count() == 0) {
                Post post1 = new Post();
                post1.setContent("刚看完《鬼灭之刃》最新话，太燃了！炎柱的战斗场面简直震撼，强烈推荐大家去看！#鬼灭之刃 #动漫推荐");
                post1.setImageUrl("https://images.unsplash.com/photo-1578632767115-351597cf2477?w=400");
                post1.setLikes(156);
                post1.setComments(23);
                post1.setUserId(1L);
                post1.setCreatedAt(new Date());
                post1.setUpdatedAt(new Date());
                postRepository.save(post1);

                Post post2 = new Post();
                post2.setContent("画了一张雷姆的插画，花了我整整一周时间，大家觉得怎么样？求点评~ #二次元 #插画 #雷姆");
                post2.setImageUrl("https://images.unsplash.com/photo-1566576912321-d58ddd7a6088?w=400");
                post2.setLikes(234);
                post2.setComments(45);
                post2.setUserId(2L);
                post2.setCreatedAt(new Date());
                post2.setUpdatedAt(new Date());
                postRepository.save(post2);

                Post post3 = new Post();
                post3.setContent("日语学习打卡第30天！今天学会了五十音图，感觉离看懂生肉动漫又近了一步！頑張ります！#日语学习 #打卡");
                post3.setImageUrl("https://images.unsplash.com/photo-1528164344705-47542687000d?w=400");
                post3.setLikes(89);
                post3.setComments(12);
                post3.setUserId(3L);
                post3.setCreatedAt(new Date());
                post3.setUpdatedAt(new Date());
                postRepository.save(post3);

                Post post4 = new Post();
                post4.setContent("求推荐好看的治愈系动漫，最近压力有点大，想看一些温馨的作品。已经看过《夏目友人帐》和《轻音少女》了~");
                post4.setLikes(67);
                post4.setComments(34);
                post4.setUserId(1L);
                post4.setCreatedAt(new Date());
                post4.setUpdatedAt(new Date());
                postRepository.save(post4);
            }

            // 初始化工坊数据
            if (workshopRepository.count() == 0) {
                Workshop workshop1 = new Workshop();
                workshop1.setTitle("二次元人物绘画基础班");
                workshop1.setDescription("从零开始学习二次元人物绘画，包含人物比例、五官画法、发型设计等基础内容");
                workshop1.setContent("第一课：人物比例基础\n第二课：头部结构与五官位置\n第三课：眼睛的画法\n第四课：发型设计\n第五课：身体结构与动态");
                workshop1.setCategory("绘画");
                workshop1.setCoverImage("https://images.unsplash.com/photo-1513364776144-60967b0f800f?w=400");
                workshop1.setStartDate(new Date());
                workshop1.setEndDate(new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000));
                workshop1.setParticipants(56);
                workshop1.setUserId(2L);
                workshop1.setCreatedAt(new Date());
                workshop1.setUpdatedAt(new Date());
                workshopRepository.save(workshop1);

                Workshop workshop2 = new Workshop();
                workshop2.setTitle("动漫剧本创作入门");
                workshop2.setDescription("学习如何创作吸引人的动漫剧本，包含人物设定、剧情架构、对话写作等技巧");
                workshop2.setContent("第一课：剧本基础结构\n第二课：人物设定与塑造\n第三课：剧情冲突设计\n第四课：对话写作技巧\n第五课：分镜基础");
                workshop2.setCategory("写作");
                workshop2.setCoverImage("https://images.unsplash.com/photo-1455390582262-044cdead277a?w=400");
                workshop2.setStartDate(new Date());
                workshop2.setEndDate(new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000));
                workshop2.setParticipants(34);
                workshop2.setUserId(1L);
                workshop2.setCreatedAt(new Date());
                workshop2.setUpdatedAt(new Date());
                workshopRepository.save(workshop2);

                Workshop workshop3 = new Workshop();
                workshop3.setTitle("Cosplay服装制作");
                workshop3.setDescription("学习Cosplay服装的制作技巧，从选料到成品，手把手教你做出完美的cos服");
                workshop3.setContent("第一课：材料选择与采购\n第二课：基础裁剪技巧\n第三课：缝纫基础\n第四课：道具制作\n第五课：化妆与造型");
                workshop3.setCategory("手工");
                workshop3.setCoverImage("https://images.unsplash.com/photo-1566576912321-d58ddd7a6088?w=400");
                workshop3.setStartDate(new Date());
                workshop3.setEndDate(new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000));
                workshop3.setParticipants(28);
                workshop3.setUserId(2L);
                workshop3.setCreatedAt(new Date());
                workshop3.setUpdatedAt(new Date());
                workshopRepository.save(workshop3);
            }

            // 初始化绘画作品数据
            if (drawingRepository.count() == 0) {
                Drawing drawing1 = new Drawing();
                drawing1.setTitle("初音未来");
                drawing1.setImageData("data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iNDAwIiBoZWlnaHQ9IjQwMCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICA8cmVjdCB3aWR0aD0iNDAwIiBoZWlnaHQ9IjQwMCIgZmlsbD0iI2YwZjBmMCIvPgogIDxjaXJjbGUgY3g9IjIwMCIgY3k9IjE1MCIgcj0iODAiIGZpbGw9IiMzOWM1YmIiLz4KICA8Y2lyY2xlIGN4PSIxNzAiIGN5PSIxNDAiIHI9IjEwIiBmaWxsPSIjZmZmIi8+CiAgPGNpcmNsZSBjeD0iMjMwIiBjeT0iMTQwIiByPSIxMCIgZmlsbD0iI2ZmZiIvPgogIDxjaXJjbGUgY3g9IjE3NSIgY3k9IjE0NSIgcj0iNSIgZmlsbD0iIzMzMyIvPgogIDxjaXJjbGUgY3g9IjIyNSIgY3k9IjE0NSIgcj0iNSIgZmlsbD0iIzMzMyIvPgogIDxwYXRoIGQ9Ik0gMTgwIDE4MCBRIDIwMCAxOTAgMjIwIDE4MCIgc3Ryb2tlPSIjMzMzIiBzdHJva2Utd2lkdGg9IjMiIGZpbGw9Im5vbmUiLz4KICA8cmVjdCB4PSIxMjAiIHk9IjgwIiB3aWR0aD0iMTYwIiBoZWlnaHQ9IjQwIiBmaWxsPSIjMzljNWJiIi8+CiAgPHRleHQgeD0iMjAwIiB5PSIzNTAiIHRleHQtYW5jaG9yPSJtaWRkbGUiIGZvbnQtc2l6ZT0iMjQiIGZpbGw9IiMzMzMiPuaZiOWHp+WFi+WkpzwvdGV4dD4KPC9zdmc+");
                drawing1.setCategory("二次元");
                drawing1.setUserId(2L);
                drawing1.setCreatedAt(new Date());
                drawing1.setUpdatedAt(new Date());
                drawingRepository.save(drawing1);

                Drawing drawing2 = new Drawing();
                drawing2.setTitle("猫咪老师");
                drawing2.setImageData("data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iNDAwIiBoZWlnaHQ9IjQwMCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICA8cmVjdCB3aWR0aD0iNDAwIiBoZWlnaHQ9IjQwMCIgZmlsbD0iI2ZmZjhlNyIvPgogIDxlbGxpcHNlIGN4PSIyMDAiIGN5PSIyMjAiIHJ4PSIxMjAiIHJ5PSIxMDAiIGZpbGw9IiNmZmYiLz4KICA8dHJpYW5nbGUgcG9pbnRzPSIxMjAsMTQwIDEwMCw4MCAxNDAsMTAwIiBmaWxsPSIjZmZmIi8+CiAgPHRyaWFuZ2xlIHBvaW50cz0iMjgwLDE0MCAzMDAsODAgMjYwLDEwMCIgZmlsbD0iI2ZmZiIvPgogIDxjaXJjbGUgY3g9IjE2MCIgY3k9IjE4MCIgcj0iMTUiIGZpbGw9IiMzMzMiLz4KICA8Y2lyY2xlIGN4PSIyNDAiIGN5PSIxODAiIHI9IjE1IiBmaWxsPSIjMzMzIi8+CiAgPGVsbGlwc2UgY3g9IjIwMCIgY3k9IjIyMCIgcng9IjEwIiByeT0iNSIgZmlsbD0iI2Y0YTQ2MCIvPgogIDxwYXRoIGQ9Ik0gMTgwIDI2MCBRIDIwMCAyODAgMjIwIDI2MCIgc3Ryb2tlPSIjMzMzIiBzdHJva2Utd2lkdGg9IjIiIGZpbGw9Im5vbmUiLz4KICA8dGV4dCB4PSIyMDAiIHk9IjM1MCIgdGV4dC1hbmNob3I9Im1pZGRsZSIgZm9udC1zaXplPSIyMCIgZmlsbD0iIzMzMyI+54yr5aW654eD6ICDPC90ZXh0Pgo8L3N2Zz4=");
                drawing2.setCategory("萌宠");
                drawing2.setUserId(1L);
                drawing2.setCreatedAt(new Date());
                drawing2.setUpdatedAt(new Date());
                drawingRepository.save(drawing2);
            }

            // 初始化消息数据
            if (messageRepository.count() == 0) {
                Message message1 = new Message();
                message1.setFromUserId(2L);
                message1.setToUserId(1L);
                message1.setContent("你好！看了你的作品，画得很棒！可以交流一下绘画技巧吗？");
                message1.setRead(false);
                message1.setCreatedAt(new Date());
                messageRepository.save(message1);

                Message message2 = new Message();
                message2.setFromUserId(3L);
                message2.setToUserId(1L);
                message2.setContent("感谢分享日语学习资料，很有帮助！");
                message2.setRead(false);
                message2.setCreatedAt(new Date());
                messageRepository.save(message2);

                Message message3 = new Message();
                message3.setFromUserId(1L);
                message3.setToUserId(2L);
                message3.setContent("谢谢你的夸奖！我们可以一起练习，互相进步~");
                message3.setRead(true);
                message3.setCreatedAt(new Date());
                messageRepository.save(message3);
            }

            System.out.println("数据初始化完成！");
        };
    }
}