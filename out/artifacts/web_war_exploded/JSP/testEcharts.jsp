<%--
  Created by IntelliJ IDEA.
  User: 15353
  Date: 2020/6/15
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    //饼状图的方法
    //对应放图片的Id（imageId）
    //typeArr:对应名称的数组
    //dataArr:对应名称数组的对应数据的数组
    var dataArr = new Array(84,14,24,3);
    var typeArr = new Array("打卡学生","未打卡学生","打卡教师","未打卡教师");

    var ListFirstArr = new Array();
    for (var i = 0; i < typeArr.length; i++) {
        var item = {
            value: dataArr[i],
            name: typeArr[i]
        };
        ListFirstArr.push(item);
    }

    // 基于准备好的dom，初始化echarts图表
    var myChart = echarts.init(document.getElementById('main'));
    option = {
        title: {
            text: '',
            subtext: '',
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: typeArr
        },
        series: [
            {
                name: '访问来源',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: ListFirstArr,
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    myChart.setOption(option);

</script>
</body>
</html>