package com.source.restclient.controller;

import com.source.restclient.model.SinhVien;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class SinhVienController {


    @Value("${URL_STUDENTS}")
    String URL_STUDENTS;

    @Value("${accessToken}")
    String accessToken;

    String addMessageError="Mã Sinh Viên đã tồn tại, Vui Lòng Nhập Lại";

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();



    @RequestMapping("/")
    public String index(Model model) {

        // accessToken can be the secret key you generate.
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> entity = new HttpEntity <> (headers);
        ResponseEntity<List<SinhVien>> response = restTemplate.exchange(URL_STUDENTS, HttpMethod.GET, entity,  new ParameterizedTypeReference<List<SinhVien>>(){});
        System.out.println(response.getClass()+"Load List");
        List<SinhVien> list = response.getBody();

        model.addAttribute("listSV", list);
        return "SinhVien/listSV";
    }

    @RequestMapping(value = "addSV")
    public String addSV(Model model) {
        SinhVien sv=new SinhVien();
        sv.setNgaySinh(new Date());
        model.addAttribute("sinhVien", new SinhVien());
        return "SinhVien/addSV";
    }

    @RequestMapping(value = "/editSV", method = RequestMethod.GET)
    public String editSV(@RequestParam("maSV") String maSV,Model model) {
        //accessToken can be the secret key you generate.
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> entity = new HttpEntity <> (headers);
        ResponseEntity<Optional<SinhVien>> response = restTemplate.exchange(URL_STUDENTS +"/"+maSV, HttpMethod.GET, entity,new ParameterizedTypeReference<Optional<SinhVien>>(){} );
        System.out.println(response.getClass()+"Edit");
        Optional<SinhVien> svEdit = response.getBody();

        svEdit.ifPresent(sinhVien -> model.addAttribute("sinhVien", sinhVien));
        return "SinhVien/editSV";

    }

    @RequestMapping(value = "saveSVEdit", method = RequestMethod.POST)
    public String saveSVEdit(@Validated @ModelAttribute("sinhVien") SinhVien sinhvien, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("có lỗi khi update");
            return "SinhVien/editSV";
        }
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<Object> entity = new HttpEntity<>(sinhvien,headers);
        Object response = restTemplate.exchange(URL_STUDENTS+"/"+sinhvien.getMaSV(), HttpMethod.PUT, entity, Object.class);
        System.out.println(response.getClass()+"save Edit");
        return "redirect:/";
    }

    @RequestMapping(value = "saveSV", method = RequestMethod.POST)
    public String save(Model model, @Validated @ModelAttribute("sinhVien") SinhVien sinhvien, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("có lỗi khi insert");
            return "SinhVien/addSV";
        }

        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<Object> entity = new HttpEntity<>(sinhvien,headers);
        try {
            Object response = restTemplate.exchange(URL_STUDENTS, HttpMethod.POST, entity, Object.class);
            System.out.println(response.getClass() + " save");
            //System.out.println(sinhvien.isGioiTinh() +" "+ sinhvien.getNgaySinh()+" "+sinhvien.getMaSV() );
        } catch (RuntimeException ex){
            // bắt lỗi trùng mã SV
            ex.printStackTrace();
            model.addAttribute("message",addMessageError);
            return "SinhVien/error";
        }
        return "redirect:/";

    }

    @RequestMapping(value = "/deleteSV", method = RequestMethod.GET)
    public String deleteSV(@RequestParam("maSV") String maSV) {
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        Object response = restTemplate.exchange(URL_STUDENTS +"/"+maSV, HttpMethod.DELETE, entity, Object.class);
        System.out.println(response.getClass()+"Delete");
        return "redirect:/";
    }
}
