<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="WebApplication1.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>益农</title>
</head>
<body>
    <div class="home">
        <div class="content">
            <div class="stars"></div>
            <img class="bgc" src="./img/OIP.jpg" width="1500" alt=""/>
            <h3 class="title">欢迎来到益农网站</h3>
            <h3 class="titles">今天又是一个劳动的日子</h3>
            <img class="icon" src="./img/down.jpg" alt=""/>
            <div class='ribbon'>
                <a href='./index.html'><span>Home</span></a>
                <a href='./about.html'><span>About</span></a>
                <a href='./form.html'><span>Form</span></a>

            </div>

        </div>
        <div class="icons">
            <div class="icons_items">
                <img class="icons_items_imgs" src="./img/down.jpg" alt=""/>
                <span>农产品售卖 </span>
            </div>
            <div class="icons_items">
                <img class="icons_items_imgs" src="./img/down1.jpg" alt=""/>
                <span>在线购买 </span>
            </div>
            <div class="icons_items">
                <img class="icons_items_imgs" src="./img/down2.jpg" alt=""/>
                <span>农机预约 </span>
            </div>
            <div class="icons_items">
                <img class="icons_items_imgs" src="./img/down3.jpg" alt=""/>
                <span>农业攻略 </span>
            </div>
        </div>
        <div class="introduce">
            <div class="introduce_item">
                <img class="introduce_item_img" src="./img/text1.jpg" alt=""/>
                <span class="introduce_item_title">重农固本，是安民之基。党的十八大以来，党中央始终坚持把解决好“三农”问题作为全部工作的重中之重，大力推进农业现代化建设。习近平总书记多次就发展现代农业发表重要讲话，指明了农业现代化的发展方向和基本实现路径。2017年4月，习近平总书记在广西调研时进一步强调，把现代特色农业这篇文章做好。我们一定要按照习近平总书记指示要求，全力推进现代特色农业建设，为“三农”发展注入新动力。</span>

            </div>
            <div class="introduce_item">

                <span class="introduce_item_titles">首先，现代特色农业是中国特色的现代农业。从世界范围看，由于客观发展条件的差异，各国在农业现代化道路的选择上不尽相同，国外现代农业发展大致可以概括为三种模式，即以美国为代表的规模化、机械化、高技术化模式，以日本、以色列为代表的资源节约和资本技术密集型模式，以法国、荷兰为代表的生产集约加机械技术的复合型模式。一个国家发展现代农业的模式，主要由该国的土地、劳动力和工业水平决定。我国的现代农业建设应借鉴发达国家先进经验，更应从全面建成小康社会的历史任务，以及农业发展水平相对滞后的现实国情出发，在稳定粮食和重要农产品生产、保障国家粮食安全和重要农产品有效供给的同时，加快转变农业发展方式，加快农业技术创新，走一条集约、高效、安全、持续的现代农业发展道路。</span>
                <img class="introduce_item_img" src="./img/text2.jpg" alt="" />
            </div>
            <div class="introduce_item">
                <img class="introduce_item_img" src="./img/text3.jpg" alt="" />
                <span class="introduce_item_title">其次，现代特色农业是区域特色的现代农业。我国幅员辽阔，各地区自然、地理、气候等农业生产条件存在较大差异，现代农业发展的重点和方向不尽相同。近年来，国内各地区从实际出发，积极探索符合自身特点的现代农业发展模式和路径，形成了诸多典型经验。例如，有的地区结合山地资源特色，大力发展生态农业；有的地区围绕服务大中城市，大力发展都市型农业；有的地区面向国内外市场，大力发展农业产业化经营。做好现代特色农业这篇文章，各地区应立足自身自然资源禀赋，因地制宜、分类指导、精准施策，培育发展各具特色的主导产业和优势产业，探索适合本地区发展实际的现代农业发展路径，形成各具特点、有机结合、功能互补、类型齐全的区域特色农业。</span>
            </div>
            <div class="introduce_item">
                <span class="introduce_item_titles">发展现代特色农业是新时期推进农业现代化的新要求，更是解决当前农业发展面临的突出矛盾和问题、夯实农业基础性地位、确保实现全面建成小康社会奋斗目标的必然选择。从实际情况来看，大力发展现代特色农业应着重加快四个转变。</span>
                <img class="introduce_item_img" src="./img/text4.jpg" alt=""/>
            </div>
        </div>
        <audio autoplay="autoplay" id="audio" loop="loop">
                <source src="./video/music.mp3" type="audio/MP3"/>
               
        </audio>
        <img class="music_img" src="./img/music_img.png" alt=""/>
    </div>
    <style> * {
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
}

h1 {
    color: white;
    text-align: center;
}

span {
    display: block;
    text-align: center;
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
    left: 0;
    right: 0;
    top: 300px;
    margin: auto;
    bottom: 0;
    color: #fff;
    font-size: 24px;
    font-weight: 500;
}

.titles {
    position: absolute;
    display: flex;
    justify-content: center;
    left: 0;
    right: 0;
    top: 350px;
    margin: auto;
    bottom: 0;
    color: #fff;
    font-size: 20px;
    font-weight: 500;
}

.icon {
    width: 15px;
    height: 15px;
    padding: 5px;
    border: 2px solid #fff;
    border-radius: 100%;
    position: absolute;
    left: 49%;
    bottom: 50px;
    animation: downs 2s linear infinite;
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

.introduce {
    display: flex;
    flex-direction: column;
}

.introduce_item {
    display: flex;
    justify-content: center;
    margin-top: 60px;
}

.introduce_item_img {
    width: 773px;
    height: 500px;
}

.introduce_item_title {
    width: 497px;
    font-size: 18px;
    line-height: 36px;
    align-self: center;
    padding-left: 100px;
}

.introduce_item_titles {
    width: 495px;
    font-size: 18px;
    line-height: 36px;
    align-self: center;
    padding-right: 100px;
}

audio {
    position: fixed;
    bottom: 50px;
    right: 0;
}

.music_img {
    position: fixed;
    bottom: 50px;
    right: 50px;
    width: 40px;
    height: 30px;
    animation: muscis 5s linear infinite;
}

@keyframes muscis {
    from {
        transform: rotate (0deg);
        opacity: .6;
    }
    to {
        transform: rotate(360deg);
        opacity: .8;
    }
}

.icons {
    display: flex;
    justify-content: space-between;
    padding: 0 400px;
    box-sizing: border-box;
    overflow: hidden;
}

.icons_items {
    display: flex;
    flex-direction: column;
    font-size: 20px;
    margin-top: 80px;
    width: 200px;
}

.icons_items_imgs {
    width: 200px;
    margin-bottom: 30px;
}
</style>
</body>
<script>
    let mucics = document.getElementById('audio')
    document.body.addEventListener('mousemove', function() {
        setTimeout(() => {
            mucics.play();
        }, 2000);
    }, false);
</script>

</html>
