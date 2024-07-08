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
import org.springframework.web.servlet.ModelAndView;

import com.prac.myapp.addr.model.AddrVO;
import com.prac.myapp.addr.service.IAddrService;

@Controller
@RequestMapping("/addr")
public class AddrController {
	
	@Autowired
	IAddrService addrService;
	
	@GetMapping("/list")
	public String getAllAddr(
			@RequestParam(value="searchFail", defaultValue="1") int fail,
			@RequestParam(value="id")String id,
			@RequestParam(value="value", defaultValue="date")String value,
			@RequestParam(value="orderby", defaultValue="ascend")String orderby,
			Model model){
		List<AddrVO> addrList = addrService.getAddrList(id, value, orderby);
		model.addAttribute("list",addrList);
		model.addAttribute("id",id);
		return "addr/list";
	}
	
	@GetMapping("/orderby")
	public ModelAndView orderbyList(
			@RequestParam(value="id")String id,
			@RequestParam(value="value")String value,
			@RequestParam(value="orderby")String orderby){
		ModelAndView mav = new ModelAndView();
		List<AddrVO> addrList = addrService.getAddrList(id, value, orderby);
		mav.addObject("list",addrList);
		mav.addObject("id",id);
		mav.setViewName("addr/list");
		return mav;
	}
	
	@GetMapping("/search")
	public String getAllAddrName(
			@RequestParam(value="id")String id,
			@RequestParam(value="name") String name,
			Model model){
		List<AddrVO> addrList = addrService.getAddrNameList(id,name);
		if(addrList.size()==0) {
			model.addAttribute("id",id);
			model.addAttribute("list",addrService.getAddrList(id,"date","ascend"));
			return "addr/list";
		}
		if(addrList.size()==1) {
			model.addAttribute("addr",addrList.get(0));
			return "addr/view";
		}
		model.addAttribute("count",addrList.size());
		model.addAttribute("list",addrList);
		return "addr/nameList";
	}
	
	@GetMapping("/{phone}")
	public String getAddrInfo(@PathVariable String phone,
			@RequestParam(value="id")String id, Model model) {
		AddrVO addr = addrService.getAddrInfo(id, phone);
		model.addAttribute("addr",addr);
		return "addr/view";
	}
	
	@GetMapping("/insert")
	public String insertAddr(
			@RequestParam(value="id")String id,Model model) {
		model.addAttribute("id",id);
		return "addr/insertform";
	}
	
	@PostMapping("/insert")
	public String insertAddr(AddrVO addr,Model model) {
		String id = addr.getId();
		addrService.insertAddr(id,addr);
		model.addAttribute("id",id);
		model.addAttribute("list",addrService.getAddrList(id,"date","ascend"));
		return "addr/list";
	}
	
	@GetMapping("/update")
	public String updateAddr(
			@RequestParam(value="id")String id,
			@RequestParam(value="phone")String phone,
			Model model) {
		model.addAttribute("addr",addrService.getAddrInfo(id, phone));
		return "addr/update";
	}
	
	@PostMapping("/update")
	public String updateAddr(AddrVO addr, Model model) {
		String id = addr.getId();
		String phone = addr.getPhone();
		addrService.updateAddr(id, phone, addr);
		model.addAttribute("addr",addrService.getAddrInfo(id, phone));
		return "addr/view";
	}
	
	@GetMapping("/delete")
	public String deleteAddr(
			@RequestParam(value="id",required=true)String id,
			@RequestParam(value="phone",required=true)String phone,
			Model model) {
		model.addAttribute("addr",addrService.getAddrInfo(id, phone));
		return "addr/deleteform";
	}
	
	@PostMapping("/delete")
	public String deleteAddr(
			@RequestParam(value="id")String id, 
			@RequestParam(value="phone")String phone,
			@RequestParam(value="confirm")String confirm
			, Model model){
		if(confirm.toUpperCase().equals("Y")) {
		addrService.deleteAddr(id, phone);
		List<AddrVO> addrList = addrService.getAddrList(id,"date","ascend");
		model.addAttribute("id",id);
		model.addAttribute("list",addrList);
		return "addr/list";
		} 
		model.addAttribute("addr",addrService.getAddrInfo(id, phone));
		return "addr/deleteform";
	}
	
	@PostMapping("/deleteAll")
	public String deleteSelectedAddr(
			@RequestParam(value="id",required=true)String id,
			@RequestParam(value="checkbox")String[] phone_list, 
			Model model) {
		for(int i = 0; i<phone_list.length; i++) {
			addrService.deleteAddr(id,phone_list[i]);
		}
		List<AddrVO> addrList = addrService.getAddrList(id,"date","ascend");
		model.addAttribute("list",addrList);
		return "addr/list";
	}
}
