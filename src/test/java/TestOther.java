import com.alibaba.fastjson.JSONArray;
import com.example.Util.RandomUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.util.*;

/**
 * Created by lincg on 2017/5/26.
 */
public class TestOther {

    @Test
    public void testDate() throws ParseException {
        Date date = DateUtils.parseDate("2017-04-27", "yyyy-MM-dd");
        System.out.println(date);

        String menuLists = "\n" +
                "\n" +
                "\n" +
                "{\"project_classify\":[],\"index\":[],\"service_project_manage\":[],\"enterprise_customer_manage\":[],\"customer_manage\":[],\"store_statistics\":[],\"seller_statistics\":[],\"activity_manage\":[],\"account_manage\":[],\"consumer_statistics\":[],\"card_receipt\":[],\"work_order_manage\":[],\"card_manage\":[],\"seller_manage\":[],\"pwd_manage\":[]}";
        Map<String, List<String>> map = (Map<String, List<String>>) JSONArray.parse(menuLists);
        List<String> keys = new ArrayList<String>();
        for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext(); ) {
            String key = iterator.next();
            keys.add(key);
        }
        System.out.println(keys.contains("customer_manage"));

    }

    @Test
    public void testDate2() throws ParseException {

        String menuLists = "\n" +
                "\n" +
                "\n" +
                "{\"project_classify\":[],\"index\":[],\"service_project_manage\":[],\"enterprise_customer_manage\":[],\"customer_manage\":[],\"store_statistics\":[],\"seller_statistics\":[],\"activity_manage\":[],\"account_manage\":[],\"consumer_statistics\":[],\"card_receipt\":[],\"work_order_manage\":[],\"card_manage\":[],\"seller_manage\":[],\"pwd_manage\":[]}";
      if(menuLists.contains("customer_manage")){
          System.out.println("-------");
      }
    }
    @Test
    public void testList() throws ParseException {
//       List<String> list=new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        System.out.println(list.size());

        String a="123456789";
        String b=a.substring(0,2);
        System.out.println(b);

        String c="hello";
        String d="he"+new String("llo");
        String e="hello";
        String f="he"+"llo";
        System.out.println(c==d);
        System.out.println(c==e);
        System.out.println(c==f);
        System.out.println(c.equals(d));
    }

    @Test
    public void testRandom(){
       char a= RandomUtil.getRandomChar();
        System.out.println(a);



    }



}
