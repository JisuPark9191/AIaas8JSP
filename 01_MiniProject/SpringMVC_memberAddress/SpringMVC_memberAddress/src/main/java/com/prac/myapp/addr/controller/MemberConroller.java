package com.prac.myapp.addr.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prac.myapp.addr.model.MemberVO;
import com.prac.myapp.addr.service.IAddrService;
import com.prac.myapp.member.service.IMemberService;

@Controller
@RequestMapping("/member")
public class MemberConroller {
	
	@Autowired
	IMemberService memberService;
	@Autowired
	IAddrService addrService;
	
	@GetMapping("/login")
	public String login(Model model) {
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(String id, String pw, Model model) {
		String checked_id = memberService.checkMember(id, pw);
		model.addAttribute("id",checked_id);
		if(checked_id.equals("admin")) {
			model.addAttribute("list",memberService.getMemberList("date","ascend"));
			return "member/list";
		}
		model.addAttribute("list",addrService.getAddrList(id,"date","ascend"));
		return "addr/list";
	}
	
	@GetMapping("/count")
	public String clientCount(Model model){
		model.addAttribute("count",memberService.getMemberCount());
		return "member/count";
	}
	
	@GetMapping("/list")
	public String getAllClient(
			@RequestParam(value="searchFail", defaultValue="1") int fail,
			Model model) {
		List<MemberVO> clntList= memberService.getMemberList("date","ascend");
		model.addAttribute("list",clntList);
		return "member/list";
	}
	
	@GetMapping("/orderby")
	public String getAllClient(String value, String orderby,
			Model model) {
		List<MemberVO> clntList= memberService.getMemberList(value,orderby);
		model.addAttribute("list",clntList);
		return "member/list";
	}
	
	@GetMapping("/search")
	public String getAllClientName(String name,
			Model model){
		List<MemberVO> clntList = memberService.getMemberNameList(name);
		if(clntList.size()==0) {
			model.addAttribute("searchFail",0);
			model.addAttribute("list",memberService.getMemberList("date","ascend"));
			return "member/list";
		}
		if(clntList.size()==1) {
			model.addAttribute("mem",clntList.get(0));
			return "member/view";
		}
		model.addAttribute("count",clntList.size());
		model.addAttribute("list",clntList);
		return "member/nameList";
	}
	
	@GetMapping("/{id}")
	public String getClientInfo(@PathVariable String id, Model model) {
		MemberVO mem = memberService.getMemberInfo(id);
		model.addAttribute("mem",mem);
		return "member/view";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		return "member/signup";
	}
	
	@PostMapping("/signup")
	public String insertClient(MemberVO mem, Model model) {
		memberService.insertMember(mem);
		model.addAttribute("id",mem.getId());
		return "member/login";
	}
	
	@GetMapping("/update")
	public String updateClient(String id, Model model) {
		model.addAttribute("mem",memberService.getMemberInfo(id));
		return "member/updateform";
	}
	
	@PostMapping("/update")
	public String updateClient(MemberVO mem, Model model) {
		memberService.updateMember(mem);
		model.addAttribute("mem",mem);
		return "member/view";
	}
	
	@GetMapping("/delete")
	public String deleteClient(String id, Model model) {
		model.addAttribute("mem",memberService.getMemberInfo(id));
		return "member/deleteform";
	}
	
	@PostMapping("/delete")
	public String deleteClient(String id, String pw, Model model) {
		memberService.deleteMember(id,pw);
		model.addAttribute("list",memberService.getMemberList("date","ascend"));
		return "member/list";
	}
	
	@GetMapping("/user")
	public String userInfo(String id,Model model) {
		model.addAttribute("user",memberService.getMemberInfo(id));
		return "member/user";
	}
	
	@PostMapping("/updateUser")
	public String userUpdate(MemberVO mem,Model model) {
		memberService.updateMember(mem);
		model.addAttribute("user",mem);
		return "member/user";
	}
	
	@GetMapping("/userDelete")
	public String deleleUser(String id,Model model) {
		model.addAttribute("user",memberService.getMemberInfo(id));
		return "member/deleteUserForm";
	}
	
	@PostMapping("/userDelete")
	public String deleteUser(String id,String pw) {
		memberService.deleteMember(id,pw);
		return "member/login";
	}
}
