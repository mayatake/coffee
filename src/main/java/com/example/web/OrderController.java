package com.example.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.Order;
import com.example.service.OrderService;

@Controller
@RequestMapping("orders")
public class OrderController {
	@Autowired
	OrderService customerService;
	
	@ModelAttribute
	OrderForm setUpForm() {
		return new OrderForm();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	String list(Model model) {
		List<Order> customers = customerService.findByDoneFalse();
		//List<Order> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		return "orders/list";
	}
	
	@RequestMapping(value = "admin" ,method = RequestMethod.GET)
	String list_all(Model model) {
		List<Order> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		return "orders/list_all";
	}
	
	@RequestMapping(value = "confirm", method = RequestMethod.POST)
	String confitm(@Validated OrderForm form, BindingResult result, Model model) {
		if (result.hasErrors()){
			return list(model);
		}
		model.addAttribute("orderForm", form);
		return "orders/confirm";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	String create(@Validated OrderForm form, BindingResult result, Model model) {
		if (result.hasErrors()){
			return list(model);
		}
		Order customer = new Order();
		BeanUtils.copyProperties(form, customer);
		customer.setDate();
		customer.resetDone();
		customerService.create(customer);
		
		return "redirect:/orders";
	}
	
	@RequestMapping(value = "create", params = "goToTop")
	String goToTop2() {
		return "redirect:/orders";
	}
	
	@RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
	String editForm(@RequestParam Integer id, OrderForm form) {
		Order customer = customerService.findOne(id);
		BeanUtils.copyProperties(customer, form);
		return "orders/edit";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	String edit(@RequestParam Integer id, @Validated OrderForm form, BindingResult result) {
		if(result.hasErrors()) {
			return editForm(id, form);
		}
		Order customer = new Order();
		BeanUtils.copyProperties(form, customer);
		customer.setId(id);
		customer.setDate();
		customerService.update(customer);
		return "redirect:/orders";
	}
	
	@RequestMapping(value = "edit", params = "goToTop")
	String goToTop() {
		return "redirect:/orders";
	}
	
	@RequestMapping(value = "check", method = RequestMethod.GET)
	String check(@RequestParam Integer id) {
		Order customer = new Order();
		customer = customerService.findOne(id);
		customer.setDone();
		customerService.update(customer);
		return "redirect:/orders/admin";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	String delete(@RequestParam Integer id) {
		customerService.delete(id);
		return "redirect:/orders";
	}
	
}
