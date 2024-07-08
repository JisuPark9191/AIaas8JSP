package com.prac.myapp.client.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prac.myapp.addr.model.ClientVO;
import com.prac.myapp.addr.service.IAddrService;
import com.prac.myapp.client.service.IClientService;

@Controller
@RequestMapping("/client")
public class ClientConroller {
	
	@Autowired
	IClientService clientService;
	@Autowired
	IAddrService addrService;
	
	@GetMapping("/login")
	public String login(Model model) {
		return "client/login";
	}
	
	@PostMapping("/login")
	public String login(
			@RequestParam String id, 
			@RequestParam String pw, Model model) {
		String checked_id = clientService.checkClient(id, pw);
		model.addAttribute("id",checked_id);
		if(checked_id.equals("admin")) {
			model.addAttribute("list",clientService.getClientList("date","ascend"));
			return "client/list";
		}
		model.addAttribute("list",addrService.getAddrList(id,"date","ascend"));
		return "addr/list";
	}
	
	@GetMapping("/count")
	public String clientCount(Model model){
		model.addAttribute("count",clientService.getClientCount());
		return "client/count";
	}
	
	@GetMapping("/list")
	public String getAllClient(
		@RequestParam(value="searchFail", defaultValue="1") int fail,
		Model model) {
		List<ClientVO> clntList= clientService.getClientList("date","ascend");
		model.addAttribute("list",clntList);
		return "client/list";
	}
	
	@GetMapping("/orderby")
	public String getAllClient(
			@RequestParam(value="value")String value,
			@RequestParam(value="orderby")String orderby,
			Model model) {
		List<ClientVO> clntList= clientService.getClientList(value,orderby);
		model.addAttribute("list",clntList);
		return "client/list";
	}
	
	@GetMapping("/search")
	public String getAllClientName(
			@RequestParam(value="name") String name,
			Model model){
		List<ClientVO> clntList = clientService.getClientNameList(name);
		if(clntList.size()==0) {
			model.addAttribute("searchFail",0);
			model.addAttribute("list",clientService.getClientList("date","ascend"));
			return "client/list";
		}
		if(clntList.size()==1) {
			model.addAttribute("clnt",clntList.get(0));
			return "client/view";
		}
		model.addAttribute("count",clntList.size());
		model.addAttribute("list",clntList);
		return "client/nameList";
	}
	
	@GetMapping("/{id}")
	public String getClientInfo(@PathVariable String id, Model model) {
		ClientVO clnt = clientService.getClientInfo(id);
		model.addAttribute("clnt",clnt);
		return "client/view";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		return "client/signup";
	}
	
	@PostMapping("/signup")
	public String insertClient(ClientVO clnt, Model model) {
		clientService.insertClient(clnt);
		model.addAttribute("id",clnt.getId());
		return "client/login";
	}
	
	@GetMapping("/update")
	public String updateClient(String id, Model model) {
		model.addAttribute("clnt",clientService.getClientInfo(id));
		return "client/updateform";
	}
	
	@PostMapping("/update")
	public String updateClient(ClientVO clnt, Model model) {
		model.addAttribute("clnt",clnt);
		return "client/view";
	}
	
	@GetMapping("/delete")
	public String deleteClient(
			@RequestParam(value="id")String id, Model model) {
		model.addAttribute("clnt",clientService.getClientInfo(id));
		return "client/deleteform";
	}
	
	@PostMapping("/delete")
	public String deleteClient(
			@RequestParam(value="id")String id, 
			@RequestParam(value="pw")String pw, Model model) {
		clientService.deleteClient(id,pw);
		model.addAttribute("list",clientService.getClientList("date","ascend"));
		return "client/list";
	}
	
	@GetMapping("/user")
	public String userInfo(
			@RequestParam(value="id")String id,Model model) {
		model.addAttribute("user",clientService.getClientInfo(id));
		return "client/user";
	}
	
	@PostMapping("/updateUser")
	public String userUpdate(ClientVO clnt,Model model) {
		clientService.updateClient(clnt);
		model.addAttribute("user",clnt);
		return "client/user";
	}
	
	@GetMapping("/userDelete")
	public String deleleUser(
			@RequestParam(value="id")String id,Model model) {
		model.addAttribute("user",clientService.getClientInfo(id));
		return "client/deleteUserForm";
	}
	
	@PostMapping("/userDelete")
	public String deleteUser(
			@RequestParam(value="id")String id,
			@RequestParam(value="pw")String pw) {
		clientService.deleteClient(id,pw);
		return "client/login";
	}
}
