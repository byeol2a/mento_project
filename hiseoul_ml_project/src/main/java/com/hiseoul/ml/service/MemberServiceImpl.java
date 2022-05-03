package com.hiseoul.ml.service;

import java.util.List;
import java.util.Optional;

import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.hiseoul.ml.controller.TempKey;
import com.hiseoul.ml.enumpkg.ServiceResult;
import com.hiseoul.ml.model.Member;
import com.hiseoul.ml.model.MemberRe;
import com.hiseoul.ml.model.MemberReQueryDTO;
import com.hiseoul.ml.model.MemberReUpdateDTO;
import com.hiseoul.ml.model.ErrorResponse;
import com.hiseoul.ml.model.Result;
import com.hiseoul.ml.repositories.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	private static final org.apache.logging.log4j.Logger 
	logger = LogManager.getLogger(MemberServiceImpl.class);
	@Autowired
	MemberRepository repository;
	
	public Result updateMember(Member member) {
		List<Member> search = repository.findByEmail(member.getEmail());
		Result result = new Result();
		if(search != null) {
			member = repository.save(member);
			result.setPayload(member);
		}else {
			result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
		}
		return result;
	}
	public Result deleteMember(String email) {
		Result result = new Result();
		boolean isPresent = repository.findByEmail(email) != null;
		if(!isPresent) {
			result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
		}else {
			repository.deleteById(email);
		}
		return result;
	}
	
	@Autowired
	private JavaMailSender mailSender;	

	@Override
	public Result createMember(Member member) throws Exception {
		List<Member> search = repository.findByEmail(member.getEmail());
		//member = repository.save(member);
		Result result = new Result();
		Member members = member;
		
		// authkey
		String authkey = new TempKey().getKey(50, false);
		
		members = search.get(search.size()-1);
		member.setAuth(0);	// auth瑜� 1濡�, 沅뚰븳 �뾽�뜲�씠�듃
		member.setAuthkey(authkey);
		//MailUtil sendMail = new MailUtil(mailSender);
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper sendMail = new MimeMessageHelper(message, true, "UTF-8");

		sendMail.setSubject("�쉶�썝媛��엯 �씠硫붿씪 �씤利�");
		sendMail.setText(new StringBuffer().append("<h1>[�씠硫붿씪 �씤利�]</h1>")
				.append("<p>�븘�옒 留곹겕瑜� �겢由��븯�떆硫� �씠硫붿씪 �씤利앹씠 �셿猷뚮맗�땲�떎.</p>")
				.append("<a href='http://localhost:8080/Yolo/member/joinConfirm?no=")
				.append(members.getNo()+1)
				.append("&email=")
				.append(member.getEmail())
				.append("&authkey=")
				.append(member.getAuthkey())
				.append("' target='_blenk'>[�씠硫붿씪 �씤利�]</a>")
				.toString(), true);
		sendMail.setFrom("learnprojectstart@naver.com", "hiseoul");
		sendMail.setTo(member.getEmail());
		mailSender.send(message);
		
		member = repository.save(member);
		result.setPayload(member);
		
		
		return result;
	}
	
	@Override
	public Result retrieveMemberList() {
		List<Member> list = repository.findAllByOrderByEmailDesc();
		Result result = new Result();
		result.setPayload(list);
		return result;
	}
	
	@Override
	public Result retrieveMember(String email) {
		List<Member> optionalMember = repository.findByEmail(email);
		Result result = new Result();
		if(optionalMember != null) {
			result.setPayload(optionalMember);
		}else {
			result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
		}
		return result;
	}
	//public String emailConfirm(Member member) {
		//List<Member> search = repository.findByEmail(member.getEmail());
		//Result result = new Result();
		//logger.info(member.getAuthkey());
		//logger.info(search.get(1));
		//if(search != null) {
			//member = search.get(search.size()-1);
			//member.setAuth(0);
			//member = repository.save(member);
			//result.setPayload(search.get(search.size()-1));
		//}else {
			//result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
		//}
		//return "/restapi/emailconfirm";
	//}
	@Override
	public Result emailConfirm(Member member) {
		// TODO Auto-generated method stub
		List<Member> search = repository.findByEmail(member.getEmail());
		Result result = new Result();
		result.setPayload(search.get(search.size()-1));
		return result;
	}
}