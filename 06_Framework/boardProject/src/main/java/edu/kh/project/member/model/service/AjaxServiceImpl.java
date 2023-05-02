package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dao.AjaxDAO;

@Service // 서비스임을 명시 + bean 등록
public class AjaxServiceImpl implements AjaxService {
   
   @Autowired // DI
   private AjaxDAO dao;

   @Override
   public String selectNickname(String email) {
      return dao.selectNickname(email);
   }
   
   @Override
   public String selectMemberTel(String nickname) {
	   return dao.selectMemberTel(nickname);
   }
   
   @Override
   public int checkEmail(String email) {
	   return dao.checkEmail(email);
   }
   
   @Override
   public int checkNickname(String nickname) {
	   return dao.checkNickname(nickname);
   }
   
}