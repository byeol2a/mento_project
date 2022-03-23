package com.hiseoul.ml.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hiseoul.ml.model.Member;
import com.hiseoul.ml.model.Result;
import com.hiseoul.ml.repositories.MemberRepository;
import com.hiseoul.ml.service.MemberService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="restapi/member")
public class MemberRestController{
	private static final org.apache.logging.log4j.Logger
	logger = LogManager.getLogger(MemberRestController.class);
		@Autowired
		MemberRepository repository;
		
		@Autowired
		MemberService boardService;
		
		@GetMapping
		public Result retrieveMemberList() {
			Result result = boardService.retrieveMemberList();
			return result;
		}
		@GetMapping("/{no}")
		public Result retrieveMember(@PathVariable Integer no) {
			Result result = boardService.retrieveMember(no);
		    return result;
		}
		@PostMapping
		public Result createMember(@ModelAttribute Member member) {
			Result result = boardService.createMember(member);
			return result;
		}
		
		@PutMapping
		public Result updateMember(@ModelAttribute Member member) {
			Result result = boardService.updateMember(member);
			return result;
		}
		
		@DeleteMapping
		public Result deleteMember(@RequestParam int no) {
			Result result = boardService.deleteMember(no);
			return result;
		}
		
}