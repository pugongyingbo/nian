
#### Nian 
   >  for my gilrfriends
* 爬取网易云歌单热评，花了几个晚上利用下班时间选取了217个情歌热评，每天作为安卓桌面小部件在屏幕随机显示一句，logo她自己P的。

举个例子：
1. 我什么都可以扛住 
就是扛不住对你的喜欢。from《喜欢》
2. 家人 朋友 恋人 爱人 夫妻  我们 都是十二划
十二的名字叫难忘
十二包含了我们最珍贵的人
十二月了  我好想你啊 --《哈利路亚》
3. 我们将来的女儿小名就叫慢慢吧
慢慢长大，慢慢生活，慢慢恋爱，慢慢爱你。from《慢慢喜欢你》
4. 我将来的儿子小名就叫慢慢吧
慢慢长大，慢慢懂事，慢慢和一个小名也叫慢慢的姑娘相遇。from《慢慢喜欢你》
5. 我希望我是一条鱼，每七秒忘记一次喜欢你，再每七秒再喜欢你一遍，这样时间就不那么漫长和枯燥了吧。from《你迟到的许多年》
6. “月光明亮而辽远，八月的清爽如此温情，你迟到了许多年，可我依然为你的到来而高兴。”from《你迟到的许多年》
7. 自从遇见你人生苦短甜长--from《白羊》
8. 有的人就像这些日子不断的下雨之后出现的第一缕阳光一样，一笑扫清你的乌云。这一笑，一切都会觉得美好和值得。from《生活倒影》
9. 从前很慢，想你了就翻过一座山去牵你的手，趁微风不燥阳光正好。from《从前慢》
10. “有时候想，这人间有一户灯火是我亲自点亮的，柴米油盐齐全，瓜果蔬菜新鲜，爱有伴侣，困有暖床，纵然简淡，也心生喜欢。”from《从前慢》


<p align="center">
    <img src="https://github.com/pugongyingbo/nian/blob/master/images/nian.jpg" alt="Sample"  width="280" height="500">
    <p align="center">
        <em>图片示例</em>
    </p>
</p>

#### Python代码

>注意：不要登录自己的账号就行，替换歌单URL和请求头，导出文件名字

```
#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import re
import urllib.request
import urllib.error
import urllib.parse
import json



def get_all_hotSong():     #获取热歌榜所有歌曲名称和id
    url='https://music.163.com/playlist?id=370359730'    #网易云云音乐热歌榜url
    header = {  # 请求头部
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.92 Safari/537.36'
    }
    request=urllib.request.Request(url=url, headers=header)
    html=urllib.request.urlopen(request).read().decode('utf8')   #打开url
    html=str(html)     #转换成str
    pat1=r'<ul class="f-hide"><li><a href="/song\?id=\d*?">.*</a></li></ul>'  #进行第一次筛选的正则表达式
    result=re.compile(pat1).findall(html)     #用正则表达式进行筛选
    result=result[0]     #获取tuple的第一个元素

    pat2=r'<li><a href="/song\?id=\d*?">(.*?)</a></li>' #进行歌名筛选的正则表达式
    pat3=r'<li><a href="/song\?id=(\d*?)">.*?</a></li>'  #进行歌ID筛选的正则表达式
    hot_song_name=re.compile(pat2).findall(result)    #获取所有热门歌曲名称
    hot_song_id=re.compile(pat3).findall(result)    #获取所有热门歌曲对应的Id

    return hot_song_name,hot_song_id

def get_hotComments(hot_song_name,hot_song_id):
    url='http://music.163.com/weapi/v1/resource/comments/R_SO_4_' + hot_song_id + '?csrf_token='   #歌评url
    header={    # 请求头部
   'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.92 Safari/537.36'
    }
    # post请求表单数据
    data={'params':'Rh0jkdRnhOZa7Mlbb6hAt+qGVZ8Yq9MBUO3+ffAMgv0tCiTa7TH6cD40sK3xKiCHhPws7rSVVQCB/NelhfkgEk4ZqahyO+iExqsEMhTGst1yOUbSIBAi7b+4HnSBsu4s9kP8Dl6gMDgyFrNpwJWFET/8a8T3sLdTpm9Fo1n7BmJyPsGU8M9BAA0JtUWFeJC6klxnNNlAjmTp7/3qCEEAjl4rrRyc2RwCt9MvE8SaoOA=',
          'encSecKey':'32276d499ad498b6c8c1d5d1c86878a497cb140af0d3e4b2070c7940590b29d3a50f37239487c9c77467130eb45330eadb83e7bfb21da07700eb8eb5d675abd5ca3d1c2d05749bbbd1ed43168f089e79e231bcd9c9b87439c2d6fbeb89aa657491e9c747963fc7047b2ed625612a92002a864b5b823d366e44ffd79d1223dba6'}
    postdata=urllib.parse.urlencode(data).encode('utf8')  # 进行编码
    request=urllib.request.Request(url,headers=header,data=postdata)
    reponse=urllib.request.urlopen(request).read().decode('utf8')
    json_dict=json.loads(reponse)   # 获取json
    hot_commit=json_dict['hotComments']  # 获取json中的热门评论


    num=0
    fhandle=open('./minyao_com.txt','a',encoding='utf-8')  # 写入文件
    fhandle.write(hot_song_name+':'+'\n')

    for item in hot_commit:
        num+=1
        fhandle.write(str(num)+'.'+item['content']+'\n')
    fhandle.write('\n==============================================\n\n')
    fhandle.close()


hot_song_name,hot_song_id=get_all_hotSong()  # 获取热歌榜所有歌曲名称和id

num=0
while num < len(hot_song_name):    # 保存所有热歌榜中的热评
    print('正在抓取第%d首歌曲热评...'%(num+1))
    get_hotComments(hot_song_name[num],hot_song_id[num])
    print('第%d首歌曲热评抓取成功'%(num+1))
    num += 1

```

 
* 一首歌写法
 
```
#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import re
import urllib.request
import urllib.error
import urllib.parse
import json


def get_hotComments():
    url='http://music.163.com/weapi/v1/resource/comments/R_SO_4_514761281?csrf_token='   #歌评url
    header={    # 请求头部
   'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.92 Safari/537.36'
    }
    # post请求表单数据
    data={'params':'rZ2nIC81RfvmY3Kzxg4O2Aie5M119xG9kLl61ytcrUx3+m3xh9huoVCLSd/WkJeROjzbv/2G6qXH5nkZ4iEBPzcYtt5Jfu+Zg/pg0P+EXBfwG1QSYtC/H2EzZEkw59GID5+KmnICIfhBTjpQOwBDFLxdf/yZSLydeTakd5izPY6Ez+gQjgbcFtRSyh5Cngke',
          'encSecKey':'587d3def22a8d6e5b944da4df1245717fce0a1896a6e5694aeee1676a816e8689be9d1f9006d5a5b2a566dd7419a1df3400ddf36de0ef2b5b7ba42367b0730ac99663255700f549c9fb4484766b314caedcb9487d48bff9805f47e52b428130283bbfea1633a3aaac0f9a64e753c7ab922dd7032da44a6d7412a50a37eccfa0e'}
    postdata=urllib.parse.urlencode(data).encode('utf8')  # 进行编码
    request=urllib.request.Request(url,headers=header,data=postdata)
    reponse=urllib.request.urlopen(request).read().decode('utf8')
    json_dict=json.loads(reponse)   # 获取json
    hot_commit=json_dict['hotComments']  # 获取json中的热门评论


    num=0
    fhandle=open('./song_comments.txt','a',encoding='utf-8')  # 写入文件
    fhandle.write('sheep'+':'+'\n')

    for item in hot_commit:
        num+=1
        fhandle.write(str(num)+'.'+item['content']+'\n')
    fhandle.write('\n==============================================\n\n')
    fhandle.close()

get_hotComments()

```

