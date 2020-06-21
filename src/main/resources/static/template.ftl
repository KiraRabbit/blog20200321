<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:http="http://www.w3.org/1999/xhtml"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
<head>
    <meta charset="UTF-8">
    <title>三日月</title>
    <link rel="icon" type="image/x-icon" href="https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3794032166,3245555489&fm=26&gp=0.jpg">
    <link href="https://lib.baomitu.com/amazeui/2.7.2/css/amazeui.min.css" rel="stylesheet">
    <link href="https://lib.baomitu.com/font-awesome/5.8.0/css/fontawesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/plugs_paging.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">


</head>
<body>
<div>
    <!--头部-->
    <div class="header">
        <div class="am-topbar" style="margin-bottom: 0">
            <h1 class="am-topbar-brand">
                <a href="/" class="blogTitleName"><img src="img/kira/logo.jpeg" class="imgStyle">三日月</a>
            </h1>
            <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
                    style="background-color: #CCCCCC;border-color: white;border-radius: 6px"
                    data-am-collapse="{target: '#doc-topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span
                        class="am-icon-bars"></span></button>

            <div id="personal-card" class="am-dropdown am-show-md-down" data-am-dropdown style="float: right">
                <button id="personal-card-btn" class="am-btn am-btn-success am-dropdown-toggle" style="padding: 0">
                    <img src="img/kira/logo.jpeg"><span class="am-icon-caret-down"></span></button>
                <div class="am-dropdown-content">
                    <div class="personal-card-show" style="text-align: center">
                        <div class="personal-card-show-img">
                            <img src="img/kira/logo.jpeg">
                        </div>
                        <div class="personal-card-show-name">
                            <h4 style="font-weight: 500">三日月</h4>
                        </div>
                        <div class="personal-card-show-words">
                            <small style="font-size: 13px;color: #808080ad;">我穿过鸟居,能否遇见神明?</small>
                        </div>
                        <div class="personal-card-show-connection" style="margin-top: 10px">
                            <span style="color: #009688">微信：my_soul_your_beats_</span><br>
                            <span style="color: #009688">QQ：745583189</span><br>
                        </div>
                        <div class="personal-card-show-attention_btn">
                            <button class="myCardBtn am-btn am-btn-secondary am-round attention_btn"
                                    data-am-offcanvas="{target: '#doc-oc-demo1'}" style="margin-top: 10px">扫描二维码关注我
                            </button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
                <ul class="am-nav am-nav-pills am-topbar-nav">
                    <li><a class="top_bar" href="/firstPage.html" style="cursor: pointer;"><span class="am-icon-home"></span>&nbsp;首页</a>
                    </li>
                    <li><a class="top_bar" href="/life.html" style="cursor: pointer;"><span class="am-icon-th"></span>&nbsp;生活</a>
                    </li>
                    <li><a class="top_bar" href="/technology.html" style="cursor: pointer;"><span
                                    class="am-icon-archive"></span>&nbsp;技术</a></li>
                    <li><a class="top_bar" href="/tags.html" style="cursor: pointer;"><span class="am-icon-tags"></span>&nbsp;标签</a>
                    </li>
                    <li><a class="top_bar" href="/update.html" style="cursor: pointer;"><span
                                    class="am-icon-calendar-plus-o"></span>&nbsp;版本更新</a></li>
                    <li><a class="top_bar" href="/aboutMe.html" style="cursor: pointer;"><span
                                    class="am-icon-user"></span>&nbsp;关于三日月</a></li>
                </ul>


                <div class="am-topbar-right" th:if="${#httpServletRequest.remoteUser}">
                    <div class="am-dropdown" data-am-dropdown="{boundary: '.am-topbar'}">
                        <button class="personalSpace am-btn am-btn-secondary am-topbar-btn am-btn-sm am-dropdown-toggle"
                                data-am-dropdown-toggle><span></span> <span class="am-icon-caret-down"></span></button>
                        <ul class="am-dropdown-content">
                            <li><a href="/user.html">个人主页</a></li>
                            <li><a href="/superAdmin.html">网站后台管理</a></li>
                            <li><a href="/user.html" class="news">消息<span
                                            class="newsNum am-badge am-badge-danger"></span></a></li>
                            <li><a class="feedbackClick">反馈</a></li>
                            <hr style="margin: 10px 0 5px 0;">
                            <li><a th:href="@{/logout}">退出登录</a></li>
                        </ul>
                    </div>
                </div>
                <div class="am-topbar-right">
                    <a href="/zoom/register.html" class="am-btn am-btn-primary am-topbar-btn am-btn-sm"
                       style="color: white">注册</a>
                </div>
                <div class="am-topbar-right">
                    <a href="zoom/login.html" class="loginBtn am-btn am-btn-primary am-topbar-btn am-btn-sm"
                       style="color: white">登录</a>
                </div>
                <div class="am-topbar-right writing am-hide-sm-down">
                    <a href="/editor.html">
                        <img src="img/sign/write.png">
                        <span class="write-word">写博客</span>
                    </a>
                </div>
                <div class="am-topbar-right reward am-hide-sm-down">
                    <a href="/reward.html" style="text-decoration: none">
                        <img class="am-circle" src="img/sign/forbidden.png" width="20" height="20">
                        <span class="reward-word">禁止投食</span>
                    </a>
                </div>

            </div>
        </div>
    </div>
</div>

<!--页面主体-->
<div id="main" style="margin-top: 16px">

    <div id="test-editormd">
        　　<textarea style="display:none;"></textarea>
    </div>

</div>
</body>
<script src="js/jquery-1.8.2.min.js"></script>
<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<script src="lib/marked.min.js"></script>
<script src="lib/prettify.min.js"></script>
<script src="lib/raphael.min.js"></script>
<script src="lib/underscore.min.js"></script>
<script src="lib/sequence-diagram.min.js"></script>
<script src="lib/flowchart.min.js"></script>
<script src="lib/jquery.flowchart.min.js"></script>
<script src="js/editormd/editormd.js"></script>
<script src="js/technology.js"></script>

</html>