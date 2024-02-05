package com.tp.threeproject.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tp.threeproject.domain.dto.TaskDisplayDto;
import com.tp.threeproject.domain.form.TaskForm;
import com.tp.threeproject.domain.service.TaskService;

/**
 * 
 * Task表示用Controllerクラス
 * 
 */

@Controller
public class TaskController {

	@Autowired
    TaskService service;

	@GetMapping(value="/")
	 public String index(Model model) {
		List<TaskDisplayDto> list = service.index();
		model.addAttribute("tasks",list);
		return "index";
	}

	@GetMapping("/task/edit")
	public String edit(@RequestParam("id") Long id, Model model) {
		TaskDisplayDto task = service.edit(id);
		model.addAttribute("task",task);
		return "edit";
	}

	@PostMapping(value="/task/add")
	public String add(TaskForm form){
		service.add(form);
		return "redirect:/";
	}
	
	@PostMapping("/task/update/detail")
	@Transactional
	public String updateDetail(TaskForm form) {
		service.updateDetail(form);
		return "redirect:/";
	}

	@PostMapping("/task/update/done")
	@Transactional
	public String updateDoneFlg(@RequestParam("id") Long id, @RequestParam("doneFlg") String doneFlg) {
		service.updateDoneFlg(id, doneFlg);
		return "redirect:/";
	}

	@GetMapping("/task/delete")
	@Transactional
	public String delete(@RequestParam("id") Long id) {
		service.delete(id);
		return "redirect:/";
	}

}
