package yang.java.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
* @ClassName: DateFormatTest
* @Description: DateFormat�����
* DateFormat����Խ�һ������/ʱ������ʽ��Ϊ��ʾĳ�����ҵ���������/ʱ���ַ���
* @author: yangzhen
* @date: 2014-8-29 ����10:03:26
*
*/ 
public class DateFormatTest {

    public static void main(String[] args) throws ParseException {
        Date date = new Date(); // ��ǰ��һ�̵�ʱ�䣨���ڡ�ʱ�䣩
        Calendar c = Calendar.getInstance();
        date = c.getTime();
        //c.set(year, month, date, hourOfDay, minute, second);
        // ������ڲ���
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,Locale.GERMAN);
        String result = df.format(date);
        System.out.println(result);

        // ���ʱ�䲿��
        df = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CHINA);
        result = df.format(date);
        System.out.println(result);

        // ������ں�ʱ��
        df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG,Locale.CHINA);
        result = df.format(date);
        System.out.println(result);

        // ���ַ������������һ��date����
        String s = "10-9-26 ����02ʱ49��53��";
        df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG,Locale.CHINA);
        Date d = df.parse(s);
        System.out.println(d);
    }
}