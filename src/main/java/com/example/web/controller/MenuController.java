//package com.example.web.controller;
//
//import com.example.web.dto.RoleDTO;
//import com.example.web.entity.Menu;
//import com.example.web.service.MenuService;
//import com.example.web.util.DTOConventer;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class MenuController {
//    @Autowired
//    private MenuService menuService;
//    @Autowired
//    DTOConventer dtoConventer;
//    @GetMapping("/listMenu")
//    public ResponseEntity<?> listMenu(@RequestBody RoleDTO roleDTO){
//        List<Menu> menuRequest = menuService.getListMenuByRoleId(roleDTO.getRoleId());
//        return new ResponseEntity<>(menuRequest,HttpStatus.OK);
//    }
//}
