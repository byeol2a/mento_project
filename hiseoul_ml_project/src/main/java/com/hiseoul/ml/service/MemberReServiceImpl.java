package com.hiseoul.ml.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hiseoul.ml.enumpkg.ServiceResult;
import com.hiseoul.ml.model.MemberRe;
import com.hiseoul.ml.model.MemberReCreateDTO;
import com.hiseoul.ml.model.MemberReQueryDTO;
import com.hiseoul.ml.model.MemberReUpdateDTO;
import com.hiseoul.ml.model.ErrorResponse;
import com.hiseoul.ml.model.Result;
import com.hiseoul.ml.repositories.MemberReRepository;

@Service
public class MemberReServiceImpl implements MemberReService{
	private static final org.apache.logging.log4j.Logger 
	logger = LogManager.getLogger(MemberReServiceImpl.class);
	
	@Autowired
	MemberReRepository repository;
	
	public MemberReQueryDTO getMemberRe(int no) {
		if (repository.findById(no).isPresent()) {
			MemberRe fetchedMemberRe = repository.findById(no).get();
			return new MemberReQueryDTO(fetchedMemberRe.getNo(),fetchedMemberRe.getId(),fetchedMemberRe.getPass(),fetchedMemberRe.getName(),fetchedMemberRe.getEmail(),fetchedMemberRe.getInstanceyn(),fetchedMemberRe.getWritedate(),fetchedMemberRe.getUpdate(),fetchedMemberRe.getActiveyn(), fetchedMemberRe.getPermission(),fetchedMemberRe.getAuth()); 
		}else {
			return null;
		}
	}
	
	public List<MemberReQueryDTO> listAllMemberRe() {
		List<MemberReQueryDTO> memberReList = new ArrayList<>();
		
		repository.findAll().forEach(memberre -> {
			memberReList.add(new MemberReQueryDTO(memberre.getNo(),memberre.getId(),memberre.getPass(),memberre.getName(),memberre.getEmail(),memberre.getInstanceyn(),memberre.getWritedate(),memberre.getUpdate(),memberre.getActiveyn(), memberre.getPermission(),memberre.getAuth()));
		});
		
		return memberReList;	
	}
	
	public int createMemberRe(MemberReCreateDTO memberReCreateDTO) {
		MemberRe newMemberRe = new MemberRe();
		
		newMemberRe.setNo(memberReCreateDTO.getNo());
		newMemberRe.setId(memberReCreateDTO.getId());
		newMemberRe.setPass(memberReCreateDTO.getPass());
		newMemberRe.setName(memberReCreateDTO.getName());
		newMemberRe.setEmail(memberReCreateDTO.getEmail());
		newMemberRe.setInstanceyn(memberReCreateDTO.getInstanceyn());
		newMemberRe.setWritedate(memberReCreateDTO.getWritedate());
		newMemberRe.setUpdate(memberReCreateDTO.getUpdate());
		newMemberRe.setActiveyn(memberReCreateDTO.getActiveyn());
		newMemberRe.setPermission(memberReCreateDTO.getPermission());
		newMemberRe.setAuth(memberReCreateDTO.getAuth());
		
		return repository.save(newMemberRe).getNo();
	}
	
	
	
	@Override
	public MemberReQueryDTO updateMemberAuth(Integer no, MemberReUpdateDTO memberReUpdateDTO){
		if (repository.findById(no).isPresent()) {
			MemberRe existingMemberRe = repository.findById(no).get();
			
			existingMemberRe.setAuth(memberReUpdateDTO.getAuth());
			existingMemberRe.setUpdate(memberReUpdateDTO.getUpdate());
			
			MemberRe updatedMemberRe = repository.save(existingMemberRe);
			
			return new MemberReQueryDTO(updatedMemberRe.getNo(), updatedMemberRe.getId(), updatedMemberRe.getPass(),updatedMemberRe.getName(),updatedMemberRe.getEmail(),updatedMemberRe.getInstanceyn(),updatedMemberRe.getWritedate(),updatedMemberRe.getUpdate(),updatedMemberRe.getActiveyn(),updatedMemberRe.getPermission(),updatedMemberRe.getAuth());
		}else {
			return null;
		}
	}
	
	@Override
	public MemberReQueryDTO updateMemberActive(Integer no, MemberReUpdateDTO memberReUpdateDTO){
		if (repository.findById(no).isPresent()) {
			MemberRe existingMemberRe = repository.findById(no).get();
			
			existingMemberRe.setActiveyn(memberReUpdateDTO.getActiveyn());
			existingMemberRe.setUpdate(memberReUpdateDTO.getUpdate());
			
			MemberRe updatedMemberRe = repository.save(existingMemberRe);
			
			return new MemberReQueryDTO(updatedMemberRe.getNo(), updatedMemberRe.getId(), updatedMemberRe.getPass(),updatedMemberRe.getName(),updatedMemberRe.getEmail(),updatedMemberRe.getInstanceyn(),updatedMemberRe.getWritedate(),updatedMemberRe.getUpdate(),updatedMemberRe.getActiveyn(),updatedMemberRe.getPermission(),updatedMemberRe.getAuth());
		}else {
			return null;
		}
	}
}