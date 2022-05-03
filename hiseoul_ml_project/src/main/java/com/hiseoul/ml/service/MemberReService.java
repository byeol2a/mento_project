package com.hiseoul.ml.service;

import java.util.List;

import com.hiseoul.ml.model.Member;
import com.hiseoul.ml.model.MemberRe;
import com.hiseoul.ml.model.MemberReCreateDTO;
import com.hiseoul.ml.model.MemberReQueryDTO;
import com.hiseoul.ml.model.MemberReUpdateDTO;
import com.hiseoul.ml.model.Result;

public interface MemberReService {
	public MemberReQueryDTO getMemberRe(String email);
	public List<MemberReQueryDTO> listAllMemberRe();
	public String createMemberRe(MemberReCreateDTO memberReCreateDTO);
	public MemberReQueryDTO updateMemberAuth(String email, MemberReUpdateDTO memberReUpdateDTO);
	public MemberReQueryDTO updateMemberActive(String email, MemberReUpdateDTO memberReUpdateDTO);
	public MemberReQueryDTO updateMemberAccount(String email, MemberReUpdateDTO memberReUpdateDTO);
	public MemberReQueryDTO emailConfirm(String email, MemberReUpdateDTO memberReUpdateDTO);
	//public Result emailConfirm(Member member);
}