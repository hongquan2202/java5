package com.example.buoi10java5.service;

import com.example.buoi10java5.entity.NhanVien;
import com.example.buoi10java5.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    public List<NhanVien> findAll(){
        return nhanVienRepository.findAll();
    }
    public Optional<NhanVien> detail(Integer id){
        return nhanVienRepository.findById(id);
    }
    public void save(NhanVien nhanVien){
        nhanVienRepository.save(nhanVien);
    }
    public void delete(Integer id){
        nhanVienRepository.deleteById(id);
    }
}
