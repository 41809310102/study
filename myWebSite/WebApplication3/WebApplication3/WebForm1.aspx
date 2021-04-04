﻿<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="WebApplication3.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Wed练习</title>
    <style type="text/css">
        body {
            background-image: url('img/zhuche1.jpg');
        }

        font {
            color ="darkgray"
        }

        tr {
            height: 60px
        }

        #sub {
            height: 30px;
            width: 95px;
        }
    </style>
</head>
<body>
    <header>
        <div class="content">
            <div class="stars"></div>
            <img class="bgc" src="./img/OIP.jpg" alt="" />
            <h3 class="title">欢迎来到我的web练习网站</h3>
            <h3 class="titles">今天也要加油鸭</h3>
            <div class='ribbon'>
                <a href='./index.html'><span>首页</span></a>
                <a href='./about.html'><span>关于</span></a>
                <a href='./test.aspx'><span>资料</span></a>
                <a href='./form.html'><span>扣工资</span></a>
                <a href='./form.html'><span>论坛</span></a>
            </div>
        </div>
    </header>

    <article>
        <section>
            <div class="icons">
                <div class="icons_items">
                    <img class="icons_items_imgs" src="./img/down.jpg" alt="" />
                    <span>文档1</span>
                </div>
                <div class="icons_items">
                    <img class="icons_items_imgs" src="./img/down1.jpg" alt="" />
                    <span>文档2</span>
                </div>
                <br />
                <div class="icons_items">
                    <img class="icons_items_imgs" src="./img/down2.jpg" alt="" />
                    <span>文档3</span>
                </div>
                <div class="icons_items">
                    <img class="icons_items_imgs" src="./img/OIP.jpg" alt="" />
                    <span>文档4</span>
                </div>
            </div>
        </section>
    </article>


    <div class="contentunder">
        &nbsp;<div class="stars"></div>
        &nbsp;<h3 class="titleunder">欢迎来到我的web练习网站</h3>

        <aside style="height: 424px">

            <div class="from">
              
                <div class="submit">
                    <span class="form_title">个人</span>
                    <div class="form_input">
                        <span>姓名：</span>
                        <input class="inputs" type="text" value="胡俊杰" >
                    </div>
                    <div class="form_input">
                        <span>密码:</span>
                        <input class="inputs" type="text" value=" " />
                    </div>
                    <div class="form_input">
                        <span>邮箱：</span>
                        <input class="inputs" type="text" value="2857154359@qq.com" >
                    </div>
                    <div class="form_input">
                        <span>性别：</span>
                        <input class="inputs" type="text" value="男" >
                    </div>
                    <div class="form_input">
                        <span>课程名称：</span>
                        <input class="inputs" type="text" value="Web开发" >
                    </div>
                    <div class="btn_submit">
                        <a href="./denlu.aspx">
                            <button class="btn">注册账号</button></a>
                        <a href="./index.html" class="back">
                            <button class="home_href">进入首页</button></a>
                    </div>
                </div>
            </div>



        </aside>


        <style>
            * {
                margin: 0;
                padding: 0
            }

            .home {
                height: 100%;
                overflow: hidden;
            }

            .content {
                perspective: 340px;
                width: 100%;
                position: relative;
                top: 0px;
                left: 0px;
                height: 152px;
            }

            .contentunder {
                perspective: 340px;
                width: 109%;
                position: relative;
                margin-top: 0;
                left: 0px;
                height: 144px;
                top: -144px;
            }

            .bgunder {
                margin-top: 50px;
                height: 149px;
                width: 1707px;
            }

            h1 {
                color: white;
                text-align: center;
            }

            span {
                display: block;
                text-align: center;
            }

            .bgc {
                height: 150px;
                width: 1500px;
            }


            .stars {
                position: absolute;
                top: 50%;
                left: 50%;
                width: 2px;
                height: 2px;
                z-index: 999;
                border-radius: 50%;
                box-shadow: -447px 387px #c4c4c4, -401px 118px #fafafa, -109px 217px #d9d9d9, -680px -436px #e3e3e3, 514px 360px #cccccc, -708px 298px #e8e8e8, -696px -270px #ededed, 116px -128px #f7f7f7, 179px 35px white, -404px -90px whitesmoke, -331px -309px #c4c4c4, -363px -24px #d1d1d1, 277px 416px #fafafa, -145px -244px whitesmoke, 123px 62px #d4d4d4, -407px 418px #d9d9d9, 535px 237px #d9d9d9, -466px -78px #f7f7f7, 257px 287px #dedede, 327px -398px #e0e0e0, -602px -38px #c2c2c2, 128px 398px #e6e6e6, 274px -446px #d1d1d1, -602px -298px #c7c7c7, 526px -5px #c4c4c4, -90px -158px #fcfcfc, 5px 294px whitesmoke, -633px 229px #c4c4c4, -475px 427px #dedede, 586px -453px #f2f2f2, 180px -432px #c7c7c7, -637px -88px #cfcfcf, -453px 308px #d6d6d6, -111px 1px #d9d9d9, 573px -450px #ededed, 198px 300px #d6d6d6, -355px 166px #dedede, -715px 13px #e3e3e3, 262px -104px #d1d1d1, 147px 325px #dbdbdb, 1px 399px #dbdbdb, 286px -100px white, 43px -329px #e8e8e8, 617px 55px #d9d9d9, -168px -392px #cccccc, 84px 219px #c9c9c9, 507px -226px #d9d9d9, -327px -70px #e6e6e6, 386px -212px #c4c4c4, -717px 4px #cfcfcf, 502px -231px #e3e3e3, 302px 56px #ededed, 649px 341px #c7c7c7, 569px 350px #c9c9c9, 516px -31px #e6e6e6, 689px 447px #c2c2c2, 591px -206px #fafafa, 422px -137px #e6e6e6, -510px -324px #cccccc, -649px 287px #c2c2c2, -194px -48px #f7f7f7, -279px -329px #d1d1d1, -406px 478px #dbdbdb, -735px -87px #c9c9c9, 30px -197px #dedede, -564px 233px #e6e6e6, -486px -324px #ededed, -54px -7px #ededed, -441px -194px #e3e3e3, -133px -95px #e0e0e0, -722px -73px #d6d6d6, 595px 423px #ededed, 568px -39px #ededed, 370px 377px #d1d1d1, -419px -102px #fcfcfc, -450px 109px #c4c4c4, -57px -119px #d1d1d1, -582px 150px #e6e6e6, 206px -263px #cfcfcf, 582px -461px #c9c9c9, -268px -141px #d9d9d9, -148px 291px #c7c7c7, 254px -179px #c9c9c9, 725px 424px #f0f0f0, 391px -150px #ebebeb, 89px -299px #d4d4d4, 170px 1px #c9c9c9, 243px 209px #c7c7c7, 27px 460px #c9c9c9, -465px -380px #d4d4d4, 530px -360px whitesmoke, -626px 53px #e0e0e0, 706px 218px #d9d9d9, 40px -82px #cccccc, -5px -212px #e6e6e6, -742px 33px #ebebeb, -714px 478px #e0e0e0, -585px -125px #cccccc, -216px 348px #cfcfcf, 601px 332px #ededed, 344px -88px #c4c4c4, 659px -22px #d1d1d1, -411px 188px #d6d6d6, -423px -206px #fcfcfc, -359px -136px #cfcfcf, 612px 406px whitesmoke, 725px 96px whitesmoke, 363px -446px white, -204px 325px #c9c9c9, 740px 176px #fafafa, -489px -352px white, -638px 64px #dbdbdb, 537px -65px #dbdbdb, 151px -32px #ebebeb, 681px 212px #fcfcfc, 604px -149px #e6e6e6, -542px -398px #c4c4c4, -707px 66px whitesmoke, -381px 258px #cfcfcf, -30px 332px #d6d6d6, 512px -381px #c9c9c9, 195px 288px #cccccc, -278px 479px #c7c7c7, 27px -208px #d6d6d6, -288px 15px white, -680px 248px #dedede, 433px 31px #c9c9c9, 150px -206px #d4d4d4, -79px 247px white, -594px 115px #e0e0e0, 99px 292px #e0e0e0, 673px -269px #dedede, -257px -64px #d1d1d1, 449px 81px #f2f2f2, 18px -99px #d1d1d1, -694px 415px #f7f7f7, 240px 264px #e0e0e0, 450px -172px white, 383px 7px #e8e8e8, 338px -73px #c9c9c9, 291px -19px #ebebeb, 659px 137px #d1d1d1, 602px -6px #fcfcfc, 554px 249px #ebebeb, 625px 356px #d9d9d9, 579px -183px #d6d6d6, -20px 250px white, -401px 431px #c4c4c4, -645px -232px #cccccc, -265px -148px white, 553px 258px #d1d1d1, 166px -360px #ebebeb, 719px 51px #ededed, 612px -129px #ebebeb, -465px -104px #f2f2f2, -154px -121px #d9d9d9, -1px 330px #f2f2f2, -666px 248px #f7f7f7, -720px 264px #ededed, 148px -365px #e6e6e6, -388px -349px #c4c4c4, 128px -88px #e3e3e3, -683px -274px #fafafa, -341px 41px #c9c9c9, -59px -471px #f0f0f0, -3px -427px #c2c2c2, 418px 167px #d6d6d6, 343px 247px #c7c7c7, 623px -347px #d1d1d1, 716px -217px white, 243px -409px whitesmoke, -75px -126px #d6d6d6, -730px -91px #c9c9c9, -210px -397px #cfcfcf, -349px 180px #c9c9c9, -567px -281px #e0e0e0, -460px 381px #fcfcfc, -310px -22px #ededed, 450px -1px #dbdbdb, -405px -328px #e3e3e3, 5px 332px #d6d6d6, -294px 302px #fcfcfc, -398px 97px whitesmoke, -696px 325px #cfcfcf, -589px 110px #d6d6d6, 353px -411px #dbdbdb, -697px -318px #ebebeb, -114px -72px #f0f0f0, 259px -193px #fcfcfc, 60px 26px #e6e6e6, -63px -232px white, 205px -372px #f7f7f7, -464px -333px #f2f2f2, -374px 123px white, -377px -386px #c7c7c7, -80px 337px #cccccc, 478px -178px #dbdbdb, 222px 420px #ebebeb, -707px 99px #c4c4c4, 716px -132px #fafafa, -253px -286px #e3e3e3, 646px 178px #f0f0f0, 201px 24px #d1d1d1, 178px -58px #c7c7c7, -557px 368px #ededed, 0px 219px #d9d9d9, -266px -269px #cccccc, 242px -197px #c9c9c9, -419px 193px #c2c2c2, -47px 91px #c7c7c7, -109px 75px #c2c2c2, -146px -453px #d6d6d6, 671px -350px #f2f2f2, 421px -91px #d9d9d9, 738px 19px #ededed, -316px -155px #dedede, 419px 244px #fcfcfc, -278px -418px #d6d6d6, -581px -181px #fcfcfc, 139px 264px #d9d9d9, 691px -11px #ebebeb, -622px 402px #c2c2c2, 219px 396px #f0f0f0, -149px -423px white, -716px -78px #d9d9d9, -590px 341px #e6e6e6, -208px 79px #d6d6d6, -227px -24px #f7f7f7, 239px 262px #d1d1d1, 740px 443px #f7f7f7, 509px 134px #d6d6d6, -555px 232px #e8e8e8, -67px -427px #cfcfcf, -368px 250px #f7f7f7, 715px -415px #fafafa, 411px -301px #f0f0f0, -322px 287px #d9d9d9, -429px -90px #f2f2f2, -327px -387px #f0f0f0, -491px 183px #c2c2c2, -133px 250px #d4d4d4, 538px 139px #e3e3e3, -417px -125px #f0f0f0, 653px -351px #e6e6e6, -549px 38px #d4d4d4, 602px 110px whitesmoke, 415px 105px #e0e0e0, -733px -371px #cfcfcf, 286px 403px #d4d4d4, 11px 320px #c4c4c4, -597px 158px whitesmoke, 716px -350px whitesmoke, 321px 67px #fafafa, -237px -300px #cfcfcf, 74px 152px #c9c9c9, 587px -123px #fcfcfc, 699px -332px whitesmoke, 399px 355px #f7f7f7, -323px 314px #dbdbdb, 89px 416px #c7c7c7, 445px 38px #e3e3e3, 572px 122px #c4c4c4, -258px 372px white, 49px 306px #d9d9d9, 437px -35px #dedede, 566px 174px #f2f2f2, 732px -299px whitesmoke, -410px 394px #ededed, 131px -415px white, 19px -326px #e8e8e8, -700px -188px #d1d1d1, 96px -1px #e0e0e0, -328px -396px #f0f0f0, -117px -214px #fcfcfc, -53px 261px #ebebeb, 80px 134px #d6d6d6, -364px -216px white, -636px -125px #dbdbdb, -639px -265px #e3e3e3, 208px 98px #c7c7c7, 172px 467px #e0e0e0, 435px 309px #e3e3e3, 194px -259px #f0f0f0, 209px -186px #c9c9c9, -312px 418px #fafafa, 229px 407px #c9c9c9, -449px -357px #fafafa, 674px 121px #e8e8e8, 608px -429px #ebebeb, -431px -428px #cfcfcf, 105px 462px #e3e3e3, -179px -372px #e3e3e3, 143px -317px #d6d6d6, -449px -149px #fafafa, -544px 250px #dedede, -220px -323px whitesmoke, 658px 8px whitesmoke, -656px -244px #e8e8e8, 347px 11px whitesmoke, 694px -230px #f7f7f7, -317px 1px #c4c4c4, 28px 23px #fcfcfc, -382px 321px #dbdbdb, 632px -74px #c4c4c4, 154px -245px #c2c2c2, -553px 337px #d6d6d6, -48px -243px #d1d1d1, 92px -391px #cccccc, -71px -256px #cfcfcf, -372px 57px #d9d9d9, 369px -140px #fcfcfc, 675px 81px #c2c2c2, -663px 254px #cccccc, 703px -203px #ededed, 74px -363px #c2c2c2, 643px -458px #d1d1d1, 198px 359px #cccccc, 265px 309px #d4d4d4, -353px -368px #e8e8e8, -465px 439px whitesmoke, 693px 360px #c9c9c9, 634px -397px #d1d1d1, 467px 25px whitesmoke, -558px -272px #e6e6e6, 671px 69px #dbdbdb, 407px 357px #cfcfcf, 379px 80px white, 10px -203px #c9c9c9, 104px -292px #f0f0f0, -667px -29px #d1d1d1, 557px -155px #e6e6e6, -505px 115px #cfcfcf, -605px 164px #f2f2f2, -108px -223px #e0e0e0, 523px -156px #ebebeb, 691px 230px white, -507px -13px #d1d1d1, -349px 332px #dedede, 520px 266px whitesmoke, -66px -250px #e6e6e6, -496px -449px #ebebeb, 414px -170px #dedede, -649px 230px #ebebeb, 598px -92px #c7c7c7, -638px 113px #c2c2c2, 151px 363px #f7f7f7, -445px -241px #f0f0f0, 527px -14px #dedede, 203px -61px #cfcfcf, -716px -284px #ebebeb, -525px 134px #c2c2c2;
                animation: fly 15s linear infinite;
                transform-style: preserve-3d;
            }

                .stars:before,
                .stars:after {
                    content: "";
                    position: absolute;
                    width: inherit;
                    height: inherit;
                    box-shadow: inherit;
                }

                .stars:before {
                    transform: translateZ(-300px);
                    opacity: .6;
                }

                .stars:after {
                    transform: translateZ(-600px);
                    opacity: .4;
                }

            @keyframes fly {
                from {
                    transform: translateZ(0px);
                    opacity: .6;
                }

                to {
                    transform: translateZ(200px);
                    opacity: .8;
                }
            }

            .title {
                position: absolute;
                display: flex;
                justify-content: center;
                left: 111px;
                right: 61%;
                top: 13px;
                margin: auto;
                bottom: 103px;
                color: #fff;
                font-size: 24px;
                font-weight: 500;
            }

            .titles {
                position: absolute;
                display: flex;
                justify-content: center;
                left: 68%;
                right: 291px;
                top: 20px;
                margin: auto;
                bottom: 114px;
                color: #fff;
                font-size: 20px;
                font-weight: 500;
            }

            .titleunder {
                position: absolute;
                display: flex;
                justify-content: center;
                left: 1081px;
                right: 11%;
                top: 409px;
                margin: auto;
                bottom: -330px;
                color: #fff;
                font-size: 24px;
                font-weight: 500;
            }

            .titlesunber {
                position: absolute;
                display: flex;
                justify-content: center;
                left: 68%;
                right: 291px;
                top: 20px;
                margin: auto;
                bottom: 114px;
                color: #fff;
                font-size: 20px;
                font-weight: 500;
            }

            @keyframes downs {
                from {
                    transform: translatey(0px);
                    opacity: .6;
                }

                to {
                    transform: translatey(30px);
                    opacity: .8;
                }
            }

            .ribbon {
                display: flex;
                justify-content: center;
                position: absolute;
                right: 300px;
                top: 50px;
                margin: auto;
            }

                .ribbon:after,
                .ribbon:before {
                    margin-top: 0.5em;
                    content: "";
                    display: flex;
                    ;
                    border: 1.5em solid #fff;
                }

                .ribbon:after {
                    border-right-color: transparent;
                }

                .ribbon:before {
                    border-left-color: transparent;
                }

                .ribbon a:link,
                .ribbon a:visited {
                    color: #000;
                    text-decoration: none;
                    height: 3.5em;
                    overflow: hidden;
                }

                .ribbon span {
                    background: #fff;
                    display: inline-block;
                    line-height: 3em;
                    padding: 0 1.5em;
                    margin-top: 0.5em;
                    position: relative;
                    -webkit-transition: background-color 0.2s, margin-top 0.2s;
                    /* Saf3.2+, Chrome */
                    -moz-transition: background-color 0.2s, margin-top 0.2s;
                    /* FF4+ */
                    -ms-transition: background-color 0.2s, margin-top 0.2s;
                    /* IE10 */
                    -o-transition: background-color 0.2s, margin-top 0.2s;
                    /* Opera 10.5+ */
                    transition: background-color 0.2s, margin-top 0.2s;
                }

                .ribbon a:hover span {
                    background: #FFD204;
                    margin-top: 0;
                }

                .ribbon span:before {
                    content: "";
                    position: absolute;
                    top: 3em;
                    left: 0;
                    border-right: 0.5em solid #9B8651;
                    border-bottom: 0.5em solid #fff;
                }

                .ribbon span:after {
                    content: "";
                    position: absolute;
                    top: 3em;
                    right: 0;
                    border-left: 0.5em solid #9B8651;
                    border-bottom: 0.5em solid #fff;
                }


            .icons {
                display: flex;
                justify-content: space-between;
                padding: 0 400px;
                box-sizing: border-box;
                overflow: hidden;
                margin-left: 250px;
            }

            .icons_items {
                display: flex;
                flex-direction: column;
                font-size: 20px;
                width: 200px;
            }

            .icons_items_imgs {
                width: 200px;
                margin-bottom: 30px;
                margin-top: 30px
            }

            * {
                margin: 0;
                padding: 0
            }

            .from {
                overflow: hidden;
                position: relative;
                top: -115px;
                left: 38px;
                height: 624px;
                width: 1701px;
            }

            .bg {
                width: 500px;
                height: 500px;
            }

            .submit {
                position: absolute;
                z-index: 9;
                left: 8%;
                top: -137px;
                right: 998px;
                bottom: 24px;
                margin-top: 150px;
                width: 566px;
                height: 587px;
                border-radius: 10px;
                color: black;
                display: flex;
                flex-direction: column;
                margin-left: auto;
                margin-right: 0px;
                margin-bottom: auto;
            }

            .form_title {
                text-align: center;
                margin-top: 40px;
                font-size: 18px;
            }

            .form_input {
                padding: 0 30px;
                box-sizing: border-box;
                display: flex;
                margin-top: 20px;
            }

            .inputs {
                height: 40px;
                width: 300px;
                border-radius: 5px;
                border: none;
                background-color: #eee;
                color: #666;
                padding-left: 20px;
            }

            .form_input span {
                width: 85px;
                align-self: center;
            }

            .btn_submit {
                align-self: center;
            }

            .btn {
                border: none;
                width: 80px;
                height: 40px;
                color: #fff;
                border-radius: 5px;
                background: #999;
                margin-top: 40px;
            }

                .btn:hover {
                    background: #666;
                }

            .back {
                margin-left: 10px;
            }

            .home_href {
                border: none;
                width: 80px;
                height: 40px;
                color: #fff;
                border-radius: 5px;
                background: #FFD204;
            }

            .titlesunder {
                height: 55px;
                width: 489px;
            }
        </style>
</body>
</html>