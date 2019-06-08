package com.it.zzb.nian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    List<String> dataList = new ArrayList<>();
    RecyclerView recyclerView;
    OneAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        recyclerView = findViewById(R.id.recycleview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new OneAdapter(dataList);
        recyclerView.setAdapter(adapter);

    }
    public void init(){

        dataList.add("水瓶给白羊打Call!!! --from《白羊》");
        dataList.add("家人、朋友、恋人、爱人、夫妻、我们都是十二划，十二的名字叫难忘，十二包含了我们最珍贵的人，十二月了 ，我好想你啊 --《哈利路亚》");
        dataList.add("我们将来的女儿小名就叫慢慢吧，慢慢长大，慢慢生活，慢慢恋爱，慢慢爱你。from《慢慢喜欢你》");
        dataList.add("我将来的儿子小名就叫慢慢吧，慢慢长大，慢慢懂事，慢慢和一个小名也叫慢慢的姑娘相遇。from《慢慢喜欢你》");
        dataList.add("我希望我是一条鱼，每七秒忘记一次喜欢你，再每七秒再喜欢你一遍，这样时间就不那么漫长和枯燥了吧。from《你迟到的许多年》");
        dataList.add("“月光明亮而辽远，八月的清爽如此温情，你迟到了许多年，可我依然为你的到来而高兴。”from《你迟到的许多年》");
        dataList.add("自从遇见你人生苦短甜长--from《白羊》");
        dataList.add("有的人就像这些日子不断的下雨之后出现的第一缕阳光一样，一笑扫清你的乌云。这一笑，一切都会觉得美好和值得。from《生活倒影》");
        dataList.add("从前很慢，想你了就翻过一座山去牵你的手，趁微风不燥阳光正好。from《从前慢》");
        dataList.add("“有时候想，这人间有一户灯火是我亲自点亮的，柴米油盐齐全，瓜果蔬菜新鲜，爱有伴侣，困有暖床，纵然简淡，也心生喜欢。”from《从前慢》");
        dataList.add("“五分喜欢的人，恨不得把他挂在嘴上招摇过市。有七分喜欢，就只能跟至亲密友分享。 有十分喜欢 ，那就谁也不舍得说了，憋着每天憋着一点小高兴，像只松鼠攒着满腮帮子的果仁”from《喜欢》");
        dataList.add("我什么都可以扛住 就是扛不住对你的喜欢。from《喜欢》");
        dataList.add("一心一意一痴念，一生一世一双人。from《一》");
        dataList.add("前路不须太重的行囊和过去和解吧，我会像永远不变的时光，一路寄望。from《下一站茶山刘》");
        dataList.add("“旧念往忆无处躲，只愿去路平坦成河。”from《平坦》");
        dataList.add("你的声音最好听，你身上的味道最好闻，你笑起来的样子最好看，我喜欢的样子你都有，你问我多喜欢你。from《摸摸它》");
        dataList.add("你真是一个很棒的人，我本来觉得，在我的这个阶段，爱情应该放在一边的。但是我发现，要是真的遇上了爱情，它自己就会变得越来越重要，根本由不得我。from《可一可再》");
        dataList.add("下次 还是我来叫你起床吧，下次 还是我来给你做你最爱的可乐鸡翅吧，下次 还是我来给你熬红糖水准备胃药吧，下次，可不可以换你褪去一身骄傲喜欢我到疯掉啊……from《陷阱》");
        dataList.add("你本是这世间独一无二千般好，无奈落入我眼底，万种颜色与旖旎皆褪，只留一抹甜，才下眉梢，又上心头。 ​​from《旧诗》");
        dataList.add("“好想变成雪啊，这样就可以落在先生的肩上了……”“若是先生撑了伞呢？”“那就落在先生的红伞上，静载一路的月光。”“若是先生将雪拂去……”“那就任他拂去，能在他的手掌上停留一刻，便足矣。”from《浪人琵琶》");
        dataList.add("他们说.青山是否妩媚还须看青山是谁.可我摇头.我见众生皆草木唯你是青山. from《浪人琵琶》");
        dataList.add("你眼中倒映的星河灿烂，是我不曾见过的世外桃源。from《仰世而来》");
        dataList.add("你一定是作弊了，不然你在我心里，怎么总是第一名. from《戏精》");
        dataList.add("你可以为风 为门 为虹 为秒针 为星辰 然而你选择为人 于是我也就 爱上你的人。from《灵魂伴侣》");
        dataList.add("“老板能不能给我调五杯和昨晚一样的酒。”“是因为今晚的心情和昨晚一样吗？”“不是，是因为昨晚的醉意刚好可以梦到她。” from《灵魂伴侣》");
        dataList.add("我这一生遇到过很多人，他们如同指间的烟火，忽明忽暗，最后只沦为一抹灰烬。而你不同，你如北斗，闪耀在我的整个人生。from《Sons and Daughters》");
        dataList.add("那一世，转山转水转佛塔，不为修来世，只为途中与你相见。from《可能否》");
        dataList.add("想把你带入我多彩的世界，却惊醒你根本就不屑一顾这世界的每一粒尘土。from《尘土》");
        dataList.add("如何优雅地说我喜欢你？“太极生两仪，两仪生四象，四象生八卦，八卦衍万物” 然后呢  “万物不如你” from 《未见青山老》");
        dataList.add("“听闻小姐治家有方，鄙人余生愿闻其详。”  from 《未见青山老》");
        //打乱顺序
        shuffle(dataList);
    }

    public  void shuffle(List<String> list) {
        int size = list.size();
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            int randomPos = random.nextInt(size);
            String temp = list.get(i);
            list.set(i, list.get(randomPos));
            list.set(randomPos, temp);
        }
    }
}
