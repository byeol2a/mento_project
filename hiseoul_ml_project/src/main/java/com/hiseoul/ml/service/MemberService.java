package com.hiseoul.ml.service;

import java.util.List;

import com.hiseoul.ml.model.Member;
import com.hiseoul.ml.model.Result;

public interface MemberService {
	public Result createMember(Member member) throws Exception;
	public Result retrieveMemberList();
	public Result retrieveMember(String email);
	public Result updateMember(Member member);
	public Result deleteMember(String email);
	public Result emailConfirm(Member member);
}