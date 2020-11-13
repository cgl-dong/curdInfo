package com.his.app.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.his.app.dao.DoctorDao;
import com.his.app.pojo.EchartsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @author cgl
 * @version 1.0
 * @desc
 * @date 2020/10/10 14:09
 */
@Component
public class EchartsUtil {

    @Autowired
    DoctorDao doctorDao;

    public String echart(){
        List<HashMap<String, Object>> maps = doctorDao.countByOffice();
        String string = JSON.toJSONString(maps);

        EchartsEntity echarts=new EchartsEntity();
        echarts.setName("科室医生");
        echarts.setType("pie");

        //把数据解析出来，然后拼接
        JSONObject json = (JSONObject) JSON.toJSON(echarts);

        json.put("data",string);
        //replaceAll("\\\\","")
        return  json.toJSONString();

    }



    /*
    public void testBar(boolean isHorizontal) {
        String[] citis = {"广州", "深圳", "珠海", "汕头", "韶关", "佛山"};
        int[] datas = {6030, 7800, 5200, 3444, 2666, 5708};
        String[] colors = {"rgb(2,111,230)", "rgb(186,73,46)", "rgb(78,154,97)", "rgb(2,111,230)", "rgb(186,73,46)", "rgb(78,154,97)"};
        String title = "地市数据";

        GsonOption option = new GsonOption();

        option.title(title); // 标题
        // 工具栏
        option.toolbox().show(true).feature(Tool.mark, // 辅助线
                Tool.dataView, // 数据视图
                new MagicType(Magic.line, Magic.bar),// 线图、柱状图切换
                Tool.restore,// 还原
                Tool.saveAsImage);// 保存为图片

        option.tooltip().show(true).formatter("{a} <br/>{b} : {c}");//显示工具提示,设置提示格式

        option.legend(title);// 图例

        Bar bar = new Bar(title);// 图类别(柱状图)
        CategoryAxis category = new CategoryAxis();// 轴分类
        category.data(citis);// 轴数据类别
        // 循环数据
        for (int i = 0; i < citis.length; i++) {
            int data = datas[i];
            String color = colors[i];
            // 类目对应的柱状图
            Map<String, Object> map = new HashMap<String, Object>(2);
            map.put("value", data);
            map.put("itemStyle", new ItemStyle().normal(new Normal().color(color)));
            bar.data(map);
        }

        if (isHorizontal) {// 横轴为类别、纵轴为值
            option.xAxis(category);// x轴
            option.yAxis(new ValueAxis());// y轴
        } else {// 横轴为值、纵轴为类别
            option.xAxis(new ValueAxis());// x轴
            option.yAxis(category);// y轴
        }

        System.out.println(option.series(bar));
        ;
    }

     */
}
