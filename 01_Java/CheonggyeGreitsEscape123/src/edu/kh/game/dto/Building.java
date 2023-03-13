package edu.kh.game.dto;

import java.util.ArrayList;
import java.util.List;

public class Building {

   List<List<String>> list = new ArrayList<>(7);
   List<List<String>> keyroomlist = new ArrayList<>(7);
   List<List<String>> listed = new ArrayList<>(7);
   
   public Building() {
      for(int i=0; i<7; i++) {
         list.add(new ArrayList<>());
         listed.add(new ArrayList<>());
         
         for(int j=0; j<=5; j++) {
          	 listed.get(i).add(""); 
         }
         
         
          
      }
      for (int i = 0; i < 7; i++) {
          keyroomlist.add(new ArrayList<>());
          if (i == 1 || i == 2 || i == 3) {
             int key2 = (int) (Math.random() * 4 );
             for (int j = 0; j < 5; j++) {

                if (key2 == j) {
                   keyroomlist.get(i).add("열쇠를 발견하였습니다.");
                } else {
                   keyroomlist.get(i).add("");
                }
             }
          } else {
             int key1 = (int) (Math.random() * 5 );
             for (int j = 0; j < 5; j++) {
                if (key1 == j) {
                   keyroomlist.get(i).add("열쇠를 발견하였습니다.");
                } else {
                   keyroomlist.get(i).add("");
                }
             }
          }
       }
      for(int j=0; j<=5; j++) {
      	 listed.get(j).add(""); 
       }
      
      // 1층: 로비
      list.get(0).add("로비");
      list.get(0).add("");
      list.get(0).add("");
      list.get(0).add("");
      list.get(0).add("");
      
      
      // 2~3층: 회의실, 강의실, 화장실, 탕비실
      for(int i=1; i<=2; i++) {
         list.get(i).add("회의실");
         list.get(i).add("강의실");
         list.get(i).add("화장실");
         list.get(i).add("탕비실");
         list.get(i).add("");
      }
      
      // 4층: 회장실, 대회의실, 강당, 탕비실
      list.get(3).add("회장실");
      list.get(3).add("대회의실");
      list.get(3).add("강당");
      list.get(3).add("탕비실");
      list.get(3).add("");
      
      
      // 5~6층: 회의실1, 회의실2, 강당, 화장실, 탕비실
      for(int i=4; i<=5; i++) {
         list.get(i).add("회의실1");
         list.get(i).add("회의실2");
         list.get(i).add("강당");
         list.get(i).add("화장실");
         list.get(i).add("탕비실");
      }
      
      // 7층: 옥상정원
      list.get(6).add("옥상정원");
      list.get(6).add("");
      list.get(6).add("");
      list.get(6).add("");
      list.get(6).add("");
   }
   public String getFloor(int asd, int dsa) {
      
      return list.get(asd).get(dsa);
   }
   public String getFloor2(int asd, int dsa) {
	   
	   return listed.get(asd).get(dsa);
   }
   public String keyCheck(int asd, int dsa) {
	   
	   return keyroomlist.get(asd).get(dsa);
   }
   public void setFloor(int i, int j, String f) {
	   listed.get(i).set(j, f);
   }
   
   
   
   public String getRoom(int j) {
	      ArrayList<String> roomList = new ArrayList<String>();
	      for (int i = 0; i < list.get(j).size(); i++) {
	         if (list.get(j).get(i).equals("")) {
	            System.out.println();
	         } else if (list.get(j).get(i).equals("로비")) {
	            System.out.println("        " + list.get(j).get(i));
	            System.out.println(" 탈출 하였습니다. ");
	         } else if (list.get(j).get(i).equals("옥상정원")) {
	            System.out.println("        " + list.get(j).get(i));
	         } else {
	            System.out.println("    " + (i + 1) + "." + list.get(j).get(i));
	         }
	         roomList.add(list.get(j).get(i));

	      }
	      return " ";

	   }
   /* 7 옥상정원
    * 6 회의실1  회의실2  강당  화장실  탕비실
    * 5 회의실1  회의실2  강당  화장실  탕비실
    * 4 회장실  대회의실  강당  탕비실    ""
    * 3 회의실  강의실  화장실  탕비실    ""
    * 2 회의실  강의실  화장실  탕비실    ""
    * 1 로비
    * 
    * * 7 옥상정원
    * 6 ""  ""  ""  ""  ""
    * 5 ""  ""  ""  ""  ""
    * 4 ""  ""  ""  ""  ""
    * 3 ""  ""  ""  ""  ""
    * 2 ""  ""  ""  ""  ""
    * 1 로비
    * 
    * 
    * 탕비실: 아이템이 랜덤으로 등장 / 좀비 확률 0%
    * 화장실: 좀비 확률 10%
    * 강의실: 좀비 확률 30%
    * 회의실: 좀비 확률 50%
    * 강당: 좀비 확률 70%
    * 대회의실: 좀비 확률 80%
    * 회장실: 좀비 확률 100%
    */
}