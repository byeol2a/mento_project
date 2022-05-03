package com.hiseoul.ml.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hiseoul.ml.enumpkg.ServiceResult;
import com.hiseoul.ml.model.ErrorResponse;
import com.hiseoul.ml.model.Member;
import com.hiseoul.ml.model.Result;
import com.hiseoul.ml.repositories.MemberRepository;
import com.hiseoul.ml.service.MemberService;
import com.hiseoul.ml.service.MemberReService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="Yolo/member")
public class MemberRestController{
	private static final org.apache.logging.log4j.Logger
	logger = LogManager.getLogger(MemberRestController.class);
		@Autowired
		MemberRepository repository;
		
		@Autowired
		MemberService memberService;
		
		@Autowired
		MemberReService memberReService;
		
		@GetMapping
		public Result retrieveMemberList() {
			Result result = memberService.retrieveMemberList();
			return result;
		}
		@GetMapping("/{email}")
		public Result retrieveMember(@PathVariable String email) {
			Result result = memberService.retrieveMember(email);
		    return result;
		}
		@PostMapping
		public Result createMember(@ModelAttribute Member member) throws Exception {
			Result result = memberService.createMember(member);
			return result;
		}
		
		@PutMapping
		public Result updateMember(@ModelAttribute Member member) {
			Result result = memberService.updateMember(member);
			return result;
		}
		
		@DeleteMapping
		public Result deleteMember(@RequestParam String email) {
			Result result = memberService.deleteMember(email);
			return result;
		}
		
		@RequestMapping(value="joinConfirm", method=RequestMethod.GET)
		public String emailConfirm(@ModelAttribute("member") Member member) throws Exception {
			logger.info(member.getEmail() + ": auth confirmed");
			Result result = memberService.emailConfirm(member);
			
			List<Member> search = repository.findByEmail(member.getEmail());
			logger.info(member.getAuthkey());
			logger.info(search.get(1));
			if(search != null) {
				member = search.get(search.size()-1);
				member.setAuth(0);
				member = repository.save(member);
				result.setPayload(search.get(search.size()-1));
			}else {
				result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
			}
			
			return "<h3>EmailConfirm Success!</h3>";
		}
	
}