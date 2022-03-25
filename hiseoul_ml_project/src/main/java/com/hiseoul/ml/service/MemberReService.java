package com.hiseoul.ml.service;

import java.util.List;

import com.hiseoul.ml.model.MemberRe;
import com.hiseoul.ml.model.MemberReCreateDTO;
import com.hiseoul.ml.model.MemberReQueryDTO;
import com.hiseoul.ml.model.MemberReUpdateDTO;
import com.hiseoul.ml.model.Result;

public interface MemberReService {
	public MemberReQueryDTO getMemberRe(int no);
	public List<MemberReQueryDTO> listAllMemberRe();
	public int createMemberRe(MemberReCreateDTO memberReCreateDTO);
	public MemberReQueryDTO updateMemberAuth(Integer no, MemberReUpdateDTO memberReUpdateDTO);
	public MemberReQueryDTO updateMemberActive(Integer no, MemberReUpdateDTO memberReUpdateDTO);
}