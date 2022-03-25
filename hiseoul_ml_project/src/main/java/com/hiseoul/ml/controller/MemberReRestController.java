package com.hiseoul.ml.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.hiseoul.ml.model.Member;
import com.hiseoul.ml.model.MemberReCreateDTO;
import com.hiseoul.ml.model.MemberReQueryDTO;
import com.hiseoul.ml.model.MemberReUpdateDTO;
import com.hiseoul.ml.model.Result;
import com.hiseoul.ml.repositories.MemberRepository;
import com.hiseoul.ml.service.MemberReService;
import com.hiseoul.ml.service.MemberService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="restapi/memberre")
public class MemberReRestController{
	private static final org.apache.logging.log4j.Logger
	logger = LogManager.getLogger(MemberReRestController.class);
		
		@Autowired
		private MemberReService memberReService;
		
		@GetMapping
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<List<MemberReQueryDTO>> listAllMemberRe(){
			return new ResponseEntity<>(memberReService.listAllMemberRe(), HttpStatus.OK);
		}

		@GetMapping(value = "/{no}", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<MemberReQueryDTO> getMemberRe(@PathVariable(value = "no") Integer no) {
			return new ResponseEntity<>(memberReService.getMemberRe(no), HttpStatus.OK);
		}
		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<Integer> createMemberRe(MemberReCreateDTO memberReCreateDTO){
			return new ResponseEntity<>(memberReService.createMemberRe(memberReCreateDTO),HttpStatus.CREATED);
		}
		
		@PutMapping(value = "/Auth/{no}", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<MemberReQueryDTO> updateMemberAuth(@PathVariable(value = "no") Integer no, MemberReUpdateDTO memberReUpdateDTO){
			return new ResponseEntity<>(memberReService.updateMemberAuth(no, memberReUpdateDTO),HttpStatus.OK);
		}
		
		@PutMapping(value = "/Active/{no}", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<MemberReQueryDTO> updateMemberActive(@PathVariable(value = "no") Integer no, MemberReUpdateDTO memberReUpdateDTO){
			return new ResponseEntity<>(memberReService.updateMemberActive(no, memberReUpdateDTO),HttpStatus.OK);
		}
			
}