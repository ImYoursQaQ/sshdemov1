package org.ssh.product.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import freemarker.ext.beans.HashAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.ssh.product.model.Brand;
import org.ssh.product.model.Goods;
import org.ssh.product.model.Poster;
import org.ssh.product.service.GoodsService;
import org.ssh.product.util.SafeUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
@Controller
public class IndexAction extends ActionSupport {
    public String keyword;

    private String brandname;

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexAction.class);

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private SafeUtil safeUtil;


    public String listGoods() {
        Map session = ActionContext.getContext().getSession();
        System.out.println("action result:");
        Map<String, List<Goods>> result = new LinkedHashMap<>();
        List<Brand> brands = goodsService.listBrand();
        for (Brand brand : brands) {
            Byte searchId = brand.getBrandid();
            List<Goods> goodslist = goodsService.getGoodslist(searchId);
            List<Goods> goodslist1 = new ArrayList<>();
            System.out.println("hehehhe"+goodslist.size());
            if (goodslist.size()!=0) {
                for (int i = 0; i < 4; i++) {
                    Goods goods = goodslist.get(i);
                    goodslist1.add(goods);
                }
            }
            if (!result.containsKey(brand.getBrandname())) {
                result.put(brand.getBrandname(), goodslist1);
            }
        }
        LOGGER.info("result = {}", result);
//        ActionContext.getContext().put("result", result);
        System.out.println("index result");
        System.out.println(result);
        session.put("result", result);

        //加载海报内容
        List<Poster> posterList =new ArrayList<>();
        posterList.add(goodsService.getPoster(1));
        posterList.add(goodsService.getPoster(2));
        posterList.add(goodsService.getPoster(3));
        session.put("posterList", posterList);


//        session.put("brands", brands);
//        for (int i = 0; i < brands.size(); i++) {//内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
//            Byte searchid = brands.get(i).getBrandid();
//            List<Goods> goodsList = goodsService.getGoodslist(searchid);
//            //List<List<Goods>> brandlistofgoods;
//            //int j = i+1;
//            String s = String.valueOf(searchid);
//            String brandgoods = "goods";
//            brandgoods = brandgoods.concat(s);
//            if (brandgoods.equals("goods101")) {
//                System.out.println("hahahaha");
//            }
//            System.out.println(brandgoods);
//            session.put(brandgoods, goodsList);
//            System.out.println(brands.get(i));
//            System.out.println("session result:" + brandgoods);
//            session.get(brandgoods);
//        }
   /* Byte searchid = brands.get(0).getBrandid();
    System.out.println(searchid);
    List<Goods> goods = goodsService.getGoods(searchid);
    session.put("goods1", goods);
    System.out.println(goods.get(0).getTitle());*/


        return SUCCESS;

    }

    public String searchGoods(){
        Map session=ActionContext.getContext().getSession();
        session.remove("searchlist");
        System.out.println("keyword:");
        System.out.println(keyword);
       if(safeUtil.iscorrect(keyword)){

           String str =keyword.replaceAll("\\s*", "");
           System.out.println(str);
           System.out.println("通过");
           List<Goods> searchgoodsList = goodsService.getGoodslist(str);

           if(searchgoodsList.size()==0) {
               //System.out.println(searchgoodsList.get(0).getTitle());
               //在这里做组合查询
               String [] arrkey = keyword.split("\\s+");
               if (arrkey.length==2){

                   List<Goods> goodsListTest11 = goodsService.getGoodslist(arrkey[0]);
                   List<Goods> goodsListTest22 = goodsService.getGoodslist(arrkey[1]);


                   if (safeUtil.HasDigit(arrkey[1])){
                       System.out.println("转换前："+arrkey[1]);
                       //searchgoodsList = goodsService.getGoodslistforRom(arrkey[0], arrkey[1]);
                       int a= safeUtil.firstDigitalStrToInt(arrkey[1]);
                       System.out.println("转换后："+a);
                       searchgoodsList = goodsService.getGoodslistforRom(arrkey[0], a);
                   }
                   else if(safeUtil.HasDigit(arrkey[0])){
                       int b= safeUtil.firstDigitalStrToInt(arrkey[0]);
                       searchgoodsList = goodsService.getGoodslistforRom(arrkey[1], b);
                       System.out.println("组合查询搜索结果为：");
                       System.out.println(searchgoodsList.size());
                   }

                   else {

                       searchgoodsList = goodsService.getGoodslist(arrkey[0],arrkey[1]);
                   }

                   if (searchgoodsList.size()==0){
                       searchgoodsList = goodsService.getGoodslist(arrkey[1],arrkey[0]);
                   }
                   if (goodsListTest11.size()==0&&goodsListTest22.size()==0){
                       if (safeUtil.HasDigit(arrkey[1])){
                           System.out.println("转换前："+arrkey[1]);
                           //searchgoodsList = goodsService.getGoodslistforRom(arrkey[0], arrkey[1]);
                           int a= safeUtil.firstDigitalStrToInt(arrkey[1]);
                           System.out.println("转换后："+a);
                           searchgoodsList = goodsService.getGoodslistforColorandRom(arrkey[0], a);
                       }
                       else if(safeUtil.HasDigit(arrkey[0])){
                           int b= safeUtil.firstDigitalStrToInt(arrkey[0]);
                           searchgoodsList = goodsService.getGoodslistforColorandRom(arrkey[1], b);
                           System.out.println("组合查询搜索结果为：");
                           System.out.println(searchgoodsList.size());
                       }


                   }

               }
               else if(arrkey.length==3){
                    List<Goods> goodsListTest1 = goodsService.getGoodslist(arrkey[0]);
                   List<Goods> goodsListTest2 = goodsService.getGoodslist(arrkey[1]);
                   System.out.println(goodsListTest1.toString());
                   System.out.println(goodsListTest1.size());
                   //第一个关键字是title
                    if (goodsListTest1.size()!=0&&goodsListTest2.size()==0){
                        if (safeUtil.HasDigit(arrkey[1])){
                            int a= safeUtil.firstDigitalStrToInt(arrkey[1]);
                            searchgoodsList = goodsService.getGoodslistforRom(arrkey[0], arrkey[2],a);
                        }
                        else {
                            int b =safeUtil.firstDigitalStrToInt(arrkey[2]);
                            searchgoodsList = goodsService.getGoodslistforRom(arrkey[0], arrkey[1],b);
                        }
                    }
                    //第二个关键字是title
                    else if (goodsListTest1.size()==0&&goodsListTest2.size()!=0){
                        if (safeUtil.HasDigit(arrkey[0])){
                            int a= safeUtil.firstDigitalStrToInt(arrkey[0]);
                            searchgoodsList = goodsService.getGoodslistforRom(arrkey[1], arrkey[2],a);
                        }
                        else {
                            int b =safeUtil.firstDigitalStrToInt(arrkey[2]);
                            searchgoodsList = goodsService.getGoodslistforRom(arrkey[1], arrkey[0],b);
                        }
                    }
                    //第三个关键字是title
                    else if (goodsListTest1.size()==0&&goodsListTest2.size()==0){
                        if (safeUtil.HasDigit(arrkey[0])){
                            int a= safeUtil.firstDigitalStrToInt(arrkey[0]);
                            searchgoodsList = goodsService.getGoodslistforRom(arrkey[2], arrkey[1],a);
                        }
                        else {
                            int b =safeUtil.firstDigitalStrToInt(arrkey[1]);
                            searchgoodsList = goodsService.getGoodslistforRom(arrkey[2], arrkey[0],b);
                        }

                    }
               }
           }

           session.put("searchlist",searchgoodsList);


           return SUCCESS;
       }
       else {
           System.out.println("不通过！！！");
           return SUCCESS;
       }
    }

    public String searchGoodsByBrand(){
        System.out.println("action test:"+brandname);
        List<Goods> searchgoodsList = goodsService.getGoodslistBybrandname(brandname);
        Map session=ActionContext.getContext().getSession();
        session.remove("searchlist");
        session.put("searchlist",searchgoodsList);
        return SUCCESS;
    }

    public String searchRankingList(){

        List<Goods> allGoodsList = goodsService.getGoodslist();
        System.out.println("ranking:");
        System.out.println(allGoodsList.size());
        for (Goods goods : allGoodsList) {
            double score = goods.getAppearanceScore()*0.3+goods.getPerformanceScore()*0.3+goods.getPhotoScore()*0.25+goods.getUserScore()*0.15;
            goods.setComprehensiveScore(score);
            System.out.println(goods.getTitle());
        }

        Collections.sort(allGoodsList, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                Goods g1=(Goods) o1;
                Goods g2=(Goods) o2;
                if(g1.getComprehensiveScore()>g2.getComprehensiveScore()){
                    return -1;
                }else if(g1.getComprehensiveScore()==g2.getComprehensiveScore()){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
        for (Goods goods : allGoodsList) {
            double s=goods.getComprehensiveScore();
            BigDecimal b = new BigDecimal(s);
            double value =b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            goods.setComprehensiveScore(value);
            //System.out.println(df.format(f));
        }
        System.out.println(allGoodsList.size());
        List<Goods> rankingGoods = new ArrayList<>();
        for (int i = 0; i < allGoodsList.size(); i++) {
            if (i<10){
                rankingGoods.add(allGoodsList.get(i));
            }
        }

        Map session = ActionContext.getContext().getSession();
        session.put("ranking",rankingGoods);





        return SUCCESS;
    }

    public String searchNewPhoneList(){

        Map session = ActionContext.getContext().getSession();
        List<Goods> newPhoneList = goodsService.getNewPhonelist();
        session.put("newPhoneList",newPhoneList);

        return SUCCESS;
    }

}
