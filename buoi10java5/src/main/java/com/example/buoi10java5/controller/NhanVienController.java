package com.example.buoi10java5.controller;

import com.example.buoi10java5.entity.ChucVu;
import com.example.buoi10java5.entity.NhanVien;
import com.example.buoi10java5.repository.ChucVuRepository;
import com.example.buoi10java5.repository.NhanVienRepository;
import com.example.buoi10java5.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienRepository;
    @Autowired
    private ChucVuRepository chucVuRepository;
    @GetMapping("/nhan-vien/hien-thi")
    public String hienThi(Model model,@ModelAttribute("nhanVien") NhanVien nhanVien){
        model.addAttribute("listNhanVien",nhanVienRepository.findAll());
        model.addAttribute("listChucVu",chucVuRepository.findAll());
        return "nhan-vien/hien-thi";
    }
    @PostMapping("/nhan-vien/add")
    public String add(@ModelAttribute("nhanVien") NhanVien nhanVien ){
        nhanVienRepository.save(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }
    @GetMapping("/nhan-vien/delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        nhanVienRepository.delete(id);
        return "redirect:/nhan-vien/hien-thi";
    }
    @GetMapping("/nhan-vien/detail/{id}")
    public String detail(@PathVariable("id")Integer id,Model model){
        NhanVien nhanVien = nhanVienRepository.detail(id).get();
        model.addAttribute("nhanVien",nhanVien);
        model.addAttribute("listChucVu",chucVuRepository.findAll());
        return "nhan-vien/detail";
    }
    @PostMapping("/nhan-vien/update/{id}")
    public String update( NhanVien nhanVien ){
        nhanVienRepository.save(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

}
