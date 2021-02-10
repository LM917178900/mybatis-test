package com.example.demo.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @description: CalendarTask
 * @author: leiming5
 * @date: 2021-02-05 11:28
 */
public class mm {


    /**
     * 1. 触发时获取当前时间点时间；
     * 2. 获取后3年的时间数据；（需要干掉当前时间之后的数据）
     * 3. 解析每一天的数据:日/周/月/季度/年/财年.../假期，封装list;
     * 4. 批量新增list
     */
    public static void main(String[] args) {

        Date startDate = new Date();

        Calendar startCalender = new GregorianCalendar();
        startCalender.setTime(startDate);
        startCalender.add(Calendar.YEAR, 1);
        Date endDate = startCalender.getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> list=new ArrayList<>();


        try {
            startCalender.setTime(startDate);

            while (startCalender.getTime().before(endDate)) {

                System.out.println(dateFormat.format(startCalender.getTime()));
                list.add(dateFormat.format(startCalender.getTime()));
                startCalender.add(Calendar.DAY_OF_MONTH, 1);
            }

            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
